package net.mlk.mlcord.discord.guild.integrations.util;

public enum IntegrationExpire {
    UNDEFINED(-1),
    REMOVE_ROLE(0),
    KICK(1);

    private final int code;
    IntegrationExpire(int code) {
        this.code = code;
    }

    /**
     * @return expire code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code expire code
     * @return expire by code
     */
    public static IntegrationExpire getByCode(int code) {
        for (IntegrationExpire expire : values()) {
            if (expire.getCode() == code) {
                return expire;
            }
        }
        return UNDEFINED;
    }
}
