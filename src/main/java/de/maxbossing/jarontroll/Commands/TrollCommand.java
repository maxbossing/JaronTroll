package de.maxbossing.jarontroll.Commands;

import de.maxbossing.jarontroll.Constants.TextPrefix;

import de.maxbossing.jarontroll.JaronTroll;
import de.maxbossing.jarontroll.UTils.ItemBuilder;
import de.maxbossing.jarontroll.UTils.UTils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrollCommand implements CommandExecutor {

    private final String MAIN = TextPrefix.MAIN();
    private final String ERROR = TextPrefix.ERROR();

    private static ArrayList<Player> moveBlock = new ArrayList<Player>();
    private static ArrayList<Player> breakBlock = new ArrayList<Player>();
    private static ArrayList<Player> placeBlock = new ArrayList<Player>();



    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return true;
        if (args.length != 2) return true;

        Player troller = (Player) sender;

        Player victim = Bukkit.getPlayer(args[0]);


        if (victim == null) {troller.sendMessage(ERROR + "§5" + victim.getName() + " §4is not Online"); return true;}

        switch (args[1]) {
            case "freeze":{
                if (!(troller.hasPermission("Jarontroll.Troll.Freeze"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                if (!(moveBlock.contains(victim))) {
                    moveBlock.add(victim);
                    troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is now Frozen");
                } else {
                    moveBlock.remove(victim);
                    troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is now Unfrozen");
                }
                break;}

            case "burn":{
                if (!(troller.hasPermission("Jarontroll.Troll.Burn"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                victim.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 5*20, 1, false));
                victim.setFireTicks(5*20);
                troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is now on Fire");
                break;}

            case "tnt":{
                if (!(troller.hasPermission("Jarontroll.Troll.Tnt"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                victim.getWorld().spawn(victim.getLocation(), TNTPrimed.class, (tnt) -> tnt.setYield(0));
                troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is now getting bombed");
                break;}

            case "boost":{
                if (!(troller.hasPermission("Jarontroll.Troll.Boost"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                victim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 42, false, false));
                troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is now boosted");
                break;}

            case "cage":{
                if (!(troller.hasPermission("Jarontroll.Troll.Cage"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is now caged");
                try {
                    cage(victim);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;}

            case "cobweb":{
                if (!(troller.hasPermission("Jarontroll.Troll.CobWeb"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                victim.getLocation().getBlock().setType(Material.COBWEB);
                troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is now cobwebed");
                break;}

            case "nether": {
                if (!(troller.hasPermission("Jarontroll.Troll.Nether"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                victim.teleport(JaronTroll.getInstance().getServer().getWorld("world_nether").getSpawnLocation());
                troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 has been sent to hell");
                break;}

            case "hole":{
                if (!(troller.hasPermission("Jarontroll.Troll.Hole"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                victim.getInventory().addItem(new ItemBuilder(Material.WATER_BUCKET).setDisplayname("§4QUICK!!").build());

                int Y =  (int) victim.getLocation().getY();
                for (int i = Y; i > -64; i-- ) {
                    Location j = new Location(victim.getWorld(), victim.getLocation().getX(), i, victim.getLocation().getZ());
                    j.getBlock().setType(Material.AIR);
                }
                troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 has been holed");
            }

            case "mobflud": {
                if (!(troller.hasPermission("Jarontroll.Troll.MobFlud"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                for (int i = 0; i <= 10; i++) {
                    LivingEntity mob1 = (LivingEntity)victim.getWorld().spawnEntity(victim.getLocation(), EntityType.ZOMBIE);
                    Zombie z = (Zombie)mob1;
                    z.setHealth(1);
                    z.setShouldBurnInDay(false);
                    LivingEntity mob2 = (LivingEntity)victim.getWorld().spawnEntity(victim.getLocation(), EntityType.SKELETON);
                    Skeleton s = (Skeleton)mob2;
                    s.setHealth(1);
                    s.setShouldBurnInDay(false);
                }
                troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is under attack");
                break;
            }

            case "breakBlock": {
                if (!(troller.hasPermission("Jarontroll.Troll.BreakBlock"))) {troller.sendMessage(ERROR +"Insufficient permissions"); return true;}

                if (!(breakBlock.contains(victim))) {
                    breakBlock.add(victim);
                    troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is now to weak to break blocks");
                } else {
                    breakBlock.remove(victim);
                    troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is not that weak anymore");
                }
                break;
            }

            case "placeBlock": {
                if (!(troller.hasPermission("Jarontroll.Troll.PlaceBlock"))) {
                    troller.sendMessage(ERROR + "Insufficient permissions");
                    return true;
                }

                if (!(placeBlock.contains(victim))) {
                    placeBlock.add(victim);
                    troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is now too weak to place blocks");
                } else {
                    placeBlock.remove(victim);
                    troller.sendMessage(MAIN + "§5" + victim.getName() + "§2 is not too weak to place blocks anymore");
                }
                break;
            }

            default: {
                troller.sendMessage(ERROR + "§5" + args[1] + " §4is not a valid argument");
                break;}

        }
        return false;
    }

    public static ArrayList<Player> getMoveBlock() { return moveBlock; }
    public static ArrayList<Player> getBreakBlock() { return breakBlock; }
    public static ArrayList<Player> getPlaceBlock() {
        return placeBlock;
    }

    private void cage(Player victim) throws InterruptedException {

        Location location = victim.getLocation();

        victim.teleport(location);



        Location locx1 = new Location(location.getWorld(),location.getX() + 1, location.getY() + 1, location.getZ());
        Location locz1 = new Location(location.getWorld(),location.getX() - 1, location.getY() + 1, location.getZ());
        Location locx2 = new Location(location.getWorld(), location.getX() , location.getY() + 1, location.getZ() + 1);
        Location locz2 = new Location(location.getWorld(), location.getX(), location.getY() + 1, location.getZ() - 1);

        Location locx1y = new Location(location.getWorld(),location.getX() + 1, location.getY(), location.getZ());
        Location locz1y = new Location(location.getWorld(),location.getX() - 1, location.getY(), location.getZ());
        Location locx2y = new Location(location.getWorld(), location.getX() , location.getY(), location.getZ() + 1);
        Location locz2y = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ() - 1);



        locx1.getBlock().setType(Material.BEDROCK);
        locx2.getBlock().setType(Material.BEDROCK);
        locz1.getBlock().setType(Material.BEDROCK);
        locz2.getBlock().setType(Material.BEDROCK);

        locx1y.getBlock().setType(Material.BEDROCK);
        locx2y.getBlock().setType(Material.BEDROCK);
        locz1y.getBlock().setType(Material.BEDROCK);
        locz2y.getBlock().setType(Material.BEDROCK);



        new BukkitRunnable() {
            @Override
            public void run() {
                locx1.getBlock().setType(Material.AIR);
                locx2.getBlock().setType(Material.AIR);
                locz1.getBlock().setType(Material.AIR);
                locz2.getBlock().setType(Material.AIR);

                locx1y.getBlock().setType(Material.AIR);
                locx2y.getBlock().setType(Material.AIR);
                locz1y.getBlock().setType(Material.AIR);
                locz2y.getBlock().setType(Material.AIR);

            }
        }.runTaskLater(JaronTroll.getInstance(),  10*20);
    }
}
