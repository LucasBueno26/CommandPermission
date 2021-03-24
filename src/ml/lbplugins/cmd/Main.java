package ml.lbplugins.cmd;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	@Override
	public void onEnable() {
		if (!new File(getDataFolder(), "config.yml").exists()) {
			saveDefaultConfig();
		}
		instance = this;
		getServer().getPluginManager().registerEvents(new CheckCommand(), this);
	}

	
	public static Main getInstance() {
		return instance;
	}
	
	
}
