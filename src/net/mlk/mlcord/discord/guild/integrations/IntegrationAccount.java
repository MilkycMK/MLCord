package net.mlk.mlcord.discord.guild.integrations;

import net.mlk.jmson.utils.JsonConvertible;

public class IntegrationAccount implements JsonConvertible {
    private String id;
    private String name;

    /**
     * @return account id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return account name
     */
    public String getName() {
        return this.name;
    }
}
