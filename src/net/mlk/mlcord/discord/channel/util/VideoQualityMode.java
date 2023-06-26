package net.mlk.mlcord.discord.channel.util;

/**
 * Enum with channel types and codes
 */
public enum VideoQualityMode {
    UNDEFINED(-1),
    /*
     Discord chooses the quality for optimal performance
     */
    AUTO(1),

    /*
     720p
     */
    FULL(2);

    private final int code;
    VideoQualityMode(int code) {
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
     * @return type by code or null
     */
    public static VideoQualityMode getByCode(int code) {
        for (VideoQualityMode type : values()) {
            if (code == type.getCode()) {
                return type;
            }
        }
        return UNDEFINED;
    }



}