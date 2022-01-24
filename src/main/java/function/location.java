package function;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class location {
    public static void Location(String name, Plugin plugin) {
        Player player = Bukkit.getPlayer(name);
        assert player != null;
        String msg="";
        if(player.getWorld().getName().equals("world")){
            msg=ChatColor.GREEN+"\u4e3b\u4e16\u754c ["+number(player.getLocation().getX())+" . "+number(player.getLocation().getY())+" . "+number(player.getLocation().getZ())+"]"+ChatColor.GRAY+" -> "+ChatColor.RED+"["+number(player.getLocation().getX()/8)+" . "+number(player.getLocation().getY()/8)+" . "+number(player.getLocation().getZ()/8)+"]";
        }else if(player.getWorld().getName().equals("nether")){
            msg=ChatColor.RED+"\u5730\u7344 ["+number(player.getLocation().getX())+" . "+number(player.getLocation().getY())+" . "+number(player.getLocation().getZ())+"]"+ChatColor.GRAY+" -> "+ChatColor.GREEN+"["+number(player.getLocation().getX()*8)+" . "+number(player.getLocation().getY()*8)+" . "+number(player.getLocation().getZ()*8)+"]";
        }else {
            msg=ChatColor.LIGHT_PURPLE+"\u7d42\u672b\u4e4b\u754c ["+number(player.getLocation().getX())+" . "+number(player.getLocation().getY())+" . "+number(player.getLocation().getZ())+"]";
        }
        plugin.getServer().broadcastMessage(ChatColor.YELLOW+name+ChatColor.WHITE+" @ "+msg);
        if (plugin.getConfig().getInt("HighLightTime") > 0) {
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "effect give "+name+" minecraft:glowing "+plugin.getConfig().getInt("HighLightTime")+" 0 true");
        }
    }

    public static BigDecimal number(Double number){
        return new BigDecimal(number).setScale(0, RoundingMode.HALF_UP);
    }
}
