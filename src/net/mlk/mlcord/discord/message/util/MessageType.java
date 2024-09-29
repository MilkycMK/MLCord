package net.mlk.mlcord.discord.message.util;

import net.mlk.mlcord.discord.guild.util.GuildPermission;

import java.util.List;

/**
 * Enum with message types
 */
public enum MessageType {
    UNDEFINED(-1, false),
    DEFAULT(0, true),
    RECIPIENT_ADD(1, false),
    RECIPIENT_REMOVE(2, false),
    CALL(3, false),
    CHANNEL_NAME_CHANGE(4, false),
    CHANNEL_ICON_CHANGE(5, false),
    CHANNEL_PINNED_MESSAGE(6, true),
    USER_JOIN(7, true),
    GUILD_BOOST(8, true),
    GUILD_BOOST_TIER_1(9, true),
    GUILD_BOOST_TIER_2(10, true),
    GUILD_BOOST_TIER_3(11, true),
    CHANNEL_FOLLOW_ADD(12, true),
    GUILD_DISCOVERY_DISQUALIFIED(14, false),
    GUILD_DISCOVERY_REQUALIFIED(15, false),
    GUILD_DISCOVERY_GRACE_PERIOD_INITIAL_WARNING(16, false),
    GUILD_DISCOVERY_GRACE_PERIOD_FINAL_WARNING(17, false),
    THREAD_CREATED(18, true),
    REPLY(19, true),
    CHAT_INPUT_COMMAND(20, true),
    THREAD_STARTER_MESSAGE(21, false),
    GUILD_INVITE_REMINDER(22, true),
    CONTEXT_MENU_COMMAND(23, true),
    AUTO_MODERATION_ACTION(24, true), // Can only be deleted by members with MANAGE_MESSAGES permission
    ROLE_SUBSCRIPTION_PURCHASE(25, true),
    INTERACTION_PREMIUM_UPSELL(26, true),
    STAGE_START(27, true),
    STAGE_END(28, true),
    STAGE_SPEAKER(29, true),
    STAGE_TOPIC(31, true),
    GUILD_APPLICATION_PREMIUM_SUBSCRIPTION(32, false);

    private final int code;
    private final boolean deletable;
    MessageType(int code, boolean deletable) {
        this.code = code;
        this.deletable = deletable;
    }

    /**
     * @return true if you can delete message
     */
    public boolean isDeletable() {
        return this.deletable;
    }

    /**
     * check delete with permissions
     * @param permissionList permissions to check
     * @return false if don't have permissions to delete message
     */
    public boolean isDeletable(List<GuildPermission> permissionList) {
        if (this == MessageType.AUTO_MODERATION_ACTION) {
            return permissionList.contains(GuildPermission.MANAGE_MESSAGES) && this.isDeletable();
        }
        return this.isDeletable();
    }

    /**
     * @param code code of the type
     * @return type by code or null
     */
    public static MessageType getByCode(int code) {
        for (MessageType type : MessageType.values()) {
            if (code == type.getCode()) {
                return type;
            }
        }
        return UNDEFINED;
    }

    /**
     * @return type code
     */
    public int getCode() {
        return this.code;
    }

}