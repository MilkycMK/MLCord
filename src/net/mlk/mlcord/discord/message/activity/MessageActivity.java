package net.mlk.mlcord.discord.message.activity;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.message.activity.util.MessageActivityType;

public class MessageActivity implements JsonConvertible {
    private int type;
    private String party_id;

    /**
     * @return raw activity type
     */
    public int getTypeRaw() {
        return this.type;
    }

    /**
     * @return activity type
     */
    public MessageActivityType getType() {
        return MessageActivityType.getByCode(this.type);
    }

    /**
     * @return party id
     */
    public String getPartyId() {
        return this.party_id;
    }
}
