package net.mlk.mlcord.discord.message.components.select;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.emoji.Emoji;

public class SelectOptionComponent implements JsonConvertible {
    private String label;
    private String value;
    private String description;
    private Emoji emoji;
    private boolean isDefault;

    /**
     * @return option label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * @return option value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @return option description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return option emoji
     */
    public Emoji getEmoji() {
        return this.emoji;
    }

    /**
     * @return true if selected by default
     */
    public boolean isDefault() {
        return this.isDefault;
    }
}