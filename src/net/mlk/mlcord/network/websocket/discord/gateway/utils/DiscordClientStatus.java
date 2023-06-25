package net.mlk.mlcord.network.websocket.discord.gateway.utils;

public enum DiscordClientStatus {
    /*
     undefined status
     */
    UNDEFINED,

    /*
     User's status set for an active desktop (Windows, Linux, Mac) application session
     */
    DESKTOP,

    /*
     User's status set for an active mobile (iOS, Android) application session
     */
    MOBILE,

    /*
     User's status set for an active web (browser, bot user) application session
     */
    WEB;

    public static DiscordClientStatus getByName(String name) {
        for (DiscordClientStatus status : values()) {
            if (status.name().equalsIgnoreCase(name)) {
                return status;
            }
        }
        return UNDEFINED;
    }
}
