package net.mlk.mlcord.discord.message.components;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.message.components.util.MessageComponentType;

public class MessageComponent implements JsonConvertible {
    protected int type;
    protected String custom_id;

    public MessageComponent() {

    }

    public MessageComponent(int type) {
        this.type = type;
    }

    /**
     * @return custom menu id
     */
    public String getCustomId() {
        return this.custom_id;
    }

    /**
     * @return raw component type
     */
    public int getTypeRaw() {
        return this.type;
    }

    /**
     * @return component type
     */
    public MessageComponentType getType() {
        return MessageComponentType.getByCode(this.type);
    }
}
