package dice.jiuc.dicytotems;

import dice.jiuc.ru.japi.DataBase;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static DataBase dataBase;
    @Override
    public void onEnable() {

        saveDefaultConfig();
        dataBase = new DataBase("database.yml", this);

        Bukkit.getServer().getPluginManager().registerEvents(new UseTotemEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ReloadTotemEvent(), this);
    }

    @Override
    public void onDisable() {
    }

    public static DataBase getDataBase(){ return dataBase; }
}
