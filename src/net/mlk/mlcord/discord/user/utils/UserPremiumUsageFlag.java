package net.mlk.mlcord.discord.user.utils;

import java.util.ArrayList;
import java.util.List;

public enum UserPremiumUsageFlag {
    PREMIUM_DISCRIMINATOR(0),
    ANIMATED_AVATAR(1),
    PROFILE_BANNER(2);

    private final int code;
    UserPremiumUsageFlag(int code) {
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
    public static long toFlags(List<UserPremiumUsageFlag> flagsList) {
        long flags = 0;
        for (UserPremiumUsageFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static List<UserPremiumUsageFlag> getFlags(long flags) {
        ArrayList<UserPremiumUsageFlag> flagsList = new ArrayList<>();
        for (UserPremiumUsageFlag flag : UserPremiumUsageFlag.values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }
}