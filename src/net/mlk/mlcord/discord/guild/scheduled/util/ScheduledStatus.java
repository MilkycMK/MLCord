package net.mlk.mlcord.discord.guild.scheduled.util;

public enum ScheduledStatus {
    UNDEFINED(-1, false),
    SCHEDULED(1, false),
    ACTIVE(2, false),
    COMPLETED(3, true),
    CANCELED(4, true);

    private final int code;
    private final boolean update;
    ScheduledStatus(int code, boolean update) {
        this.code = code;
        this.update = update;
    }

    /**
     * @return status code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @return true if can be updated
     */
    public boolean canUpdate() {
        return this.update;
    }

    /**
     * @param code status code
     * @return event status
     */
    public static ScheduledStatus getByCode(int code) {
        for (ScheduledStatus status : values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return UNDEFINED;
    }
}
