package me.cangasso.scoreboard;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class uScore {
	private Scoreboard Scoreboard;
	private String Titulo;
	private Map<String, Integer> Scores;
	private List<Team> Times;
	private Objective Objetivo;

	public uScore(final String title) {
		this.Scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		this.Titulo = title;
		this.Scores = Maps.newLinkedHashMap();
		this.Times = Lists.newArrayList();
	}

	public void addLine(String message, final Integer Score) {
		Preconditions.checkArgument(message.length() < 70, (Object) "Sua Scoreboard nao pode passar de 48 caracteres");
		message = this.substituir(message);
		this.Scores.put(message, Score);
	}

	private String substituir(String message) {
		while (this.Scores.containsKey(message)) {
			message = String.valueOf(message) + "\u00c2§r";
		}
		if (message.length() > 60) {
			message = message.substring(0, 69);
		}
		return message;
	}

	private Map.Entry<Team, String> createTeam(final String message) {
		String result = "";
		if (message.length() <= 16) {
			return new AbstractMap.SimpleEntry<Team, String>(null, message);
		}
		final Team Time = this.Scoreboard.registerNewTeam("text-" + this.Scoreboard.getTeams().size());
		final Iterator<String> MensagemSplit = Splitter.fixedLength(16).split((CharSequence) message).iterator();
		Time.setPrefix((String) MensagemSplit.next());
		result = MensagemSplit.next();
		if (message.length() > 32) {
			Time.setSuffix((String) MensagemSplit.next());
		}
		this.Times.add(Time);
		return new AbstractMap.SimpleEntry<Team, String>(Time, result);
	}

	public void setScoreboard() {
		(this.Objetivo = this.Scoreboard.registerNewObjective("a", "dummy")).setDisplayName(this.Titulo);
		this.Objetivo.setDisplaySlot(DisplaySlot.SIDEBAR);
		int index = this.Scores.size();
		for (final Map.Entry<String, Integer> Mensagem : this.Scores.entrySet()) {
			final Map.Entry<Team, String> Time = this.createTeam(Mensagem.getKey());
			final Integer Score = (Mensagem.getValue() != null) ? Mensagem.getValue() : index;
			final String jogador = Time.getValue();
			if (Time.getKey() != null) {
				Time.getKey().addEntry(jogador);
			}
			this.Objetivo.getScore(jogador).setScore((int) Score);
			--index;
		}
	}

	public void resetScoreboard() {
		if (this.Objetivo != null) {
			this.Objetivo.unregister();
		}
		this.Scores.clear();
		for (final Team Times : this.Times) {
			Times.unregister();
		}
		this.Times.clear();
	}

	public Scoreboard getScoreboard() {
		return this.Scoreboard;
	}
}
