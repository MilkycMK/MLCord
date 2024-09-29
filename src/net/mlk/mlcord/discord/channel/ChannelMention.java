package net.mlk.mlcord.discord.channel;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.channel.util.ChannelType;

public class ChannelMention implements JsonConvertible {
    private String id;
    private String guild_id;
    private int type;
    private String name;

    /**
     * @return type raw value
     */
    public int getTypeRaw() {
        return this.type;
    }

    /**
     * @return channel type
     */
    public ChannelType getType() {
        return ChannelType.getByCode(this.type);
    }

    /**
     * @return channel name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return channel id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return guild id
     */
    public String getGuildId() {
        return this.guild_id;
    }
}
