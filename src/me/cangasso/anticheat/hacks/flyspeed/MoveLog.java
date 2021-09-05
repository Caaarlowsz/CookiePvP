package me.cangasso.anticheat.hacks.flyspeed;

import org.bukkit.Material;
import org.bukkit.util.Vector;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class MoveLog
{
    public Player player;
    public long time;
    public Location location;
    public Vector velocity;
    public boolean isSprinting;
    public boolean isSneaking;
    public boolean isAir;
    public boolean isOnFire;
    public boolean isInVehicle;
    public boolean isOnLadder;
    
    public MoveLog(final Player Jogador, final Location Local) {
        this.player = Jogador;
        this.location = Local.clone();
        this.time = System.currentTimeMillis();
        this.velocity = Jogador.getVelocity();
        this.isSprinting = Jogador.isSprinting();
        this.isSneaking = Jogador.isSneaking();
        this.isInVehicle = Jogador.isInsideVehicle();
        this.isOnFire = (Jogador.getFireTicks() > 0);
        if (Math.abs(this.velocity.getX()) < 0.001) {
            this.velocity.setX(0);
        }
        if (Math.abs(this.velocity.getY()) < 0.001) {
            this.velocity.setY(0);
        }
        if (Math.abs(this.velocity.getZ()) < 0.001) {
            this.velocity.setZ(0);
        }
        this.isOnLadder = this.isInBlock(this.location.getBlock().getType());
        this.isAir = this.isBlockAir(this.location);
    }
    
    public double Speed(final MoveLog Mover) {
        if (Mover == null) {
            return 0.0;
        }
        final long Time = Math.abs(this.time - Mover.time);
        final double Distancia = this.location.distance(Mover.location);
        return Distancia / Time;
    }
    
    private boolean isMaterialAir(final Material Tipo) {
        return Tipo == Material.AIR || Tipo == Material.TORCH || Tipo == Material.REDSTONE_TORCH_OFF || Tipo == Material.REDSTONE_TORCH_ON || Tipo == Material.SIGN;
    }
    
    private boolean isInBlock(final Material Tipo) {
        return Tipo != Material.AIR || Tipo != Material.TORCH || Tipo != Material.REDSTONE_TORCH_OFF || Tipo != Material.REDSTONE_TORCH_ON || Tipo != Material.SIGN;
    }
    
    private boolean isBlockAir(final Location Local) {
        final Location Localiza\u00e7\u00e3o = Local.clone();
        final double X = Localiza\u00e7\u00e3o.getX();
        double Y = Localiza\u00e7\u00e3o.getY();
        final double Z = Localiza\u00e7\u00e3o.getZ();
        Y = Math.floor(Y) - 0.001;
        Material Tipo = new Location(Localiza\u00e7\u00e3o.getWorld(), X, Y, Z).getBlock().getType();
        if (!this.isMaterialAir(Tipo)) {
            return false;
        }
        boolean Boolean1 = false;
        boolean Boolean2 = false;
        boolean Boolean3 = false;
        boolean Boolean4 = false;
        if ((int)X != (int)(Y + 0.32)) {
            Boolean1 = true;
            Tipo = new Location(Localiza\u00e7\u00e3o.getWorld(), X + 0.32, Y, Z).getBlock().getType();
            if (!this.isMaterialAir(Tipo)) {
                return false;
            }
        }
        if ((int)X != (int)(X - 0.32)) {
            Boolean2 = true;
            Tipo = new Location(Localiza\u00e7\u00e3o.getWorld(), X - 0.32, Y, Z).getBlock().getType();
            if (!this.isMaterialAir(Tipo)) {
                return false;
            }
        }
        if ((int)Z != (int)(Z + 0.32)) {
            Boolean3 = true;
            Tipo = new Location(Localiza\u00e7\u00e3o.getWorld(), X, Y, Z + 0.32).getBlock().getType();
            if (!this.isMaterialAir(Tipo)) {
                return false;
            }
        }
        if ((int)Z != (int)(Z - 0.32)) {
            Boolean4 = true;
            Tipo = new Location(Localiza\u00e7\u00e3o.getWorld(), X, Y, Z - 0.32).getBlock().getType();
            if (!this.isMaterialAir(Tipo)) {
                return false;
            }
        }
        if (Boolean1 && Boolean3) {
            Tipo = new Location(Localiza\u00e7\u00e3o.getWorld(), X + 0.32, Y, Z + 0.32).getBlock().getType();
            if (!this.isMaterialAir(Tipo)) {
                return false;
            }
        }
        if (Boolean1 && Boolean4) {
            Tipo = new Location(Localiza\u00e7\u00e3o.getWorld(), X + 0.32, Y, Z - 0.32).getBlock().getType();
            if (!this.isMaterialAir(Tipo)) {
                return false;
            }
        }
        if (Boolean2 && Boolean3) {
            Tipo = new Location(Localiza\u00e7\u00e3o.getWorld(), X - 0.32, Y, Z + 0.32).getBlock().getType();
            if (!this.isMaterialAir(Tipo)) {
                return false;
            }
        }
        if (Boolean2 && Boolean4) {
            Tipo = new Location(Localiza\u00e7\u00e3o.getWorld(), X - 0.32, Y, Z - 0.32).getBlock().getType();
            if (!this.isMaterialAir(Tipo)) {
                return false;
            }
        }
        return true;
    }
}
