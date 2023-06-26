package net.mlk.mlcord.network.websocket.discord.gateway.data;

import net.mlk.jmson.utils.JsonConvertible;

public class GatewayData implements JsonConvertible {
    private String url;
    private int shards;
    private SessionLimit session_start_limit;

    /**
     * @return true if bot session
     */
    public boolean isBot() {
        return !(this.session_start_limit == null);
    }

    /**
     * @return gateway url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @return recommended count of shards to use (0 if user)
     */
    public int getShardsCount() {
        return this.shards;
    }

    /**
     * @return session limits for user (null if user)
     */
    public SessionLimit getSessionStartLimit() {
        return this.session_start_limit;
    }
}
