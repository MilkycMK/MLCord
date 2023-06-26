package net.mlk.mlcord.discord.guild.scheduled.util;

public enum ScheduledEntityType {
    UNDEFINED(-1),
    STAGE_INSTANCE(1),
    VOICE(2),
    EXTERNAL(3);

    private final int code;
    ScheduledEntityType(int code) {
        this.code = code;
    }

    /**
     * @return entity type code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code type code
     * @return type by code
     */
    public static ScheduledEntityType getByCode(int code) {
        for (ScheduledEntityType level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        return UNDEFINED;
    }
}
