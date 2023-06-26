package net.mlk.mlcord.discord.emoji;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.emoji.util.StickerFormatType;

public class StickerItem implements JsonConvertible {
    private String id;
    private String name;
    private int format_type;

    /**
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return raw format
     */
    public int getFormatRaw() {
        return this.format_type;
    }

    /**
     * @return format
     */
    public StickerFormatType getFormat() {
        return StickerFormatType.getByCode(this.format_type);
    }
}