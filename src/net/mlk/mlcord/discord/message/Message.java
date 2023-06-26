package net.mlk.mlcord.discord.message;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.Discord;
import net.mlk.mlcord.discord.application.Application;
import net.mlk.mlcord.discord.channel.Channel;
import net.mlk.mlcord.discord.channel.ChannelMention;
import net.mlk.mlcord.discord.emoji.Reaction;
import net.mlk.mlcord.discord.emoji.StickerItem;
import net.mlk.mlcord.discord.guild.member.Member;
import net.mlk.mlcord.discord.guild.member.UserMention;
import net.mlk.mlcord.discord.guild.roles.Role;
import net.mlk.mlcord.discord.guild.roles.RoleSubscriptionData;
import net.mlk.mlcord.discord.message.activity.MessageActivity;
import net.mlk.mlcord.discord.message.attachments.Attachment;
import net.mlk.mlcord.discord.message.components.MessageComponent;
import net.mlk.mlcord.discord.message.embeds.Embed;
import net.mlk.mlcord.discord.message.interactions.MessageInteraction;
import net.mlk.mlcord.discord.message.reference.MessageReference;
import net.mlk.mlcord.discord.message.util.MessageFlag;
import net.mlk.mlcord.discord.message.util.MessageType;
import net.mlk.mlcord.discord.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Message implements JsonConvertible {
    private String id;
    private String channel_id;
    private User author;
    private String content;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime timestamp;
    @JsonField(dateFormat = Discord.TIMESTAMP_FORMAT)
    private LocalDateTime edited_timestamp;
    private boolean tts;
    private boolean mention_everyone;
    private final List<UserMention> mentions = new ArrayList<>();
    private final List<Role> mention_roles = new ArrayList<>();
    private final List<ChannelMention> mention_channels = new ArrayList<>();
    private final List<Attachment> attachments = new ArrayList<>();
    private final List<Embed> embeds = new ArrayList<>();
    private final List<Reaction> reactions = new ArrayList<>();
    private String nonce;
    private boolean pinned;
    private String webhook_id;
    private int type;
    private MessageActivity activity;
    private Application application;
    private String application_id;
    private MessageReference message_reference;
    private long flags;
    private Message referenced_message;
    private MessageInteraction interaction;
    private Channel thread;
    private final List<MessageComponent> components = new ArrayList<>();
    private final List<StickerItem> sticker_items = new ArrayList<>();
    private int position;
    private RoleSubscriptionData role_subscription_data;
    private String guild_id;
    private Member member;

    /**
     * create event only
     * @return member
     */
    public Member getMember() {
        return this.member;
    }

    /**
     * create event only
     * @return guild id
     */
    public String getGuildId() {
        return this.guild_id;
    }

    /**
     * @return data of the role subscription purchase or renewal that prompted this ROLE_SUBSCRIPTION_PURCHASE message
     */
    public RoleSubscriptionData getRoleSubscriptionData() {
        return this.role_subscription_data;
    }

    /**
     * @return position of the message in a thread
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * @return message stickers
     */
    public List<StickerItem> getStickerItems() {
        return this.sticker_items;
    }

    /**
     * @return message components
     */
    public List<MessageComponent> getComponents() {
        return this.components;
    }

    /**
     * @return the thread that was started from this message
     */
    public Channel getThread() {
        return this.thread;
    }

    /**
     * sent if the message is a response to an Interaction
     * @return interaction
     */
    public MessageInteraction getInteraction() {
        return this.interaction;
    }

    /**
     * @return the message associated with the message_reference
     */
    public Message getReferencedMessage() {
        return this.referenced_message;
    }

    /**
     * @return raw flags value
     */
    public long getFlagsRaw() {
        return this.flags;
    }

    /**
     * @return flags
     */
    public List<MessageFlag> getFlags() {
        return MessageFlag.getFlags(this.flags);
    }

    /**
     * @return data showing the source of a crosspost, channel follow add, pin, or reply message
     */
    public MessageReference getMessageReference() {
        return this.message_reference;
    }

    /**
     * @return application id
     */
    public String getApplicationId() {
        return this.application_id;
    }

    /**
     * sent with Rich Presence-related chat embeds
     * @return application object
     */
    public Application getApplication() {
        return this.application;
    }

    /**
     * sent with Rich Presence-related chat embeds
     * @return message activity
     */
    public MessageActivity getActivity() {
        return this.activity;
    }

    /**
     * @return message type raw
     */
    public int getTypeRaw() {
        return this.type;
    }

    /**
     * @return message type
     */
    public MessageType getType() {
        return MessageType.getByCode(this.type);
    }

    /**
     * @return webhook id if message generated by webhook
     */
    public String getWebhookId() {
        return this.webhook_id;
    }

    /**
     * @return true if message is pinned
     */
    public boolean isPinned() {
        return this.pinned;
    }

    /**
     * @return message nonce
     */
    public String getNonce() {
        return this.nonce;
    }

    /**
     * @return message reactions
     */
    public List<Reaction> getReactions() {
        return this.reactions;
    }

    /**
     * @return message embeds
     */
    public List<Embed> getEmbeds() {
        return this.embeds;
    }

    /**
     * @return channels that mentioned in message
     */
    public List<ChannelMention> getMentionedChannels() {
        return this.mention_channels;
    }

    /**
     * @return roles that mentioned in message
     */
    public List<Role> getMentionedRoles() {
        return this.mention_roles;
    }

    /**
     * @return users that mentioned in message
     */
    public List<UserMention> getMentionedUsers() {
        return this.mentions;
    }

    /**
     * @return true if everyone was mentioned in message
     */
    public boolean isEveryoneMentioned() {
        return this.mention_everyone;
    }

    /**
     * @return true if tts message
     */
    public boolean isTts() {
        return this.tts;
    }

    /**
     * @return time when message edited
     */
    public LocalDateTime getEditDate() {
        return this.edited_timestamp;
    }

    /**
     * @return time when message created
     */
    public LocalDateTime getCreationDate() {
        return this.timestamp;
    }

    /**
     * @return message content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * @return message author
     */
    public User getAuthor() {
        return this.author;
    }

    /**
     * @return message channel id
     */
    public String getChannelId() {
        return this.channel_id;
    }

    /**
     * @return message id
     */
    public String getId() {
        return this.id;
    }
}
