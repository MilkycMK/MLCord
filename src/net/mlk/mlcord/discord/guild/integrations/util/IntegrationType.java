package net.mlk.mlcord.discord.guild.integrations.util;

public enum IntegrationType {
    UNDEFINED,
    TWITCH,
    YOUTUBE,
    DISCORD,
    GUILD_SUBSCRIPTION;

    /**
     * @param name raw integration name
     * @return type by name
     */
    public static IntegrationType getByName(String name) {
        for (IntegrationType type : values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return UNDEFINED;
    }
}
