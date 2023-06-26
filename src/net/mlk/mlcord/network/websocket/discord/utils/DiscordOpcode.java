package net.mlk.mlcord.network.websocket.discord.utils;

public enum DiscordOpcode {
    /*
     Unknown opcode
    */
    UNKNOWN_OPCODE(-1),

    /*
     Receive only
     An event was dispatched
    */
    DISPATCH(0),

    /*
     Send/Receive
     Fired periodically by the client to keep the connection alive.
    */
    HEARTBEAT(1),

    /*
     Send only
     Starts a new session during the initial handshake.
    */
    IDENTIFY(2),

    /*
     Send only
     Update the client's presence.
    */
    PRESENCE_UPDATE(3),

    /*
     Send only
     Used to join/leave or move between voice channels.
    */
    VOICE_STATE_UPDATE(4),

    /*
     Send only
     Resume a previous session that was disconnected.
    */
    RESUME(6),

    /*
     Receive only
     You should attempt to reconnect and resume immediately.
    */
    RECONNECT(7),

    /*
     Send only
     Request information about offline guild members in a large guild.
    */
    REQUEST_GUILD_MEMBERS(8),

    /*
     Receive only
     The session has been invalidated. You should reconnect and identify/resume accordingly.
    */
    INVALID_SESSION(9),

    /*
     Receive only
     Sent immediately after connecting, contains the heartbeat_interval to use.
    */
    HELLO(10),

    /*
     Receive only
     Sent in response to receiving a heartbeat to acknowledge that it has been received.
    */
    HEARTBEAT_ACK(11);

    private final int code;
    DiscordOpcode(int code) {
        this.code = code;
    }

    /**
     * return DiscordOpcode by integer value
     * @param errorCode code
     * @return DiscordOpcode
     */
    public static DiscordOpcode getByCode(int errorCode) {
        for (DiscordOpcode code : values()) {
            if (code.getValue() == errorCode) {
                return code;
            }
        }
        return UNKNOWN_OPCODE;
    }

    /**
     * @return the integer value of the opcode
     */
    public int getValue() {
        return this.code;
    }
}
