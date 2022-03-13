package pl.pijok.aidisabler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.pijok.api.Debugger;

public class AIDisabler extends JavaPlugin {

    private Debugger debugger;

    @Override
    public void onEnable() {

        API.setupAPI(this);

        if(!loadStuff(false)){
            debugger.log("&cSomething went wrong while enabling " + getDescription().getName() + "! Disabling...");
            getServer().getPluginManager().disablePlugin(this);
            return;
    }
        else{
            debugger.log("&aEverything loaded!");
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
            AIController.checkSpawnedMobs();
        }, 30L);

    }

    @Override
    public void onDisable() {

    }

    public boolean loadStuff(boolean reload){
        try{

            if(!reload){
                Listeners.register(this);
                Commands.register(this);
            }

            AIController.loadMobs();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
