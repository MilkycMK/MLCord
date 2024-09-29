package net.mlk.mlcord.discord.guild.util;

import java.util.ArrayList;
import java.util.List;

public enum GuildPermission {
    UNDEFINED(-1, false),

    /*
     Allows creation of instant invites
     Channels: Text, Voice, Stage
     */
    CREATE_INSTANT_INVITE(0, false),

    /*
     Allows kicking members
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     */
    KICK_MEMBERS(1, true),

    /*
     Allows banning members
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     */
    BAN_MEMBERS(2, true),

    /*
     Allows all permissions and bypasses channel permission overwrites
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     */
    ADMINISTRATOR(3, true),

    /*
     Allows management and editing of channels (Text, Voice, Stage)
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     */
    MANAGE_CHANNELS(4, true),

    /*
     Allows management and editing of the guild
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     */
    MANAGE_GUILD(5, true),

    /*
     Allows for the addition of reactions to messages
     Channels: Text, Voice, Stage
     */
    ADD_REACTIONS(6, false),

    /*
     Allows for viewing of audit logs
     */
    VIEW_AUDIT_LOG(7, false),

    /*
     Allows for using priority speaker in a voice channel
     Channels: Voice
     */
    PRIORITY_SPEAKER(8, false),

    /*
     Allows the user to go live
     Channels: Voice, Stage
     */
    STREAM(9, false),

    /*
     Allows guild members to view a channel, which includes reading messages in text channels and joining voice channels
     Channels: Voice, Text, Stage
     */
    VIEW_CHANNEL(10, false),

    /*
     Allows for sending messages in a channel and creating threads in a forum (does not allow sending messages in threads)
     Channels: Voice, Text, Stage
     */
    SEND_MESSAGES(11, false),

    /*
     Allows for sending of /tts messages
     Channels: Voice, Text, Stage
     */
    SEND_TTS_MESSAGES(12, false),

    /*
     Allows for deletion of other users messages
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     Channels: Voice, Text, Stage
     */
    MANAGE_MESSAGES(13, true),

    /*
     Links sent by users with this permission will be auto-embedded
     Channels: Voice, Text, Stage
     */
    EMBED_LINKS(14, false),

    /*
     Allows for uploading images and files
     Channels: Voice, Text, Stage
     */
    ATTACH_FILES(15, false),

    /*
     Allows for reading of message history
     Channels: Voice, Text, Stage
     */
    READ_MESSAGE_HISTORY(16, false),

    /*
    Allows for using the @everyone tag to notify all users in a channel, and the @here tag to notify all online users in a channel
    Channels: Voice, Text, Stage
     */
    MENTION_EVERYONE(17, false),

    /*
     Allows the usage of custom emojis from other servers
     Channels: Voice, Text, Stage
     */
    USE_EXTERNAL_EMOJIS(18, false),

    /*
     Allows for viewing guild insights
     */
    VIEW_GUILD_INSIGHTS(19, false),

    /*
     Allows for joining of a voice channel
     Channels: Voice, Stage
     */
    CONNECT(20, false),

    /*
     Allows for speaking in a voice channel
     Channels: Voice
     */
    SPEAK(21, false),

    /*
     Allows for muting members in a voice channel
     Channels: Voice, Stage
     */
    MUTE_MEMBERS(22, false),

    /*
     Allows for deafening of members in a voice channel
     Channels: Voice
     */
    DEAFEN_MEMBERS(23, false),

    /*
     Allows for moving of members between voice channels
     Channels: Voice, Stage
     */
    MOVE_MEMBERS(24, false),

    /*
     Allows for using voice-activity-detection in a voice channel
     Channels: Voice
     */
    USE_VAD(25, false),

    /*
     Allows for modification of own nickname
     */
    CHANGE_NICKNAME(26, false),

    /*
     Allows for modification of other users nicknames
     */
    MANAGE_NICKNAMES(27, false),

    /*
     Allows management and editing of roles
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     Channels: Voice, Text, Stage
     */
    MANAGE_ROLES(28, true),

    /*
     Allows management and editing of webhooks
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     Channels: Voice, Text, Stage
     */
    MANAGE_WEBHOOKS(29, true),

    /*
     Allows management and editing of emojis, stickers, and soundboard sounds
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     */
    MANAGE_GUILD_EXPRESSIONS(30, true),

    /*
     Allows members to use application commands, including slash commands and context menu commands.
     Channels: Voice, Text, Stage
     */
    USE_APPLICATION_COMMANDS(31, false),

    /*
     Allows for requesting to speak in stage channels. (This permission is under active development and may be changed or removed.)
     Channels: Stage
     */
    REQUEST_TO_SPEAK(32, false),

    /*
     Allows for creating, editing, and deleting scheduled events
     Channels: Voice, Stage
     */
    MANAGE_EVENTS(33, false),

    /*
     Allows for deleting and archiving threads, and viewing all private threads
     This permission require the owner account to use two-factor authentication when used on a guild that has server-wide 2FA enabled
     Channels: Text
     */
    MANAGE_THREADS(34, true),

    /*
     Allows for creating public and announcement threads
     Channels: Text
     */
    CREATE_PUBLIC_THREADS(35, false),

    /*
     Allows for creating private threads
     Channels: Text
     */
    CREATE_PRIVATE_THREADS(36, false),

    /*
     Allows the usage of custom stickers from other servers
     Channels: Text, Voice, Stage
     */
    USE_EXTERNAL_STICKERS(37, false),

    /*
     Allows for sending messages in threads
     Channels: Text
     */
    SEND_MESSAGES_IN_THREADS(38, false),

    /*
     Allows for using Activities (applications with the EMBEDDED flag) in a voice channel
     Channels: Voice
     */
    USE_EMBEDDED_ACTIVITIES(39, false),

    /*
     Allows for timing out users to prevent them from sending or reacting to messages in chat and threads, and from speaking in voice and stage channels
     */
    MODERATE_MEMBERS(40, false),

    /*
     Allows for viewing role subscription insights
     */
    VIEW_CREATOR_MONETIZATION_ANALYTICS(41, false),

    /*
     Allows for using soundboard in a voice channel
     Channels: Voice
     */
    USE_SOUNDBOARD(42, false),

    /*
     Allows sending voice messages
     Channels: Voice, Text, Stage
     */
    SEND_VOICE_MESSAGES(46, false);

    private final int code;
    private final boolean twoFactor;
    GuildPermission(int code, boolean twoFactor) {
        this.code = code;
        this.twoFactor = twoFactor;
    }

    /**
     * @return permission code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * need only for guild that has server-wide 2FA enabled
     * @return true if permission required 2FA on user account
     */
    public boolean isTwoFactorNeeded() {
        return this.twoFactor;
    }

    /**
     * @return current permission value
     */
    public long toPermission() {
        return 1L << this.code;
    }

    /**
     * @param permissionsList list of the permissions
     * @return permission value
     */
    public static long toPermissions(List<GuildPermission> permissionsList) {
        long flags = 0;
        for (GuildPermission flag : permissionsList) {
            flags |= 1L << flag.getCode();
        }
        return flags;
    }

    /**
     * @param flags long permission value
     * @return list of permissions
     */
    public static List<GuildPermission> getFlags(long flags) {
        List<GuildPermission> flagsList = new ArrayList<>();
        for (GuildPermission flag : GuildPermission.values()) {
            if ((flags & (1L << flag.getCode())) != 0) {
                flagsList.add(flag);
            }
        }
        return flagsList;
    }

}