package net.mlk.mlcord.discord.channel.forum;

import net.mlk.jmson.utils.JsonConvertible;

public class ForumTag implements JsonConvertible {
    private String id;
    private String name;
    private boolean moderated;
    private String emoji_id;
    private String emoji_name;

    /**
     * @return true if moderated;
     */
    public boolean isModerated() {
        return this.moderated;
    }

    /**
     * @return tag name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return tag id
     */
    public String getId() {
        return this.id;
    }

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