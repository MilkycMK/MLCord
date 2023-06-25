package net.mlk.mlcord.network.websocket.discord.utils;

import java.util.Arrays;
import java.util.HashSet;

public enum DiscordIntent {
    /*
     GUILD_CREATE
     GUILD_UPDATE
     GUILD_DELETE
     GUILD_ROLE_CREATE
     GUILD_ROLE_UPDATE
     GUILD_ROLE_DELETE
     CHANNEL_CREATE
     CHANNEL_UPDATE
     CHANNEL_DELETE
     CHANNEL_PINS_UPDATE
     THREAD_CREATE
     THREAD_UPDATE
     THREAD_DELETE
     THREAD_LIST_SYNC
     THREAD_MEMBER_UPDATE
     THREAD_MEMBERS_UPDATE
     STAGE_INSTANCE_CREATE
     STAGE_INSTANCE_UPDATE
     STAGE_INSTANCE_DELETE
     */
    GUILDS(0),

    /*
     This is a "privileged" intent.
     Privileged intents require you to toggle the intent for your app in your app's settings
     within the Developer Portal before passing said intent.
     For verified apps (required for apps in 100+ guilds), the intent must also be approved
     after the verification process to use the intent.

     GUILD_MEMBER_ADD
     GUILD_MEMBER_UPDATE
     GUILD_MEMBER_REMOVE
     THREAD_MEMBERS_UPDATE
     */
    GUILD_MEMBERS(1),

    /*
     GUILD_AUDIT_LOG_ENTRY_CREATE
     GUILD_BAN_ADD
     GUILD_BAN_REMOVE
     */
    GUILD_MODERATION(2),

    /*
     GUILD_EMOJIS_UPDATE
     GUILD_STICKERS_UPDATE
     */
    GUILD_EMOJIS_AND_STICKERS(3),

    /*
     GUILD_INTEGRATIONS_UPDATE
     INTEGRATION_CREATE
     INTEGRATION_UPDATE
     INTEGRATION_DELETE
     */
    GUILD_INTEGRATIONS(4),

    /*
     WEBHOOKS_UPDATE
     */
    GUILD_WEBHOOKS(5),

    /*
     INVITE_CREATE
     INVITE_DELETE
     */
    GUILD_INVITES(6),

    /*
     VOICE_STATE_UPDATE
     */
    GUILD_VOICE_STATES(7),

    /*
     This is a "privileged" intent.
     Privileged intents require you to toggle the intent for your app in your app's settings
     within the Developer Portal before passing said intent.
     For verified apps (required for apps in 100+ guilds), the intent must also be approved
     after the verification process to use the intent.

     PRESENCE_UPDATE
     */
    GUILD_PRESENCES(8),

    /*
     MESSAGE_CREATE
     MESSAGE_UPDATE
     MESSAGE_DELETE
     MESSAGE_DELETE_BULK
     */
    GUILD_MESSAGES(9),

    /*
     MESSAGE_REACTION_ADD
     MESSAGE_REACTION_REMOVE
     MESSAGE_REACTION_REMOVE_ALL
     MESSAGE_REACTION_REMOVE_EMOJI
     */
    GUILD_MESSAGE_REACTIONS(10),

    /*
     TYPING_START
     */
    GUILD_MESSAGE_TYPING(11),

    /*
     MESSAGE_CREATE
     MESSAGE_UPDATE
     MESSAGE_DELETE
     CHANNEL_PINS_UPDATE
     */
    DIRECT_MESSAGES(12),

    /*
     MESSAGE_REACTION_ADD
     MESSAGE_REACTION_REMOVE
     MESSAGE_REACTION_REMOVE_ALL
     MESSAGE_REACTION_REMOVE_EMOJI
     */
    DIRECT_MESSAGE_REACTIONS(13),

    /*
     TYPING_START
     */
    DIRECT_MESSAGE_TYPING(14),

    /*
     This is a "privileged" intent.
     Privileged intents require you to toggle the intent for your app in your app's settings
     within the Developer Portal before passing said intent.
     For verified apps (required for apps in 100+ guilds), the intent must also be approved
     after the verification process to use the intent.

     More information about message
     */
    MESSAGE_CONTENT(15),

    /*
     GUILD_SCHEDULED_EVENT_CREATE
     GUILD_SCHEDULED_EVENT_UPDATE
     GUILD_SCHEDULED_EVENT_DELETE
     GUILD_SCHEDULED_EVENT_USER_ADD
     GUILD_SCHEDULED_EVENT_USER_REMOVE
     */
    GUILD_SCHEDULED_EVENTS(16),

    /*
     AUTO_MODERATION_RULE_CREATE
     AUTO_MODERATION_RULE_UPDATE
     AUTO_MODERATION_RULE_DELETE
     */
    AUTO_MODERATION_CONFIGURATION(20),

    /*
     AUTO_MODERATION_ACTION_EXECUTION
     */
    AUTO_MODERATION_EXECUTION(21);

    /*
     All intents from this enum
     */
    public static final int ALL_INTENTS = getIntentsNumber(new HashSet<>(Arrays.asList(values())));
    private final int code;
    DiscordIntent(int code) {
        this.code = code;
    }

    /**
     * @return raw intent value
     */
    public int getValue() {
        return this.code;
    }

    /**
     * @return intent value
     */
    public int getIntent() {
        return 1 << this.code;
    }

    /**
     * Count the intents
     * @param set list of the discord intents
     * @return intents number
     */
    public static int getIntentsNumber(HashSet<DiscordIntent> set) {
        set = new HashSet<>(set);
        int intents = 0;
        for (DiscordIntent value : set) {
            intents |= value.getIntent();
        }
        return intents;
    }

    /**
     * get intents by integer value
     * @param intents value
     * @return intents
     */
    public static HashSet<DiscordIntent> getIntentsSet(int intents) {
        HashSet<DiscordIntent> set = new HashSet<>();
        for (DiscordIntent value : values()) {
            if ((intents & value.getIntent()) == value.getIntent()) {
                set.add(value);
            }
        }
        return set;
    }
}
