package net.mlk.mlcord.discord.channel.stage.util;

public enum StagePrivacyLevel {
    UNDEFINED(-1),

    /*
     The Stage instance is visible publicly. (deprecated)
     */
    PUBLIC(1),

    /*
     The Stage instance is visible to only guild members.
     */
    GUILD_ONLY(2);

    private final int code;
    StagePrivacyLevel(int code) {
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
     * @return level by code
     */
    public static StagePrivacyLevel getByCode(int code) {
        for (StagePrivacyLevel level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        return UNDEFINED;
    }
}
