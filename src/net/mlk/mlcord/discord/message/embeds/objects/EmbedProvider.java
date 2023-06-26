package net.mlk.mlcord.discord.message.embeds.objects;

import net.mlk.jmson.utils.JsonConvertible;

public class EmbedProvider implements JsonConvertible {
    private String url;
    private String name;

    /**
     * set provider name
     * @param name provider name
     * @return this
     */
    public EmbedProvider setName(String name) {
        this.name = name;
        return this;
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