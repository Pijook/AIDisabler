package pl.pijok.aidisabler;

import org.bukkit.plugin.PluginManager;
import pl.pijok.aidisabler.listeners.EntitySpawnListener;

public class Listeners {

    public static void register(AIDisabler plugin){
        PluginManager pluginManager = plugin.getServer().getPluginManager();

        pluginManager.registerEvents(new EntitySpawnListener(plugin), plugin);
    }

}
