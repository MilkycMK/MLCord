package net.mlk.mlcord.discord.message.util;

import java.util.ArrayList;
import java.util.List;

public enum MessageFlag {
    /*
     this message has been published to subscribed channels (via Channel Following)
     */
    CROSSPOSTED(0),

    /*
     this message originated from a message in another channel (via Channel Following)
     */
    IS_CROSSPOST(1),

    /*
     do not include any embeds when serializing this message
     */
    SUPPRESS_EMBEDS(2),

    /*
     the source message for this crosspost has been deleted (via Channel Following)
     */
    SOURCE_MESSAGE_DELETED(3),

    /*
     this message came from the urgent message system
     */
    URGENT(4),

    /*
     this message has an associated thread, with the same id as the message
     */
    HAS_THREAD(5),

    /*
     this message is only visible to the user who invoked the Interaction
     */
    EPHEMERAL(6),

    /*
     this message is an Interaction Response and the bot is "thinking"
     */
    LOADING(7),

    /*
     this message failed to mention some roles and add their members to the thread
     */
    FAILED_TO_MENTION_SOME_ROLES_IN_THREAD(8),

    /*
     this message will not trigger push and desktop notifications
     */
    SUPPRESS_NOTIFICATIONS(12),

    /*
     this message is a voice message
     */
    IS_VOICE_MESSAGE(13);

    private final int code;
    MessageFlag(int code) {
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
    public static long toFlags(List<MessageFlag> flagsList) {
        long flags = 0;
        for (MessageFlag flag : flagsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long flags value
     * @return list of flags
     */
    public static List<MessageFlag> getFlags(long flags) {
        List<MessageFlag> flagsList = new ArrayList<>();
        for (MessageFlag flag : MessageFlag.values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }
}
