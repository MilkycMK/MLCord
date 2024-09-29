package net.mlk.mlcord.discord.channel.util;

import java.util.ArrayList;
import java.util.List;

public enum ChannelFlag {
    /*
     this thread is pinned to the top of its parent GUILD_FORUM channel
     */
    PINNED(1),

    /*
     whether a tag is required to be specified when creating a thread in a GUILD_FORUM channel. Tags are specified in the applied_tags field.
     */
    REQUIRE_TAG(2);

    private final int code;
    ChannelFlag(int code) {
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
    public static long toFlags(List<ChannelFlag> flagsList) {
        long flags = 0;
        for (ChannelFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static List<ChannelFlag> getFlags(long flags) {
        List<ChannelFlag> flagsList = new ArrayList<>();
        for (ChannelFlag flag : values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }
}