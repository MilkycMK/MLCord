package net.mlk.mlcord.discord.user.voice;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.guild.member.Member;

import java.time.LocalDateTime;

public class VoiceState implements JsonConvertible {
    private String guild_id;
    private String channel_id;
    private String user_id;
    private Member member;
    private String session_id;
    private boolean deaf;
    private boolean mute;
    private boolean self_deaf;
    private boolean self_mute;
    private boolean self_stream;
    private boolean self_video;
    private boolean suppress;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime request_to_speak_timestamp;

    /**
     * @return the time at which the user requested to speak
     */
    public LocalDateTime getRequestToSpeakTimestamp() {
        return this.request_to_speak_timestamp;
    }

    /**
     * @return true if this user's permission to speak is denied
     */
    public boolean isSuppress() {
        return this.suppress;
    }

    /**
     * @return true if this user's camera is enabled
     */
    public boolean isSelfVideo() {
        return this.self_video;
    }

    /**
     * @return true if this user is streaming using "Go Live"
     */
    public boolean isSelfStream() {
        return this.self_stream;
    }

    /**
     * @return true if this user is locally muted
     */
    public boolean isSelfMute() {
        return this.self_mute;
    }

    /**
     * @return true if this user is locally deafened
     */
    public boolean isSelfDeaf() {
        return this.self_deaf;
    }

    /**
     * @return true if this user is muted by the server
     */
    public boolean isMute() {
        return this.mute;
    }

    /**
     * @return true if this user is deafened by the server
     */
    public boolean isDeaf() {
        return this.deaf;
    }

    /**
     * @return the session id for this voice state
     */
    public String getSessionId() {
        return this.session_id;
    }

    /**
     * @return guild member
     */
    public Member getMember() {
        return this.member;
    }

    /**
     * @return user id
     */
    public String getUserId() {
        return this.user_id;
    }

    /**
     * @return the channel id this user is connected to
     */
    public String getChannelId() {
        return this.channel_id;
    }

    /**
     * @return the guild id this voice state is for
     */
    public String getGuildId() {
        return this.guild_id;
    }
}
