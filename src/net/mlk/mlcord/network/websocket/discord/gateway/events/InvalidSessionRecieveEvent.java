package net.mlk.mlcord.network.websocket.discord.gateway.events;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.network.websocket.discord.utils.DiscordEvent;

public class InvalidSessionRecieveEvent extends DiscordEvent implements JsonConvertible {
    private boolean d;

    /**
     * @return true if session can be resumed
     */
    public boolean canResume() {
        return this.d;
    }
}
