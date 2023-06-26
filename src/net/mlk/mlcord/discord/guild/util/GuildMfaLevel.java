package net.mlk.mlcord.discord.guild.util;

public enum GuildMfaLevel {
    UNDEFINED(-1),
    NONE(0),
    ELEVATED(1);

    private final int code;
    GuildMfaLevel(int code) {
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
    public static GuildMfaLevel getByCode(int code) {
        for (GuildMfaLevel level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        return UNDEFINED;
    }
}
