package net.mlk.mlcord.discord.application;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.application.util.ApplicationFlag;
import net.mlk.mlcord.discord.user.User;
import net.mlk.mlcord.discord.utils.ImageFormat;
import net.mlk.mlcord.team.Team;

import java.util.ArrayList;
import java.util.List;

public class Application implements JsonConvertible {
    private String id;
    private String name;
    private String icon;
    private String description;
    private final List<String> rpc_origins = new ArrayList<>();
    private boolean bot_public;
    private boolean bot_require_code_grant;
    private String terms_of_service_url;
    private String privacy_policy_url;
    private User owner;
    private String verify_key;
    private Team team;
    private String guild_id;
    private String primary_sku_id;
    private String slug;
    private String cover_image;
    private long flags;
    private final List<String> tags = new ArrayList<>();
    private InstallParams install_params;
    private String custom_install_url;
    private String role_connections_verification_url;

    /**
     * @return the application's role connection verification entry point,
     * which when configured will render the app as a verification method in the guild role verification configuration
     */
    public String getRoleConnectionsVerificationUrl() {
        return this.role_connections_verification_url;
    }

    /**
     * @return the application's default custom authorization link, if enabled
     */
    public String getCustomInstallUrl() {
        return this.custom_install_url;
    }

    /**
     * @return settings for the application's default in-app authorization link, if enabled
     */
    public InstallParams getInstallParams() {
        return this.install_params;
    }

    /**
     * @return tags describing the content and functionality of the application
     */
    public List<String> getTags() {
        return this.tags;
    }

    /**
     * @return application flags
     */
    public List<ApplicationFlag> getFlags() {
        return ApplicationFlag.getFlags(this.flags);
    }

    /**
     * @return raw application flags
     */
    public long getFlagsRaw() {
        return this.flags;
    }

    /**
     * @return cover image hash
     */
    public String getCoverImageHash() {
        return this.cover_image;
    }

    /**
     * @return cover image url
     */
    public String getCoverImageUrl() {
        return this.getCoverImageUrl(ImageFormat.PNG);
    }

    /**
     * @param format image format to recieve
     * @return cover image url
     * @see Discord
     * @see ImageFormat
     */
    public String getCoverImageUrl(ImageFormat format) {
        return String.format(Discord.APPLICATION_COVER_URL, this.id, this.icon, format);
    }

    /**
     * @return if this application is a game sold on Discord, this field will be the URL slug that links to the store page
     */
    public String getSlug() {
        return this.slug;
    }

    /**
     * @return if this application is a game sold on Discord, this field will be the id of the "Game SKU" that is created, if exists
     */
    public String getSkuId() {
        return this.primary_sku_id;
    }

    /**
     * @return if this application is a game sold on Discord, this field will be the guild to which it has been linked
     */
    public String getGuildId() {
        return this.guild_id;
    }

    /**
     * @return if the application belongs to a team, this will be a list of the members of that team
     */
    public Team getTeam() {
        return this.team;
    }

    /**
     * @return the hex encoded key for verification in interactions and the GameSDK's
     */
    public String getVerifyKey() {
        return this.verify_key;
    }

    /**
     * @return application owner
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     * @return url of the app's privacy policy
     */
    public String getPrivacyPolicyUrl() {
        return this.privacy_policy_url;
    }

    /**
     * @return url of the app's terms of service
     */
    public String getTermsOfServiceUrl() {
        return this.terms_of_service_url;
    }

    /**
     * @return if true the app's bot will only join upon completion of the full oauth2 code grant flow
     */
    public boolean isRequireGrant() {
        return this.bot_require_code_grant;
    }

    /**
     * @return false if not public
     */
    public boolean isPublic() {
        return this.bot_public;
    }

    /**
     * @return list of rpc origin urls, if rpc is enabled
     */
    public List<String> getRpcOrigins() {
        return this.rpc_origins;
    }

    /**
     * @return application description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return application icon hash
     */
    public String getIconHash() {
        return this.icon;
    }

    /**
     * @return application icon url
     */
    public String getIconUrl() {
        return this.getIconUrl(ImageFormat.PNG);
    }

    /**
     * @param format image format to recieve
     * @return application icon url
     * @see Discord
     * @see ImageFormat
     */
    public String getIconUrl(ImageFormat format) {
        return String.format(Discord.APPLICATION_ICON_URL, this.id, this.icon, format);
    }

    /**
     * @return application name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return application id
     */
    public String getId() {
        return this.id;
    }
}
