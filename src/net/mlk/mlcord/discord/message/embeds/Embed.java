package net.mlk.mlcord.discord.message.embeds;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.annotations.JsonObject;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.message.embeds.objects.*;
import net.mlk.mlcord.discord.message.embeds.util.EmbedType;
import net.mlk.mlcord.discord.utils.DiscordColor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonObject(ignoreNull = true)
public class Embed implements JsonConvertible {
    private String title;
    private String type;
    private String description;
    private String url;
    @JsonField(dateFormat= Discord.TIMESTAMP_FORMAT)
    private LocalDateTime timestamp;
    private int color;
    private EmbedFooter footer;
    private EmbedImage image;
    private EmbedThumbnail thumbnail;
    private EmbedVideo video;
    private EmbedProvider provider;
    private EmbedAuthor author;
    private final List<EmbedField> fields = new ArrayList<>();

    /**
     * @return true if can send
     */
    public boolean canSend() {
        return this.title != null || this.description != null || this.footer != null
                || this.image != null || this.thumbnail != null || this.video != null || this.provider != null
                || this.author != null;
    }

    /**
     * @return embed charachters length
     */
    public int getLength() {
        int length = 0;
        if (this.title != null) {
            length += this.title.length();
        }
        if (this.description != null) {
            length += this.description.length();
        }
        if (this.footer != null && this.footer.getText() != null) {
            length += this.footer.getText().length();
        }
        if (this.author != null && this.author.getName() != null) {
            length += this.author.getName().length();
        }
        for (EmbedField field : this.fields) {
            if (field != null) {
                length += field.getName().length() + field.getValue().length();
            }
        }
        return length;
    }

    /**
     * add embed field
     * @param field embed field
     * @return this
     */
    public Embed addEmbedField(EmbedField field) {
        if (this.fields.size() > 25) {
            throw new IllegalArgumentException("Fields count can't be > 25");
        }
        this.fields.add(field);
        return this;
    }

    /**
     * set embed author
     * @param author embed author
     * @return this
     */
    public Embed setAuthor(EmbedAuthor author) {
        this.author = author;
        return this;
    }

    /**
     * set embed provider
     * @param provider embed provider
     * @return this
     */
    public Embed setProvider(EmbedProvider provider) {
        this.provider = provider;
        return this;
    }

    /**
     * set embed video
     * @param video embed video
     * @return this
     */
    public Embed setVideo(EmbedVideo video) {
        this.video = video;
        return this;
    }

    /**
     * set embed thumbnail
     * @param thumbnail embed thumbnail
     * @return this
     */
    public Embed setThumbnail(EmbedThumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    /**
     * set embed image
     * @param image embed image
     * @return this
     */
    public Embed setImage(EmbedImage image) {
        this.image = image;
        return this;
    }

    /**
     * set embed footer
     * @param footer embed footer
     * @return this
     */
    public Embed setFooter(EmbedFooter footer) {
        this.footer = footer;
        return this;
    }

    /**
     * set color of embed
     * @param color color to set
     * @return this
     */
    public Embed setColor(int color) {
        this.color = color;
        return this;
    }

    /**
     * set color of embed
     * @param color color to set
     * @return this
     */
    public Embed setColor(DiscordColor color) {
        this.color = color.getColorCode();
        return this;
    }


    /**
     * set embed timestamp in ISO8601 (f. e: 2021-08-24T18:00:00.000Z)
     * @param timestamp embed timestamp
     * @return this
     */
    public Embed setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * set embed description
     * @param description embed description
     * @return this
     */
    public Embed setDescription(String description) {
        if (description.length() > 4096) {
            throw new IllegalArgumentException("Embed description length can't be > 4096");
        }
        this.description = description;
        return this;
    }

    /**
     * set embed type
     * @param type embed type
     * @return this
     * @see EmbedType
     */
    public Embed setType(EmbedType type) {
        this.type = type.name().toLowerCase();
        return this;
    }

    /**
     * set title to embed
     * @param title embed title
     * @return this
     */
    public Embed setTitle(String title) {
        if (title.length() > 256) {
            throw new IllegalArgumentException("Embed title length can't be > 256");
        }
        this.title = title;
        return this;
    }

    /**
     * @return embed fields
     */
    public List<EmbedField> getFields() {
        return this.fields;
    }

    /**
     * @return embed author
     */
    public EmbedAuthor getAuthor() {
        return this.author;
    }

    /**
     * @return embed provider
     */
    public EmbedProvider getProvider() {
        return this.provider;
    }

    /**
     * @return embed video
     */
    public EmbedVideo getVideo() {
        return this.video;
    }

    /**
     * @return embed thumbnail
     */
    public EmbedThumbnail getThumbnail() {
        return this.thumbnail;
    }

    /**
     * @return embed image
     */
    public EmbedImage getImage() {
        return this.image;
    }

    /**
     * @return embed footer
     */
    public EmbedFooter getFooter() {
        return this.footer;
    }

    /**
     * @return color code of embed
     */
    public int getColor() {
        return this.color;
    }

    /**
     * @return timestamp of embed content
     */
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    /**
     * @return embed url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @return embed description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return embed title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return embed type
     */
    public EmbedType getType() {
        return EmbedType.getByName(this.type);
    }

    /**
     * @return string type value
     */
    public String getTypeRaw() {
        return this.type;
    }
}
