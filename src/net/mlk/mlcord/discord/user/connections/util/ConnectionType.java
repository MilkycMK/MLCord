package net.mlk.mlcord.discord.user.connections.util;

public enum ConnectionType {
    NONE(""),
    BATTLENET("Battle.net"),
    EBAY("eBay"),
    EPICGAMES("Epic Games"),
    FACEBOOK("Facebook"),
    GITHUB("GitHub"),
    INSTAGRAM("Instagram"),
    LEGUEOFLEGENDS("League of Legends"),
    PAYPAL("PayPal"),
    PLAYSTATION("PlayStation Network"),
    REDDIT("Reddit"),
    RIOTGAMES("Riot Games"),
    SPOTIFY("Spotify"),
    STEAM("Steam"),
    TIKTOK("TikTok"),
    TWITCH("Twitch"),
    TWITTER("Twitch"),
    XBOX("Xbox"),
    YOUTUBE("YouTube"),

    /*
     not working more
     */
    SKYPE("Skype");

    private final String name;
    ConnectionType(String name) {
        this.name = name;
    }

    /**
     * @return connection name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name name of the connection
     * @return connection
     */
    public static ConnectionType getByName(String name) {
        for (ConnectionType type : values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return NONE;
    }

}
