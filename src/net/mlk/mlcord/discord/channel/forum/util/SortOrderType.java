package net.mlk.mlcord.discord.channel.forum.util;

public enum SortOrderType {
    UNDEFINED(-1),
    /*
     Sort forum posts by activity
     */
    LATEST_ACTIVITY(0),

    /*
     Sort forum posts by creation time (from most recent to oldest)
     */
    CREATION_DATE(1);

    private final int code;
    SortOrderType(int code) {
        this.code = code;
    }

    /**
     * @return type code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code type code
     * @return type by code
     */
    public static SortOrderType getByCode(int code) {
        for (SortOrderType type : values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return UNDEFINED;
    }
}