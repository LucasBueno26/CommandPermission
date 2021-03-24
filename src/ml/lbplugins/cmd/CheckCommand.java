package ml.lbplugins.cmd;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CheckCommand implements Listener {
	
	
	@EventHandler
	public void onCmd(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (Main.getInstance().getConfig().contains("Comandos." + e.getMessage().toLowerCase().replace("/", ""))) {
			for (String perm : Main.getInstance().getConfig().getStringList("Comandos." + e.getMessage().toLowerCase().replace("/", "") + ".Perms")) {
				if (!p.hasPermission(perm)) {
					e.setCancelled(true);
					p.sendMessage(Main.getInstance().getConfig().getString("Comandos." + e.getMessage().toLowerCase().replace("/", "") + ".Sem_Perm").replace("&", "§"));
					return;
				}
			}
		}
	}

}
