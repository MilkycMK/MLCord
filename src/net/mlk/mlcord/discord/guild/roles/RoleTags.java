package net.mlk.mlcord.discord.guild.roles;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;

public class RoleTags implements JsonConvertible {
    private String bot_id;
    private String integration_id;
    @JsonField(type = String.class)
    private String premium_subscriber;
    @JsonField(type = String.class)
    private String available_for_purchase;
    @JsonField(type = String.class)
    private String guild_connections;
    private String subscription_listing_id;

    /**
     * @return the id of this role's subscription sku and listing
     */
    public String getSubscriptionListingId() {
        return this.subscription_listing_id;
    }

    /**
     * @return true if this role is a guild's linked role
     */
    public boolean isLinkedRole() {
        return this.guild_connections != null;
    }

    /**
     * @return true if this role is available for purchase
     */
    public boolean canPurchase() {
        return this.available_for_purchase != null;
    }

    /**
     * @return true if this is the guild's Booster role
     */
    public boolean isPremiumSubscriber() {
        return this.premium_subscriber != null;
    }

    /**
     * @return the id of the bot this role belongs to
     */
    public String getBotId() {
        return this.bot_id;
    }

    /**
     * @return the id of the integration this role belongs to
     */
    public String getIntegrationId() {
        return this.integration_id;
    }
}
