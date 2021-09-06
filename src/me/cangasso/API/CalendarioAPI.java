package me.cangasso.API;

import java.util.Calendar;

public class CalendarioAPI {
	public static int PegarCalendario(final Calendario c) {
		switch (c) {
		case Dia: {
			return Calendar.getInstance().get(5);
		}
		case Mes: {
			return Calendar.getInstance().get(2) + 1;
		}
		case Ano: {
			return Calendar.getInstance().get(1);
		}
		case DiaDaSemana: {
			return Calendar.getInstance().get(7);
		}
		case Hora: {
			return Calendar.getInstance().get(11);
		}
		case Minuto: {
			return Calendar.getInstance().get(12);
		}
		case Segundo: {
			return Calendar.getInstance().get(13);
		}
		default: {
			return 0;
		}
		}
	}

	public enum Calendario {
		Dia("Dia", 0), Mes("Mes", 1), Ano("Ano", 2), DiaDaSemana("DiaDaSemana", 3), Hora("Hora", 4),
		Minuto("Minuto", 5), Segundo("Segundo", 6);

		private Calendario(final String s, final int n) {
		}
	}
}
