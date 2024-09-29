package net.mlk.mlcord.discord.emoji.util;

public enum StickerFormat {
    UNDEFINED(-1),
    PNG(1),
    APNG(2),
    LOTTIE(3),
    GIF(4);

    private final int code;
    StickerFormat(int code) {
        this.code = code;
    }

    /**
     * @return format code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code format code
     * @return format
     */
    public static StickerFormat getByCode(int code) {
        for (StickerFormat format : values()) {
            if (format.getCode() == code) {
                return format;
            }
        }
        return UNDEFINED;
    }
}
