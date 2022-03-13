package pl.pijok.aidisabler.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import pl.pijok.aidisabler.AIController;
import pl.pijok.aidisabler.AIDisabler;

public class EntitySpawnListener implements Listener {

    private final AIDisabler plugin;

    public EntitySpawnListener(AIDisabler plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent event){
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            AIController.checkMob(event.getEntity());
        }, 1L);
    }

}
