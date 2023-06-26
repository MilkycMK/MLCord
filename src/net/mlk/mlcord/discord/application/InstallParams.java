package net.mlk.mlcord.discord.application;

import net.mlk.mlcord.discord.application.util.ApplicationScope;
import net.mlk.mlcord.discord.guild.util.GuildPermission;

import java.util.ArrayList;
import java.util.List;

public class InstallParams {
    private final List<String> scopes = new ArrayList<>();
    private long permissions;

    /**
     * @return scopes raw list
     */
    public List<String> getScopesRaw() {
        return this.scopes;
    }

    /**
     * @return scopes list
     */
    public List<ApplicationScope> getScopes() {
        return ApplicationScope.getByName(this.getScopesRaw());
    }

    /**
     * @return permissions raw
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
}
