package net.mlk.mlcord.network.websocket.discord;

import net.mlk.jmson.Json;
import net.mlk.jmson.utils.JsonConverter;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.network.websocket.WebSocket;
import net.mlk.mlcord.network.websocket.discord.gateway.Identify;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.PresenceUpdate;
import net.mlk.mlcord.network.websocket.discord.gateway.utils.Resume;
import net.mlk.mlcord.network.websocket.discord.utils.*;
import net.mlk.mlcord.network.websocket.utils.WebSocketCloseCode;

import java.io.IOException;
import java.net.URI;
import java.util.HashSet;

public class DiscordWebSocket extends WebSocket {
    private String token;
    private int sequence;
    private int intents;
    private String session_id;
    private PresenceUpdate presence;
    private URI reconnectGateway;
    private DiscordWebSocketListener listener;
    private Thread heartBeatThread;
    private boolean waitForACK;

    public DiscordWebSocket(String token) {
        this(token, DiscordIntent.getIntentsSet(DiscordIntent.ALL_INTENTS));
    }

    public DiscordWebSocket(String token, HashSet<DiscordIntent> intents) {
        super(URI.create(Discord.GATEWAY_URL));
        super.setListener(this::onMessage);
        this.setIntents(intents);
        this.token = token;
    }

    /**
     * Override class from WebSocket to start connection with the discord gateway
     * @return instance of the discord websocket
     * @see WebSocket
     */
    @Override
    public DiscordWebSocket connect() {
        try {
            super.connect();
            this.sequence = -1;

            Identify identify = new Identify(this.token, this.intents);
            if (this.presence != null) {
                identify.setPresence(this.presence);
            }

            super.send(JsonConverter.convertToJson(identify).toString());
        } catch (IOException ex) {
            throw new RuntimeException("Something went wrong while connecting...");
        }
        return this;
    }

    /**
     * Reconnect to the discord gateway
     * @return instance of the discord web socket
     */
    public DiscordWebSocket reconnect() {
        if (!super.isConnected() || this.reconnectGateway == null) {
            throw new RuntimeException("Can't reconnect now.");
        }
        try {
            this.close(WebSocketCloseCode.SERVICE_RESTART.getCode());
            super.connect(this.reconnectGateway);
            Json resume = JsonConverter.convertToJson(new Resume(this.token, this.session_id, this.sequence));
            this.send(resume.toString());
        } catch (IOException ignored) {}
        return this;
    }

    private void onMessage(String message) {
        System.out.println(message);
        if (!Json.isJson(message)) {
            return;
        }
        Json payload = new Json(message);
        if (!payload.getString("s").equals("null")) {
            this.sequence = payload.getInteger("s");
        }
        this.handleOpcode(payload.getInteger("op"), payload);
    }

    /**
     * Check received message opcode and do something
     * if not opcode then check close code
     * @param op opcode of the message
     * @param payload received payload
     */
    private void handleOpcode(int op, Json payload) {
        DiscordOpcode opcode = DiscordOpcode.getByCode(op);
        DiscordEvent event = null;

//        if (opcode == DiscordOpcode.DISPATCH) {
//            event = DispatchEvent.getDispatchEvent(payload);
//        } else if (opcode == DiscordOpcode.HEARTBEAT) {
//            event = JsonConverter.convertToObject(payload, HeartBeatReceiveEvent.class);
//            this.s = event.getSequence() == -1 ? this.s : event.getSequence();
//            this.sendHeartBeat();
//        } else if (opcode == DiscordOpcode.RECONNECT) {
//            event = JsonConverter.convertToObject(payload, ReconnectReceiveEvent.class);
//            this.reconnect();
//        } else if (opcode == DiscordOpcode.INVALID_SESSION) {
//            event = JsonConverter.convertToObject(payload, InvalidSessionReceiveEvent.class);
//            InvalidSessionReceiveEvent inv = (InvalidSessionReceiveEvent) event;
//            if (inv.canResume()) {
//                this.reconnect();
//            } else {
//                super.close();
//                this.connect();
//            }
//        } else if (opcode == DiscordOpcode.HELLO) {
//            event = JsonConverter.convertToObject(payload, HelloReceiveEvent.class);
//            this.startHeartBeat(((HelloReceiveEvent) event).getHeartBeatInterval());
//        } else if (opcode == DiscordOpcode.HEARTBEAT_ACK) {
//            event = JsonConverter.convertToObject(payload, AckReceiveEvent.class);
//            this.waitForACK = false;
//        }

        if (event != null) {
            this.handleEvent(event);
        }
    }

    /**
     * Check discord events and do something
     * @param event event payload
     */
    private void handleEvent(DiscordEvent event) {
        boolean isUnavailableGuild = false;
        DiscordEventType type = event.getType();

//        if (type == DiscordEventType.READY) {
//            ReadyReceiveEvent ready = (ReadyReceiveEvent) event;
//            this.user = ready.getUser();
//            this.reconnectGateway = ready.getResumeGatewayUrl();
//            this.session_id = ready.getSessionId();
//            for (Guild guild : ready.getGuilds()) {
//                this.awaitedGuilds.add(guild.getId());
//            }
//        } else if (type == DiscordEventType.GUILD_CREATE) {
//            Guild createdGuild = ((GuildCreateEvent) event).getGuild();
//            isUnavailableGuild = this.awaitedGuilds.remove(createdGuild.getId());
//        } else if (type == DiscordEventType.GUILD_DELETE) {
//            Guild deletedGuild = ((GuildDeleteEvent) event).getGuild();
//            if (deletedGuild.isUnavailable()) {
//                this.awaitedGuilds.add(deletedGuild.getId());
//                return;
//            }
//        } else if (type == DiscordEventType.MESSAGE_CREATE) {
//            MessageReceiveEvent receiveEvent = ((MessageReceiveEvent) event);
//            if (receiveEvent.getMessage().getAuthor().getId().equals(this.user.getId())) {
//                return;
//            }
//        }

        if (this.listener != null && !isUnavailableGuild) {
            this.listener.onEvent(event);
        }
    }

