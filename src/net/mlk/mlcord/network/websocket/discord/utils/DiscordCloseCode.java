package net.mlk.mlcord.network.websocket.discord.utils;

public enum DiscordCloseCode {
    /*
     Unknown code
    */
    UNKNOWN_CODE(-1),

    /*
     We're not sure what went wrong. Try reconnecting?
    */
    UNKNOWN_ERROR(4000),

    /*
     You sent an invalid Gateway opcode or an invalid payload for an opcode. Don't do that!
    */
    UNKNOWN_OPCODE(4001),

    /*
     You sent an invalid payload to Discord. Don't do that!
    */
    DECODE_ERROR(4002),

    /*
     You sent us a payload prior to identifying.
    */
    NOT_AUTHENTICATED(4003),

    /*
     The account token sent with your identify payload is incorrect.
    */
    AUTHENTICATION_FAILED(4004),

    /*
     You sent more than one identify payload.
     Don't do that!
    */
    ALREADY_AUTHENTICATED(4005),

    /*
     The sequence sent when resuming the session was invalid.
     Reconnect and start a new session.
    */
    INVALID_SEQ(4007),

    /*
     Woah nelly! You're sending payloads to us too quickly.
     Slow it down! You will be disconnected on receiving this.
    */
    RATE_LIMITED(4008),

    /*
     Your session timed out. Reconnect and start a new one.
    */
    SESSION_TIMED_OUT(4009),

    /*
     You sent us an invalid shard when identifying.
    */
    INVALID_SHARD(4010),

    /*
     The session would have handled too many guilds -
     you are required to shard your connection in order to connect.
    */
    SHARDING_REQUIRED(4011),

    /*
     You sent an invalid version for the gateway.
    */
    INVALID_API_VERSION(4012),

    /*
     You sent an invalid intent for a Gateway Intent.
     You may have incorrectly calculated the bitwise value.
    */
    INVALID_INTENTS(4013),

    /*
     You sent a disallowed intent for a Gateway Intent.
     You may have tried to specify an intent that you have not enabled or are not approved for.
    */
    DISALLOWED_INTENTS(4014);



    private final int code;
    DiscordCloseCode(int code) {
        this.code = code;
    }

    /**
     * return DiscordErrorCode code by integer value
     * @param errorCode code
     * @return DiscordErrorCode
     */
    public static DiscordCloseCode getByCode(int errorCode) {
        for (DiscordCloseCode code : values()) {
            if (code.getValue() == errorCode) {
                return code;
            }
        }
        return UNKNOWN_CODE;
    }

    /**
     * @return the integer value of the close code
     */
    public int getValue() {
        return this.code;
    }
}
