package riyaya1528.paper.chatregulation;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatRegulation extends JavaPlugin {
    public static ChatRegulation instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        Bukkit.getPluginManager().registerEvents(new Chat(),this);
        System.out.println("[ChatRegulation]プラグインが有効になりました");
    }

    @Override
    public void onDisable() {
        System.out.println("[ChatRegulation]プラグインが無効になりました");
    }
}
