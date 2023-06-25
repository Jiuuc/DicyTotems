package dice.jiuc.dicytotems;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.world.TimeSkipEvent;

public class ReloadTotemEvent implements Listener{

    @EventHandler
    public static void onDeath(PlayerDeathEvent e){
        Main.getDataBase().write("players."+e.getPlayer().getName(), false);

    }

    @EventHandler
    public static void onSleep(TimeSkipEvent e){
        if(e.getSkipReason() != TimeSkipEvent.SkipReason.NIGHT_SKIP) return;

        for(Player player: Bukkit.getOnlinePlayers()){
            if(player.isSleeping()) Main.getDataBase().write("players." + player.getName(), false);
        }
    }
}
