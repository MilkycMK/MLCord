package net.mlk.mlcord.network.websocket.discord.utils;

import net.mlk.mlcord.discord.guild.events.GuildCreateEvent;
import net.mlk.mlcord.discord.guild.events.GuildDeleteEvent;
import net.mlk.mlcord.discord.guild.events.GuildUpdateEvent;
import net.mlk.mlcord.discord.guild.member.events.GuildMemberUpdateEvent;
import net.mlk.mlcord.discord.message.events.MessageDeleteEvent;
import net.mlk.mlcord.discord.message.events.MessageReceiveEvent;
import net.mlk.mlcord.discord.message.events.MessageUpdateEvent;
import net.mlk.mlcord.network.websocket.discord.gateway.events.ReadyReceiveEvent;

public enum DiscordEventType {
    /*
     Events that do not depend on the following:
      - HelloRecieveEvent
      - AckRecieveEvent
      - InvalidSessionRecieveEvent
      - ReconnectRecieveEvent
      - HeartBeatRecieveEvent
     */

    /*
     undefined event
     */
    UNDEFINED(null),

    /*
     When bot is authorized
     */
    READY(ReadyReceiveEvent.class),

    /*
     When bot was resumed
     */
    RESUMED(null),

    /*
     When bot join to guild
     */
    GUILD_CREATE(GuildCreateEvent.class),

    /*
     Sent when a guild is updated
     */
    GUILD_UPDATE(GuildUpdateEvent.class),

    /*
     Guild became unavailable, or user left/was removed from a guild
     */
    GUILD_DELETE(GuildDeleteEvent.class),

    /*
     Application command permission was updated
     */
    APPLICATION_COMMAND_PERMISSIONS_UPDATE(null),

    /*
     Guild role was created
     */
    GUILD_ROLE_CREATE(null),

    /*
     Guild role was updates
     */
    GUILD_ROLE_UPDATE(null),

    /*
     Guild role was deleted
     */
    GUILD_ROLE_DELETE(null),

    /*
     Channel was created
     */
    CHANNEL_CREATE(null),

    /*
     Channel was updated
     */
    CHANNEL_UPDATE(null),

    /*
     Channel was deleted
     */
    CHANNEL_DELETE(null),

    /*
     Message was pinned or unpinned
     */
    CHANNEL_PINS_UPDATE(null),

    /*
     Thread created, also sent when being added to a private thread
     */
    THREAD_CREATE(null),

    /*
     Thread was updated
     */
    THREAD_UPDATE(null),

    /*
     Thread was deleted
     */
    THREAD_DELETE(null),

    /*
     Sent when gaining access to a channel, contains all active threads in that channel
     */
    THREAD_LIST_SYNC(null),

    /*
     Thread member for the bot was updated
     */
    THREAD_MEMBER_UPDATE(null),

    /*
     Some user(s) were added to or removed from a thread
     */
    THREAD_MEMBERS_UPDATE(null),

    /*
     Stage instance was created
     */
    STAGE_INSTANCE_CREATE(null),

    /*
    Stage instance was updated
     */
    STAGE_INSTANCE_UPDATE(null),

    /*
     Stage instance was deleted
     */
    STAGE_INSTANCE_DELETE(null),

    /*
     New user joined a guild
     */
    GUILD_MEMBER_ADD(null),

    /*
     Guild member was updated
     */
    GUILD_MEMBER_UPDATE(GuildMemberUpdateEvent.class),

    /*
     User was removed from a guild
     */
    GUILD_MEMBER_REMOVE(null),

    /*
     A guild audit log entry was created
     */
    GUILD_AUDIT_LOG_ENTRY_CREATE(null),

    /*
     User was banned from a guild
     */
    GUILD_BAN_ADD(null),

    /*
     User was unbanned from a guild
     */
    GUILD_BAN_REMOVE(null),

    /*
     Guild emojis were updated
     */
    GUILD_EMOJIS_UPDATE(null),

