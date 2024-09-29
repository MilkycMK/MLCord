package net.mlk.mlcord.discord.guild.welcome;

import net.mlk.jmson.utils.JsonConvertible;

public class WelcomeScreenChannel implements JsonConvertible {
    private String channel_id;
    private String description;
    private String emoji_id;
    private String emoji_name;

    /**
     * @return emoji id
     */
    public String getEmojiId() {
        return this.emoji_id;
    }

    /**
     * @return emoji name
     */
    public String getEmojiName() {
        return this.emoji_name;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return channel id
     */
    public String getChannelId() {
        return this.channel_id;
    }
}
