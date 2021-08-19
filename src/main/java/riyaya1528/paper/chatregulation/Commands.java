package riyaya1528.paper.chatregulation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    public static Configuration Config = ChatRegulation.instance.getConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if(sender instanceof Player) {
            if(!sender.isOp()) {
                sender.sendMessage("§c§lこのコマンドを打つにはOP権限が必要です");
                return true;
            }
            if(command.getName().equalsIgnoreCase("chatregulation")) {
                if(args[0].length() != 0) {
                    if(args[0].equals("on")) {
                        Config.set("chat-allow", true);
                        ChatRegulation.instance.saveConfig();
                        ChatRegulation.instance.reloadConfig();
                        sender.sendMessage("チャット制限を有効にしました");
                        return true;
                    }else if(args[0].equals("off")) {
                        Config.set("chat-allow", false);
                        ChatRegulation.instance.saveConfig();
                        ChatRegulation.instance.reloadConfig();
                        sender.sendMessage("チャット制限を無効にしました");
                        return true;
                    }else if(args[0].equals("set")) {
                        if(args[1].length() != 0) {
                            Config.set("chat-deny-message", args[1]);
                            ChatRegulation.instance.saveConfig();
                            ChatRegulation.instance.reloadConfig();
                            sender.sendMessage("チャットの制限メッセージを設定しました");
                            return true;
                        }else {
                            sender.sendMessage("制限メッセージの引数を指定してください");
                            return true;
                        }
                    }
                }else {
                    sender.sendMessage("§c§l/chatregulation [on / off / set] を打ってください");
                    return true;
                }
            }
            if(command.getName().equalsIgnoreCase("regulationreload")) {
                ChatRegulation.instance.reloadConfig();
            }
        }else {
            if(args[0].length() != 0) {
                if(args[0].equals("on")) {
                    Config.set("chat-allow",true);
                    ChatRegulation.instance.saveConfig();
                    ChatRegulation.instance.reloadConfig();
                    System.out.println("チャットを有効にしました");
                    return true;
                }else if(args[0].equals("off")) {
                    Config.set("chat-allow", false);
                    ChatRegulation.instance.saveConfig();
                    ChatRegulation.instance.reloadConfig();
                    System.out.println("チャットを無効にしました");
                    return true;
                }else if(args[0].equals("set")) {
                    if(args[1].length() != 0) {
                        Config.set("chat-deny-message", args[1]);
                        ChatRegulation.instance.saveConfig();
                        ChatRegulation.instance.reloadConfig();
                        System.out.println("チャットを設定しました");
                        return true;
                    }else {
                        System.out.println("制限メッセージの引数を指定してください");
                        return true;
                    }
                }
            }else {
                System.out.println("§c§l/chatregulation [on / off / set] を打ってください");
                return true;
            }
        }
        return false;
    }
}
