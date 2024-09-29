package net.mlk.mlcord.network.websocket.discord.utils;

import net.mlk.jmson.utils.JsonConvertible;

public class DiscordEvent implements JsonConvertible {
    private int op;
    private String s;
    private String t;

    protected DiscordEvent() {

    }

    protected DiscordEvent(int op) {
        this.op = op;
    }

    /**
     * @return event opcode
     */
    public int getOpcode() {
        return this.op;
    }

    /**
     * @return sequence number
     */
    public int getSequence() {
        return this.s.equalsIgnoreCase("null") ? -1 : Integer.parseInt(this.s);
    }


    /**
     * @return event type raw
     */
    public String getTypeRaw() {
        return this.t;
    }

    /**
     * @return event type
     */
    public DiscordEventType getType() {
        return DiscordEventType.getByName(this.t);
    }
}
