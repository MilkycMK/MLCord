package net.mlk.mlcord.discord.utils;

public enum DiscordColor {
    DEFAULT(0),
    AQUA(1752220),
    DARK_AQUA(1146986),
    GREEN(5763719),
    DARK_GREEN(2067276),
    BLUE(3447003),
    DARK_BLUE(2123412),
    PURPLE(10181046),
    DARK_PURPLE(7419530),
    LUMINOUS_VIVID_PINK(15277667),
    DARK_VIVID_PINK(11342935),
    GOLD(15844367),
    DARK_GOLD(12745742),
    ORANGE(15105570),
    DARK_ORANGE(11027200),
    RED(15548997),
    DARK_RED(10038562),
    GREY(9807270),
    DARK_GREY(9936031),
    DARKER_GREY(8359053),
    LIGHT_GREY(12370112),
    NAVY(3426654),
    DARK_NAVY(2899536),
    YELLOW(16776960),
    WHITE(16777215);

    private final int code;
    DiscordColor(int code) {
        this.code = code;
    }

    public int getColorCode() {
        return this.code;
    }

}