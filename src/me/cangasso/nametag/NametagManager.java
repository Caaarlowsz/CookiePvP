package me.cangasso.nametag;

import java.util.Arrays;
import java.util.Collection;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NametagManager
{
    private static final String TEAM_NAME_PREFIX = "NTE";
    private static List<Integer> list;
    private static HashMap<TeamInfo, List<String>> teams;
    
    static {
        NametagManager.list = new ArrayList<Integer>();
        NametagManager.teams = new HashMap<TeamInfo, List<String>>();
    }
    
    private static void AdicinarTeam(final TeamInfo Team, final String Jogador) {
        RemoverTeam(Jogador);
        final List<String> List = NametagManager.teams.get(Team);
        if (List != null) {
            List.add(Jogador);
            final Player Jogadores = Bukkit.getPlayerExact(Jogador);
            if (Jogadores != null) {
                MandarPacketsAdicinarTeams(Team, Jogadores.getName());
            }
            else {
                final OfflinePlayer JogadoresOff = Bukkit.getOfflinePlayer(Jogador);
                MandarPacketsAdicinarTeams(Team, JogadoresOff.getName());
            }
        }
    }
    
    private static void register(final TeamInfo Team) {
        NametagManager.teams.put(Team, new ArrayList<String>());
        MandarPacketsAdicionarTeams(Team);
    }
    
    private static boolean removeTeam(final String Nome) {
        TeamInfo[] array;
        for (int length = (array = NametagManager.teams.keySet().toArray(new TeamInfo[NametagManager.teams.size()])).length, i = 0; i < length; ++i) {
            final TeamInfo Team = array[i];
            if (Team.PegarNome().equals(Nome)) {
                removeTeam(Team);
                return true;
            }
        }
        return false;
    }
    
    private static void removeTeam(final TeamInfo Team) {
        MandarPacketsRemoverTeams(Team);
        NametagManager.teams.remove(Team);
    }
    
    private static TeamInfo RemoverTeam(final String Jogador) {
        TeamInfo[] array;
        for (int length = (array = NametagManager.teams.keySet().toArray(new TeamInfo[NametagManager.teams.size()])).length, i = 0; i < length; ++i) {
            final TeamInfo Team = array[i];
            final List<String> list = NametagManager.teams.get(Team);
            String[] array2;
            for (int length2 = (array2 = list.toArray(new String[list.size()])).length, j = 0; j < length2; ++j) {
                final String Tags = array2[j];
                if (Tags.equals(Jogador)) {
                    final Player Jogador2 = Bukkit.getPlayerExact(Jogador);
                    if (Jogador2 != null) {
                        MandarPacketsRemoverTeams(Team, Jogador2.getName());
                    }
                    else {
                        final OfflinePlayer Jogador3 = Bukkit.getOfflinePlayer(Tags);
                        MandarPacketsRemoverTeams(Team, Jogador3.getName());
                    }
                    list.remove(Tags);
                    return Team;
                }
            }
        }
        return null;
    }
    
    private static TeamInfo getTeam(final String name) {
        TeamInfo[] array;
        for (int length = (array = NametagManager.teams.keySet().toArray(new TeamInfo[NametagManager.teams.size()])).length, i = 0; i < length; ++i) {
            final TeamInfo team = array[i];
            if (team.PegarNome().equals(name)) {
                return team;
            }
        }
        return null;
    }
    
    private static TeamInfo[] PegarTeams() {
        final TeamInfo[] list = new TeamInfo[NametagManager.teams.size()];
        int at = 0;
        TeamInfo[] array;
        for (int length = (array = NametagManager.teams.keySet().toArray(new TeamInfo[NametagManager.teams.size()])).length, i = 0; i < length; ++i) {
            final TeamInfo team = array[i];
            list[at] = team;
            ++at;
        }
        return list;
    }
    
    private static String[] PegarTeamJogadores(final TeamInfo Team) {
        final List<String> List = NametagManager.teams.get(Team);
        if (List != null) {
            return List.toArray(new String[List.size()]);
        }
        return new String[0];
    }
    
    public static void Atualizar(final String Jogador, String Prefix, String Suffix) {
        if (Prefix == null || Prefix.isEmpty()) {
            Prefix = PegarPrefix(Jogador);
        }
        if (Suffix == null || Suffix.isEmpty()) {
            Suffix = PegarSuffix(Jogador);
        }
        final TeamInfo t = Pegar(Prefix, Suffix);
        AdicinarTeam(t, Jogador);
    }
    
    public static void Overlap(final String Jogador, String Prefix, String Suffix) {
        if (Prefix == null) {
            Prefix = "";
        }
        if (Suffix == null) {
            Suffix = "";
        }
        final TeamInfo t = Pegar(Prefix, Suffix);
        AdicinarTeam(t, Jogador);
    }
    
    public static void Limpar(final String player) {
        RemoverTeam(player);
    }
    
    public static String PegarPrefix(final String Jogador) {
        TeamInfo[] pegarTeams;
        for (int length = (pegarTeams = PegarTeams()).length, i = 0; i < length; ++i) {
            final TeamInfo Team = pegarTeams[i];
            String[] pegarTeamJogadores;
            for (int length2 = (pegarTeamJogadores = PegarTeamJogadores(Team)).length, j = 0; j < length2; ++j) {
                final String Tags = pegarTeamJogadores[j];
                if (Tags.equals(Jogador)) {
                    return Team.PegarPrefix();
                }
            }
        }
        return "";
    }
    
    public static String PegarSuffix(final String Jogador) {
        TeamInfo[] pegarTeams;
        for (int length = (pegarTeams = PegarTeams()).length, i = 0; i < length; ++i) {
            final TeamInfo Team = pegarTeams[i];
            String[] pegarTeamJogadores;
            for (int length2 = (pegarTeamJogadores = PegarTeamJogadores(Team)).length, j = 0; j < length2; ++j) {
                final String Tags = pegarTeamJogadores[j];
                if (Tags.equals(Jogador)) {
                    return Team.PegarSuffix();
                }
            }
        }
        return "";
    }
    
    public static String PegarFormattedName(final String Jogador) {
        return String.valueOf(PegarPrefix(Jogador)) + Jogador + PegarSuffix(Jogador);
    }
    
    private static TeamInfo DeclareTeam(final String Nome, final String Prefix, final String Suffix) {
        if (getTeam(Nome) != null) {
            final TeamInfo Team = getTeam(Nome);
            removeTeam(Team);
        }
        final TeamInfo Team = new TeamInfo(Nome);
        Team.SetarPrefix(Prefix);
        Team.SetarSuffix(Suffix);
        register(Team);
        return Team;
    }
    
    private static TeamInfo Pegar(final String Prefix, final String Suffix) {
        Atualizar();
        for (final int t : NametagManager.list.toArray(new Integer[NametagManager.list.size()])) {
            if (getTeam("NTE" + t) != null) {
                final TeamInfo team = getTeam("NTE" + t);
                if (team.PegarSuffix().equals(Suffix) && team.PegarPrefix().equals(Prefix)) {
                    return team;
                }
            }
        }
        return DeclareTeam("NTE" + NextName(), Prefix, Suffix);
    }
    
    private static int NextName() {
        int at = 0;
        boolean cont = true;
        while (cont) {
            cont = false;
            for (final int t : NametagManager.list.toArray(new Integer[NametagManager.list.size()])) {
                if (t == at) {
                    ++at;
                    cont = true;
                }
            }
        }
        NametagManager.list.add(at);
        return at;
    }
    
    private static void Atualizar() {
        TeamInfo[] pegarTeams;
        for (int length = (pegarTeams = PegarTeams()).length, i = 0; i < length; ++i) {
            final TeamInfo Team = pegarTeams[i];
            int Entry = -1;
            try {
                Entry = Integer.parseInt(Team.PegarNome());
            }
            catch (Exception ex) {}
            if (Entry != -1 && PegarTeamJogadores(Team).length == 0) {
                removeTeam(Team);
                NametagManager.list.remove(new Integer(Entry));
            }
        }
    }
    
    public static void MandarTeamsParaJogador(final Player Jogador) {
        try {
            TeamInfo[] pegarTeams;
            for (int length = (pegarTeams = PegarTeams()).length, i = 0; i < length; ++i) {
                final TeamInfo Team = pegarTeams[i];
                PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Team.PegarPrefix(), Team.PegarSuffix(), new ArrayList(), 0);
                PacketPlayOut.sendToPlayer(Jogador);
                PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Arrays.asList(PegarTeamJogadores(Team)), 3);
                PacketPlayOut.sendToPlayer(Jogador);
            }
        }
        catch (Exception e) {
            System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
            e.printStackTrace();
        }
    }
    
    private static void MandarPacketsAdicionarTeams(final TeamInfo Team) {
        try {
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                final Player Jogadores = onlinePlayers[i];
                final PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Team.PegarPrefix(), Team.PegarSuffix(), new ArrayList(), 0);
                PacketPlayOut.sendToPlayer(Jogadores);
            }
        }
        catch (Exception e) {
            System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
            e.printStackTrace();
        }
    }
    
    private static void MandarPacketsRemoverTeams(final TeamInfo Team) {
        boolean Cont = false;
        TeamInfo[] pegarTeams;
        for (int length = (pegarTeams = PegarTeams()).length, i = 0; i < length; ++i) {
            final TeamInfo Team2 = pegarTeams[i];
            if (Team2 == Team) {
                Cont = true;
            }
        }
        if (!Cont) {
            return;
        }
        try {
            Player[] onlinePlayers;
            for (int length2 = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                final Player Jogadores = onlinePlayers[j];
                final PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Team.PegarPrefix(), Team.PegarSuffix(), new ArrayList(), 1);
                PacketPlayOut.sendToPlayer(Jogadores);
            }
        }
        catch (Exception e) {
            System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
            e.printStackTrace();
        }
    }
    
    private static void MandarPacketsAdicinarTeams(final TeamInfo Team, final String Jogador) {
        boolean Cont = false;
        TeamInfo[] pegarTeams;
        for (int length = (pegarTeams = PegarTeams()).length, i = 0; i < length; ++i) {
            final TeamInfo Team2 = pegarTeams[i];
            if (Team2 == Team) {
                Cont = true;
            }
        }
        if (!Cont) {
            return;
        }
        try {
            Player[] onlinePlayers;
            for (int length2 = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                final Player Jogadores = onlinePlayers[j];
                final PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Arrays.asList(Jogador), 3);
                PacketPlayOut.sendToPlayer(Jogadores);
            }
        }
        catch (Exception e) {
            System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
            e.printStackTrace();
        }
    }
    
    private static void MandarPacketsRemoverTeams(final TeamInfo Team, final String Jogador) {
        boolean Cont = false;
        TeamInfo[] pegarTeams;
        for (int length = (pegarTeams = PegarTeams()).length, i = 0; i < length; ++i) {
            final TeamInfo Team2 = pegarTeams[i];
            if (Team2 == Team) {
                String[] pegarTeamJogadores;
                for (int length2 = (pegarTeamJogadores = PegarTeamJogadores(Team2)).length, j = 0; j < length2; ++j) {
                    final String NomeDoJogador = pegarTeamJogadores[j];
                    if (NomeDoJogador.equals(Jogador)) {
                        Cont = true;
                    }
                }
            }
        }
        if (!Cont) {
            return;
        }
        try {
            Player[] onlinePlayers;
            for (int length3 = (onlinePlayers = Bukkit.getOnlinePlayers()).length, k = 0; k < length3; ++k) {
                final Player Jogadores = onlinePlayers[k];
                final PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Arrays.asList(Jogador), 4);
                PacketPlayOut.sendToPlayer(Jogadores);
            }
        }
        catch (Exception e) {
            System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
            e.printStackTrace();
        }
    }
    
    public static void Resetar() {
        TeamInfo[] pegarTeams;
        for (int length = (pegarTeams = PegarTeams()).length, i = 0; i < length; ++i) {
            final TeamInfo Team = pegarTeams[i];
            removeTeam(Team);
        }
    }
}
