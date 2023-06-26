package net.mlk.mlcord.discord.guild.integrations;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.user.User;
import net.mlk.mlcord.discord.utils.ImageFormat;

public class IntegrationApplication implements JsonConvertible {
    private String id;
    private String name;
    private String icon;
    private String description;
    private User bot;

    /**
     * @return bot of this application
     */
    public User getBot() {
        return this.bot;
    }

    /**
     * @return application description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return application icon hash
     */
    public String getIconHash() {
        return this.icon;
    }

    /**
     * @return application banner url or null
     */
    public String getIconUrl() {
        return this.getIconUrl(ImageFormat.PNG);
    }

    /**
     * @param format image format to recieve
     * @return application icon url or null
     * @see Discord
     * @see ImageFormat
     */
    public String getIconUrl(ImageFormat format) {
        if (this.icon == null) {
            return null;
        }
        return String.format(Discord.APPLICATION_ICON_URL, this.id, this.icon, format);
    }

    /**
     * @return application name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return application id
     */
    public String getId() {
        return this.id;
    }
}
