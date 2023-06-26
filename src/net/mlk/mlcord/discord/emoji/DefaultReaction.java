package net.mlk.mlcord.discord.emoji;

import net.mlk.jmson.utils.JsonConvertible;

public class DefaultReaction implements JsonConvertible {
    private String emoji_id;
    private String emoji_name;

    /**
     * @return emoji name
     */
    public String getEmojiName() {
        return this.emoji_name;
    }

    /**
     * @return emoji id
     */
    public String getEmojiId() {
        return this.emoji_id;
    }
}
