package net.mlk.mlcord.discord.utils;

public enum ImageFormat {
    JPG,
    JPEG,
    PNG,
    WEBP,
    GIF,
    LOTTIE;

    /**
     * @return override to return lower case
     */
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
