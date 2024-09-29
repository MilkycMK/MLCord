package net.mlk.mlcord.discord.user.utils;

public enum UserPremiumType {
    NONE(0),
    NITRO_CLASSIC(1),
    NITRO(2),
    NITRO_BASIC(3);

    private final int code;
    UserPremiumType(int code) {
        this.code = code;
    }

    /**
     * @param code code of the type
     * @return type by code or null
     */
    public static UserPremiumType getByCode(int code) {
        for (UserPremiumType type : UserPremiumType.values()) {
            if (code == type.getCode()) {
                return type;
            }
        }
        return null;
    }

    /**
     * @return type code
     */
    public int getCode() {
        return this.code;
    }

}