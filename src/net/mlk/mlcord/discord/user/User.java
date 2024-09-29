package net.mlk.mlcord.discord.user;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.user.utils.UserFlag;
import net.mlk.mlcord.discord.user.utils.UserPremiumType;
import net.mlk.mlcord.discord.utils.ImageFormat;
import net.mlk.mlcord.discord.utils.Locale;
import net.mlk.mlcord.discord.Discord;

import java.util.List;

public class User implements JsonConvertible {
    private String id;
    private String username;
    private String discriminator;
    private String avatar;
    private boolean bot;
    private boolean system;
    private boolean mfa_enabled;
    private String banner;
    private String accent_color;
    private String locale;
    private boolean verified;
    private String email;
    private long flags;
    private int premium_type;
    private long public_flags;

    /**
     * @return user public flags raw
     */
    public long getPublicFlagsRaw() {
        return this.public_flags;
    }

    /**
     * @return user public flags
     */
    public List<UserFlag> getPublicFlags() {
        return UserFlag.getFlags(this.public_flags);
    }

    /**
     * @return user premium type raw
     */
    public int getPremiumTypeRaw() {
        return this.premium_type;
    }

    /**
     * @return user premium type
     */
    public UserPremiumType getPremiumType() {
        return UserPremiumType.getByCode(this.premium_type);
    }

    /**
     * @return user flags raw
     */
    public long getFlagsRaw() {
        return this.flags;
    }

    /**
     * @return list of user flags
     */
    public List<UserFlag> getFlags() {
        return UserFlag.getFlags(this.flags);
    }

    /**
     * @return user's email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return true if user has verified email
     */
    public boolean isVerified() {
        return this.verified;
    }

    /**
     * @return raw locale value
     */
    public String getLocaleRaw() {
        return this.locale;
    }

    /**
     * @return locale value
     */
    public Locale getLocale() {
        return Locale.getLocale(this.locale);
    }

    /**
     * @return user's banner color
     */
    public int getBannerColor() {
        return this.accent_color == null ? 0 : Integer.parseInt(this.accent_color);
    }

    /**
     * @return user banner hash
     */
    public String getBannerHash() {
        return this.banner;
    }

    /**
     * @return user banner url or null
     */
    public String getBannerUrl() {
        return this.getBannerUrl(ImageFormat.PNG);
    }

    /**
     * @param format image format to receive
     * @return user banner url or null
     * @see Discord
     * @see ImageFormat
     */
    public String getBannerUrl(ImageFormat format) {
        if (this.banner == null) {
            return null;
        }
        return String.format(Discord.USER_BANNER_URL, this.id, this.banner, format);
    }

    /**
     * @return true if 2FA is enabled
     */
    public boolean isMfaEnabled() {
        return this.mfa_enabled;
    }

    /**
     * @return true if system user
     */
    public boolean isSystem() {
        return this.system;
    }

    /**
     * @return true if bot
     */
    public boolean isBot() {
        return this.bot;
    }

    /**
     * @return user avatar hash
     */
    public String getAvatarHash() {
        return this.avatar;
    }

    /**
     * @return user avatar url
     */
    public String getAvatarUrl() {
        return this.getAvatarUrl(ImageFormat.PNG);
    }

    /**
     * @param format image format to receive
     * @return user avatar url
     * @see Discord
     * @see ImageFormat
     */
    public String getAvatarUrl(ImageFormat format) {
        return String.format(Discord.USER_AVATAR_URL, this.id, this.avatar, format);
    }

    /**
     * @return user discriminator
     */
    public String getDiscriminator() {
        return this.discriminator;
    }

    /**
     * @return user name
     */
    public String getName() {
        return this.username;
    }

    /**
     * @return user id
     */
    public String getId() {
        return this.id;
    }
}
