package net.mlk.mlcord.discord.channel.stage;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.channel.stage.util.StagePrivacyLevel;

public class StageInstance implements JsonConvertible {
    private String id;
    private String guild_id;
    private String channel_id;
    private String topic;
    private int privacy_level;
    private boolean discoverable_disabled;
    private String guild_scheduled_event_id;

    /**
     * @return The id of the scheduled event for this Stage instance
     */
    public String getScheduledEventId() {
        return this.guild_scheduled_event_id;
    }

    /**
     * @return true if Stage Discovery is disabled (deprecated)
     */
    public boolean isDiscoverableDisabled() {
        return this.discoverable_disabled;
    }

    /**
     * @return raw privacy level value
     */
    public int getPrivacyLevelRaw() {
        return this.privacy_level;
    }

    /**
     * @return privacy level
     */
    public StagePrivacyLevel getPrivacyLevel() {
        return StagePrivacyLevel.getByCode(this.privacy_level);
    }

    /**
     * @return stage topic
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * @return channel id
     */
    public String getChannelId() {
        return this.channel_id;
    }

    /**
     * @return guild id
     */
    public String getGuildId() {
        return this.guild_id;
    }

    /**
     * @return stage id
     */
    public String getId() {
        return this.id;
    }
}
