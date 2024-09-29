package net.mlk.mlcord.discord.message.interactions;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.guild.member.Member;
import net.mlk.mlcord.discord.message.interactions.util.MessageInteractionType;
import net.mlk.mlcord.discord.user.User;

public class MessageInteraction implements JsonConvertible {
    private String id;
    private int type;
    private String name;
    private User user;
    private Member member;

    /**
     * @return interaction id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return raw interaction type
     */
    public int getTypeRaw() {
        return this.type;
    }

    /**
     * @return interaction type
     */
    public MessageInteractionType getType() {
        return MessageInteractionType.getByCode(this.type);
    }

    /**
     * @return user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * @return member
     */
    public Member getMember() {
        return this.member;
    }
}