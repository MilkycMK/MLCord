package net.mlk.mlcord.team;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.utils.ImageFormat;

import java.util.ArrayList;
import java.util.List;

public class Team implements JsonConvertible {
    private String icon;
    private String id;
    private final List<TeamMember> members = new ArrayList<>();
    private String name;
    private String owner_user_id;
    /**
     * @return team owner id
     */
    public String getOwnerId() {
        return this.owner_user_id;
    }

    /**
     * @return team name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return list of team members
     */
    public List<TeamMember> getMembers() {
        return this.members;
    }

    /**
     * @return team id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return team icon hash
     */
    public String getIconHash() {
        return this.icon;
    }

    /**
     * @return team icon url
     */
    public String getIconUrl() {
        return this.getIconUrl(ImageFormat.PNG);
    }

    /**
     * @param format image format to recieve
     * @return team icon url
     * @see Discord
     * @see ImageFormat
     */
    public String getIconUrl(ImageFormat format) {
        return String.format(Discord.TEAM_ICON_URL, this.id, this.icon, format);
    }
}
