package net.mlk.mlcord.discord.user.utils;

import java.util.ArrayList;
import java.util.List;

public enum UserPurchasedFlag {
    NITRO_CLASSIC(0),
    NITRO(1),
    GUILD_BOOST(2),
    NITRO_BASIC(3);

    private final int code;

    UserPurchasedFlag(int code) {
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
    public static long toFlags(List<UserPurchasedFlag> flagsList) {
        long flags = 0;
        for (UserPurchasedFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static List<UserPurchasedFlag> getFlags(long flags) {
        ArrayList<UserPurchasedFlag> flagsList = new ArrayList<>();
        for (UserPurchasedFlag flag : UserPurchasedFlag.values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }
}
