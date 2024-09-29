package net.mlk.mlcord.discord.emoji;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.emoji.util.StickerFormat;
import net.mlk.mlcord.discord.emoji.util.StickerType;
import net.mlk.mlcord.discord.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sticker implements JsonConvertible {
    private String id;
    private String pack_id;
    private String name;
    private String description;
    private String tags;
    private int type;
    private int format_type;
    private boolean available;
    private String guild_id;
    private User user;
    private int sort_value;

    /**
     * @return the standard sticker's sort order within its pack
     */
    public int getSortValue() {
        return this.sort_value;
    }

    /**
     * @return the user that uploaded the guild sticker
     */
    public User getUser() {
        return this.user;
    }

    /**
     * @return id of the guild that owns this sticker
     */
    public String getGuildId() {
        return this.guild_id;
    }

    /**
     * @return true if this guild sticker can be used, may be false due to loss of Server Boosts
     */
    public boolean isAvailable() {
        return this.available;
    }

    /**
     * @return format type raw value
     */
    public int getFormatTypeRaw() {
        return this.format_type;
    }

    /**
     * @return format type
     */
    public StickerFormat getFormatType() {
        return StickerFormat.getByCode(this.format_type);
    }

    /**
     * @return raw type value
     */
    public int getTypeRaw() {
        return this.type;
    }

    /**
     * @return type value
     */
    public StickerType getType() {
        return StickerType.getByCode(this.type);
    }

    /**
     * @return raw autocomplete/suggestion tags for the sticker (max 200 characters)
     */
    public String getTagsRaw() {
        return this.tags;
    }

    /**
     * @return autocomplete/suggestion tags for the sticker (max 200 characters)
     */
    public List<String> getTags() {
        return new ArrayList<>(Arrays.asList(this.tags.split(",")));
    }

    /**
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return sticker name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return stickers pack id
     */
    public String getPackId() {
        return this.pack_id;
    }

    /**
     * @return id
     */
    public String getId() {
        return this.id;
    }
}
