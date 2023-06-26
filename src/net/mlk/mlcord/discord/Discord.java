package net.mlk.mlcord.discord;

public class Discord {
    //                                             2023-05-22T05:19:48+00:00
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][XXX]";

    public static final String GATEWAY_URL = "wss://gateway.discord.gg/";

    public static final String API = "https://discord.com/api/v10/";


    /**
     * get gateway (only websocket url)
     */
    public static final String GET_GATEWAY_API = API + "gateway";

    /**
     * get gateway bot (websocket url with some additional information)
     */
    public static final String GET_GATEWAY_BOT_API = GET_GATEWAY_API + "/bot";

    /*
        IMAGES API
     */
    /**
     * user id, banner hash, image format
     * PNG, JPEG, WebP, GIF
     */
    public static final String IMAGE_BASE = "https://cdn.discordapp.com/";


    /**
     * user id, banner hash, image format
     * PNG, JPEG, WebP, GIF
     */
    public static final String USER_BANNER_URL = IMAGE_BASE + "banners/%s/%s.%s";

    /**
     * user id, avatar hash, image format
     * PNG, JPEG, WebP, GIF
     */
    public static final String USER_AVATAR_URL = IMAGE_BASE + "avatars/%s/%s.%s";

    /**
     * avatar decoration hash, image format
     * PNG, JPG, JPEG, WEBP
     */
    public static final String AVATAR_DECORATION_URL = IMAGE_BASE + "avatar-decoration-presets/%s.%s";

    /**
     * guild id, banner hash, image format
     * PNG, JPEG, WebP, GIF
     */
    public static final String GUILD_BANNER_URL = IMAGE_BASE + "banners/%s/%s.%s";

    /**
     * guild id, splash hash, image format
     * PNG, JPEG, WebP
     */
    public static final String GUILD_SPLASH_URL = IMAGE_BASE + "splashes/%s/%s.%s";


    /**
     * guild id, discovery splash, image format
     * PNG, JPEG, WebP
     */
    public static final String GUILD_DISCOVERY_SPLASH_URL = IMAGE_BASE + "discovery-splashes/%s/%s.%s";

    /**
     * guild id, icon hash, image format
     * PNG, JPEG, WebP, GIF
     */
    public static final String GUILD_ICON_URL = IMAGE_BASE + "icons/%s/%s.%s";

    /**
     * application id, cover hash, image format
     * PNG, JPEG, WebP
     */
    public static final String APPLICATION_COVER_URL = IMAGE_BASE + "app-icons/%s/%s.%s";


    /**
     * application id, icon hash, image format
     * PNG, JPEG, WebP
     */
    public static final String APPLICATION_ICON_URL = IMAGE_BASE + "app-icons/%s/%s.%s";


    /**
     * scheduled event id, event cover image hash, image format
     * PNG, JPEG, WebP
     */
    public static final String GUILD_SCHEDULED_EVENT_COVER_URL = IMAGE_BASE + "guild-events/%s/%s.%s";

    /**
     * team id, icon hash, image format
     * PNG, JPEG, WebP
     */
    public static final String TEAM_ICON_URL = IMAGE_BASE + "team-icons/%s/%s.%s";

    /**
     * guild id, user_id, avatar hash, image format
     * PNG, JPEG, WebP, GIF
     */
    public static final String GUILD_MEMBER_AVATAR_URL = IMAGE_BASE + "guilds/%s/users/%s/avatars/%s.%s";

    /**
     * role id, role icon hash, image format
     * PNG, JPEG, WebP
     */
    public static final String ROLE_ICON_URL = IMAGE_BASE + "role-icons/%s/%s.%s";
}
