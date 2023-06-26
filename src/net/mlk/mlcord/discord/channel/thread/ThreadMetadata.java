package net.mlk.mlcord.discord.channel.thread;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;

import java.time.LocalDateTime;

public class ThreadMetadata implements JsonConvertible {
    private boolean archived;
    private int auto_archive_duration;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime archive_timestamp;
    private boolean locked;
    private boolean invitable;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime create_timestamp;

    /**
     * @return timestamp of thread creation
     */
    public LocalDateTime getCreateTimestamp() {
        return this.create_timestamp;
    }

    /**
     * @return whether non-moderators can add other non-moderators to a thread
     */
    public boolean isInvitable() {
        return this.invitable;
    }

    /**
     * @return true if locked
     */
    public boolean isLocked() {
        return this.locked;
    }

    /**
     * @return timestamp when the thread's archive status was last changed
     */
    public LocalDateTime getArchiveTimestamp() {
        return this.archive_timestamp;
    }

    /**
     * @return max minutes of inactivity
     */
    public int getAutoArchiveDuration() {
        return this.auto_archive_duration;
    }

    /**
     * @return true if archived
     */
    public boolean isArchived() {
        return this.archived;
    }
}