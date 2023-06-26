package net.mlk.mlcord.discord.guild.member.util;

import java.util.ArrayList;
import java.util.List;

/**
 Enum with all discord flags
 */
public enum MemberFlag {
    /*
     Member has left and rejoined the guild
     */
    DID_REJOIN(0, false),

    /*
     Member has completed onboarding
     */
    COMPLETED_ONBOARDING(1, false),

    /*
     Member is exempt from guild verification requirements
     */
    BYPASSES_VERIFICATION(2, true),

    /*
     Member has started onboarding
     */
    STARTED_ONBOARDING(3, false);

    private final int code;
    private final boolean editable;
    MemberFlag(int code, boolean editable) {
        this.code = code;
        this.editable = editable;
    }

    /**
     * @return flag code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @return true if can edit
     */
    public boolean isEditable() {
        return this.editable;
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
    public static long toFlags(List<MemberFlag> flagsList) {
        long flags = 0;
        for (MemberFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static List<MemberFlag> getFlags(long flags) {
        List<MemberFlag> flagsList = new ArrayList<>();
        for (MemberFlag flag : values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }

}