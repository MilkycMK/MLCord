package net.mlk.mlcord.discord.channel.forum.util;

public enum ForumLayoutType {
    UNDEFINED(-1),
    /*
     No default has been set for forum channel
     */
    NOT_SET(0),

    /*
     Display posts as a list
     */
    LIST_VIEW(1),

    /*
     Display posts as a collection of tiles
     */
    GALLERY_VIEW(2);

    private final int code;
    ForumLayoutType(int code) {
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
     * @return type by code
     */
    public static ForumLayoutType getByCode(int code) {
        for (ForumLayoutType type : values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return UNDEFINED;
    }
}