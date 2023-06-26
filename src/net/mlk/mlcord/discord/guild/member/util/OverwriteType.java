package net.mlk.mlcord.discord.guild.member.util;

public enum OverwriteType {
    UNDEFINED(-1),
    ROLE(0),
    MEMBER(1);

    private final int code;
    OverwriteType(int code) {
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
    public static OverwriteType getByCode(int code) {
        for (OverwriteType type : values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return UNDEFINED;
    }

    /**
     * @param name type name
     * @return type by name
     */
    public static OverwriteType getByName(String name) {
        for (OverwriteType type : values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return UNDEFINED;
    }
}
