package net.mlk.mlcord.network.websocket.discord.gateway.presence;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.network.websocket.discord.gateway.presence.activity.Activity;

import java.util.ArrayList;

public class PresenceUpdate implements JsonConvertible {
    private int since;
    private final ArrayList<Activity> activities = new ArrayList<>();
    private String status;
    private boolean afk;

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
     * @return user's new status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * @return true if afk
     */
    public boolean isAfk() {
        return this.afk;
    }
}
