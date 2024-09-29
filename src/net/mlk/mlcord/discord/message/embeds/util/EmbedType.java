package net.mlk.mlcord.discord.message.embeds.util;

public enum EmbedType {
    UNDEFINED,
    RICH,
    IMAGE,
    VIDEO,
    GIFV,
    ARTICLE,
    LINK;

    public static EmbedType getByName(String name) {
        for (EmbedType type : EmbedType.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return UNDEFINED;
    }
}
