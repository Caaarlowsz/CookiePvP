package me.cangasso.API;

import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LugarAPI implements Listener
{
    public static void random(final Player p) {
        final Random random = new Random();
        final int number = random.nextInt(4);
        switch (number) {
            case 0: {
                WarpsAPI.Ir(p, "Loc1");
                break;
            }
            case 1: {
                WarpsAPI.Ir(p, "Loc2");
                break;
            }
            case 2: {
                WarpsAPI.Ir(p, "Loc3");
                break;
            }
            case 3: {
                WarpsAPI.Ir(p, "Loc4");
                break;
            }
            case 4: {
                WarpsAPI.Ir(p, "Loc5");
                break;
            }
        }
    }
}
