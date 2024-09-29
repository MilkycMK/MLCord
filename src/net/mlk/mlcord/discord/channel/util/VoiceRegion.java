package net.mlk.mlcord.discord.channel.util;

import net.mlk.jmson.utils.JsonConvertible;

public class VoiceRegion implements JsonConvertible {
    private String id;
    private String name;
    private boolean optimal;
    private boolean deprecated;
    private boolean custom;

    /**
     * @return true if this is a custom voice region
     */
    public boolean isCustom() {
        return this.custom;
    }

    /**
     * @return true if this is a deprecated voice region
     */
    public boolean isDeprecated() {
        return this.deprecated;
    }

    /**
     * @return true for a single server that is closest to the current user's client
     */
    public boolean isOptimal() {
        return this.optimal;
    }

    /**
     * @return region name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return region id
     */
    public String getId() {
        return this.id;
    }
}
