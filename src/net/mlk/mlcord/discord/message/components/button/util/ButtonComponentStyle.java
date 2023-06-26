package net.mlk.mlcord.discord.message.components.button.util;

/**
 * Enum with button stylesssssssssss
 */
public enum ButtonComponentStyle {
    UNDEFINED(-1),
    /*
     Color: blurple
     */
    PRIMARY(1),

    /*
     Color: grey
     */
    SECONDARY(2),

    /*
     Color: green
     */
    SUCCESS(3),

    /*
     Color: red
     */
    DANGER(4),

    /*
     Color: grey
     navigates to url
     */
    LINK(5);

    private final int code;
    ButtonComponentStyle(int code) {
        this.code = code;
    }

    /**
     * @param code code of the style
     * @return style by code or null
     */
    public static ButtonComponentStyle getByCode(int code) {
        for (ButtonComponentStyle type : values()) {
            if (code == type.getCode()) {
                return type;
            }
        }
        return UNDEFINED;
    }

    /**
     * @return style code
     */
    public int getCode() {
        return this.code;
    }
}