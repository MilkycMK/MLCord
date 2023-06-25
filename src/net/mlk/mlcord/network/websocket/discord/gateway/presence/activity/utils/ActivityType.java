package net.mlk.mlcord.network.websocket.discord.gateway.presence.activity.utils;

public enum ActivityType {
    /*
     undefined type
     */
    UNDEFINED(-1),

    /*
     Playing {name}
     */
    GAME(0),

    /*
     Streaming {details}
     */
    STREAMING(1),

    /*
     Listening to {name}
     */
    LISTENING(2),

    /*
     Watching {name}
     */
    WATCHING(3),

    /*
     {emoji} {name}
     */
    CUSTOM(4),

    /*
     Competing in {name}
     */
    COMPETING(5);

    private final int code;
    ActivityType(int code) {
        this.code = code;
    }

    /**
     * @return type code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * get type by code
     * @param code code to get
     * @return type
     */
    public static ActivityType getByCode(int code) {
        for (ActivityType type : values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return UNDEFINED;
    }
}
