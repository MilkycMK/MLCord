package net.mlk.mlcord.discord.guild;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.channel.Channel;
import net.mlk.mlcord.discord.channel.stage.StageInstance;
import net.mlk.mlcord.discord.channel.util.SystemChannelFlag;
import net.mlk.mlcord.discord.emoji.Emoji;
import net.mlk.mlcord.discord.emoji.Sticker;
import net.mlk.mlcord.discord.guild.member.Member;
import net.mlk.mlcord.discord.guild.roles.Role;
import net.mlk.mlcord.discord.guild.scheduled.ScheduledEvent;
import net.mlk.mlcord.discord.guild.util.*;
import net.mlk.mlcord.discord.guild.welcome.WelcomeScreen;
import net.mlk.mlcord.discord.user.voice.VoiceState;
import net.mlk.mlcord.discord.utils.ImageFormat;
import net.mlk.mlcord.discord.utils.Locale;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.PresenceUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Guild implements JsonConvertible {
    private String id;
    private String owner_id;
    private String name;
    private String icon;
    private String icon_hash;
    private String splash;
    private String discovery_splash;
    private boolean unavailable;
    private boolean owner;
    private long permissions;
    private String afk_channel_id;
    private int afk_timeout;
    private boolean widget_enabled;
    private String widget_channel_id;
    private int verification_level;
    private int default_message_notifications;
    private int explicit_content_filter;
    private final List<Role> roles = new ArrayList<>();
    private final List<Emoji> emojis = new ArrayList<>();
    private final List<String> features = new ArrayList<>();
    private int mfa_level;
    private String application_id;
    private String system_channel_id;
    private long system_channel_flags;
    private String rules_channel_id;
    private String max_presences;
    private int max_members;
    private String vanity_url_code;
    private String description;
    private String banner;
    private int premium_tier;
    private int premium_subscription_count;
    private String preferred_locale;
    private String public_updates_channel_id;
    private int max_video_channel_users;
    private int max_stage_video_channel_users;
    private int approximate_member_count;
    private int approximate_presence_count;
    private WelcomeScreen welcome_screen;
    private int nsfw_level;
    private final List<Sticker> stickers = new ArrayList<>();
    private boolean premium_progress_bar_enabled;
    private String safety_alerts_channel_id;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime joined_at;
    private boolean large;
    private int member_count;
    private final List<VoiceState> voice_states = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Channel> channels = new ArrayList<>();
    private final List<Channel> threads = new ArrayList<>();
    private final List<PresenceUpdate> presences = new ArrayList<>();
    private final List<StageInstance> stage_instances = new ArrayList<>();
    private final List<ScheduledEvent> guild_scheduled_events = new ArrayList<>();

    /**
     * @return Scheduled events in the guild
     */
    public List<ScheduledEvent> getScheduledEvents() {
        return this.guild_scheduled_events;
    }

    /**
     * @return Stage instances in the guild
     */
    public List<StageInstance> getStageInstances() {
        return this.stage_instances;
    }

    /**
     * @return Presences of the members in the guild, will only include non-offline members if the size is greater than large threshold
     */
    public List<PresenceUpdate> getPresences() {
        return this.presences;
    }

    /**
     * @return All active threads in the guild that current user has permission to view
     */
    public List<Channel> getThreads() {
        return this.threads;
    }

    /**
     * @return Channels in the guild
     */
    public List<Channel> getChannels() {
        return this.channels;
    }

    /**
     * @return list with members
     */
    public List<Member> getMembers() {
        return this.members;
    }

    /**
     * @return list with voice states
     */
    public List<VoiceState> getVoiceStates() {
        return this.voice_states;
    }

    /**
     * @return Total number of members in this guild
     */
    public int getMemberCont() {
        return this.member_count;
    }

    /**
     * @return true if this is considered a large guild
     */
    public boolean isLarge() {
        return this.large;
    }

    /**
     * @return When this guild was joined at
     */
    public LocalDateTime getJoinedAt() {
        return this.joined_at;
    }

    /**
     * @return safety alerts channel id
     */
    public String getSafetyAlertsChannelId() {
        return this.safety_alerts_channel_id;
    }

    /**
     * @return if the guild has the boost progress bar enabled
     */
    public boolean isBoostBarEnabled() {
        return this.premium_progress_bar_enabled;
    }

    /**
     * @return guild stickers
     */
    public List<Sticker> getStickers() {
        return this.stickers;
    }

    /**
     * @return raw nsfw level value
     */
    public int getNsfwLevelRaw() {
        return this.nsfw_level;
    }

    /**
     * @return nsfw level value
     */
    public GuildNsfwLevel getNsfwLevel() {
        return GuildNsfwLevel.getByCode(this.nsfw_level);
    }

    /**
     * @return guild welcome screen
     */
    public WelcomeScreen getWelcomeScreen() {
        return this.welcome_screen;
    }

    /**
     * @return approximate number of non-offline members in this guild
     */
    public int getApproximatePresenceCount() {
        return this.approximate_presence_count;
    }

    /**
     * @return approximate number of members in this guild
     */
    public int getApproximateMemberCount() {
        return this.approximate_member_count;
    }

    /**
     * @return max stage video channel users
     */
    public int getMaxStageVideoChannelUsers() {
        return this.max_stage_video_channel_users;
    }

    /**
     * @return max video channel users
     */
    public int getMaxVideoChannelUsers() {
        return this.max_video_channel_users;
    }

    /**
     * @return public updates channel id
     */
    public String getPublicUpdatesChannelId() {
        return this.public_updates_channel_id;
    }

    /**
     * @return raw locale value
     */
    public String getPreferredLocaleRaw() {
        return this.preferred_locale;
    }

    /**
     * @return locale value
     */
    public Locale getPrefferedLocale() {
        return Locale.getLocale(this.preferred_locale);
    }

    /**
     * @return number of guild boosts
     */
    public int getBoostsCount() {
        return this.premium_subscription_count;
    }

    /**
     * @return raw value of premium tier
     */
    public int getPremiumTierRaw() {
        return this.premium_tier;
    }

    /**
     * @return premium tier
     */
    public GuildPremiumTier getPremiumTier() {
        return GuildPremiumTier.getByCode(this.premium_tier);
    }

    /**
     * @return banner hash
     */
    public String getBannerHash() {
        return this.banner;
    }

    /**
     * @return guild banner url
     */
    public String getBannerUrl() {
        return this.getBannerUrl(ImageFormat.PNG);
    }

    /**
     * @param format image format to recieve
     * @return guild banner url
     * @see Discord
     * @see ImageFormat
     */
    public String getBannerUrl(ImageFormat format) {
        return String.format(Discord.GUILD_BANNER_URL, this.id, this.banner, format);
    }

    /**
     * @return guild description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return vanity url code for guild
     */
    public String getVanityUrlCode() {
        return this.vanity_url_code;
    }

    /**
     * @return max members count for guild
     */
    public int getMaxMembers() {
        return this.max_members;
    }

    /**
     * @return max presences for guild
     */
    public int getMaxPresences() {
        return this.max_presences == null ? 0 : Integer.parseInt(this.max_presences);
    }

    /**
     * @return rules channel id
     */
    public String getRulesChannelId() {
        return this.rules_channel_id;
    }

    /**
     * @return raw system channel flags
     */
    public long getSystemChannelFlagsRaw() {
        return this.system_channel_flags;
    }

    /**
     * @return system channel flags
     */
    public List<SystemChannelFlag> getSystemChannelFlags() {
        return SystemChannelFlag.getFlags(this.system_channel_flags);
    }

    /**
     * @return the id of the channel where guild notices such as welcome messages and boost events are posted
     */
    public String getSystemChannelId() {
        return this.system_channel_id;
    }

    /**
     * @return application id of the guild creator if it is bot-created
     */
    public String getApplicationId() {
        return this.application_id;
    }

    /**
     * @return raw mfa level of guild
     */
    public int getMfaLevelRaw() {
        return this.mfa_level;
    }

    /**
     * @return mfa level of guild
     */
    public GuildMfaLevel getMfaLevel() {
        return GuildMfaLevel.getByCode(this.mfa_level);
    }

    /**
     * @return guild features raw
     */
    public List<String> getFeaturesRaw() {
        return this.features;
    }

    /**
     * @return guild features
     */
    public List<GuildFeature> getFeatures() {
        return GuildFeature.getByNames(this.features);
    }

    /**
     * @return list with guild emojis
     */
    public List<Emoji> getEmojis() {
        return this.emojis;
    }

    /**
     * @return list with guild roles
     */
    public List<Role> getRoles() {
        return this.roles;
    }

    /**
     * @return content filter level raw
     */
    public int getContentFilterRaw() {
        return this.explicit_content_filter;
    }

    /**
     * @return content filter level
     */
    public GuildContentFilterLevel getContentFilter() {
        return GuildContentFilterLevel.getByCode(this.explicit_content_filter);
    }

    /**
     * @return raw message notification level
     */
    public int getMessageNotificationLevelRaw() {
        return this.default_message_notifications;
    }

    /**
     * @return message notification level
     */
    public GuildMessageNotificationLevel getMessageNotificationLevel() {
        return GuildMessageNotificationLevel.getByCode(this.verification_level);
    }

    /**
     * @return raw verification level
     */
    public int getVerificationLevelRaw() {
        return this.verification_level;
    }

    /**
     * @return verification level
     */
    public GuildVerificationLevel getVerificationLevel() {
        return GuildVerificationLevel.getByCode(this.verification_level);
    }

    /**
     * @return widget channel id
     */
    public String getWidgetChannelId() {
        return this.widget_channel_id;
    }

    /**
     * @return true if server widget enabled
     */
    public boolean isWidgetEnabled() {
        return this.widget_enabled;
    }

    /**
     * @return afk timeout in seconds
     */
    public int getAfkTimeout() {
        return this.afk_timeout;
    }

    /**
     * @return afk channel id if exists
     */
    public String getAfkChannelId() {
        return this.afk_channel_id;
    }

    /**
     * @return raw user permissions
     */
    public long getPermissionsRaw() {
        return this.permissions;
    }

    /**
     * @return user permissions
     */
    public List<GuildPermission> getPermissions() {
        return GuildPermission.getFlags(this.permissions);
    }

    /**
     * @return true if current user is owner
     */
    public boolean isOwner() {
        return this.owner;
    }

    /**
     * @return splash hash
     */
    public String getSplashHash() {
        return this.splash;
    }

    /**
     * @return splash url
     */
    public String getSplashUrl() {
        return this.getSplashUrl(ImageFormat.PNG);
    }

    /**
     * @param format format to get
     * @see Discord
     * @see ImageFormat
     * @return splash url
     */
    public String getSplashUrl(ImageFormat format) {
        return String.format(Discord.GUILD_SPLASH_URL, this.id, this.splash, format);
    }

    /**
     * @return discovery splash hash
     */
    public String getDiscoverySplashHash() {
        return this.discovery_splash;
    }

    /**
     * @return discovery splash url
     */
    public String getDiscoverySplashUrl() {
        return this.getDiscoverySplashUrl(ImageFormat.PNG);
    }

    /**
     * @param format format to get
     * @see Discord
     * @see ImageFormat
     * @return discovery splash url
     */
    public String getDiscoverySplashUrl(ImageFormat format) {
        return String.format(Discord.GUILD_DISCOVERY_SPLASH_URL, this.id, this.discovery_splash, format);
    }

    /**
     * @return template icon hash
     */
    public String getTemplateIconHash() {
        return this.icon_hash;
    }

    /**
     * @return template icon url
     */
    public String getTemplateIconUrl() {
        return this.getTemplateIconUrl(ImageFormat.PNG);
    }

    /**
     * @param format format to get
     * @see Discord
     * @see ImageFormat
     * @return template icon url
     */
    public String getTemplateIconUrl(ImageFormat format) {
        return String.format(Discord.GUILD_ICON_URL, this.id, this.icon_hash, format);
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
        return String.format(Discord.GUILD_ICON_URL, this.id, this.icon, format);
    }

    /**
     * @return guild name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return true if unavailable
     */
    public boolean isUnavailable() {
        return this.unavailable;
    }

    /**
     * @return guild id
     */
    public String getId() {
        return this.id;
    }
}
