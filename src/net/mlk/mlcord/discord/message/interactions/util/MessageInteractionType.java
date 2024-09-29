package net.mlk.mlcord.discord.message.interactions.util;

/**
 * Enum with message interaction types
 */
public enum MessageInteractionType {
    UNDEFINED(-1),
    PING(1),
    APPLICATION_COMMAND(2),
    MESSAGE_COMPONENT(3),
    APPLICATION_COMMAND_AUTOCOMPLETE(4),
    MODAL_SUBMIT(5);

    private final int code;
    MessageInteractionType(int code) {
        this.code = code;
    }

    /**
     * @return get type code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code type code
     * @return type by code
     */
    public static MessageInteractionType getByCode(int code) {
        for (MessageInteractionType type : MessageInteractionType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return UNDEFINED;
    }
}