package net.mlk.mlcord.discord.guild.util;

public enum GuildMessageNotificationLevel {
    UNDEFINED(-1),

    /*
     members will receive notifications for all messages by default
     */
    ALL_MESSAGES(0),

    /*
     members will receive notifications only for messages that @mention them by default
     */
    ONLY_MENTIONS(1);

    private final int code;
    GuildMessageNotificationLevel(int code) {
        this.code = code;
    }

    /**
     * @return level code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code level code
     * @return level
     */
    public static GuildMessageNotificationLevel getByCode(int code) {
        for (GuildMessageNotificationLevel level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        return UNDEFINED;
    }
}
