package net.mlk.mlcord.discord.message.components.input.util;


public enum TextInputStyle {
    UNDEFINED(-1),
    /*
     Single-line input
     */
    SHORT(1),

    /*
     Multi-line input
     */
    PARAGRAPH(2);

    private final int code;
    TextInputStyle(int code) {
        this.code = code;
    }

    /**
     * @param code code of the type
     * @return type by code or null
     */
    public static TextInputStyle getByCode(int code) {
        for (TextInputStyle type : values()) {
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
