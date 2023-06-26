package net.mlk.mlcord.network.websocket.discord.gateway.data;

import net.mlk.jmson.utils.JsonConvertible;

public class SessionLimit implements JsonConvertible {
    private int total;
    private int remaining;
    private int reset_after;
    private int max_concurrency;

    /**
     * @return max login count for day
     */
    public int getTotal() {
        return this.total;
    }

    /**
     * @return remaining login count for day
     */
    public int getRemaining() {
        return this.remaining;
    }

    /**
     * @return mills before count reset
     */
    public int getResetAfter() {
        return this.reset_after;
    }

    /**
     * @return max login per 5 secs
     */
    public int getMaxConcurrency() {
        return this.max_concurrency;
    }
}
