package net.mlk.mlcord.network.websocket.discord.gateway.events;

import net.mlk.jmson.annotations.JsonObject;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.network.websocket.discord.utils.DiscordEvent;

import java.util.ArrayList;

@JsonObject(key = "d")
public class HelloReceiveEvent extends DiscordEvent implements JsonConvertible {
    private int heartbeat_interval;
    private final ArrayList<String> _trace = new ArrayList<>();

    /**
     * @return discord heartbeat interval
     */
    public int getHeartBeatInterval() {
        return this.heartbeat_interval;
    }

    /**
     * @return discord trace
     */
    public ArrayList<String> getTrace() {
        return this._trace;
    }
}