package net.mlk.mlcord.discord.message.embeds.objects;

import net.mlk.jmson.utils.JsonConvertible;

public class EmbedImage implements JsonConvertible {
    private String url;
    private String proxy_url;
    private int height;
    private int width;

    /**
     * set proxy image url
     * @param url proxy image url
     * @return this
     */
    public EmbedImage setProxyUrl(String url) {
        this.proxy_url = url;
        return this;
    }

    /**
     * set image url
     * @param url image url
     * @return this
     */
    public EmbedImage setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * set image width
     * @param width image width
     * @return this
     */
    public EmbedImage setWidth(int width) {
        this.width = width;
        return this;
    }

    /**
     * set image height
     * @param height image height
     * @return this
     */
    public EmbedImage setHeight(int height) {
        this.height = height;
        return this;
    }

    /**
     * set image size(height & width)
     * @param height heigth to set
     * @param width width to set
     * @return this
     */
    public EmbedImage setSize(int height, int width) {
        this.height = height;
        this.width = width;
        return this;
    }

    /**
     * set image size(x & x)
     * @param size size to set
     * @return this
     */
    public EmbedImage setSize(int size) {
        this.height = size;
        this.width = size;
        return this;
    }

    /**
     * @return height of image
     */
    public long getHeight() {
        return this.height;
    }

    /**
     * @return width of image
     */
    public long getWidth() {
        return this.width;
    }

    /**
     * @return proxied image url
     */
    public String getProxyUrl() {
        return this.proxy_url;
    }

    /**
     * @return image url
     */
    public String getUrl() {
        return this.url;
    }
}