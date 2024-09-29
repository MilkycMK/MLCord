package net.mlk.mlcord.discord.message.embeds.objects;

import net.mlk.jmson.utils.JsonConvertible;

public class EmbedAuthor implements JsonConvertible {
    private String icon_url;
    private String proxy_icon_url;
    private String url;
    private String name;

    /**
     * set author name
     * @param name author name
     * @return this
     */
    public EmbedAuthor setName(String name) {
        if (name.length() > 256) {
            throw new IllegalArgumentException("Author name length can't be > 256");
        }
        this.name = name;
        return this;
    }

    /**
     * set author proxy icon url
     * @param icon proxy icon url
     * @return this
     */
    public EmbedAuthor setProxyIconUrl(String icon) {
        this.proxy_icon_url = icon;
        return this;
    }

    /**
     * set author icon url
     * @param icon icon url
     * @return this
     */
    public EmbedAuthor setIconUrl(String icon) {
        this.icon_url = icon;
        return this;
    }

    /**
     * @return author icon url
     */
    public String getIconUrl() {
        return this.icon_url;
    }

    /**
     * @return proxied author icon url
     */
    public String getProxyIconUrl() {
        return this.proxy_icon_url;
    }

    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return this.url;
    }
}