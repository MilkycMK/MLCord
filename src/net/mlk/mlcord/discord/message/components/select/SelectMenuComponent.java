package net.mlk.mlcord.discord.message.components.select;

import net.mlk.jmson.Json;
import net.mlk.jmson.annotations.JsonObject;
import net.mlk.jmson.utils.JsonConverter;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.channel.Channel;
import net.mlk.mlcord.discord.channel.util.ChannelType;
import net.mlk.mlcord.discord.guild.member.Member;
import net.mlk.mlcord.discord.guild.roles.Role;
import net.mlk.mlcord.discord.message.components.MessageComponent;
import net.mlk.mlcord.discord.user.User;

import java.util.ArrayList;
import java.util.List;

@JsonObject(methodName = "validateJson")
public class SelectMenuComponent extends MessageComponent implements JsonConvertible {
    private List<SelectOptionComponent> options;
    private final List<Integer> channel_types = new ArrayList<>();
    private String placeholder;
    private int min_values;
    private int max_values;
    private boolean disabled;
    private Json resolved;
    private List<String> values;

    /**
     * @return list of the resolved channels
     */
    public List<Channel> getResolvedChannels() {
        List<Channel> channels = new ArrayList<>();
        Json ch = this.resolved.getJson("channels");
        if (ch == null) {
            return channels;
        }
        for (String key : ch.keySet()) {
            channels.add(JsonConverter.convertToObject(ch.getJson(key), Channel.class));
        }
        return channels;
    }

    /**
     * @return list of the resolved members
     */
    public List<Member> getResolvedMembers() {
        List<Member> channels = new ArrayList<>();
        Json ch = this.resolved.getJson("members");
        if (ch == null) {
            return channels;
        }
        for (String key : ch.keySet()) {
            channels.add(JsonConverter.convertToObject(ch.getJson(key), Member.class));
        }
        return channels;
    }

    /**
     * @return list of the resolved users
     */
    public List<User> getResolvedUsers() {
        List<User> channels = new ArrayList<>();
        Json ch = this.resolved.getJson("users");
        if (ch == null) {
            return channels;
        }
        for (String key : ch.keySet()) {
            channels.add(JsonConverter.convertToObject(ch.getJson(key), User.class));
        }
        return channels;
    }

    /**
     * @return list of the resolved roles
     */
    public List<Role> getResolvedRoles() {
        List<Role> channels = new ArrayList<>();
        Json ch = this.resolved.getJson("roles");
        if (ch == null) {
            return channels;
        }
        for (String key : ch.keySet()) {
            channels.add(JsonConverter.convertToObject(ch.getJson(key), Role.class));
        }
        return channels;
    }

    /**
     * @return values if resolved object
     */
    public List<String> getValues() {
        return this.values;
    }

    /**
     * @return true if disabled
     */
    public boolean isDisabled() {
        return this.disabled;
    }

    /**
     * @return Minimum number of items that must be chosen
     */
    public int getMinValues() {
        return this.min_values;
    }

    /**
     * @return Maximum number of items that must be chosen
     */
    public int getMaxValues() {
        return this.max_values;
    }

    /**
     * @return select menu placeholder
     */
    public String getPlaceholder() {
        return this.placeholder;
    }

    /**
     * @return raw channel types if channel select component
     */
    public List<Integer> getChannelTypesRaw() {
        return this.channel_types;
    }

    /**
     * @return channel types if channel select component
     */
    public List<ChannelType> getChannelTypes() {
        return ChannelType.getByCodes(this.channel_types);
    }

    /**
     * @return select options
     */
    public List<SelectOptionComponent> getOptions() {
        return this.options;
    }

    private boolean validateJson(Json json) {
        int type = json.getInteger("type");
        return type == 3 || type == 5 || type == 6 || type == 7 || type == 8;
    }

}