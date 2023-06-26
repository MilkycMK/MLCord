package net.mlk.mlcord.discord.guild.member.events;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.guild.member.Member;
import net.mlk.mlcord.network.websocket.discord.utils.DispatchEvent;

public class GuildMemberUpdateEvent extends DispatchEvent implements JsonConvertible {
    @JsonField(key = "d")
    private Member member;

    public Member getMember() {
        return this.member;
    }
}
