package beanbeanjuice.beanrtp.managers.teleportation;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.UUID;

public class TeleportCooldown {

    public static HashMap<UUID, Double> cooldowns;

    public static void setupCooldown() {
        cooldowns = new HashMap<>();
    }

    public static void setCooldown(Player player, int seconds) {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cooldowns.put(player.getUniqueId(), delay);
    }

    public static int getCooldown(Player player) {
        return Math.toIntExact(Math.round((cooldowns.get(player.getUniqueId()) - (System.currentTimeMillis()))/1000));
    }

    public static boolean checkCooldown(Player player) {
        return !cooldowns.containsKey(player.getUniqueId()) || cooldowns.get(player.getUniqueId()) <= System.currentTimeMillis();
    }
}