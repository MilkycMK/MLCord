package net.mlk.mlcord.discord.message.embeds.objects;


import net.mlk.jmson.utils.JsonConvertible;

public class EmbedThumbnail implements JsonConvertible {
    private String url;
    private String proxy_url;
    private long height;
    private long width;

    /**
     * set proxy thumbnail url
     * @param url proxy thumbnail url
     * @return this
     */
    public EmbedThumbnail setProxyUrl(String url) {
        this.proxy_url = url;
        return this;
    }

    /**
     * set thumbnail url
     * @param url thumbnail url
     * @return this
     */
    public EmbedThumbnail setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * set thumbnail width
     * @param width thumbnail width
     * @return this
     */
    public EmbedThumbnail setWidth(long width) {
        this.width = width;
        return this;
    }

    /**
     * set thumbnail height
     * @param height thumbnail height
     * @return this
     */
    public EmbedThumbnail setHeight(long height) {
        this.height = height;
        return this;
    }

    /**
     * @return height of source
     */
    public long getHeight() {
        return this.height;
    }

    /**
     * @return width of source
     */
    public long getWidth() {
        return this.width;
    }

    /**
     * @return proxied url
     */
    public String getProxyUrl() {
        return this.proxy_url;
    }

    /**
     * @return source url
     */
    public String getUrl() {
        return this.url;
    }
}
