package net.mlk.mlcord.discord.emoji.util;

public enum StickerFormatType {
    UNDEFINED(-1),
    PNG(1),
    APNG(2),
    LOTTIE(3),
    GIF(4);

    private final int code;
    StickerFormatType(int code) {
        this.code = code;
    }

    /**
     * @param code code of the type
     * @return type by code or null
     */
    public static StickerFormatType getByCode(int code) {
        for (StickerFormatType type : values()) {
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