package net.mlk.mlcord.discord.guild.util;

public enum GuildPremiumTier {
    UNDEFINED(-1),

    /*
     guild has not unlocked any Server Boost perks
     */
    NONE(0),

    /*
     guild has unlocked Server Boost level 1 perks
     */
    TIER_1(1),

    /*
     guild has unlocked Server Boost level 2 perks
     */
    TIER_2(2),

    /*
     guild has unlocked Server Boost level 3 perks
     */
    TIER_3(3);

    private final int code;
    GuildPremiumTier(int code) {
        this.code = code;
    }

    /**
     * @return tier code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code tier code
     * @return tier
     */
    public static GuildPremiumTier getByCode(int code) {
        for (GuildPremiumTier tier : values()) {
            if (tier.getCode() == code) {
                return tier;
            }
        }
        return UNDEFINED;
    }
}
