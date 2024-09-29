package net.mlk.mlcord.discord.guild.roles;


import net.mlk.jmson.utils.JsonConvertible;

public class RoleSubscriptionData implements JsonConvertible {
    private String role_subscription_listing_id;
    private String tier_name;
    private int total_months_subscribed;
    private boolean is_renewal;

    /**
     * @return the id of the sku and listing that the user is subscribed to
     */
    public String getId() {
        return this.role_subscription_listing_id;
    }

    /**
     * @return the name of the tier that the user is subscribed to
     */
    public String getTierName() {
        return this.tier_name;
    }

    /**
     * @return the cumulative number of months that the user has been subscribed for
     */
    public int getMonthsSubscribed() {
        return this.total_months_subscribed;
    }

    /**
     * @return whether this notification is for a renewal rather than a new purchase
     */
    public boolean isRenewal() {
        return this.is_renewal;
    }
}
