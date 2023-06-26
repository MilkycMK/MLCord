package net.mlk.mlcord.discord.guild.integrations;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.application.util.OAuthScope;
import net.mlk.mlcord.discord.guild.integrations.util.IntegrationExpire;
import net.mlk.mlcord.discord.guild.integrations.util.IntegrationType;
import net.mlk.mlcord.discord.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Integration implements JsonConvertible {
    private String id;
    private String name;
    private String type;
    private boolean enabled;
    private boolean syncing;
    private String role_id;
    private boolean enable_emoticons;
    private int expire_behavior;
    private int expire_grace_period;
    private User user;
    private IntegrationAccount account;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime synced_at;
    private int subscriber_count;
    private boolean revoked;
    private IntegrationApplication application;
    private List<String> scopes = new ArrayList<>();

    /**
     * @return application object
     */
    public IntegrationApplication getApplication() {
        return this.application;
    }

    /**
     * @return raw scopes list
     */
    public List<String> getScopesRaw() {
        return this.scopes;
    }

    /**
     * @return scopes list
     */
    public List<OAuthScope> getScopes() {
        return OAuthScope.getByName(this.scopes);
    }

    /**
     * not provided for discord bot integrations
     * @return true if revoked
     */
    public boolean isRevoked() {
        return this.revoked;
    }

    /**
     * not provided for discord bot integrations
     * @return count of the integration accounts
     */
    public int getSubscribersCound() {
        return this.subscriber_count;
    }

    /**
     * not provided for discord bot integrations
     * @return last integration sync date
     */
    public LocalDateTime getLastSyncDate() {
        return this.synced_at;
    }

    /**
     * @return integration account
     */
    public IntegrationAccount getAccount() {
        return this.account;
    }

    /**
     * @return integration user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * @return grace period (in days) before expiring subscribers
     */
    public int getExpireGracePerion() {
        return this.expire_grace_period;
    }

    /**
     * @return expire behavior raw
     */
    public int getExpireBehaviorRaw() {
        return this.expire_behavior;
    }

    /**
     * @return expire behavior
     */
    public IntegrationExpire getExpireBehavior() {
        return IntegrationExpire.getByCode(this.expire_behavior);
    }

    /**
     * not provided for discord bot integrations
     * @return true if emoticons enabled (twitch only)
     */
    public boolean isEmoticonsEnabled() {
        return this.enable_emoticons;
    }

    /**
     * not provided for discord bot integrations
     * @return id for subscribers
     */
    public String getRoleId() {
        return this.role_id;
    }

    /**
     * not provided for discord bot integrations
     * @return true if integration syncing
     */
    public boolean isSyncing() {
        return this.syncing;
    }

    /**
     * @return true if enabled
     */
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * @return raw integration type
     */
    public String getTypeRaw() {
        return this.type;
    }

    /**
     * @return integration type
     */
    public IntegrationType getType() {
        return IntegrationType.getByName(this.type);
    }

    /**
     * @return integration name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return integration id
     */
    public String getId() {
        return this.id;
    }
}
