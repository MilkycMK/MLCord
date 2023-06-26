package net.mlk.mlcord.discord.message.components.util;

/**
 * Enum with message components types
 */
public enum MessageComponentType {
    UNDEFINED(-1),
    /*
     Container for other components
     */
    ACTION_ROW(1),

    /*
     Button object
     */
    BUTTON(2),

    /*
     Select menu for picking from defined text options
     */
    STRING_SELECT(3),

    /*
     Text input object
     */
    TEXT_INPUT(4),

    /*
     Select menu for users
     */
    USER_SELECT(5),

    /*
     Select menu for roles
     */
    ROLE_SELECT(6),

    /*
     Select menu for mentionables (users and roles)
     */
    MENTIONABLE_SELECT(7),

    /*
     Select menu for channels
     */
    CHANNEL_SELECT(8);

    private final int code;
    MessageComponentType(int code) {
        this.code = code;
    }

    /**
     * @param code code of the type
     * @return type by code or null
     */
    public static MessageComponentType getByCode(int code) {
        for (MessageComponentType type : values()) {
            if (code == type.getCode()) {
                return type;
            }
        }
        return UNDEFINED;
    }

    /**
     * @return type code
     */
    public int getCode() {
        return this.code;
    }

}