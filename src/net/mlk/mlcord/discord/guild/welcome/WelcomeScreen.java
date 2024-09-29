package net.mlk.mlcord.discord.guild.welcome;

import net.mlk.jmson.utils.JsonConvertible;

import java.util.ArrayList;
import java.util.List;

public class WelcomeScreen implements JsonConvertible {
    private String description;
    private List<WelcomeScreenChannel> welcome_channels = new ArrayList<>();

    /**
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return welcome screen channels
     */
    public List<WelcomeScreenChannel> getWelcomeChannels() {
        return this.welcome_channels;
    }
}
