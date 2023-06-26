package net.mlk.mlcord.discord.channel.util;

import java.util.ArrayList;
import java.util.List;

public enum SystemChannelFlag {
    /*
     Suppress member join notifications
     */
    SUPPRESS_JOIN_NOTIFICATIONS(0),

    /*
     Suppress server boost notifications
     */
    SUPPRESS_PREMIUM_SUBSCRIPTIONS(1),

    /*
     Suppress server setup tips
     */
    SUPPRESS_GUILD_REMINDER_NOTIFICATIONS(2),

    /*
     Hide member join sticker reply buttons
     */
    SUPPRESS_JOIN_NOTIFICATION_REPLIES(3),

    /*
     Suppress role subscription purchase and renewal notifications
     */
    SUPPRESS_ROLE_SUBSCRIPTION_PURCHASE_NOTIFICATIONSYSTEM_CHANNEL_FLAG(4),

    /*
     Hide role subscription sticker reply buttons
     */
    SUPPRESS_ROLE_SUBSCRIPTION_PURCHASE_NOTIFICATION_REPLIES(5);

    private final int code;
    SystemChannelFlag(int code) {
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
    public static long toFlags(List<SystemChannelFlag> flagsList) {
        long flags = 0;
        for (SystemChannelFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static List<SystemChannelFlag> getFlags(long flags) {
        List<SystemChannelFlag> flagsList = new ArrayList<>();
        for (SystemChannelFlag flag : values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }
}
