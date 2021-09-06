package me.cangasso.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.cangasso.API.GrupoAPI;
import me.cangasso.API.WarpsAPI;
import me.cangasso.anticheat.Events;
import me.cangasso.anticheat.hacks.AutoSoup;
import me.cangasso.anticheat.hacks.FastClick;
import me.cangasso.anticheat.hacks.ForceField;
import me.cangasso.anticheat.hacks.Macro;
import me.cangasso.anticheat.hacks.flyspeed.FlySpeed;
import me.cangasso.anticheat.hacks.flyspeed.MoveCheck;
import me.cangasso.bans.BanCommand;
import me.cangasso.bans.Config;
import me.cangasso.bans.Eventos;
import me.cangasso.bans.IPBanCommand;
import me.cangasso.bans.KickCommand;
import me.cangasso.bans.MuteCommand;
import me.cangasso.bans.PardonCommand;
import me.cangasso.bans.PunishCheckCommand;
import me.cangasso.bans.TempBanCommand;
import me.cangasso.bans.TempMuteCommand;
import me.cangasso.bans.WarnCommand;
import me.cangasso.check.CheckCommand;
import me.cangasso.combatlog.CombatLog;
import me.cangasso.commands.AccountCommand;
import me.cangasso.commands.AddPermissaoCommand;
import me.cangasso.commands.AdminCommand;
import me.cangasso.commands.AplicarCommand;
import me.cangasso.commands.AutoSoupCommand;
import me.cangasso.commands.BcCommand;
import me.cangasso.commands.BuilderCommand;
import me.cangasso.commands.CageCommand;
import me.cangasso.commands.ChatCommand;
import me.cangasso.commands.ClearAllCommand;
import me.cangasso.commands.DanoCommand;
import me.cangasso.commands.FlyCommand;
import me.cangasso.commands.GamemodeCommand;
import me.cangasso.commands.GetIPCommand;
import me.cangasso.commands.GiveAllCommand;
import me.cangasso.commands.GiveCommand;
import me.cangasso.commands.GiveKitCommand;
import me.cangasso.commands.GiveVipCommand;
import me.cangasso.commands.GroupSetCommand;
import me.cangasso.commands.HeadCommand;
import me.cangasso.commands.HelpopCommand;
import me.cangasso.commands.HgCommand;
import me.cangasso.commands.HorasCommand;
import me.cangasso.commands.HrcCommand;
import me.cangasso.commands.InvisCommand;
import me.cangasso.commands.InvseeCommand;
import me.cangasso.commands.IpCommand;
import me.cangasso.commands.KickAllCommand;
import me.cangasso.commands.KitCommand;
import me.cangasso.commands.LojaCommand;
import me.cangasso.commands.ManutencaoCommand;
import me.cangasso.commands.MonitorarCommand;
import me.cangasso.commands.PingCommand;
import me.cangasso.commands.ProCommand;
import me.cangasso.commands.PvPCommand;
import me.cangasso.commands.RankCommand;
import me.cangasso.commands.RemoveAllCommand;
import me.cangasso.commands.ReportCommand;
import me.cangasso.commands.SKitCommand;
import me.cangasso.commands.ScCommand;
import me.cangasso.commands.ScoreCommand;
import me.cangasso.commands.SemiytCommand;
import me.cangasso.commands.SetCommand;
import me.cangasso.commands.SpawnCommand;
import me.cangasso.commands.SpecCommand;
import me.cangasso.commands.StopServerCommand;
import me.cangasso.commands.TagCommand;
import me.cangasso.commands.TagsCommand;
import me.cangasso.commands.TellCommand;
import me.cangasso.commands.TpAllCommand;
import me.cangasso.commands.TpCommand;
import me.cangasso.commands.TpHereCommand;
import me.cangasso.commands.VisCommand;
import me.cangasso.commands.WarpCommand;
import me.cangasso.commands.YoutuberCommand;
import me.cangasso.commands.cRemoveHead;
import me.cangasso.configura\u00e7\u00e3o.WarpsConfig;
import me.cangasso.configura\u00e7\u00e3o.cfConfig;
import me.cangasso.configura\u00e7\u00e3o.cfEntrou;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.configura\u00e7\u00e3o.cfKitdiario;
import me.cangasso.configura\u00e7\u00e3o.cfPermiss\u00e3o;
import me.cangasso.configura\u00e7\u00e3o.cfStatus;
import me.cangasso.configura\u00e7\u00e3o.cfTempGrupo;
import me.cangasso.events.ColorSigns;
import me.cangasso.events.PlacaLC;
import me.cangasso.events.PlacaRecraft;
import me.cangasso.events.PlacaSopas;
import me.cangasso.events.PlacaVIP;
import me.cangasso.events.eEvents;
import me.cangasso.events.eMoveSpawn;
import me.cangasso.events.eTab;
import me.cangasso.events.eUtills;
import me.cangasso.friends.FriendsCommand;
import me.cangasso.habilidades.Ajnin;
import me.cangasso.habilidades.FireLauncher;
import me.cangasso.habilidades.Fisherman;
import me.cangasso.habilidades.Gladiator;
import me.cangasso.habilidades.Grappler;
import me.cangasso.habilidades.Hulk;
import me.cangasso.habilidades.Kangaroo;
import me.cangasso.habilidades.Magma;
import me.cangasso.habilidades.Monk;
import me.cangasso.habilidades.Ninja;
import me.cangasso.habilidades.Phantom;
import me.cangasso.habilidades.Snail;
import me.cangasso.habilidades.Stomper;
import me.cangasso.habilidades.Strong;
import me.cangasso.habilidades.Sumo;
import me.cangasso.habilidades.Switcher;
import me.cangasso.habilidades.Thor;
import me.cangasso.habilidades.Timelord;
import me.cangasso.habilidades.Viper;
import me.cangasso.invencivel.Prote\u00e7\u00e3o;
import me.cangasso.jumps.Diamante;
import me.cangasso.jumps.Esmeralda;
import me.cangasso.jumps.Esponja;
import me.cangasso.jumps.Ferro;
import me.cangasso.menus.CliqueInventory;
import me.cangasso.menus.HeadsMenu;
import me.cangasso.menus.LojaItemMenu;
import me.cangasso.menus.OpenInventory;
import me.cangasso.nametag.Array;
import me.cangasso.nametag.PlayerLoader;
import me.cangasso.packets.Cancellable;
import me.cangasso.packets.Injector;
import me.cangasso.packets.PacketHandler;
import me.cangasso.packets.PacketReceiveEvent;
import me.cangasso.packets.PacketSendEvent;
import me.cangasso.packets.ReceivedPacket;
import me.cangasso.packets.SentPacket;
import me.cangasso.rdmautomatica.Comando;
import me.cangasso.rdmautomatica.Configura\u00e7\u00e3o;
import me.cangasso.rdmautomatica.Estado;
import me.cangasso.rdmautomatica.EventoAPI;
import me.cangasso.rdmautomatica.PlayerAPI;
import me.cangasso.rdmautomatica.Tempo;
import me.cangasso.twitter.cTweetar;
import me.cangasso.umVum.CmdsSpeed;
import me.cangasso.umVum.Events1v1;
import me.cangasso.umVum.Speed1v1;

