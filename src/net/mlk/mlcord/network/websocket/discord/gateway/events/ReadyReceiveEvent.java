package net.mlk.mlcord.network.websocket.discord.gateway.events;

import net.mlk.jmson.annotations.JsonObject;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.application.Application;
import net.mlk.mlcord.discord.guild.Guild;
import net.mlk.mlcord.discord.user.ExtendedUser;
import net.mlk.mlcord.network.websocket.discord.utils.DispatchEvent;

import java.util.ArrayList;
import java.util.List;

@JsonObject(key="d")
public class ReadyReceiveEvent extends DispatchEvent implements JsonConvertible {
    private int v;
    private ExtendedUser user;
    private final ArrayList<Guild> guilds = new ArrayList<>();
    private String session_id;
    private String resume_gateway_url;
    private int[] shard;
    private Application application;

    /**
     * @return application
     */
    public Application getApplication() {
        return this.application;
    }

    /**
     * @return Shard information associated with this session, if sent when identifying
     */
    public int[] getShard() {
        return this.shard;
    }

    /**
     * @return resume gateway url
     */
    public String getResumeGatewayUrl() {
        return this.resume_gateway_url;
    }

    /**
     * @return session id
     */
    public String getSessionId() {
        return this.session_id;
    }

    /**
     * @return user guilds
     */
    public List<Guild> getGuilds() {
        return this.guilds;
    }

    /**
     * @return connected user
     */
    public ExtendedUser getUser() {
        return this.user;
    }

    /**
     * @return api version
     */
    public int getApiVersion() {
        return this.v;
    }
}
