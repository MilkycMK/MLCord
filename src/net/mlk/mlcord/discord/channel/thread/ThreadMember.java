package net.mlk.mlcord.discord.channel.thread;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.channel.thread.util.UserThreadFlag;
import net.mlk.mlcord.discord.guild.member.Member;

import java.time.LocalDateTime;
import java.util.List;

public class ThreadMember implements JsonConvertible {
    private String id;
    private String user_id;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime join_timestamp;
    private long flags;
    private Member member;

    /**
     * @return raw flags
     */
    public long getFlagsRaw() {
        return this.flags;
    }

    /**
     * @return flags
     */
    public List<UserThreadFlag> getFlags() {
        return UserThreadFlag.getFlags(this.flags);
    }

    /**
     * @return guild member
     */
    public Member getMember() {
        return this.member;
    }

    /**
     * @return join timestamp
     */
    public LocalDateTime getJoinTimestamp() {
        return this.join_timestamp;
    }

    /**
     * @return user id
     */
    public String getId() {
        return this.user_id;
    }

    /**
     * @return id of the thread
     */
    public String getThreadId() {
        return this.id;
    }
}