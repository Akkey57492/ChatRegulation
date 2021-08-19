package riyaya1528.paper.chatregulation;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import java.util.Objects;

public class Chat implements Listener {
    public static Configuration Config = ChatRegulation.instance.getConfig();

    @EventHandler
    public void OnChat(AsyncChatEvent e) {
        if(Config.getBoolean("chat-allow")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Objects.requireNonNull(Config.getString("chat-deny-message")));
        }
    }
}
