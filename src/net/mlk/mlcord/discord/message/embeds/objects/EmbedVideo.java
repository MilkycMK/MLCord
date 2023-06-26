package net.mlk.mlcord.discord.message.embeds.objects;

import net.mlk.jmson.utils.JsonConvertible;

public class EmbedVideo implements JsonConvertible {
    private String url;
    private String proxy_url;
    private long height;
    private long width;

    /**
     * set proxy video url
     * @param url proxy video url
     * @return this
     */
    public EmbedVideo setProxyUrl(String url) {
        this.proxy_url = url;
        return this;
    }

    /**
     * set video url
     * @param url video url
     * @return this
     */
    public EmbedVideo setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * set video width
     * @param width video width
     * @return this
     */
    public EmbedVideo setWidth(long width) {
        this.width = width;
        return this;
    }

    /**
     * set video height
     * @param height video height
     * @return this
     */
    public EmbedVideo setHeight(long height) {
        this.height = height;
        return this;
    }

    /**
     * set video size(height & width)
     * @param height heigth to set
     * @param width width to set
     * @return this
     */
    public EmbedVideo setSize(int height, int width) {
        this.height = height;
        this.width = width;
        return this;
    }

    /**
     * set video size(x & x)
     * @param size size to set
     * @return this
     */
    public EmbedVideo setSize(int size) {
        this.height = size;
        this.width = size;
        return this;
    }

    /**
     * @return height of video
     */
    public long getHeight() {
        return this.height;
    }

    /**
     * @return width of video
     */
    public long getWidth() {
        return this.width;
    }

    /**
     * @return proxied video url
     */
    public String getProxyUrl() {
        return this.proxy_url;
    }

    /**
     * @return video url
     */
    public String getUrl() {
        return this.url;
    }
}