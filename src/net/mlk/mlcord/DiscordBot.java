package net.mlk.mlcord;

import net.mlk.jmson.Json;
import net.mlk.jmson.utils.JsonConverter;
import net.mlk.mlcord.annotations.EventHandler;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.DiscordEventListener;
import net.mlk.mlcord.discord.guild.Guild;
import net.mlk.mlcord.discord.guild.events.GuildCreateEvent;
import net.mlk.mlcord.discord.guild.events.GuildDeleteEvent;
import net.mlk.mlcord.discord.guild.events.GuildUpdateEvent;
import net.mlk.mlcord.network.http.discord.DiscordHttpRequestManager;
import net.mlk.mlcord.network.websocket.discord.DiscordWebSocket;
import net.mlk.mlcord.network.websocket.discord.gateway.data.GatewayData;
import net.mlk.mlcord.network.websocket.discord.gateway.data.SessionLimit;
import net.mlk.mlcord.network.websocket.discord.gateway.events.ReadyReceiveEvent;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.PresenceUpdate;
import net.mlk.mlcord.network.websocket.discord.utils.DiscordEvent;
import net.mlk.mlcord.network.websocket.discord.utils.DispatchEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class DiscordBot {
    private final String token;
    private final DiscordWebSocket discordGateway;
    private GatewayData gatewayData;
    private DiscordHttpRequestManager apiManager;
    private final ArrayList<DiscordEventListener> listeners = new ArrayList<>();

    private final HashMap<String, Guild> guilds = new HashMap<>();

    public DiscordBot(String token) {
        if (token == null) {
            throw new NullPointerException("Token can't be null");
        }
        this.token = token;
        this.discordGateway = new DiscordWebSocket(token);
        this.discordGateway.setListener(this::eventHandler);
    }

    /**
     * starts the discord connection
     * @return instance of the bot
     */
    public DiscordBot start() {
        if (!this.getGatewayData().isBot()) {
            System.out.println("You are running as user.");
        } else {
            SessionLimit limit = this.gatewayData.getSessionStartLimit();
            System.out.printf("You are running as bot. Your stats: \n" +
                            "Max Authorizations per 5 secs: %s\n" +
                            "Authorizations: %s/%s\n" +
                            "Authorizations reset after %s mills\n" +
                            "Recommended number of shards to use: %s\n\n",
                    limit.getMaxConcurrency(), limit.getRemaining(), limit.getTotal(),
                    limit.getResetAfter(), this.gatewayData.getShardsCount());
        }
        this.discordGateway.connect();
        synchronized (this) { // waiting a ready event
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return this;
    }

    /**
     * @return the token of the bot
     */
    public String getToken() {
        return this.token;
    }

    /**
     * set presence
     * @param presence presence to set
     * @return discord bot instance
     */
    public DiscordBot setPresence(PresenceUpdate presence) {
        if (presence.getActivities().size() == 0) {
            throw new RuntimeException("presence activity doesn't exists");
        }
        this.discordGateway.setPresence(presence);
        return this;
    }

    /**
     * @return gateway data like url, shards and other user limits (for user only url)
     */
    public GatewayData getGatewayData() {
        if (this.gatewayData == null) {
            this.apiManager = new DiscordHttpRequestManager(this.token, true);
            Json data = new Json(this.apiManager.send(Discord.GET_GATEWAY_BOT_API));
            if (data.containsKey("code")) {
                this.apiManager = new DiscordHttpRequestManager(this.token, false);
                data = new Json(this.apiManager.send(Discord.GET_GATEWAY_API));
            }
            this.gatewayData = JsonConverter.convertToObject(data, GatewayData.class);
        }
        return this.gatewayData;
    }


    /**
     * Use it if you know what are you doing
     * @return discord api manager
     */
    public DiscordHttpRequestManager getApiManager() {
        return this.apiManager;
    }

    /**
     * Use it if you know what are you doing
     * @return websocket connection
     */
    public DiscordWebSocket getWebSocket() {
        return this.discordGateway;
    }

    /**
     * @return user guilds (without unavailable)
     */
    public Collection<Guild> getGuilds() {
        return this.guilds.values();
    }

    /**
     * Invoke methods by received event
     * @param event recieved event
     */
    private void eventHandler(DiscordEvent event) {
        // if ready send notify that we connected
        if (event instanceof ReadyReceiveEvent) {
            synchronized (this) {
                // Waiting user guilds
                // if receive null or another event - break
                while (true) {
                    String response = this.discordGateway.receive();
                    if (response == null) {
                        break;
                    }
                    DispatchEvent ev = DispatchEvent.getDispatchEvent(new Json(response));
                    if (!(ev instanceof GuildCreateEvent)) {
                        break;
                    }
                    Guild guild = ((GuildCreateEvent) ev).getGuild();
                    this.guilds.put(guild.getId(), guild);
                }

                this.notify();
            }
        }

        // Events for data caching
        if (event instanceof GuildCreateEvent) {
            Guild guild = ((GuildCreateEvent) event).getGuild();
            this.guilds.put(guild.getId(), guild);
        } else if (event instanceof GuildUpdateEvent) {
            Guild guild = ((GuildUpdateEvent) event).getGuild();
            this.guilds.put(guild.getId(), guild);
        } else if (event instanceof GuildDeleteEvent) {
            Guild guild = ((GuildDeleteEvent) event).getGuild();
            this.guilds.remove(guild.getId());
        }

        // Send events to handlers
        for (DiscordEventListener listener : this.listeners) {
            for (Method method : listener.getClass().getDeclaredMethods()) {
                EventHandler handler = method.getAnnotation(EventHandler.class);
                if (handler != null && Arrays.asList(method.getParameterTypes()).contains(event.getClass())) {
                    try {
                        method.invoke(listener, event);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    /**
     * add a Listener class for receive events
     * @param listener class
     * @return current application class
     */
    public DiscordBot addListener(DiscordEventListener listener) {
        if (listener == null) {
            throw new NullPointerException("Listener is null");
        }
        this.listeners.add(listener);
        return this;
    }

}

/*
    Plans:
        - create the sharding in the network/websocket/discord/gateway/Identify
 */
