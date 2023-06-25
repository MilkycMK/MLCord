package net.mlk.mlcord.network.websocket.discord.gateway.presence.activity;

import net.mlk.jmson.utils.JsonConvertible;

public class ActivityEmoji implements JsonConvertible {
    private String name;
    private String id;
    private boolean animated;

    /**
     * @return emoji name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return emoji id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return true if emoji is animated
     */
    public boolean isAnimated() {
        return this.animated;
    }
}
