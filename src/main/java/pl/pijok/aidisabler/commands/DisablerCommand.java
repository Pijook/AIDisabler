package pl.pijok.aidisabler.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.pijok.aidisabler.AIDisabler;
import pl.pijok.aidisabler.API;
import pl.pijok.api.ChatManager;

public class DisablerCommand implements CommandExecutor {

    private final ChatManager chatManager;
    private final AIDisabler plugin;

    public DisablerCommand(AIDisabler plugin){
        this.plugin = plugin;
        chatManager = API.getChatManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(!player.hasPermission("aidisabler.admin")){
                return true;
            }
        }

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("reload")){
                plugin.loadStuff(true);
                chatManager.sendMessage(sender, "&aDone!");
                return true;
            }
        }

        chatManager.sendMessage(sender, "&7/" + label + " reload");
        return true;
    }

}
