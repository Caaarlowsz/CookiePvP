package me.cangasso.anticheat.hacks.flyspeed;

import org.bukkit.Location;

public class Jump
{
    public MoveLog start;
    public MoveLog apex;
    public MoveLog end;
    public double height;
    public double fallDistance;
    public double length;
    public double time;
    public double jumpTime;
    public double fallTime;
    public double verticalSpeed;
    public double jumpSpeed;
    public double fallSpeed;
    public double horizontalSpeed;
    public boolean isFloating;
    public boolean isOnGround;
    public boolean isOnLadder;
    public boolean isOnFire;
    public static double nextexpectedY;
    
    public Jump(final MoveLog start, final MoveLog apex, final MoveLog end) {
        this.isFloating = false;
        this.isOnGround = false;
        this.isOnLadder = false;
        this.isOnFire = false;
        this.start = start;
        this.apex = apex;
        this.end = end;
        if (start.location.getY() == apex.location.getY() && apex.location.getY() == end.location.getY() && !start.isAir && !apex.isAir && !end.isAir) {
            this.isOnGround = true;
        }
        this.height = apex.location.getY() - start.location.getY();
        this.fallDistance = apex.location.getY() - end.location.getY();
        this.length = this.GetHorzDistance(start.location, apex.location) + this.GetHorzDistance(apex.location, end.location);
        this.time = (end.time - start.time) / 1000.0;
        this.jumpTime = (apex.time - start.time) / 1000.0;
        this.fallTime = (end.time - apex.time) / 1000.0;
        this.jumpSpeed = this.height / this.jumpTime;
        this.fallSpeed = this.fallDistance / this.fallTime;
        this.verticalSpeed = (this.height + this.fallDistance) / this.time;
        this.horizontalSpeed = this.length / this.time;
    }
    
    public static double getNextExpectedY() {
        return Jump.nextexpectedY;
    }
    
    public static void setNextExpectedY(final double d) {
        Jump.nextexpectedY = d;
    }
    
    private double GetHorzDistance(final Location a, final Location b) {
        final double x = Math.abs(a.getX() - b.getX());
        final double z = Math.abs(a.getZ() - b.getZ());
        return Math.sqrt(x * x + z * z);
    }
}
