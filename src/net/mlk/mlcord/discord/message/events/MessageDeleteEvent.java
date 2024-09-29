package net.mlk.mlcord.discord.message.events;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.network.websocket.discord.utils.DispatchEvent;

public class MessageDeleteEvent extends DispatchEvent implements JsonConvertible {
    private String id;
    private String channel_id;
    private String guild_id;

    /**
     * @return message id
     */
    public String getId() {
        return this.id;
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
    public String getGuild_id() {
        return this.guild_id;
    }
}
