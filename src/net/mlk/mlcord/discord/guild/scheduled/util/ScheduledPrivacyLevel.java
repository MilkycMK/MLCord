package net.mlk.mlcord.discord.guild.scheduled.util;

public enum ScheduledPrivacyLevel {
    UNDEFINED(-1),

    /*
     The Stage instance is visible to only guild members.
     */
    GUILD_ONLY(2);

    private final int code;
    ScheduledPrivacyLevel(int code) {
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
    public static ScheduledPrivacyLevel getByCode(int code) {
        for (ScheduledPrivacyLevel level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        return UNDEFINED;
    }
}
