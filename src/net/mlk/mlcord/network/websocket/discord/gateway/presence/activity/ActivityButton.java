package net.mlk.mlcord.network.websocket.discord.gateway.presence.activity;

import net.mlk.jmson.utils.JsonConvertible;

public class ActivityButton implements JsonConvertible {
    private String label;
    private String url;

    /**
     * @return button label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * @return button url
     */
    public String getUrl() {
        return this.url;
    }
}
