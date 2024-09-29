package net.mlk.mlcord.discord.message.reference;

import net.mlk.jmson.utils.JsonConvertible;

public class MessageReference implements JsonConvertible {
    private String message_id;
    private String channel_id;
    private String guild_id;
    private boolean fail_if_not_exists;

    public MessageReference() {

    }

    public MessageReference(String messageId, String channelId, String guildId) {
        this.message_id = messageId;
        this.channel_id = channelId;
        this.guild_id = guildId;
    }

    /**
     * @return message id
     */
    public String getMessageId() {
        return this.message_id;
    }

    /**
     * @return channel id
     */
    public String getChannelId() {
        return this.channel_id;
    }

    /**
     * @return guild id
     */
    public String getGuildId() {
        return this.guild_id;
    }

    /**
     * @return true if the referenced message doesn't exist instead of sending as a normal message
     */
    public boolean isFailIfNotExists() {
        return this.fail_if_not_exists;
    }
}
