package net.mlk.mlcord;

import net.mlk.mlcord.network.websocket.discord.DiscordWebSocket;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.PresenceUpdate;

public class DiscordBot {
    private final String token;
    private final DiscordWebSocket discordGateway;

    public DiscordBot(String token) {
        if (token == null) {
            throw new RuntimeException("Token can't be null");
        }
        this.token = token;
        this.discordGateway = new DiscordWebSocket(token);
    }

    /**
     * starts the discord connection
     * @return instance of the bot
     */
    public DiscordBot start() {
        this.discordGateway.connect();
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

}

/*
    Plans:
        - create the sharding in the network/websocket/discord/gateway/Identify
        - create the presence update
 */
