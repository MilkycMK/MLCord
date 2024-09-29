package net.mlk.mlcord.discord.application.util;

import java.util.ArrayList;
import java.util.List;

public enum ApplicationScope {
    UNDEFINED,
    /*
     allows your app to fetch data from a user's "Now Playing/Recently Played" list — not currently available for apps
     */
    ACTIVITIES_READ,

    /*
     allows your app to update a user's activity - requires Discord approval (NOT REQUIRED FOR GAMESDK ACTIVITY MANAGER)
     */
    ACTIVITIES_WRITE,

    /*
     allows your app to read build data for a user's applications
     */
    APPLICATIONS_BUILDS_READ,

    /*
     allows your app to upload/update builds for a user's applications - requires Discord approval
     */
    APPLICATIONS_BUILDS_UPLOAD,

    /*
     allows your app to use commands in a guild
     */
    APPLICATIONS_COMMANDS,

    /*
     allows your app to update its commands using a Bearer token - client credentials grant only
     */
    APPLICATIONS_COMMANDS_UPDATE,

    /*
     allows your app to update permissions for its commands in a guild a user has permissions to
     */
    APPLICATIONS_COMMANDS_PERMISSIONS_UPDATE,

    /*
     allows your app to read entitlements for a user's applications
     */
    APPLICATIONS_ENTITLEMENTS,

    /*
     allows your app to read and update store data (SKUs, store listings, achievements, etc.) for a user's applications
     */
    APPLICATIONS_STORE_UPDATE,

    /*
     for oauth2 bots, this puts the bot in the user's selected guild by default
     */
    BOT,

    /*
     allows /users/@me/connections to return linked third-party accounts
     */
    CONNECTIONS,

    /*
     allows your app to see information about the user's DMs and group DMs - requires Discord approval
     */
    DM__CHANNELS_READ,

    /*
     enables /users/@me to return an email
     */
    EMAIL,

    /*
     allows your app to join users to a group dm
     */
    GDM_JOIN,

    /*
     allows /users/@me/guilds to return basic information about all of a user's guilds
     */
    GUILDS,

    /*
     allows /guilds/{guild.id}/members/{user.id} to be used for joining users to a guild
     */
    GUILDS_JOIN,

    /*
     allows /users/@me/guilds/{guild.id}/member to return a user's member information in a guild
     */
    GUILDS_MEMBERS_READ,

    /*
     allows /users/@me/guilds/{guild.id}/member to return a user's member information in a guild
     */
    IDENTIFY,

    /*
     allows /users/@me without email
     */
    MESSAGES_READ,

    /*
     for local rpc server api access, this allows you to read messages from all client channels
     (otherwise restricted to channels/guilds your app creates)
     */
    RELATIONSHIPS_READ,

    /*
     allows your app to know a user's friends and implicit relationships - requires Discord approval
     */
    ROLE__CONNECTIONS_WRITE,

    /*
     allows your app to update a user's connection and metadata for the app
     */
    RPC,

    /*
     for local rpc server access, this allows you to control a user's local Discord client - requires Discord approval
     */
    RPC_ACTIVITIES_WRITE,

    /*
     for local rpc server access, this allows you to update a user's activity - requires Discord approval
     */
    RPC_NOTIFICATIONS_READ,

    /*
     for local rpc server access, this allows you to receive notifications pushed out to the user - requires Discord approval
     */
    RPC_VOICE_READ,

    /*
     for local rpc server access, this allows you to update a user's voice settings - requires Discord approval
     */
    RPC_VOICE_WRITE,

    /*
     allows your app to connect to voice on user's behalf and see all the voice members - requires Discord approval
     */
    VOICE,

    /*
     this generates a webhook that is returned in the oauth token response for authorization code grants
     */
    WEBHOOK_INCOMING;

    public static ApplicationScope getByName(String name) {
        for (ApplicationScope scope : ApplicationScope.values()) {
            if (name.toLowerCase().contains(scope.name().toLowerCase().replace("_", ".").replace("..", "."))) {
                return scope;
            }
        }
        return UNDEFINED;
    }

    public static List<ApplicationScope> getByName(List<String> names) {
        List<ApplicationScope> scopes = new ArrayList<>();
        for (String name : names) {
            ApplicationScope scope = getByName(name);
            if (scope != null) {
                scopes.add(scope);
            }
        }
        return scopes;
    }
}
