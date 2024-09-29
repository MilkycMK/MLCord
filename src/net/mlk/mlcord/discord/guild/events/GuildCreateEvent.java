package net.mlk.mlcord.discord.guild.events;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.guild.Guild;
import net.mlk.mlcord.network.websocket.discord.utils.DispatchEvent;

public class GuildCreateEvent extends DispatchEvent implements JsonConvertible {
    @JsonField(key="d")
    private Guild guild;

    /**
     * @return created guild
     */
    public Guild getGuild() {
        return this.guild;
    }
}
