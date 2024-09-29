package net.mlk.mlcord.discord.user.utils;

import java.util.ArrayList;
import java.util.List;

public enum UserFlag {
    /*
     Discord Employee
     */
    STAFF(0),

    /*
     Discord Partner
     */
    PARTNER(1),

    /*
     HypeSquad Events
     */
    HYPESQUAD(2),

    /*
     Bug Hunter Level 1
     */
    BUG_HUNTER_LEVEL_1(3),

    /*
     Bug Hunter Level 2
     */
    BUG_HUNTER_LEVEL_2(14),

    /*
     SMS recovery for 2FA enabled
     */
    MFA_SMS(4),

    /*
     Dismissed Nitro promotion
     */
    PREMIUM_PROMO_DISMISSED(5),

    /*
     HypeSquad Online House Bravery
     */
    HYPESQUAD_ONLINE_HOUSE_1(6),

    /*
     HypeSquad Online House Brilliance
     */
    HYPESQUAD_ONLINE_HOUSE_2(7),

    /*
     HypeSquad Online House Balance
     */
    HYPESQUAD_ONLINE_HOUSE_3(8),

    /*
     Early Supporter
     */
    PREMIUM_EARLY_SUPPORTER(9),

    /*
     Team User
     */
    TEAM_USER(10),

    /*
     Relates to partner/verification applications.
     */
    INTERNAL_APPLICATION(11),

    /*
     System User
     */
    SYSTEM(12),

    /*
     Has an unread system message
     */
    HAS_UNREAD_URGENT_MESSAGES(13),

    /*
     Pending deletion for being underage in DOB prompt
     */
    UNDERAGE_DELETED(15),

    /*
     Verified Bot
     */
    VERIFIED_BOT(16),

    /*
     Early Verified Bot Developer
     */
    VERIFIED_DEVELOPER(17),

    /*
     Moderator Programs Alumni
     */
    CERTIFIED_MODERATOR(18),

    /*
     Bot has set an interactions endpoint url
     */
    BOT_HTTP_INTERACTIONS(19),

    /*
     User is disabled for being a spammer
     */
    SPAMMER(20),

    /*
     Disables Nitro Features
     */
    DISABLE_PREMIUM(21),

    /*
     User is an active developer
     */
    ACTIVE_DEVELOPER(22),

    /*
     Account has a high global ratelimit
     */
    HIGH_GLOBAL_RATE_LIMIT(33),

    /*
     Account has been deleted
     */
    DELETED(34),

    /*
     Account has been disabled for suspicious activity
     */
    DISABLED_SUSPICIOUS_ACTIVITY(35),

    /*
     Account was deleted by the user
     */
    SELF_DELETED(36),

    /*
     User has a premium discriminator
     */
    PREMIUM_DISCRIMINATOR(37),

    /*
     User has used the desktop client
     */
    USED_DESKTOP_CLIENT(38),

    /*
     User has used the web client
     */
    USED_WEB_CLIENT(39),

    /*
     User has used the mobile client
     */
    USED_MOBILE_CLIENT(40),

    /*
     User is currently temporarily or permanently disabled
     */
    DISABLED(41),

    /*
     User has a verified email
     */
    VERIFIED_EMAIL(43),

    /*
     User account is quarantined
     */
    QUARANTINED(44),

    /*
     User is a collaborator and has staff permissions
     */
    COLLABORATOR(50),

    /*
     User is a restricted collaborator and has staff permissions
     */
    RESTRICTED_COLLABORATOR(51);

    private final int code;
    UserFlag(int code) {
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
    public static long toFlags(List<UserFlag> flagsList) {
        long flags = 0;
        for (UserFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static ArrayList<UserFlag> getFlags(long flags) {
        ArrayList<UserFlag> flagsList = new ArrayList<>();
        for (UserFlag flag : values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }
}
