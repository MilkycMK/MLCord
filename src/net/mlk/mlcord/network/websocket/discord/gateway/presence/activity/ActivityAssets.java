package net.mlk.mlcord.network.websocket.discord.gateway.presence.activity;

import net.mlk.jmson.utils.JsonConvertible;

public class ActivityAssets implements JsonConvertible {
    private String large_image;
    private String large_text;
    private String small_image;
    private String small_text;

    /**
     * @return large image hash
     */
    public String getLargeImageHash() {
        return this.large_image;
    }

    /**
     * @return large image text
     */
    public String getLargeImageText() {
        return this.large_text;
    }

    /**
     * @return small image hash
     */
    public String getSmallImageHash() {
        return this.small_image;
    }

    /**
     * @return small image text
     */
    public String getSmallImageText() {
        return this.small_text;
    }
}
