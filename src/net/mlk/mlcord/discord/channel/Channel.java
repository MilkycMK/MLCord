package net.mlk.mlcord.discord.channel;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.channel.forum.ForumTag;
import net.mlk.mlcord.discord.channel.forum.util.ForumLayoutType;
import net.mlk.mlcord.discord.channel.forum.util.SortOrderType;
import net.mlk.mlcord.discord.channel.util.ChannelFlag;
import net.mlk.mlcord.discord.channel.util.ChannelType;
import net.mlk.mlcord.discord.channel.util.VideoQualityMode;
import net.mlk.mlcord.discord.emoji.DefaultReaction;
import net.mlk.mlcord.discord.guild.member.PermissionOverwrite;
import net.mlk.mlcord.discord.guild.util.GuildPermission;
import net.mlk.mlcord.discord.channel.thread.ThreadMember;
import net.mlk.mlcord.discord.channel.thread.ThreadMetadata;
import net.mlk.mlcord.discord.user.User;
import net.mlk.mlcord.discord.utils.ImageFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Channel implements JsonConvertible {
    private String id;
    private int type;
    private String guild_id;
    private int position;
    private final List<PermissionOverwrite> permission_overwrites = new ArrayList<>();
    private String name;
    private String topic;
    private boolean nsfw;
    private String last_message_id;
    private int bitrate;
    private int user_limit;
    private int rate_limit_per_user;
    private final List<User> recipients = new ArrayList<>();
    private String icon;
    private String owner_id;
    private String application_id;
    private boolean managed;
    private String parent_id;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime last_pin_timestamp;
    private String rtc_region;
    private int video_quality_mode;
    private ThreadMetadata thread_metadata;
    private ThreadMember member;
    private int default_auto_archive_duration;
    private long permissions;
    private long flags;
    private int total_message_sent;
    private final List<ForumTag> available_tags = new ArrayList<>();
    private final List<String> applied_tags = new ArrayList<>();
    private DefaultReaction default_reaction_emoji;
    private int default_thread_rate_limit_per_user;
    private String default_sort_order;
    private int default_forum_layout;

    /**
     * @return forum layout raw
     */
    public int getForumLayoutRaw() {
        return this.default_forum_layout;
    }

    /**
     * @return forum layout
     */
    public ForumLayoutType getForumLayout() {
        return ForumLayoutType.getByCode(this.default_forum_layout);
    }

    /**
     * @return raw default sort order type
     */
    public int getDefaultSortOrderTypeRaw() {
        return this.default_sort_order == null ? -1 : Integer.parseInt(this.default_sort_order);
    }

    /**
     * @return default sort order type
     */
    public SortOrderType getDefaultSortOrderType() {
        return SortOrderType.getByCode(this.getDefaultSortOrderTypeRaw());
    }

    /**
     * @return the initial rate_limit_per_user to set on newly created threads in a channel
     */
    public int getDefaultThreadRateLimit() {
        return this.default_thread_rate_limit_per_user;
    }

    /**
     * @return the emoji to show in the add reaction button on a thread in a GUILD_FORUM channel
     */
    public DefaultReaction getDefaultReaction() {
        return this.default_reaction_emoji;
    }

    /**
     * @return the IDs of the set of tags that have been applied to a thread in a GUILD_FORUM channel
     */
    public List<String> getAppliedTags() {
        return this.applied_tags;
    }

    /**
     * @return the list of tags that can be used in a GUILD_FORUM channel
     */
    public List<ForumTag> getAvailableTags() {
        return this.available_tags;
    }

    /**
     * @return number of messages ever sent in a thread
     */
    public int getTotalMessageCount() {
        return this.total_message_sent;
    }

    /**
     * @return raw flags
     */
    public long getFlagsRaw() {
        return this.flags;
    }

    /**
     * @return flags
     */
    public List<ChannelFlag> getFlags() {
        return ChannelFlag.getFlags(this.flags);
    }

    /**
     * @return raw permissions
     */
    public long getPermissionsRaw() {
        return this.permissions;
    }

    /**
     * @return permissions
     */
    public List<GuildPermission> getPermissions() {
        return GuildPermission.getFlags(this.permissions);
    }
    /**
     * @return default duration, threads will stop showing in the channel list after the specified period of inactivity
     */
    public int getAutoArchiveDuration() {
        return this.default_auto_archive_duration;
    }

    /**
     * @return thread member object for the current user
     */
    public ThreadMember getThreadMember() {
        return this.member;
    }

    /**
     * @return thread-specific fields not needed by other channels
     */
    public ThreadMetadata getThreadMetadata() {
        return this.thread_metadata;
    }

    /**
     * @return the camera video quality mode of the voice channel, 1 when not present
     */
    public int getVideoQualityModeRaw() {
        return this.video_quality_mode;
    }

    /**
     * @return video quality mode
     */
    public VideoQualityMode getVideoQualityMode() {
        return VideoQualityMode.getByCode(this.type);
    }

    /**
     * @return id for the voice channel, automatic when set to null
     */
    public String getRtcRegion() {
        return this.rtc_region;
    }

    /**
     * @return when the last pinned message was pinned
     */
    public LocalDateTime getLastPinTimestamp() {
        return this.last_pin_timestamp;
    }

    /**
     * @return id of the parent category for a channel
     */
    public String getParentId() {
        return this.parent_id;
    }

    /**
     * @return true if the channel is managed by an application via the gdm.join OAuth2 scope
     */
    public boolean isManaged() {
        return this.managed;
    }

    /**
     * @return application id of the group DM creator if it is bot-created
     */
    public String getApplicationId() {
        return this.application_id;
    }

    /**
     * @return channel owner
     */
    public String getOwnerId() {
        return this.owner_id;
    }

    /**
     * @return icon hash
     */
    public String getIconHash() {
        return this.icon;
    }

    /**
     * @return icon url
     */
    public String getIconUrl() {
        return this.getIconUrl(ImageFormat.PNG);
    }

    /**
     * @param format format to get
     * @see Discord
     * @see ImageFormat
     * @return icon url
     */
    public String getIconUrl(ImageFormat format) {
        return String.format(Discord.USER_AVATAR_URL, this.id, this.icon, format);
    }

    /**
     * @return the recipients of the DM
     */
    public List<User> getRecipients() {
        return this.recipients;
    }

    /**
     * @return amount of seconds a user has to wait before sending another message
     */
    public int getRateLimit() {
        return this.rate_limit_per_user;
    }

    /**
     * @return the user limit of the voice channel
     */
    public int getUserVoiceLimit() {
        return this.user_limit;
    }

    /**
     * @return the bitrate (in bits) of the voice channel
     */
    public int getVoiceBitrate() {
        return this.bitrate;
    }

    /**
     * @return channel's last message id
     */
    public String getLastMessageId() {
        return this.last_message_id;
    }

    /**
     * @return true if nsfw channel
     */
    public boolean isNsfw() {
        return this.nsfw;
    }

    /**
     * @return channel topic
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * @return channel name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return explicit permission overwrites for members and roles
     */
    public List<PermissionOverwrite> getPermissionOverwrites() {
        return this.permission_overwrites;
    }

    /**
     * @return sorted position of channel
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * @return guild id
     */
    public String getGuildId() {
        return this.guild_id;
    }

    /**
     * @return raw channel type value
     */
    public int getTypeRaw() {
        return this.type;
    }

    /**
     * @return channel type
     */
    public ChannelType getType() {
        return ChannelType.getByCode(this.type);
    }

    /**
     * @return channel id
     */
    public String getId() {
        return this.id;
    }
}
