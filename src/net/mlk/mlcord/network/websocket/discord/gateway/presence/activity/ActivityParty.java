package net.mlk.mlcord.network.websocket.discord.gateway.presence.activity;

import net.mlk.jmson.utils.JsonConvertible;

public class ActivityParty implements JsonConvertible {
    private String id;
    private int[] size;

    /**
     * @return party id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return array with 2 integers current/max size
     */
    public int[] getSize() {
        return this.size;
    }
}