public class Main extends JavaPlugin {
	public static final String Menssagens;
	public static Main main;
	public static Plugin plugin;
	public static Estado Evento;
	public static Injector injector;
	public static boolean disableEvents;
	public static BukkitRunnable cleanupTask;
	public static ArrayList<String> JogadoresLogados;
	public static Object logado;

	static {
		Menssagens = null;
		Main.disableEvents = false;
		Main.JogadoresLogados = new ArrayList<String>();
	}

	public static Main getInstance() {
		return Main.main;
	}

	public static Plugin getPlugin() {
		return Main.plugin;
	}

	public void onEnable() {
		Main.plugin = (Plugin) this;
		Bukkit.getConsoleSender().sendMessage("§aPlugin ativado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§aBy: Cangasso and MoradorDeRua");
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) this, (Runnable) new MoveCheck(), 41L,
				40L);
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			todos.kickPlayer(
					"   §c§lSERVIDOR REINICIANDO... \n§7Aguarde! \n§7Estamos melhorando a sua jogabilidade, espero que entenda!");
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
			}
		}, 0L, 2400L);
		this.LoadConfig();
		GrupoAPI.Checando = true;
		Main.Evento = Estado.FECHADO;
		Tempo.CancelarTempo();
		Tempo.Iniciando = 301;
		OfflinePlayer[] offlinePlayers;
		for (int length2 = (offlinePlayers = this.getServer().getOfflinePlayers()).length, j = 0; j < length2; ++j) {
			final OfflinePlayer jogadores = offlinePlayers[j];
			if (Config.getConfig().kTempBans.get("TempBans." + jogadores.getUniqueId()) != null) {
				Config.getConfig().kTempBans.set("TempBans." + jogadores.getUniqueId(), (Object) null);
				Config.getConfig().saveTempBans();
			}
			if (Config.getConfig().kTempMute.get("TempMute." + jogadores.getUniqueId()) != null) {
				Config.getConfig().kTempMute.set("TempMute." + jogadores.getUniqueId(), (Object) null);
				Config.getConfig().saveTempMute();
			}
		}
		PacketsIniciar();
		PlayerAPI.LimparPlayers();
		PlayerLoader.load(this);
		Array.InciarTag();
		this.LoadEvents();
		this.LoadCommands();
		this.CarregarComandosRDM();
		DanoCommand.dano = true;
		PvPCommand.pvp = true;
	}

	public void onDisable() {
		PacketsDesabilitar();
		Bukkit.getConsoleSender().sendMessage("§cPlugin desativado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§cBy: Cangasso and MoradorDeRua");
	}

	private void CarregarComandosRDM() {
		this.getCommand("RDM").setExecutor((CommandExecutor) new Comando());
		this.getCommand("ReiDaMesa").setExecutor((CommandExecutor) new Comando());
		this.getCommand("Entrar").setExecutor((CommandExecutor) new Comando());
		this.getCommand("Join").setExecutor((CommandExecutor) new Comando());
		this.getCommand("Sair").setExecutor((CommandExecutor) new Comando());
		this.getCommand("Leave").setExecutor((CommandExecutor) new Comando());
	}

	public void onLoad() {
		Main.injector = new Injector();
		final boolean injected = Main.injector.inject();
		if (injected) {
			Main.injector.addServerConnectionChannel();
		}
	}

	private void LoadEvents() {
		final PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents((Listener) new Eventos(), (Plugin) this);
		pm.registerEvents((Listener) new eEvents(), (Plugin) this);
		pm.registerEvents((Listener) new eUtills(), (Plugin) this);
		pm.registerEvents((Listener) new Prote\u00e7\u00e3o(), (Plugin) this);
		pm.registerEvents((Listener) new OpenInventory(), (Plugin) this);
		pm.registerEvents((Listener) new CliqueInventory(), (Plugin) this);
		pm.registerEvents((Listener) new HeadsMenu(), (Plugin) this);
		pm.registerEvents((Listener) new WarpsAPI(), (Plugin) this);
		pm.registerEvents((Listener) new PlacaRecraft(), (Plugin) this);
		pm.registerEvents((Listener) new PlacaSopas(), (Plugin) this);
		pm.registerEvents((Listener) new PlacaLC(), (Plugin) this);
		pm.registerEvents((Listener) new eMoveSpawn(), (Plugin) this);
		pm.registerEvents((Listener) new eTab(), (Plugin) this);
		pm.registerEvents((Listener) new LojaItemMenu(), (Plugin) this);
		pm.registerEvents((Listener) new ColorSigns(), (Plugin) this);
		pm.registerEvents((Listener) new PlacaVIP(), (Plugin) this);
		pm.registerEvents((Listener) new AdminCommand(), (Plugin) this);
		pm.registerEvents((Listener) new ChatCommand(), (Plugin) this);
		pm.registerEvents((Listener) new ScCommand(), (Plugin) this);
		pm.registerEvents((Listener) new ManutencaoCommand(), (Plugin) this);
		pm.registerEvents((Listener) new DanoCommand(), (Plugin) this);
		pm.registerEvents((Listener) new PvPCommand(), (Plugin) this);
		pm.registerEvents((Listener) new Esmeralda(), (Plugin) this);
		pm.registerEvents((Listener) new Esponja(), (Plugin) this);
		pm.registerEvents((Listener) new Diamante(), (Plugin) this);
		pm.registerEvents((Listener) new Ferro(), (Plugin) this);
		pm.registerEvents((Listener) new Ajnin(), (Plugin) this);
		pm.registerEvents((Listener) new Fisherman(), (Plugin) this);
		pm.registerEvents((Listener) new Gladiator(), (Plugin) this);
		pm.registerEvents((Listener) new Grappler(), (Plugin) this);
		pm.registerEvents((Listener) new Hulk(), (Plugin) this);
		pm.registerEvents((Listener) new Kangaroo(), (Plugin) this);
		pm.registerEvents((Listener) new Magma(), (Plugin) this);
		pm.registerEvents((Listener) new Monk(), (Plugin) this);
		pm.registerEvents((Listener) new Ninja(), (Plugin) this);
		pm.registerEvents((Listener) new Phantom(), (Plugin) this);
		pm.registerEvents((Listener) new Snail(), (Plugin) this);
		pm.registerEvents((Listener) new Stomper(), (Plugin) this);
		pm.registerEvents((Listener) new Switcher(), (Plugin) this);
		pm.registerEvents((Listener) new Thor(), (Plugin) this);
		pm.registerEvents((Listener) new Timelord(), (Plugin) this);
		pm.registerEvents((Listener) new Viper(), (Plugin) this);
		pm.registerEvents((Listener) new FireLauncher(), (Plugin) this);
		pm.registerEvents((Listener) new Strong(), (Plugin) this);
		pm.registerEvents((Listener) new Sumo(), (Plugin) this);
		pm.registerEvents((Listener) new Events1v1(), (Plugin) this);
		pm.registerEvents((Listener) new Speed1v1(), (Plugin) this);
		pm.registerEvents((Listener) new EventoAPI(), (Plugin) this);
		pm.registerEvents((Listener) new Events(), (Plugin) this);
		pm.registerEvents((Listener) new AutoSoup(), (Plugin) this);
		pm.registerEvents((Listener) new FastClick(), (Plugin) this);
		pm.registerEvents((Listener) new Macro(), (Plugin) this);
		pm.registerEvents((Listener) new ForceField(), (Plugin) this);
		pm.registerEvents((Listener) new FlySpeed(), (Plugin) this);
		pm.registerEvents((Listener) new CombatLog(), (Plugin) this);
		pm.registerEvents((Listener) new WarpCommand(), (Plugin) this);
	}

	private void LoadCommands() {
		this.getCommand("ban").setExecutor((CommandExecutor) new BanCommand());
		this.getCommand("duvida").setExecutor((CommandExecutor) new HelpopCommand());
		this.getCommand("ipban").setExecutor((CommandExecutor) new IPBanCommand());
		this.getCommand("tempban").setExecutor((CommandExecutor) new TempBanCommand());
		this.getCommand("tempmute").setExecutor((CommandExecutor) new TempMuteCommand());
		this.getCommand("kick").setExecutor((CommandExecutor) new KickCommand());
		this.getCommand("Pardon").setExecutor((CommandExecutor) new PardonCommand());
		this.getCommand("mute").setExecutor((CommandExecutor) new MuteCommand());
		this.getCommand("sc").setExecutor((CommandExecutor) new ScCommand());
		this.getCommand("groupset").setExecutor((CommandExecutor) new GroupSetCommand());
		this.getCommand("admin").setExecutor((CommandExecutor) new AdminCommand());
		this.getCommand("kit").setExecutor((CommandExecutor) new KitCommand());
		this.getCommand("builder").setExecutor((CommandExecutor) new BuilderCommand());
		this.getCommand("giveall").setExecutor((CommandExecutor) new GiveAllCommand());
		this.getCommand("removeall").setExecutor((CommandExecutor) new RemoveAllCommand());
		this.getCommand("fly").setExecutor((CommandExecutor) new FlyCommand());
		this.getCommand("score").setExecutor((CommandExecutor) new ScoreCommand());
		this.getCommand("tag").setExecutor((CommandExecutor) new TagCommand());
		this.getCommand("pro").setExecutor((CommandExecutor) new ProCommand());
		this.getCommand("tags").setExecutor((CommandExecutor) new TagsCommand());
		this.getCommand("tp").setExecutor((CommandExecutor) new TpCommand());
		this.getCommand("gamemode").setExecutor((CommandExecutor) new GamemodeCommand());
		this.getCommand("gm").setExecutor((CommandExecutor) new GamemodeCommand());
		this.getCommand("youtuber").setExecutor((CommandExecutor) new YoutuberCommand());
		this.getCommand("spro").setExecutor((CommandExecutor) new YoutuberCommand());
		this.getCommand("chat").setExecutor((CommandExecutor) new ChatCommand());
		this.getCommand("report").setExecutor((CommandExecutor) new ReportCommand());
		this.getCommand("set").setExecutor((CommandExecutor) new SetCommand());
		this.getCommand("friends").setExecutor((CommandExecutor) new FriendsCommand());
		this.getCommand("spawn").setExecutor((CommandExecutor) new SpawnCommand());
		this.getCommand("warp").setExecutor((CommandExecutor) new WarpCommand());
		this.getCommand("speed1v1").setExecutor((CommandExecutor) new CmdsSpeed());
		this.getCommand("hrc").setExecutor((CommandExecutor) new HrcCommand());
		this.getCommand("tell").setExecutor((CommandExecutor) new TellCommand());
		this.getCommand("specs").setExecutor((CommandExecutor) new SpecCommand());
		this.getCommand("bancheck").setExecutor((CommandExecutor) new PunishCheckCommand());
		this.getCommand("mutecheck").setExecutor((CommandExecutor) new PunishCheckCommand());
		this.getCommand("loja").setExecutor((CommandExecutor) new LojaCommand());
		this.getCommand("store").setExecutor((CommandExecutor) new LojaCommand());
		this.getCommand("bc").setExecutor((CommandExecutor) new BcCommand());
		this.getCommand("account").setExecutor((CommandExecutor) new AccountCommand());
		this.getCommand("semiyt").setExecutor((CommandExecutor) new SemiytCommand());
		this.getCommand("inv").setExecutor((CommandExecutor) new InvseeCommand());
		this.getCommand("invsee").setExecutor((CommandExecutor) new InvseeCommand());
		this.getCommand("aplicar").setExecutor((CommandExecutor) new AplicarCommand());
		this.getCommand("getip").setExecutor((CommandExecutor) new GetIPCommand());
		this.getCommand("horas").setExecutor((CommandExecutor) new HorasCommand());
		this.getCommand("rank").setExecutor((CommandExecutor) new RankCommand());
		this.getCommand("ranks").setExecutor((CommandExecutor) new RankCommand());
		this.getCommand("ping").setExecutor((CommandExecutor) new PingCommand());
		this.getCommand("acc").setExecutor((CommandExecutor) new AccountCommand());
		this.getCommand("tpall").setExecutor((CommandExecutor) new TpAllCommand());
		this.getCommand("vis").setExecutor((CommandExecutor) new VisCommand());
		this.getCommand("invis").setExecutor((CommandExecutor) new InvisCommand());
		this.getCommand("hg").setExecutor((CommandExecutor) new HgCommand());
		this.getCommand("removerhead").setExecutor((CommandExecutor) new cRemoveHead());
		this.getCommand("removerhat").setExecutor((CommandExecutor) new cRemoveHead());
		this.getCommand("removehead").setExecutor((CommandExecutor) new cRemoveHead());
		this.getCommand("removehat").setExecutor((CommandExecutor) new cRemoveHead());
		this.getCommand("manutencao").setExecutor((CommandExecutor) new ManutencaoCommand());
		this.getCommand("cage").setExecutor((CommandExecutor) new CageCommand());
		this.getCommand("autosoup").setExecutor((CommandExecutor) new AutoSoupCommand());
		this.getCommand("ip").setExecutor((CommandExecutor) new IpCommand());
		this.getCommand("tphere").setExecutor((CommandExecutor) new TpHereCommand());
		this.getCommand("s").setExecutor((CommandExecutor) new TpHereCommand());
		this.getCommand("stopserver").setExecutor((CommandExecutor) new StopServerCommand());
		this.getCommand("kickall").setExecutor((CommandExecutor) new KickAllCommand());
		this.getCommand("monitorar").setExecutor((CommandExecutor) new MonitorarCommand());
		this.getCommand("skit").setExecutor((CommandExecutor) new SKitCommand());
		this.getCommand("dano").setExecutor((CommandExecutor) new DanoCommand());
		this.getCommand("pvp").setExecutor((CommandExecutor) new PvPCommand());
		this.getCommand("clearall").setExecutor((CommandExecutor) new ClearAllCommand());
		this.getCommand("tweetar").setExecutor((CommandExecutor) new cTweetar());
		this.getCommand("head").setExecutor((CommandExecutor) new HeadCommand());
		this.getCommand("addpermission").setExecutor((CommandExecutor) new AddPermissaoCommand());
		this.getCommand("removepermission").setExecutor((CommandExecutor) new AddPermissaoCommand());
		this.getCommand("check").setExecutor((CommandExecutor) new CheckCommand());
		this.getCommand("givevip").setExecutor((CommandExecutor) new GiveVipCommand());
		this.getCommand("giveyoutuber").setExecutor((CommandExecutor) new GiveCommand());
		this.getCommand("givebuilder").setExecutor((CommandExecutor) new GiveCommand());
		this.getCommand("givekit").setExecutor((CommandExecutor) new GiveKitCommand());
	}

	private void LoadConfig() {
		WarpsConfig.getConfig().ConfigEnable((Plugin) this);
		Config.getConfig().setupConfig((Plugin) this);
		cfEntrou.setarConfig((Plugin) this);
		cfEntrou.setarConfig1((Plugin) this);
		cfGrupo.setarconfig((Plugin) this);
		cfKitdiario.setarconfig((Plugin) this);
		cfTempGrupo.setarconfig((Plugin) this);
		cfPermiss\u00e3o.setarconfig((Plugin) this);
		Configura\u00e7\u00e3o.getConfig((Plugin) this);
		cfConfig.setarConfig((Plugin) this);
		new cfStatus();
		new WarnCommand();
	}

	public static void PacketsIniciar() {
		if (Main.cleanupTask == null) {
			(Main.cleanupTask = new BukkitRunnable() {
				public void run() {
				}
			}).runTaskTimer(getPlugin(), 6000L, 6000L);
		}
	}

	public static void PacketsDesabilitar() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player p = onlinePlayers[i];
			Main.injector.removeChannel(p);
		}
		while (!PacketHandler.getHandlers().isEmpty()) {
			PacketHandler.removeHandler(PacketHandler.getHandlers().get(0));
		}
	}

	public static boolean addPacketHandler(final PacketHandler handler) {
		return PacketHandler.addHandler(handler);
	}

	public static boolean removePacketHandler(final PacketHandler handler) {
		return PacketHandler.removeHandler(handler);
	}

	private void callEvent(final Event e) {
		if (Main.disableEvents) {
			return;
		}
		if (!this.isEnabled()) {
			return;
		}
		Bukkit.getScheduler().runTaskAsynchronously((Plugin) this, (Runnable) new Runnable() {
			@Override
			public void run() {
				try {
					Bukkit.getPluginManager().callEvent(e);
				} catch (IllegalStateException ex) {
					System.out.println("[PacketListenerAPI] Error while calling event (" + e.getEventName() + ")");
					ex.printStackTrace();
				}
			}
		});
	}

	public Object onPacketReceive(final Player p, final Object packet, final Cancellable cancellable) {
		if (!packet.getClass().getName().startsWith("net.minecraft.server.")) {
			return packet;
		}
		if (!Main.disableEvents) {
			final PacketReceiveEvent event = new PacketReceiveEvent(packet, cancellable, p);
			this.callEvent(event);
		}
		final ReceivedPacket pckt = new ReceivedPacket(packet, cancellable, p);
		PacketHandler.notifyHandlers(pckt);
		return pckt.getPacket();
	}

	public Object onPacketSend(final Player p, final Object packet, final Cancellable cancellable) {
		if (!packet.getClass().getName().startsWith("net.minecraft.server.")) {
			return packet;
		}
		if (!Main.disableEvents) {
			final PacketSendEvent event = new PacketSendEvent(packet, cancellable, p);
			this.callEvent(event);
		}
		final SentPacket pckt = new SentPacket(packet, cancellable, p);
		PacketHandler.notifyHandlers(pckt);
		return pckt.getPacket();
	}
}
