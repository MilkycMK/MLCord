package net.mlk.mlcord.network.websocket.discord.gateway;

import net.mlk.jmson.annotations.JsonObject;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.PresenceUpdate;
import net.mlk.mlcord.network.websocket.discord.utils.DiscordEvent;
import net.mlk.mlcord.network.websocket.discord.utils.DiscordIntent;
import net.mlk.mlcord.network.websocket.discord.utils.DiscordOpcode;

import java.util.HashSet;

@JsonObject(key="d", ignoreNull = true)
public class Identify extends DiscordEvent implements JsonConvertible {
    private String token;
    private ConnectionProperties properties;
    private boolean compress;
    private int large_threshold = 50;
    private PresenceUpdate presence;
    private int intents;
//    private int[] shard;

    public Identify(String token, int intents) {
        super(DiscordOpcode.IDENTIFY.getValue());
        this.token = token;
        this.intents = intents;
        this.properties = new ConnectionProperties(System.getProperty("os.name"), "MLCord", "desktop");
    }

    /**
     * @return current presence
     */
    public PresenceUpdate getPresence() {
        return this.presence;
    }

    /**
     * set current presence
     * @param presence presence to set
     * @return Identify instance
     */
    public Identify setPresence(PresenceUpdate presence) {
        this.presence = presence;
        return this;
    }

    /**
     * set total number of members where the gateway will stop sending offline members in the guild member list (50 - 250)
     * @param count value to set
     * @return Identify instance
     */
    public Identify setMaxMembers(int count) {
        this.large_threshold = count;
        return this;
    }

    /**
     * @return Value between 50 and 250, total number of members where the gateway will stop sending offline members in the guild member list
     */
    public int getMaxMembers() {
        return this.large_threshold;
    }

    /**
     * @return true if compress enabled
     */
    public boolean isCompress() {
        return this.compress;
    }

    /**
     * set compress value
     * @param compress value to set
     * @return Identify instance
     */
    public Identify setCompress(boolean compress) {
        this.compress = compress;
        return this;
    }

    /**
     * @return intents
     */
    public HashSet<DiscordIntent> getIntents() {
        return DiscordIntent.getIntentsSet(this.intents);
    }

    /**
     * set intents
     * @param intents intents to set
     * @return Identify instance
     */
    public Identify setIntents(int intents) {
        this.intents = intents;
        return this;
    }

    /**
     * @return connection properties
     */
    public ConnectionProperties getProperties() {
        return this.properties;
    }

    /**
     * set connection properties
     * @param properties connection properties to set
     * @return instance
     */
    public Identify setConnectionProperties(ConnectionProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * @return token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * set token
     * @param token token to set
     * @return instance
     */
    public Identify setToken(String token) {
        this.token = token;
        return this;
    }

}

class ConnectionProperties implements JsonConvertible {
    private String os;
    private String browser;
    private String device;

    public ConnectionProperties() {

    }

    public ConnectionProperties(String os, String browser, String device) {
        this.os = os;
        this.browser = browser;
        this.device = device;
    }

    /**
     * @return os property
     */
    public String getOs() {
        return this.os;
    }

    /**
     * @return browser property
     */
    public String getBrowser() {
        return this.browser;
    }

    /**
     * @return device property
     */
    public String getDevice() {
        return this.device;
    }

    /**
     * set os property
     * @param os os to set
     * @return instance
     */
    public ConnectionProperties setOs(String os) {
        this.os = os;
        return this;
    }

    /**
     * set browser property
     * @param browser browser to set
     * @return instance
     */
    public ConnectionProperties setBrowser(String browser) {
        this.browser = browser;
        return this;
    }

    /**
     * set device property
     * @param device device to set
     * @return instance
     */
    public ConnectionProperties setDevice(String device) {
        this.device = device;
        return this;
    }
}
