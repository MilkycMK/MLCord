package net.mlk.mlcord.discord.guild.member;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.guild.member.util.MemberFlag;
import net.mlk.mlcord.discord.guild.util.GuildPermission;
import net.mlk.mlcord.discord.user.User;
import net.mlk.mlcord.discord.utils.ImageFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Member implements JsonConvertible {
    private User user;
    private String nick;
    private String avatar;
    private final List<String> roles = new ArrayList<>();
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime joined_at;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime premium_since;
    private boolean deaf;
    private boolean mute;
    private long flags;
    private boolean pending;
    private long permissions;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime communication_disabled_until;

    /**
     * @return date until unmute
     */
    public LocalDateTime getUnmuteDate() {
        return this.communication_disabled_until;
    }

    /**
     * @return raw permissions value
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
     * @return true if the user has not yet passed the guild's Membership Screening requirements
     */
    public boolean isPending() {
        return this.pending;
    }

    /**
     * @return raw flags value
     */
    public long getFlagsRaw() {
        return this.flags;
    }

    /**
     * @return flags
     */
    public List<MemberFlag> getFlags() {
        return MemberFlag.getFlags(this.flags);
    }

    /**
     * @return true if the user is muted in voice channels
     */
    public boolean isMute() {
        return this.mute;
    }

    /**
     * @return true if the user is deafened in voice channels
     */
    public boolean isDeaf() {
        return this.deaf;
    }

    /**
     * @return member boost date
     */
    public LocalDateTime getBoostDate() {
        return this.premium_since;
    }

    /**
     * @return date when user joined
     */
    public LocalDateTime getJoinDate() {
        return this.joined_at;
    }

    /**
     * @return member roles
     */
    public List<String> getRoles() {
        return this.roles;
    }

    /**
     * @return user avatar hash
     */
    public String getAvatarHash() {
        return this.avatar;
    }

    /**
     * @param guildId id of the user guild
     * @return user avatar url
     */
    public String getAvatarUrl(String guildId) {
        return this.getAvatarUrl(guildId, ImageFormat.PNG);
    }

    /**
     * @param guildId id of the user guild
     * @param format image format to receive
     * @return user avatar url
     * @see Discord
     * @see ImageFormat
     */
    public String getAvatarUrl(String guildId, ImageFormat format) {
        return String.format(Discord.GUILD_MEMBER_AVATAR_URL, guildId, this.user.getId(), this.avatar, format);
    }

    /**
     * @return member's guild nickname
     */
    public String getNick() {
        return this.nick;
    }

    /**
     * @return user object
     */
    public User getUser() {
        return this.user;
    }
}
