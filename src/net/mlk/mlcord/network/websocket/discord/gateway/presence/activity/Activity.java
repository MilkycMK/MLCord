package net.mlk.mlcord.network.websocket.discord.gateway.presence.activity;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.activity.utils.ActivityFlag;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.activity.utils.ActivityType;

import java.util.ArrayList;

public class Activity implements JsonConvertible {
    private String name;
    private int type;
    private String url;
    private String created_at;
    private Timestamp timestamps;
    private String application_id;
    private String details;
    private String state;
    private ActivityEmoji emoji;
    private ActivityParty party;
    private ActivityAssets assets;
    private ActivitySecrets secrets;
    private boolean instance;
    private long flags;
    private final ArrayList<ActivityButton> buttons = new ArrayList<>();

    public Activity() {

    }

    public Activity(String name, ActivityType type) {
        this.setName(name);
        this.setType(type);
    }

    /**
     * set activity name
     * @param name name to set
     * @return instance of the Activity
     */
    public Activity setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * set activity url
     * @param url url to set
     * @return instance of the Activity
     */
    public Activity setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * set activity type
     * @param type type to set
     * @return instance of the Activity
     */
    public Activity setType(ActivityType type) {
        this.type = type.getCode();
        return this;
    }

    /**
     * @return activity buttons (max 2)
     */
    public ArrayList<ActivityButton> getButtons() {
        return this.buttons;
    }

    /**
     * @return raw activity flags
     */
    public long getFlagsRaw() {
        return this.flags;
    }

    /**
     * @return activity flags
     */
    public ArrayList<ActivityFlag> getFlags() {
        return ActivityFlag.getFlags(this.flags);
    }

    /**
     * @return true if the activity is an instanced game session
     */
    public boolean isInstance() {
        return this.instance;
    }

    /**
     * @return activity secrets
     */
    public ActivitySecrets getSecrets() {
        return this.secrets;
    }

    /**
     * @return activity assets
     */
    public ActivityAssets getAssets() {
        return this.assets;
    }

    /**
     * @return activity party
     */
    public ActivityParty getParty() {
        return this.party;
    }

    /**
     * @return activity emoji
     */
    public ActivityEmoji getEmoji() {
        return this.emoji;
    }

    /**
     * @return user's party status
     */
    public String getState() {
        return this.state;
    }

    /**
     * @return activity details
     */
    public String getDetails() {
        return this.details;
    }

    /**
     * @return activity application id
     */
    public String getApplicationId() {
        return this.application_id;
    }

    /**
     * @return Unix timestamps for start and/or end of the game
     */
    public Timestamp getTimestamps() {
        return this.timestamps;
    }

    /**
     * @return Unix timestamp (in milliseconds) of when the activity was added to the user's session
     */
    public String createdAt() {
        return this.created_at;
    }

    /**
     * @return activity url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @return raw type number
     */
    public int getTypeRaw() {
        return this.type;
    }

    /**
     * @return type
     */
    public ActivityType getType() {
        return ActivityType.getByCode(this.type);
    }

    /**
     * @return activity name
     */
    public String getName() {
        return this.name;
    }
}

class Timestamp implements JsonConvertible {
    private int start;
    private int end;

    /**
     * @return Unix time (in milliseconds) of when the activity started
     */
    public int getStarted() {
        return this.start;
    }

    /**
     * @return Unix time (in milliseconds) of when the activity ends
     */
    public int getEnded() {
        return this.end;
    }
}
