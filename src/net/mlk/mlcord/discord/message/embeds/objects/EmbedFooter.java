package net.mlk.mlcord.discord.message.embeds.objects;

import net.mlk.jmson.utils.JsonConvertible;

public class EmbedFooter implements JsonConvertible {
    private String icon_url;
    private String proxy_icon_url;
    private String text;

    /**
     * set footer text
     * @param text footer text
     * @return this
     */
    public EmbedFooter setText(String text) {
        if (text.length() > 2048) {
            throw new IllegalArgumentException("Footer text length can't be > 2048");
        }
        this.text = text;
        return this;
    }

    /**
     * set footer proxy icon url
     * @param icon proxy icon url
     * @return this
     */
    public EmbedFooter setProxyIconUrl(String icon) {
        this.proxy_icon_url = icon;
        return this;
    }

    /**
     * set footer icon url
     * @param icon icon url
     * @return this
     */
    public EmbedFooter setIconUrl(String icon) {
        this.icon_url = icon;
        return this;
    }

    /**
     * @return footer text
     */
    public String getText() {
        return this.text;
    }

    /**
     * @return footer icon url
     */
    public String getIconUrl() {
        return this.icon_url;
    }

    /**
     * @return proxied footer icon url
     */
    public String getProxyIconUrl() {
        return this.proxy_icon_url;
    }
}
