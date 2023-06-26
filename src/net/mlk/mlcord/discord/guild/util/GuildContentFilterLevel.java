package net.mlk.mlcord.discord.guild.util;

public enum GuildContentFilterLevel {
    UNDEFINED(-1),

    /*
     media content will not be scanned
     */
    DISABLED(0),

    /*
     media content sent by members without roles will be scanned
     */
    MEMBERS_WITHOUT_ROLES(1),

    /*
     media content sent by all members will be scanned
     */
    ALL_MEMBERS(2);

    private final int code;
    GuildContentFilterLevel(int code) {
        this.code = code;
    }

    /**
     * @return level code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code level code
     * @return level
     */
    public static GuildContentFilterLevel getByCode(int code) {
        for (GuildContentFilterLevel level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        return UNDEFINED;
    }
}
