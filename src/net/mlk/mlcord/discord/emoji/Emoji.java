package net.mlk.mlcord.discord.emoji;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.user.User;

import java.util.ArrayList;
import java.util.List;

public class Emoji implements JsonConvertible {
    private String id;
    private String name;
    private List<String> roles = new ArrayList<>();
    private User user;
    private boolean require_colons;
    private boolean managed;
    private boolean animated;
    private boolean available;

    /**
     * @return true if this emoji can be used, may be false due to loss of Server Boosts
     */
    public boolean isAvailable() {
        return this.available;
    }

    /**
     * @return true if this emoji is animated
     */
    public boolean isAnimated() {
        return this.animated;
    }

    /**
     * @return true if this emoji is managed
     */
    public boolean isManaged() {
        return this.managed;
    }

    /**
     * @return true if this emoji must be wrapped in colons
     */
    public boolean isRequireColons() {
        return this.require_colons;
    }

    /**
     * user that created emoji
     */
    public User getUser() {
        return this.user;
    }

    /**
     * @return roles id allowed to use this emoji
     */
    public List<String> getRoles() {
        return this.roles;
    }

    /**
     * @return emoji id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return emoji name
     */
    public String getName() {
        return this.name;
    }
}