    /**
     * Start sending heartbeats every heartbeat_interval
     * in another thread
     * @param heartbeat_interval interval for send
     */
    private void startHeartBeat(int heartbeat_interval) {
        if (this.heartBeatThread != null && this.heartBeatThread.isAlive()) {
            this.heartBeatThread.interrupt();
        }

        this.heartBeatThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    this.sendHeartBeat();
                    this.waitForACK = true;
                    Thread.sleep(heartbeat_interval);
                    if (this.waitForACK) {
                        this.reconnect();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        this.heartBeatThread.start();
    }


    /**
     * Send heartbeat to the discord gateway
     */
    private boolean sendHeartBeat() {
        Json json = new Json();
        json.append("op", DiscordOpcode.HEARTBEAT.getValue())
                .append("d", this.sequence == -1 ? "null" : this.sequence);
        super.send(json.toString());
        return true;
    }


    /**
     * Override method for stop heartBeat on close
     */
    @Override
    protected void onClose() {
        if (this.heartBeatThread != null && this.heartBeatThread.isAlive()) {
            this.heartBeatThread.interrupt();
        }
    }

    /**
     * Check discord close code and do something
     * if not from discord check for websocket
     * @param op opcode of the message
     */
    @Override
    protected void handleCloseCode(int op, String message) {
        DiscordCloseCode opcode = DiscordCloseCode.getByCode(op);

        if (opcode == DiscordCloseCode.UNKNOWN_ERROR) {
            this.reconnect();
        } else if (opcode == DiscordCloseCode.UNKNOWN_OPCODE) {
            this.reconnect();
        } else if (opcode == DiscordCloseCode.DECODE_ERROR) {
            this.reconnect();
        } else if (opcode == DiscordCloseCode.NOT_AUTHENTICATED) {
            this.reconnect();
        } else if (opcode == DiscordCloseCode.AUTHENTICATION_FAILED) {
            this.close();
            throw new RuntimeException("Invalid token.");
        } else if (opcode == DiscordCloseCode.ALREADY_AUTHENTICATED) {
            super.close();
            this.connect();
        } else if (opcode == DiscordCloseCode.INVALID_SEQ) {
            this.reconnect();
        } else if (opcode == DiscordCloseCode.RATE_LIMITED) {
            // Rewrite it later
            System.out.println("You are sending payloads too quickly");
        } else if (opcode == DiscordCloseCode.SESSION_TIMED_OUT) {
            this.reconnect();
        } else if (opcode == DiscordCloseCode.INVALID_SHARD) {
            this.close();
            throw new RuntimeException("You sent an invalid shard");
        } else if (opcode == DiscordCloseCode.SHARDING_REQUIRED) {
            this.close();
            throw new RuntimeException("The session would have handled too many guilds. Please use sharding");
        } else if (opcode == DiscordCloseCode.INVALID_API_VERSION) {
            // Rewrite it later
            System.out.println("Invalid api version");
        } else if (opcode == DiscordCloseCode.INVALID_INTENTS) {
            // Rewrite it later
            System.out.println("You set the invalid intents");
        } else if (opcode == DiscordCloseCode.DISALLOWED_INTENTS) {
            // Rewrite it later
            System.out.println("You set the intents that you have not enabled or are not approved for.");
        } else {
            super.handleCloseCode(op, message);
        }
    }

    /**
     * set listener to receive events
     * @param listener listener to set
     * @return instance
     */
    public DiscordWebSocket setListener(DiscordWebSocketListener listener) {
        if (listener == null) {
            throw new NullPointerException("Listener is null");
        }
        this.listener = listener;
        return this;
    }

    /**
     * set intents
     * @param intents hashset with intents
     * @return instance
     */
    public DiscordWebSocket setIntents(HashSet<DiscordIntent> intents) {
        this.intents = DiscordIntent.getIntentsNumber(intents);
        return this;
    }

    /**
     * set intents
     * @param intents integer intents
     * @return instance
     */
    public DiscordWebSocket setIntents(int intents) {
        this.intents = intents;
        return this;
    }

    /**
     * set user activity
     * @param presence presence to set
     * @return instance of the discord web socket
     */
    public DiscordWebSocket setPresence(PresenceUpdate presence) {
        if (presence == null) {
            throw new RuntimeException("presence is null");
        }
        this.presence = presence;
        return this;
    }

    /**
     * @return session id
     */
    public String getSessionId() {
        return this.session_id;
    }

    /**
     * @return sequence number
     */
    public int getSequenceNumber() {
        return this.sequence;
    }

    /**
     * @return reconnect gateway url
     */
    public URI getReconnectGateway() {
        return this.reconnectGateway;
    }

}
