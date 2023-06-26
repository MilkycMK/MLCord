package net.mlk.mlcord.discord.message.events;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.message.Message;
import net.mlk.mlcord.network.websocket.discord.utils.DispatchEvent;

public class MessageUpdateEvent extends DispatchEvent implements JsonConvertible {
    @JsonField(key="d")
    private Message message;

    /**
     * @return updated message
     */
    public Message getMessage() {
        return this.message;
    }
}
