package net.mlk.mlcord.network.websocket.discord.utils;

import net.mlk.jmson.Json;
import net.mlk.jmson.utils.JsonConverter;
import net.mlk.jmson.utils.JsonConvertible;

public class DispatchEvent extends DiscordEvent implements JsonConvertible {
    /**
     * Get dispatch event instance by "t" field in payload
     * @param payload event payload
     * @return new instance of the given event
     */
    public static DiscordEvent getDispatchEvent(Json payload) {
        DiscordEventType type = DiscordEventType.getByName(payload.getString("t"));
        if (type == null) {
            return null;
        }
        Object eventClass = type.getEventClass();
        if (eventClass == null) {
            return null;
        }
        return (DiscordEvent) JsonConverter.convertToObject(payload, (JsonConvertible) eventClass);
    }
}
