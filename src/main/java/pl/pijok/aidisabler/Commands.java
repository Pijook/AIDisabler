package pl.pijok.aidisabler;

import pl.pijok.aidisabler.commands.DisablerCommand;

public class Commands {

    public static void register(AIDisabler plugin){
        plugin.getCommand("aidisabler").setExecutor(new DisablerCommand(plugin));
    }

}
