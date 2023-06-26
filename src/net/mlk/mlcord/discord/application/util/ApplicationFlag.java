package net.mlk.mlcord.discord.application.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum with application flags
 */
public enum ApplicationFlag {
    /*
     Indicates if an app uses the Auto Moderation API
     */
    APPLICATION_AUTO_MODERATION_RULE_CREATE_BADGE(6),

    /*
     Intent required for bots in 100 or more servers to receive presence_update events
     */
    GATEWAY_PRESENCE(12),

    /*
     Intent required for bots in under 100 servers to receive presence_update events,
     found on the Bot page in your app's settings
     */
    GATEWAY_PRESENCE_LIMITED(13),

    /*
     Intent required for bots in 100 or more servers to receive member-related events like guild_member_add.
     See the list of member-related events under GUILD_MEMBERS
     */
    GATEWAY_GUILD_MEMBERS(14),

    /*
    Intent required for bots in under 100 servers to receive member-related events like guild_member_add,
    found on the Bot page in your app's settings. See the list of member-related events under GUILD_MEMBERS
     */
    GATEWAY_GUILD_MEMBERS_LIMITED(15),

    /*
     Indicates unusual growth of an app that prevents verification
     */
    VERIFICATION_PENDING_GUILD_LIMIT(16),

    /*
     Indicates if an app is embedded within the Discord client (currently unavailable publicly)
     */
    EMBEDDED(17),

    /*
     Intent required for bots in 100 or more servers to receive message content
     */
    GATEWAY_MESSAGE_CONTENT(18),

    /*
     Intent required for bots in under 100 servers to receive message content,
     found on the Bot page in your app's settings
     */
    GATEWAY_MESSAGE_CONTENT_LIMITED(19),

    /*
     Indicates if an app has registered global application commands
     */
    APPLICATION_COMMAND_BADGE(23);

    private final long code;

    ApplicationFlag(long code) {
        this.code = code;
    }

    /**
     * @return flag code
     */
    public long getCode() {
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
    public static long toFlags(List<ApplicationFlag> flagsList) {
        long flags = 0;
        for (ApplicationFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static List<ApplicationFlag> getFlags(long flags) {
        List<ApplicationFlag> flagsList = new ArrayList<>();
        for (ApplicationFlag flag : values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }
}