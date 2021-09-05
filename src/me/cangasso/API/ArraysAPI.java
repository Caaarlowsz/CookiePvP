package me.cangasso.API;

import org.bukkit.entity.Player;
import java.util.ArrayList;

public class ArraysAPI
{
    public static ArrayList<Player> Jogando;
    public static ArrayList<Player> Admin;
    public static ArrayList<Player> Checando;
    public static ArrayList<Player> CooldownDica;
    public static ArrayList<Player> Spec;
    public static ArrayList<Player> Logado;
    public static ArrayList<Player> CooldownChat;
    public static ArrayList<Player> Monitor;
    
    static {
        ArraysAPI.Jogando = new ArrayList<Player>();
        ArraysAPI.Admin = new ArrayList<Player>();
        ArraysAPI.Checando = new ArrayList<Player>();
        ArraysAPI.CooldownDica = new ArrayList<Player>();
        ArraysAPI.Spec = new ArrayList<Player>();
        ArraysAPI.Logado = new ArrayList<Player>();
        ArraysAPI.CooldownChat = new ArrayList<Player>();
        ArraysAPI.Monitor = new ArrayList<Player>();
    }
}
