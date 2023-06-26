package net.mlk.mlcord.network.websocket.discord.gateway.events;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.network.websocket.discord.utils.DiscordEvent;

public class HeartBeatReceiveEvent extends DiscordEvent implements JsonConvertible {
    private String d;

    /**
     * @return sequence number from heartbeat event
     */
    @Override
    public int getSequence() {
        return this.d.equals("null") ? -1 : Integer.parseInt(this.d);
    }
}
