package net.mlk.mlcord.discord.message.attachments.util;


public enum AttachmentType {
    UNDEFINED,
    APPLICATION,
    AUDIO,
    IMAGE,
    MESSAGE,
    MULTIPART,
    TEXT,
    VIDEO;

    /**
     * @param type type in string
     * @return DiscordAttachmentType object
     */
    public static AttachmentType getByName(String type) {
        for (AttachmentType t : values()) {
            if (type.contains(t.name().toLowerCase())) {
                return t;
            }
        }
        return UNDEFINED;
    }

}