    /*
     Guild stickers were updated
     */
    GUILD_STICKERS_UPDATE(null),

    /*
     Guild integration was updated
     */
    GUILD_INTEGRATIONS_UPDATE(null),

    /*
     Response to Request Guild Members
     */
    GUILD_MEMBERS_CHUNK(null),

    /*
     Guild integration was created
     */
    INTEGRATION_CREATE(null),

    /*
     Guild integration was updated
     */
    INTEGRATION_UPDATE(null),

    /*
     Guild integration was deleted
     */
    INTEGRATION_DELETE(null),

    /*
     Guild channel webhook was created, update, or deleted
     */
    WEBHOOKS_UPDATE(null),

    /*
     Invite to a channel was created
     */
    INVITE_CREATE(null),

    /*
     Invite to a channel was deleted
     */
    INVITE_DELETE(null),

    /*
     Someone joined, left, or moved a voice channel
     */
    VOICE_STATE_UPDATE(null),

    /*
     Guild's voice server was updated
     */
    VOICE_SERVER_UPDATE(null),

    /*
     User was updated
     */
    PRESENCE_UPDATE(null),

    /*
     Message was created
     */
    MESSAGE_CREATE(MessageReceiveEvent.class),

    /*
     Message was updated
     */
    MESSAGE_UPDATE(MessageUpdateEvent.class),

    /*
     Message was deleted
     */
    MESSAGE_DELETE(MessageDeleteEvent.class),

    /*
     Multiple messages were deleted at once
     */
    MESSAGE_DELETE_BULK(null),

    /*
     User reacted to a message
     */
    MESSAGE_REACTION_ADD(null),

    /*
     User removed a reaction from a message
     */
    MESSAGE_REACTION_REMOVE(null),

    /*
     All reactions were explicitly removed from a message
     */
    MESSAGE_REACTION_REMOVE_ALL(null),

    /*
     All reactions for a given emoji were explicitly removed from a message
     */
    MESSAGE_REACTION_REMOVE_EMOJI(null),
    /*
     User started typing in a channel
     */
    TYPING_START(null),
    /*
     Guild scheduled event was created
     */
    GUILD_SCHEDULED_EVENT_CREATE(null),

    /*
     Guild scheduled event was updated
     */
    GUILD_SCHEDULED_EVENT_UPDATE(null),

    /*
     Guild scheduled event was deleted
     */
    GUILD_SCHEDULED_EVENT_DELETE(null),

    /*
     User subscribed to a guild scheduled event
     */
    GUILD_SCHEDULED_EVENT_USER_ADD(null),

    /*
     Properties about the user changed
     */
    USER_UPDATE(null),

    /*
     User unsubscribed from a guild scheduled event
     */
    GUILD_SCHEDULED_EVENT_USER_REMOVE(null),

    /*
     Auto Moderation rule was created
     */
    AUTO_MODERATION_RULE_CREATE(null),

    /*
     Auto Moderation rule was updated
     */
    AUTO_MODERATION_RULE_UPDATE(null),

    /*
     Auto Moderation rule was deleted
     */
    AUTO_MODERATION_RULE_DELETE(null),

    /*
     Auto Moderation rule was triggered and an action was executed (e.g. a message was blocked)
     */
    AUTO_MODERATION_ACTION_EXECUTION(null);

    private final Class<? extends DispatchEvent> eventClass;

    DiscordEventType(Class<? extends DispatchEvent> eventClass) {
        this.eventClass = eventClass;
    }

    /**
     * @return instance of the current event class
     */
    public Object getEventClass() {
        try {
            if (this.eventClass == null) {
                return null;
            }
            return this.eventClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * get event by name
     * @param value name of the event
     * @return event
     */
    public static DiscordEventType getByName(String value) {
        for (DiscordEventType e : values()) {
            if (e.name().equalsIgnoreCase(value)) {
                return e;
            }
        }
        return UNDEFINED;
    }
}
