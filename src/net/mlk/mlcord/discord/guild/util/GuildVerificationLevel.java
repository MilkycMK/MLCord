package net.mlk.mlcord.discord.guild.util;

public enum GuildVerificationLevel {
    UNDEFINED(-1),

    /*
     unrestricted
     */
    NONE(0),

    /*
     must have verified email on account
     */
    LOW(1),

    /*
     must be registered on Discord for longer than 5 minutes
     */
    MEDIUM(2),

    /*
     must be a member of the server for longer than 10 minutes
     */
    HIGH(3),

    /*
     must have a verified phone number
     */
    VERY_HIGH(4);

    private final int code;
    GuildVerificationLevel(int code) {
        this.code = code;
    }

    /**
     * @return verification level code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code code of level
     * @return level by code
     */
    public static GuildVerificationLevel getByCode(int code) {
        for (GuildVerificationLevel level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        return UNDEFINED;
    }
}
