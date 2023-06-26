package net.mlk.mlcord.discord.user;

import net.mlk.jmson.utils.JsonConvertible;

import java.util.ArrayList;
import java.util.List;

import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.guild.Guild;
import net.mlk.mlcord.discord.user.utils.UserPremiumUsageFlag;
import net.mlk.mlcord.discord.user.utils.UserPurchasedFlag;
import net.mlk.mlcord.discord.utils.ImageFormat;

public class ExtendedUser extends User implements JsonConvertible {
    private long purchased_flags;
    private long premium_usage_flags;
    private boolean premium;
    private String phone;
    private boolean nsfw_allowed;
    private boolean mobile;
    private String global_name;
    private String display_name;
    private boolean desktop;
    private String bio;
    private String banner_color;
    private String avatar_decoration;
    private final ArrayList<Guild> guilds = new ArrayList<>();

    /**
     * @return user guilds
     */
    public ArrayList<Guild> getGuilds() {
        return this.guilds;
    }

    /**
     * @return user avatar decoration hash
     */
    public String getAvatarDecorationHash() {
        return this.avatar_decoration;
    }

    /**
     * @return user avatar decoration url
     */
    public String getAvatarDecorationUrl() {
        return this.getAvatarDecorationUrl(ImageFormat.PNG);
    }

    /**
     * @param format format type
     * @return user avatar decoration url
     * @see Discord
     * @see ImageFormat
     */
    public String getAvatarDecorationUrl(ImageFormat format) {
        return String.format(Discord.AVATAR_DECORATION_URL, this.avatar_decoration, format);
    }

    /**
     * @return user banner color
     */
    public int getBannerColor() {
        return this.banner_color == null ? 0 : Integer.parseInt(this.banner_color);
    }

    /**
     * @return user biography
     */
    public String getBiography() {
        return this.bio;
    }

    /**
     * @return true if user use desktop
     */
    public boolean isDesktopUsing() {
        return this.desktop;
    }

    /**
     * @return user display name
     */
    public String getDisplayName() {
        return this.display_name;
    }

    /**
     * @return global user name
     */
    public String getGlobalName() {
        return this.global_name;
    }

    /**
     * @return true if user use mobile
     */
    public boolean isMobileUsing() {
        return this.mobile;
    }

    /**
     * @return true if user enable nsfw
     */
    public boolean isNsfwAllowed() {
        return this.nsfw_allowed;
    }

    /**
     * @return user phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * @return true if user has premium
     */
    public boolean isPremium() {
        return this.premium;
    }

    /**
     * @return user premium usage flags
     */
    public List<UserPremiumUsageFlag> getPremiumUsageFlags() {
        return UserPremiumUsageFlag.getFlags(this.premium_usage_flags);
    }

    /**
     * @return raw user premium usage flags
     */
    public long getPremiumUsageFlagsRaw() {
        return this.premium_usage_flags;
    }

    /**
     * @return user purchased flags
     */
    public List<UserPurchasedFlag> getPurchasedFlags() {
        return UserPurchasedFlag.getFlags(this.purchased_flags);
    }

    /**
     * @return raw user purchased flags
     */
    public long getPurchasedFlagsRaw() {
        return this.purchased_flags;
    }
}
