package net.mlk.mlcord.team;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.user.User;
import net.mlk.mlcord.team.util.MemberShipState;

import java.util.ArrayList;
import java.util.List;

public class TeamMember implements JsonConvertible {
    private int membership_state;
    private final List<String> permissions = new ArrayList<>();
    private String team_id;
    private User user;

    /**
     * @return user object
     */
    public User getUser() {
        return this.user;
    }

    /**
     * @return member team
     */
    public String getTeamId() {
        return this.team_id;
    }

    /**
     * @return list with permissions
     */
    public List<String> getPermissions() {
        return this.permissions;
    }

    /**
     * @return membership state
     */
    public MemberShipState getState() {
        return MemberShipState.getByCode(this.membership_state);
    }

    /**
     * @return raw membership state
     */
    public int getStateRaw() {
        return this.membership_state;
    }
}
