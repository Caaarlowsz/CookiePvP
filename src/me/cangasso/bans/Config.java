package me.cangasso.bans;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
	public static Config Config;
	FileConfiguration kStats;
	File Stats;
	FileConfiguration kDamageCoins;
	File DamageCoins;
	FileConfiguration kRanks;
	File Ranks;
	FileConfiguration kBans;
	File Bans;
	FileConfiguration kIpBans;
	File IpBans;
	public FileConfiguration kTempBans;
	File TempBans;
	FileConfiguration kMute;
	File Mute;
	public FileConfiguration kTempMute;
	File TempMute;
	FileConfiguration kFeast;
	File Feast;
	FileConfiguration kTroll;
	File Troll;
	FileConfiguration kJogadores;
	File Jogadores;
	FileConfiguration kAuth;
	File auth;
	FileConfiguration kManutencao;
	File Manutencao;

	static {
		me.cangasso.bans.Config.Config = new Config();
	}

	public static Config getConfig() {
		return me.cangasso.bans.Config.Config;
	}

	public void setupConfig(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		this.Stats = new File(plugin.getDataFolder(), "Status.yml");
		if (this.Stats.exists()) {
			try {
				this.Stats.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kStats = (FileConfiguration) YamlConfiguration.loadConfiguration(this.Stats);
		this.DamageCoins = new File(plugin.getDataFolder(), "DamageCoins.yml");
		if (this.DamageCoins.exists()) {
			try {
				this.DamageCoins.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kDamageCoins = (FileConfiguration) YamlConfiguration.loadConfiguration(this.DamageCoins);
		this.Ranks = new File(plugin.getDataFolder(), "Ranks.yml");
		if (this.Ranks.exists()) {
			try {
				this.Ranks.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kRanks = (FileConfiguration) YamlConfiguration.loadConfiguration(this.Ranks);
		this.Bans = new File(plugin.getDataFolder(), "Bans.yml");
		if (this.Bans.exists()) {
			try {
				this.Bans.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kBans = (FileConfiguration) YamlConfiguration.loadConfiguration(this.Bans);
		this.TempBans = new File(plugin.getDataFolder(), "TempBans.yml");
		if (this.TempBans.exists()) {
			try {
				this.TempBans.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kTempBans = (FileConfiguration) YamlConfiguration.loadConfiguration(this.TempBans);
		this.Mute = new File(plugin.getDataFolder(), "Mute.yml");
		if (this.Mute.exists()) {
			try {
				this.Mute.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kMute = (FileConfiguration) YamlConfiguration.loadConfiguration(this.Mute);
		this.TempMute = new File(plugin.getDataFolder(), "TempMute.yml");
		if (this.TempMute.exists()) {
			try {
				this.TempMute.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kTempMute = (FileConfiguration) YamlConfiguration.loadConfiguration(this.TempMute);
		this.IpBans = new File(plugin.getDataFolder(), "IpBans.yml");
		if (this.IpBans.exists()) {
			try {
				this.IpBans.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kIpBans = (FileConfiguration) YamlConfiguration.loadConfiguration(this.IpBans);
		this.Feast = new File(plugin.getDataFolder(), "Feast.yml");
		if (this.Feast.exists()) {
			try {
				this.Feast.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kFeast = (FileConfiguration) YamlConfiguration.loadConfiguration(this.Feast);
		this.Troll = new File(plugin.getDataFolder(), "Troll.yml");
		if (this.Troll.exists()) {
			try {
				this.Troll.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kTroll = (FileConfiguration) YamlConfiguration.loadConfiguration(this.Troll);
		this.Jogadores = new File(plugin.getDataFolder(), "Jogadores.yml");
		if (this.Jogadores.exists()) {
			try {
				this.Jogadores.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kJogadores = (FileConfiguration) YamlConfiguration.loadConfiguration(this.Jogadores);
		this.auth = new File(plugin.getDataFolder(), "auth.yml");
		if (this.auth.exists()) {
			try {
				this.auth.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kAuth = (FileConfiguration) YamlConfiguration.loadConfiguration(this.auth);
		this.Manutencao = new File(plugin.getDataFolder(), "Manutencao.yml");
		if (this.Manutencao.exists()) {
			try {
				this.Manutencao.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.kManutencao = (FileConfiguration) YamlConfiguration.loadConfiguration(this.Manutencao);
	}

	public FileConfiguration getStats() {
		return this.kStats;
	}

	public FileConfiguration getDC() {
		return this.kDamageCoins;
	}

	public FileConfiguration getRank() {
		return this.kRanks;
	}

	public FileConfiguration getBans() {
		return this.kBans;
	}

	public FileConfiguration getIpBans() {
		return this.kIpBans;
	}

	public FileConfiguration getTempBans() {
		return this.kTempBans;
	}

	public FileConfiguration getMute() {
		return this.kMute;
	}

	public FileConfiguration getTempMute() {
		return this.kTempMute;
	}

	public FileConfiguration getWarp() {
		return this.kFeast;
	}

	public FileConfiguration getTroll() {
		return this.kTroll;
	}

	public FileConfiguration getJogadores() {
		return this.kJogadores;
	}

	public FileConfiguration getAuth() {
		return this.kAuth;
	}

	public FileConfiguration getManutencao() {
		return this.kManutencao;
	}

	public void saveStats() {
		try {
			this.kStats.save(this.Stats);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveDamageCoins() {
		try {
			this.kDamageCoins.save(this.DamageCoins);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveRanks() {
		try {
			this.kRanks.save(this.Ranks);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveBans() {
		try {
			this.kBans.save(this.Bans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveTempBans() {
		try {
			this.kTempBans.save(this.TempBans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveMute() {
		try {
			this.kMute.save(this.Mute);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveTempMute() {
		try {
			this.kTempMute.save(this.TempMute);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveIpBans() {
		try {
			this.kIpBans.save(this.IpBans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveFeast() {
		try {
			this.kFeast.save(this.Feast);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveTroll() {
		try {
			this.kTroll.save(this.Troll);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveJogadores() {
		try {
			this.kJogadores.save(this.Jogadores);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveAuth() {
		try {
			this.kAuth.save(this.auth);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveManutencao() {
		try {
			this.kManutencao.save(this.Manutencao);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
