package net.mlk.mlcord.discord.guild.roles;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.guild.util.GuildPermission;
import net.mlk.mlcord.discord.utils.ImageFormat;

import java.util.List;

public class Role implements JsonConvertible {
    private String id;
    private String name;
    private int color;
    private boolean hoist;
    private String icon;
    private String unicode_emoji;
    private int position;
    private long permissions;
    private boolean managed;
    private boolean mentionable;
    private RoleTags tags;

    /**
     * @return role tags
     */
    public RoleTags getTags() {
        return this.tags;
    }

    /**
     * @return true if this tole is mentionable
     */
    public boolean isMentionable() {
        return this.mentionable;
    }

    /**
     * @return true if this role is managed by an integration
     */
    public boolean isManaged() {
        return this.managed;
    }

    /**
     * @return permissions raw
     */
    public long getPermissionsRaw() {
        return this.permissions;
    }

    /**
     * @return role permission
     */
    public List<GuildPermission> getPermissions() {
        return GuildPermission.getFlags(this.permissions);
    }

    /**
     * @return position of this role
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * @return role unicode emoji
     */
    public String getUnicodeEmoji() {
        return this.unicode_emoji;
    }

    /**
     * @return icon hash
     */
    public String getIconHash() {
        return this.icon;
    }

    /**
     * @return url to icon
     */
    public String getIconHashUrl() {
        return this.getIconHashUrl(ImageFormat.PNG);
    }

    /**
     * @param format format to get
     * @return url to icon with format
     */
    public String getIconHashUrl(ImageFormat format) {
        return String.format(Discord.ROLE_ICON_URL, this.id, this.icon, format);
    }

    /**
     * @return true if this role is pinned in the user listing
     */
    public boolean isPinned() {
        return this.hoist;
    }

    /**
     * @return role colore
     */
    public int getColor() {
        return this.color;
    }

    /**
     * @return role name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return role id
     */
    public String getId() {
        return this.id;
    }
}
