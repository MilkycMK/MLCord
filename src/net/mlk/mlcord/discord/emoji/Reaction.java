package net.mlk.mlcord.discord.emoji;

import net.mlk.jmson.utils.JsonConvertible;

public class Reaction implements JsonConvertible {
    private int count;
    private boolean me;
    private Emoji emoji;

    /**
     * @return reactions count
     */
    public int getCount() {
        return this.count;
    }

    /**
     * @return true if current user reacted
     */
    public boolean isCurrentUserReacted() {
        return this.me;
    }

    /**
     * @return emoji
     */
    public Emoji getEmoji() {
        return this.emoji;
    }
}
