package me.cangasso.rdmautomatica;

import me.cangasso.main.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class Tempo
{
    public static Integer Tempo;
    public static int Iniciando;
    
    static {
        me.cangasso.rdmautomatica.Tempo.Iniciando = 301;
    }
    
    public static void CancelarTempo() {
        if (me.cangasso.rdmautomatica.Tempo.Tempo != null) {
            Bukkit.getScheduler().cancelTask((int)me.cangasso.rdmautomatica.Tempo.Tempo);
            me.cangasso.rdmautomatica.Tempo.Tempo = null;
        }
    }
    
    public static void mandarBroadcast(final String Menssagem) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player Jogadores = onlinePlayers[i];
            Jogadores.sendMessage(Menssagem);
        }
    }
    
    private void mandarAvisos() {
        mandarBroadcast("§7O evento inicia em §6§l" + FormatoTempo(me.cangasso.rdmautomatica.Tempo.Iniciando) + "§7. §e§l(" + PlayerAPI.Participando.size() + "§e§l/30)");
        mandarBroadcast("§7Para entrar no evento, use §9§l/entrar");
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player Jogadores = onlinePlayers[i];
            Jogadores.playSound(Jogadores.getLocation(), Sound.CLICK, 10.0f, 10.0f);
        }
    }
    
    public static String FormatoTempo(final int Tempo) {
        final int Minuto = Tempo / 60;
        final int Segundo = Tempo % 60;
        String MinutoTexto = null;
        String SegundoTexto = null;
        if (Minuto > 10) {
            MinutoTexto = " " + Minuto + " minuto(s)";
        }
        else {
            MinutoTexto = " " + Minuto + " minuto(s)";
        }
        if (Segundo > 10) {
            SegundoTexto = " " + Segundo + " segundo(s)";
        }
        else {
            SegundoTexto = " " + Segundo + " segundo(s)";
        }
        if (Minuto == 0) {
            MinutoTexto = "";
        }
        if (Segundo == 0) {
            SegundoTexto = "";
        }
        return String.valueOf(MinutoTexto) + SegundoTexto;
    }
    
    public Tempo(final Player Jogador) {
        if (Main.Evento == Estado.INICIANDO) {
            me.cangasso.rdmautomatica.Tempo.Tempo = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    --me.cangasso.rdmautomatica.Tempo.Iniciando;
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 300) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 240) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 180) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 120) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 60) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 30) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 15) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 5) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 4) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 3) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 2) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 1) {
                        me.cangasso.rdmautomatica.Tempo.this.mandarAvisos();
                    }
                    if (me.cangasso.rdmautomatica.Tempo.Iniciando == 0) {
                        if (PlayerAPI.Participando.size() < 2) {
                            me.cangasso.rdmautomatica.Tempo.mandarBroadcast("§cN\u00e3o foi obtido o n\u00famero m\u00ednimo de jogadores. Contagem reiniciada. ");
                            me.cangasso.rdmautomatica.Tempo.mandarBroadcast("§aO evento atingiu um n\u00famero de jogadores plaus\u00edvel. Tempo alterado para §a§l2 minutos");
                            me.cangasso.rdmautomatica.Tempo.Iniciando = 121;
                            return;
                        }
                        me.cangasso.rdmautomatica.Tempo.mandarBroadcast("§7O evento foi §a§lINICIADO§7!");
                        me.cangasso.rdmautomatica.Tempo.mandarBroadcast("§7Boa sorte aos §6§l" + PlayerAPI.Participando.size() + " §7participantes!");
                        Player[] onlinePlayers;
                        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                            final Player Jogadores = onlinePlayers[i];
                            if (PlayerAPI.Participando.contains(Jogadores)) {
                                Jogadores.playSound(Jogadores.getLocation(), Sound.LEVEL_UP, 10.0f, 10.0f);
                            }
                        }
                        me.cangasso.rdmautomatica.Tempo.CancelarTempo();
                        me.cangasso.rdmautomatica.Tempo.Iniciando = 301;
                        Main.Evento = Estado.ANDAMENTO;
                        PlayerAPI.SelecionarPrimeirosJogadores(Jogador);
                    }
                }
            }, 0L, 20L);
        }
    }
}
