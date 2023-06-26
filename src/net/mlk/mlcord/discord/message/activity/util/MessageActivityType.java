package net.mlk.mlcord.discord.message.activity.util;

public enum MessageActivityType {
    UNDEFINED(-1),
    JOIN(1),
    SPECTATE(2),
    LISTEN(3),
    JOIN_REQUEST(5);

    private final int code;
    MessageActivityType(int code) {
        this.code = code;
    }

    /**
     * @return activity type code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @return activity type
     */
    public static MessageActivityType getByCode(int code) {
        for (MessageActivityType type : MessageActivityType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return UNDEFINED;
    }
}
