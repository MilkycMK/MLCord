package net.mlk.mlcord.discord.guild.member;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.user.User;

public class UserMention extends User implements JsonConvertible {
    private Member member;

    /**
     * @return membet
     */
    public Member getMember() {
        return this.member;
    }
}
