package net.mlk.mlcord.discord.user.connections.util;

public enum ConnectionVisibility {
    NONE(0),
    EVERYONE(1);

    private final int code;
    ConnectionVisibility(int code) {
        this.code = code;
    }

    /**
     * @return visibility code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code code to get
     * @return visibility by code
     */
    public static ConnectionVisibility getByCode(int code) {
        for (ConnectionVisibility visibility : values()) {
            if (visibility.getCode() == code) {
                return visibility;
            }
        }
        return NONE;
    }
}
