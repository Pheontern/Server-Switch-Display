package io.github.pheontern.serverswitchdisplay;

import com.google.inject.Inject;
import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import org.slf4j.Logger;

import java.nio.file.Path;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.*;
import static net.kyori.adventure.text.format.TextColor.color;

@Plugin(
        id = "serverswitchdisplay",
        name = "Server Switch Display",
        version = BuildConstants.VERSION,
        description = "Displays which server a player has switched to in chat.",
        authors = {"Pheontern"}
)
public class ServerSwitchDisplay {

    private final ProxyServer server;
    private final Logger logger;
    private final Path dataDirectory;

    @Inject
    public ServerSwitchDisplay(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;

        logger.info("Hello there! I made my first plugin with Velocity.");
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        // Do some operation demanding access to the Velocity API here.
        // For instance, we could register an event:
        //server.getEventManager().register(this, new PlayerChatEvent());
    }

    @Subscribe(order = PostOrder.NORMAL)
    public void onPlayerChat(PlayerChatEvent event) {
        final Component component = text()
                .content("Hello").color(color(0x13f832))
                .append(text(" world!", GREEN))
                .build();

        server.sendMessage(component);
    }
}
