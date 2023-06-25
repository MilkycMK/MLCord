package net.mlk.mlcord.network.websocket.discord.gateway;

import net.mlk.jmson.annotations.JsonObject;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.network.websocket.discord.utils.DiscordEvent;
import net.mlk.mlcord.network.websocket.discord.utils.DiscordOpcode;

@JsonObject(key="d")
public class Resume extends DiscordEvent implements JsonConvertible {
    private String token;
    private String session_id;
    private String seq;

    public Resume(String token, String session_id, int seq) {
        super(DiscordOpcode.RESUME.getValue());
        this.token = token;
        this.session_id = session_id;
        this.setSequence(seq);
    }

    /**
     * @return token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * set token
     *
     * @param token token to set
     * @return instance
     */
    public Resume setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * @return session id
     */
    public String getSessionId() {
        return this.session_id;
    }

    /**
     * set session id
     *
     * @param id id to set
     * @return instance
     */
    public Resume setSessionId(String id) {
        this.session_id = id;
        return this;
    }

    /**
     * @return sequence number
     */
    @Override
    public int getSequence() {
        return this.seq.equals("null") ? -1 : Integer.parseInt(this.seq);
    }

    /**
     * set sequence number
     *
     * @param sequence sequence to set
     * @return instance
     */
    public Resume setSequence(int sequence) {
        this.seq = sequence == -1 ? "null" : String.valueOf(sequence);
        return this;
    }
}
