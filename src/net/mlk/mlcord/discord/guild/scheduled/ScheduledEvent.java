package net.mlk.mlcord.discord.guild.scheduled;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.guild.scheduled.util.ScheduledEntityType;
import net.mlk.mlcord.discord.guild.scheduled.util.ScheduledStatus;
import net.mlk.mlcord.discord.guild.scheduled.util.ScheduledPrivacyLevel;
import net.mlk.mlcord.discord.user.User;
import net.mlk.mlcord.discord.utils.ImageFormat;

import java.time.LocalDateTime;

public class ScheduledEvent implements JsonConvertible {
    private String id;
    private String guild_id;
    private String channel_id;
    private String creator_id;
    private String name;
    private String description;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime scheduled_start_time;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime scheduled_end_time;
    private int privacy_level;
    private int status;
    private int entity_type;
    private String entity_id;
    private ScheduledEntityMetadata entity_metadata;
    private User creator;
    private int user_count;
    private String image;

    /**
     * @return cover image hash
     */
    public String getImageHash() {
        return this.image;
    }

    /**
     * @return cover image url
     */
    public String getTemplateIconUrl() {
        return this.getTemplateIconUrl(ImageFormat.PNG);
    }

    /**
     * @param format format to get
     * @see Discord
     * @see ImageFormat
     * @return cover image url
     */
    public String getTemplateIconUrl(ImageFormat format) {
        return String.format(Discord.GUILD_SCHEDULED_EVENT_COVER_URL, this.id, this.image, format);
    }

    /**
     * @return the number of users subscribed to the scheduled event
     */
    public int getUserCount() {
        return this.user_count;
    }

    /**
     * @return event creator object
     */
    public User getCreator() {
        return this.creator;
    }

    /**
     * @return additional metadata for the guild scheduled event
     */
    public ScheduledEntityMetadata getEntityMetadata() {
        return this.entity_metadata;
    }

    /**
     * @return the id of an entity associated with a guild scheduled event
     */
    public String getEntityId() {
        return this.entity_id;
    }

    /**
     * @return scheduled event type raw
     */
    public int getEntityTypeRaw() {
        return this.entity_type;
    }

    /**
     * @return the type of the scheduled event
     */
    public ScheduledEntityType getEntityType() {
        return ScheduledEntityType.getByCode(this.entity_type);
    }

    /**
     * @return event status raw value
     */
    public int getStatusRaw() {
        return this.status;
    }

    /**
     * @return event status
     */
    public ScheduledStatus getStatus() {
        return ScheduledStatus.getByCode(this.status);
    }

    /**
     * @return privacy level raw value
     */
    public int getPrivacyLevelRaw() {
        return this.privacy_level;
    }

    /**
     * @return privacy level
     */
    public ScheduledPrivacyLevel getPrivacyLevel() {
        return ScheduledPrivacyLevel.getByCode(this.privacy_level);
    }

    /**
     * @return the time the scheduled event will start
     */
    public LocalDateTime getStartTime() {
        return this.scheduled_start_time;
    }

    /**
     * @return the time the scheduled event will end
     */
    public LocalDateTime getEndTime() {
        return this.scheduled_end_time;
    }

    /**
     * @return event description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return event name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return event creator id
     */
    public String getCreatorId() {
        return this.creator_id;
    }

    /**
     * @return channel id
     */
    public String getChannelId() {
        return this.channel_id;
    }

    /**
     * @return guild id
     */
    public String getGuildId() {
        return this.guild_id;
    }

    /**
     * @return event id
     */
    public String getId() {
        return this.id;
    }
}
