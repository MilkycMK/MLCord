package net.mlk.mlcord.discord.guild.util;

public enum GuildNsfwLevel {
    UNDEFINED(-1),
    DEFAULT(0),
    EXPLICIT(1),
    SAFE(2),
    AGE_RESTRICTED(3);

    private final int code;
    GuildNsfwLevel(int code) {
        this.code = code;
    }

    /**
     * @return level code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code level code
     * @return level
     */
    public static GuildNsfwLevel getByCode(int code) {
        for (GuildNsfwLevel level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        return UNDEFINED;
    }
}
