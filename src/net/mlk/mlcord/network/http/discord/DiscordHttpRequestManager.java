package net.mlk.mlcord.network.http.discord;

import net.mlk.mlcord.network.http.HttpRequestManager;

public class DiscordHttpRequestManager extends HttpRequestManager {

    public DiscordHttpRequestManager(String token, boolean isBot) {
        super.setHeader("Authorization", isBot ? "Bot " + token : token);
        super.setHeader("User-Agent", "MLCord");
        super.setHeader("Content-Type", "application/json");
    }

}
