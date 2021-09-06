package twitter4j.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class TimeSpanConverter implements Serializable {
	private static final long serialVersionUID = 8665013607650804076L;
	private final MessageFormat[] formats;
	private final SimpleDateFormat dateMonth;
	private final SimpleDateFormat dateMonthYear;

	public TimeSpanConverter() {
		this(Locale.getDefault());
	}

	public TimeSpanConverter(final Locale locale) {
		this.formats = new MessageFormat[6];
		final String language = locale.getLanguage();
		if ("it".equals(language)) {
			this.formats[0] = new MessageFormat("Ora");
			this.formats[1] = new MessageFormat("{0} secondi fa");
			this.formats[2] = new MessageFormat("1 minuto fa");
			this.formats[3] = new MessageFormat("{0} minuti fa");
			this.formats[4] = new MessageFormat("1 ora fa");
			this.formats[5] = new MessageFormat("{0} ore fa");
			this.dateMonth = new SimpleDateFormat("d MMM", locale);
			this.dateMonthYear = new SimpleDateFormat("d MMM yy", locale);
		} else if ("kr".equals(language)) {
			this.formats[0] = new MessageFormat("\u00ec§\u20ac\u00ea¸\u02c6");
			this.formats[1] = new MessageFormat("{0}\u00ec´\u02c6 \u00ec \u201e");
			this.formats[2] = new MessageFormat("1\u00eb¶\u201e \u00ec \u201e");
			this.formats[3] = new MessageFormat("{0}\u00eb¶\u201e \u00ec \u201e");
			this.formats[4] = new MessageFormat("1\u00ec\u2039\u0153\u00ea°\u201e \u00ec \u201e");
			this.formats[5] = new MessageFormat("{0} ore fa");
			this.dateMonth = new SimpleDateFormat("M\u00ec\u203a\u201d d\u00ec\ufffd¼", locale);
			this.dateMonthYear = new SimpleDateFormat("yy\u00eb\u2026\u201e M\u00ec\u203a\u201d d\u00ec\ufffd¼",
					locale);
		} else if ("es".equals(language)) {
			this.formats[0] = new MessageFormat("Ahora");
			this.formats[1] = new MessageFormat("hace {0} segundos");
			this.formats[2] = new MessageFormat("hace 1 minuto");
			this.formats[3] = new MessageFormat("hace {0} minutos");
			this.formats[4] = new MessageFormat("hace 1 hora");
			this.formats[5] = new MessageFormat("hace {0} horas");
			this.dateMonth = new SimpleDateFormat("d MMM", locale);
			this.dateMonthYear = new SimpleDateFormat("d MMM yy", locale);
		} else if ("fr".equals(language)) {
			this.formats[0] = new MessageFormat("Maintenant");
			this.formats[1] = new MessageFormat("Il y a {0} secondes");
			this.formats[2] = new MessageFormat("Il y a 1 minute");
			this.formats[3] = new MessageFormat("Il y a {0} minutes");
			this.formats[4] = new MessageFormat("Il y a 1 heure");
			this.formats[5] = new MessageFormat("Il y a {0} heures");
			this.dateMonth = new SimpleDateFormat("d MMM", locale);
			this.dateMonthYear = new SimpleDateFormat("d MMM yy", locale);
		} else if ("de".equals(language)) {
			this.formats[0] = new MessageFormat("Jetzt");
			this.formats[1] = new MessageFormat("vor {0} Sekunden");
			this.formats[2] = new MessageFormat("vor 1 Minute");
			this.formats[3] = new MessageFormat("vor {0} Minuten");
			this.formats[4] = new MessageFormat("vor 1 Stunde");
			this.formats[5] = new MessageFormat("vor {0} Stunden");
			this.dateMonth = new SimpleDateFormat("d MMM", locale);
			this.dateMonthYear = new SimpleDateFormat("d MMM yy", locale);
		} else if ("ja".equals(language)) {
			this.formats[0] = new MessageFormat("\u00e4»\u0160");
			this.formats[1] = new MessageFormat("{0}\u00e7§\u2019\u00e5\u2030\ufffd");
			this.formats[2] = new MessageFormat("1\u00e5\u02c6\u2020\u00e5\u2030\ufffd");
			this.formats[3] = new MessageFormat("{0}\u00e5\u02c6\u2020\u00e5\u2030\ufffd");
			this.formats[4] = new MessageFormat("1\u00e6\u2122\u201a\u00e9\u2013\u201c\u00e5\u2030\ufffd");
			this.formats[5] = new MessageFormat("{0}\u00e6\u2122\u201a\u00e9\u2013\u201c\u00e5\u2030\ufffd");
			this.dateMonth = new SimpleDateFormat("M\u00e6\u0153\u02c6d\u00e6\u2014¥", locale);
			this.dateMonthYear = new SimpleDateFormat("yy\u00e5¹´M\u00e6\u0153\u02c6d\u00e6\u2014¥", locale);
		} else {
			this.formats[0] = new MessageFormat("now");
			this.formats[1] = new MessageFormat("{0} seconds ago");
			this.formats[2] = new MessageFormat("1 minute ago");
			this.formats[3] = new MessageFormat("{0} minutes ago");
			this.formats[4] = new MessageFormat("1 hour ago");
			this.formats[5] = new MessageFormat("{0} hours ago");
			this.dateMonth = new SimpleDateFormat("d MMM", Locale.ENGLISH);
			this.dateMonthYear = new SimpleDateFormat("d MMM yy", Locale.ENGLISH);
		}
	}

	public String toTimeSpanString(final Date date) {
		return this.toTimeSpanString(date.getTime());
	}

	public String toTimeSpanString(final long milliseconds) {
		final int deltaInSeconds = (int) ((System.currentTimeMillis() - milliseconds) / 1000L);
		if (deltaInSeconds < 86400) {
			return this.toTimeSpanString(deltaInSeconds);
		}
		if (deltaInSeconds >= 2592000) {
			return this.dateMonthYear.format(new Date(milliseconds));
		}
		return this.dateMonth.format(new Date(milliseconds));
	}

	private String toTimeSpanString(final int deltaInSeconds) {
		if (deltaInSeconds <= 1) {
			return this.formats[0].format(null);
		}
		if (deltaInSeconds < 60) {
			return this.formats[1].format(new Object[] { deltaInSeconds });
		}
		if (deltaInSeconds < 2700) {
			final int minutes = deltaInSeconds / 60;
			if (minutes == 1) {
				return this.formats[2].format(null);
			}
			return this.formats[3].format(new Object[] { minutes });
		} else {
			if (deltaInSeconds < 6300) {
				return this.formats[4].format(null);
			}
			final int hours = (deltaInSeconds + 900) / 3600;
			return this.formats[5].format(new Object[] { hours });
		}
	}
}
