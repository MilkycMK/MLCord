package net.mlk.mlcord.network.websocket.discord.gateway.presence;

import net.mlk.jmson.annotations.JsonObject;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.activity.Activity;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.activity.utils.ActivityType;
import net.mlk.mlcord.network.websocket.discord.gateway.utils.DiscordClientStatus;

import java.util.ArrayList;

@JsonObject(ignoreNull = true)
public class PresenceUpdate implements JsonConvertible {
    private int since;
    private String guild_id;
    private final ArrayList<Activity> activities = new ArrayList<>();
    private String status;
    private boolean afk;

    /**
     * add new activity to list
     * @param name activity name
     * @param type activity type
     * @return created activity
     */
    public Activity addActivity(String name, ActivityType type) {
        Activity activity = new Activity(name, type);
        this.activities.add(activity);
        return activity;
    }

    /**
     * @return time in milliseconds when client start idle
     */
    public int getSince() {
        return this.since;
    }

    /**
     * @return user activities
     */
    public ArrayList<Activity> getActivities() {
        return this.activities;
    }

    /**
     * @return user's new status raw
     */
    public String getStatusRaw() {
        return this.status;
    }

    /**
     * @return user's new status
     */
    public DiscordClientStatus getStatus() {
        return DiscordClientStatus.getByName(this.status);
    }

    /**
     * @return true if afk
     */
    public boolean isAfk() {
        return this.afk;
    }
}
