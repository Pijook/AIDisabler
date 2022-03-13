package pl.pijok.aidisabler;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;
import java.util.List;

public class AIController {

    private static List<EntityType> mobTypes;
    private static List<String> worldsToUse;

    public static void loadMobs(){
        mobTypes = new ArrayList<>();

        YamlConfiguration configuration = API.getConfigProvider().load("config.yml");

        for(String type : configuration.getStringList("mobsWithDisabledAI")){
            try{
                mobTypes.add(EntityType.valueOf(type));
            }
            catch(IllegalArgumentException e){
                API.getDebugger().log("&cWrong mob type! (" + type + ")");
            }
        }

        worldsToUse = configuration.getStringList("worldsToUse");
    }

    public static void checkSpawnedMobs(){
        for(String worldName : worldsToUse){
            World world = Bukkit.getWorld(worldName);
            for(LivingEntity entity : world.getLivingEntities()){
                checkMob(entity);
            }
        }
    }

    public static void checkMob(Entity entity){
        if(worldsToUse.contains(entity.getWorld().getName())){
            if(mobTypes.contains(entity.getType())){
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.setAI(false);
            }
        }
    }

}
