package net.mlk.mlcord.discord.guild.scheduled;

import net.mlk.jmson.utils.JsonConvertible;

public class ScheduledEntityMetadata implements JsonConvertible {
    private String location;

    /**
     * @return event location
     */
    public String getLocation() {
        return this.location;
    }
}
