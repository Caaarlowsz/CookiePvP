package me.cangasso.anticheat.hacks.flyspeed;

import java.util.Iterator;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.Bukkit;
import me.cangasso.anticheat.Utills;
import org.bukkit.Server;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class MoveCheck implements Runnable
{
    public static HashMap<Player, Location> LastLocation;
    public static HashMap<Player, ArrayList<MoveLog>> Moves;
    public static HashMap<Player, Long> InvalidateExpires;
    public static MoveCheck Instance;
    public static int CheckCounter;
    public static Player LastHacker;
    public static Server server;
    
    static {
        MoveCheck.CheckCounter = 0;
    }
    
    public static void AddMove(final Player Jogador, final Location Local) {
        if (Utills.Flight(Jogador) && Utills.Speeding(Jogador)) {
            return;
        }
        final Long expires = MoveCheck.InvalidateExpires.get(Jogador);
        if (expires != null && expires > System.currentTimeMillis()) {
            return;
        }
        if (!MoveCheck.Moves.containsKey(Jogador)) {
            MoveCheck.Moves.put(Jogador, new ArrayList<MoveLog>());
        }
        synchronized (MoveCheck.Moves.get(Jogador)) {
            final MoveCheck tmp97_94 = MoveCheck.Instance;
            tmp97_94.getClass();
            MoveCheck.Moves.get(Jogador).add(new MoveLog(Jogador, Local));
        }
        // monitorexit((ArrayList)MoveCheck.Moves.get((Object)Jogador))
    }
    
    public static void Invalidate(final Player Jogador, long Tempo) {
        if (MoveCheck.Moves.containsKey(Jogador)) {
            MoveCheck.Moves.get(Jogador).clear();
        }
        Tempo += System.currentTimeMillis();
        final Long expires = MoveCheck.InvalidateExpires.get(Jogador);
        if (expires == null || expires < Tempo) {
            MoveCheck.InvalidateExpires.put(Jogador, Tempo);
        }
    }
    
    public static void Clear(final Player player) {
        if (MoveCheck.Moves.containsKey(player)) {
            MoveCheck.Moves.remove(player);
        }
        if (MoveCheck.LastLocation.containsKey(player)) {
            MoveCheck.LastLocation.remove(player);
        }
    }
    
    public MoveCheck() {
        MoveCheck.LastLocation = new HashMap<Player, Location>();
        MoveCheck.Moves = new HashMap<Player, ArrayList<MoveLog>>();
        MoveCheck.InvalidateExpires = new HashMap<Player, Long>();
        MoveCheck.Instance = this;
    }
    
    @Override
    public void run() {
        Player[] arrayOfJogador;
        for (int j = (arrayOfJogador = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
            final Player Jogador = arrayOfJogador[i];
            if (!MoveCheck.Moves.containsKey(Jogador) || !MoveCheck.LastLocation.containsKey(Jogador)) {
                MoveCheck.LastLocation.put(Jogador, Jogador.getLocation().clone());
            }
            else {
                try {
                    synchronized (MoveCheck.Moves.get(Jogador)) {
                        final ArrayList<Jump> jumps = GetJumps(MoveCheck.Moves.get(Jogador));
                        for (final Jump jump : jumps) {
                            final int Ping = ((CraftPlayer)Jogador).getHandle().ping;
                            if (!jump.isOnGround && !Utills.Flight(Jogador)) {
                                final Utills.Hack Fly = Utills.Hack.FLY;
                                if (jump.height > 5.0 || jump.isFloating) {
                                    Utills.Fly = Fly.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", new StringBuilder().append(Utills.AvisosFly.get(Jogador)).toString()).replace("ping", new StringBuilder(String.valueOf(Ping)).toString());
                                    if (Utills.Fly != null) {
                                        Utills.AvisosFly.put(Jogador, Utills.AvisosFly.get(Jogador) + 1);
                                        Utills.sendAntiCheat(Utills.Fly);
                                    }
                                    Utills.Fly = null;
                                }
                                else if ((jump.height >= 1.3 && !jump.isOnFire) || jump.height >= 2.0) {
                                    Utills.Fly = Fly.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", new StringBuilder().append(Utills.AvisosFly.get(Jogador)).toString()).replace("ping", new StringBuilder(String.valueOf(Ping)).toString());
                                    if (Utills.Fly != null) {
                                        Utills.AvisosFly.put(Jogador, Utills.AvisosFly.get(Jogador) + 1);
                                        Utills.sendAntiCheat(Utills.Fly);
                                    }
                                    Utills.Fly = null;
                                }
                            }
                            if (!Utills.Speeding(Jogador)) {
                                final Utills.Hack Speed = Utills.Hack.SPEED;
                                if ((jump.horizontalSpeed > 10.0 && jump.time > 0.5) || (jump.horizontalSpeed > 9.0 && jump.time > 1.5)) {
                                    Utills.Speed = Speed.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", new StringBuilder().append(Utills.AvisosSpeed.get(Jogador)).toString()).replace("ping", new StringBuilder(String.valueOf(Ping)).toString());
                                    if (Utills.Speed != null) {
                                        Utills.AvisosSpeed.put(Jogador, Utills.AvisosSpeed.get(Jogador) + 1);
                                        Utills.sendAntiCheat(Utills.Speed);
                                    }
                                    Utills.Speed = null;
                                }
                                else {
                                    if (jump.horizontalSpeed <= 11.0 || jump.time <= 0.5) {
                                        continue;
                                    }
                                    Utills.Speed = Speed.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", new StringBuilder().append(Utills.AvisosSpeed.get(Jogador)).toString()).replace("ping", new StringBuilder(String.valueOf(Ping)).toString());
                                    if (Utills.Speed != null) {
                                        Utills.AvisosSpeed.put(Jogador, Utills.AvisosSpeed.get(Jogador) + 1);
                                        Utills.sendAntiCheat(Utills.Speed);
                                    }
                                    Utills.Speed = null;
                                }
                            }
                        }
                        MoveCheck.Moves.get(Jogador).clear();
                    }
                    // monitorexit((ArrayList)MoveCheck.Moves.get((Object)Jogador))
                    MoveCheck.LastLocation.put(Jogador, Jogador.getLocation());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (MoveCheck.Moves.keySet().size() > Bukkit.getMaxPlayers() * 3) {
            MoveCheck.Moves.clear();
            MoveCheck.Moves = new HashMap<Player, ArrayList<MoveLog>>();
        }
    }
    
    public String GetLocationString(final Location l) {
        return "(" + l.getX() + ", " + l.getY() + ", " + l.getZ() + ")";
    }
    
    public static ArrayList<Jump> GetJumps(final ArrayList<MoveLog> moves) {
        int inc = 1;
        final ArrayList<Jump> jumps = new ArrayList<Jump>();
        while (inc < moves.size()) {
            if (moves.get(inc).isInVehicle) {
                return new ArrayList<Jump>();
            }
            final int startInc = inc;
            while (inc < moves.size() && !moves.get(inc).isAir) {
                ++inc;
            }
            if (inc > startInc + 5) {
                final MoveCheck tmp79_76 = MoveCheck.Instance;
                tmp79_76.getClass();
                final Jump jump = new Jump(moves.get(startInc), moves.get((inc + startInc - 1) / 2), moves.get(inc - 1));
                jump.isOnGround = true;
                jumps.add(jump);
            }
            if (inc >= moves.size()) {
                break;
            }
            final MoveLog start = moves.get(inc - 1);
            while (inc < moves.size() && moves.get(inc).isAir && moves.get(inc).location.getY() > moves.get(inc - 1).location.getY()) {
                ++inc;
            }
            if (inc >= moves.size()) {
                final MoveCheck tmp235_232 = MoveCheck.Instance;
                tmp235_232.getClass();
                jumps.add(new Jump(start, moves.get(inc - 1), moves.get(inc - 1)));
                break;
            }
            final MoveLog apex = moves.get(inc - 1);
            boolean isFloating = false;
            boolean isOnFire = false;
            int floatCount = 0;
            while (inc < moves.size() && moves.get(inc).isAir) {
                if (moves.get(inc - 1).location.getY() == moves.get(inc).location.getY() && !moves.get(inc).isOnLadder) {
                    if (++floatCount > 3) {
                        isFloating = true;
                    }
                }
                else {
                    floatCount = 0;
                }
                if (moves.get(inc).isOnFire) {
                    isOnFire = true;
                }
                ++inc;
            }
            MoveLog end;
            if (inc >= moves.size()) {
                end = moves.get(moves.size() - 1);
            }
            else {
                end = moves.get(inc);
            }
            final MoveCheck tmp433_430 = MoveCheck.Instance;
            tmp433_430.getClass();
            final Jump jump2 = new Jump(start, apex, end);
            jump2.isFloating = isFloating;
            jump2.isOnFire = isOnFire;
            jumps.add(jump2);
        }
        return jumps;
    }
}
