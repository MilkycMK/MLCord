package net.mlk.mlcord.network.websocket.discord.gateway.presence.activity.utils;

import java.util.ArrayList;

public enum ActivityFlag {
    INSTANCE(0),
    JOIN(1),
    SPECTATE(2),
    JOIN_REQUEST(3),
    SYNC(4),
    PLAY(5),
    PARTY_PRIVACY_FRIENDS(6),
    PARTY_PRIVACY_VOICE_CHANNEL(7),
    EMBEDDED(8);

    private final int code;
    ActivityFlag(int code) {
        this.code = code;
    }

    /**
     * @return flag code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @return current flag value
     */
    public long toFlag() {
        return 1L << this.code;
    }

    /**
     * @param flagsList list of the flags
     * @return flag value
     */
    public static long toFlags(ArrayList<ActivityFlag> flagsList) {
        long flags = 0;
        for (ActivityFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static ArrayList<ActivityFlag> getFlags(long flags) {
        ArrayList<ActivityFlag> flagsList = new ArrayList<>();
        for (ActivityFlag flag : values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }
}
