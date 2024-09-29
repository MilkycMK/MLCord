package net.mlk.mlcord.discord.channel.thread.util;

import java.util.ArrayList;
import java.util.List;

public enum UserThreadFlag {
    /*
     user is thread creator
     */
    THREAD_CREATOR(1),

    /*
     user can contrl the thread
     */
    THREAD_MODERATOR(2);

    private final int code;
    UserThreadFlag(int code) {
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
    public static long toFlags(List<UserThreadFlag> flagsList) {
        long flags = 0;
        for (UserThreadFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static List<UserThreadFlag> getFlags(long flags) {
        List<UserThreadFlag> flagsList = new ArrayList<>();
        for (UserThreadFlag flag : values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }
}
