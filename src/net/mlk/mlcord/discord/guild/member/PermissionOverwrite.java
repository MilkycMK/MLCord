package net.mlk.mlcord.discord.guild.member;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.guild.member.util.OverwriteType;
import net.mlk.mlcord.discord.guild.util.GuildPermission;

import java.util.List;

public class PermissionOverwrite implements JsonConvertible {
    private String id;
    private String type;
    private long allow;
    private long deny;

    /**
     * @return raw allow
     */
    public long getAllowRaw() {
        return this.allow;
    }

    /**
     * @return allow perms
     */
    public List<GuildPermission> getAllow() {
        return GuildPermission.getFlags(this.allow);
    }

    /**
     * @return raw deny
     */
    public long getDenyRaw() {
        return this.allow;
    }

    /**
     * @return deny perms
     */
    public List<GuildPermission> getDeny() {
        return GuildPermission.getFlags(this.allow);
    }

    /**
     * @return raw type
     */
    public String getTypeRaw() {
        return this.type;
    }

    /**
     * @return type
     */
    public OverwriteType getType() {
        return OverwriteType.getByName(this.type);
    }

    /**
     * @return role or user id
     */
    public String getId() {
        return this.id;
    }
}