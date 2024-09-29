package net.mlk.mlcord.discord.message.embeds.objects;

import net.mlk.jmson.utils.JsonConvertible;

public class EmbedField implements JsonConvertible {
    private String name;
    private String value;
    private boolean inline;

    /**
     * set field inline
     * @param inline field inline
     * @return this
     */
    public EmbedField setInline(boolean inline) {
        this.inline = inline;
        return this;
    }

    /**
     * set field value (max 256 characters)
     * @param value field value
     * @return this
     */
    public EmbedField setValue(String value) {
        if (value.length() > 1024) {
            throw new IllegalArgumentException("Field value length can't be > 1024");
        }
        this.value = value;
        return this;
    }

    /**
     * set field name (max 256 characters)
     * @param name field name
     * @return this
     */
    public EmbedField setName(String name) {
        if (name.length() > 256) {
            throw new IllegalArgumentException("Field name length can't be > 256");
        }
        this.name = name;
        return this;
    }

    /**
     * @return field name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return field value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @return true if display inline
     */
    public boolean isInline() {
        return this.inline;
    }
}