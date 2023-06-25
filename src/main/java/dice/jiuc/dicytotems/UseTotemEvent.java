package dice.jiuc.dicytotems;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;

public class UseTotemEvent implements Listener {
    @EventHandler
    public static void onUse(EntityResurrectEvent e){
        if(e.isCancelled()) return;
        if(!(e.getEntity() instanceof Player)) return;

        Player player = (Player) e.getEntity();
        String path = "players."+player.getName();
        if(Main.getDataBase().getConfig().contains(path) & Main.getDataBase().getConfig().getBoolean(path)) e.setCancelled(true);
        else Main.getDataBase().write(path, true);
    }
}
