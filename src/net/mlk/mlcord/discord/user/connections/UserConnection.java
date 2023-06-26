package net.mlk.mlcord.discord.user.connections;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.guild.integrations.Integration;
import net.mlk.mlcord.discord.user.connections.util.ConnectionType;
import net.mlk.mlcord.discord.user.connections.util.ConnectionVisibility;

import java.util.ArrayList;
import java.util.List;

public class UserConnection implements JsonConvertible {
    private String id;
    private String name;
    private String type;
    private boolean revoked;
    private boolean verified;
    private boolean friend_sync;
    private boolean show_activity;
    private boolean two_way_link;
    private int visibility;
    private List<Integration> integrations = new ArrayList<>();

    /**
     * @return list with the integrations
     */
    public List<Integration> getIntegrations() {
        return this.integrations;
    }

    /**
     * @return raw visibility value
     */
    public int getVisibilityRaw() {
        return this.visibility;
    }

    /**
     * @return visibility value
     */
    public ConnectionVisibility getVisibility() {
        return ConnectionVisibility.getByCode(this.visibility);
    }

    /**
     * @return true if this connection has a corresponding third party OAuth2 token
     */
    public boolean isTwoWayLink() {
        return this.two_way_link;
    }

    /**
     * @return true if show activity enabled
     */
    public boolean isShowActivityEnabled() {
        return this.show_activity;
    }

    /**
     * @return true if friend sync enabled
     */
    public boolean isFriendSyncEnabled() {
        return this.friend_sync;
    }

    /**
     * @return true if verified
     */
    public boolean isVerified() {
        return this.verified;
    }

    /**
     * @return true if revoked
     */
    public boolean isRevoked() {
        return this.revoked;
    }

    /**
     * @return raw connection type
     */
    public String getTypeRaw() {
        return this.type;
    }

    /**
     * @return connection type
     */
    public ConnectionType getType() {
        return ConnectionType.getByName(this.type);
    }

    /**
     * @return connection name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return connection id
     */
    public String getId() {
        return this.id;
    }
}
