package net.mlk.mlcord.network.websocket.discord.gateway.presence.activity;

public class ActivitySecrets {
    private String join;
    private String spectate;
    private String match;

    /**
     * @return secret for joining a party
     */
    public String getJoin() {
        return this.join;
    }

    /**
     * @return secret for spectate a game
     */
    public String getSpectate() {
        return this.spectate;
    }

    /**
     * @return secret for a specific instanced match
     */
    public String getMatch() {
        return this.match;
    }
}
