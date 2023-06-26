package net.mlk.mlcord.discord.emoji.util;

public enum StickerType {
    UNDEFINED(-1),
    /*
     an official sticker in a pack, part of Nitro or in a removed purchasable pack
     */
    STANDART(1),

    /*
     a sticker uploaded to a guild for the guild's members
     */
    GUILD(2);

    private final int code;
    StickerType(int code) {
        this.code = code;
    }

    /**
     * @return type code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code type code
     * @return sticker type
     */
    public static StickerType getByCode(int code) {
        for (StickerType type : values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return UNDEFINED;
    }
}
