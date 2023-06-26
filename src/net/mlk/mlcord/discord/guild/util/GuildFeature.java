package net.mlk.mlcord.discord.guild.util;

import java.util.ArrayList;
import java.util.List;

public enum GuildFeature {
    /*
     guild has access to set an animated guild banner image
     */
    ANIMATED_BANNER,

    /*
     guild has access to set an animated guild icon
     */
    ANIMATED_ICON,

    /*
     guild is using the old permissions configuration behavior
     */
    APPLICATION_COMMAND_PERMISSIONS_V2,

    /*
     guild has set up auto moderation rules
     */
    AUTO_MODERATION,

    /*
     guild has access to set a guild banner image
     */
    BANNER,

    /*
     guild can enable welcome screen, Membership Screening, stage channels and discovery, and receives community updates
     */
    COMMUNITY(GuildPermission.ADMINISTRATOR),

    /*
     guild has enabled monetization
     */
    CREATOR_MONETIZABLE_PROVISIONAL,

    /*
     guild has enabled the role subscription promo page
     */
    CREATOR_STORE_PAGE,

    /*
     guild has been set as a support server on the App Directory
     */
    DEVELOPER_SUPPORT_SERVER,

    /*
     guild is able to be discovered in the directory
     */
    DISCOVERABLE(GuildPermission.ADMINISTRATOR),

    /*
     guild is able to be featured in the directory
     */
    FEATURABLE,

    /*
     guild has paused invites, preventing new users from joining
     */
    INVITES_DISABLED(GuildPermission.MANAGE_GUILD),

    /*
     guild has access to set an invite splash background
     */
    INVITE_SPLASH,

    /*
     guild has enabled Membership Screening
     */
    MEMBER_VERIFICATION_GATE_ENABLED,

    /*
     guild has increased custom sticker slots
     */
    MORE_STICKERS,

    /*
     guild has access to create announcement channels
     */
    NEWS,

    /*
     guild is partnered
     */
    PARTNERED,

    /*
     guild can be previewed before joining via Membership Screening or the directory
     */
    PREVIEW_ENABLED,

    /*
     guild has disabled alerts for join raids in the configured safety alerts channel
     */
    RAID_ALERTS_DISABLED(GuildPermission.MANAGE_GUILD),

    /*
     guild is able to set role icons
     */
    ROLE_ICONS,

    /*
     guild has role subscriptions that can be purchased
     */
    ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE,

    /*
     guild has enabled role subscriptions
     */
    ROLE_SUBSCRIPTIONS_ENABLED,

    /*
     guild has enabled ticketed events
     */
    TICKETED_EVENTS_ENABLED,

    /*
     guild has access to set a vanity URL
     */
    VANITY_URL,

    /*
     guild is verified
     */
    VERIFIED,

    /*
     guild has access to set 384kbps bitrate in voice (previously VIP voice servers)
     */
    VIP_REGIONS,

    /*
     guild has enabled the welcome screen
     */
    WELCOME_SCREEN_ENABLED;

    private final GuildPermission permission;
    private final boolean mutable;
    GuildFeature() {
        this.permission = GuildPermission.UNDEFINED;
        this.mutable = false;
    }
    GuildFeature(GuildPermission permission) {
        this.permission = permission;
        this.mutable = true;
    }

    /**
     * @return true if mutable
     */
    public boolean isMutable() {
        return this.mutable;
    }

    /**
     * @return permission needed for feature
     */
    public GuildPermission getPermission() {
        return this.permission;
    }

    /**
     * @param names list with string names
     * @return list with features
     */
    public static List<GuildFeature> getByNames(List<String> names) {
        List<GuildFeature> features = new ArrayList<>();
        for (GuildFeature feature : values()) {
            for (String name : names) {
                if (feature.name().equalsIgnoreCase(name)) {
                    features.add(feature);
                }
            }
        }
        return features;
    }

}
