package me.cangasso.nametag;

import java.util.ArrayList;

public class NametagUtils {
	public static String formatColors(final String str) {
		final char[] chars = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'n', 'r',
				'l', 'k', 'o', 'm' };
		final char[] array = str.toCharArray();
		for (int t = 0; t < array.length - 1; ++t) {
			if (array[t] == '&') {
				char[] array2;
				for (int length = (array2 = chars).length, i = 0; i < length; ++i) {
					final char c = array2[i];
					if (c == array[t + 1]) {
						array[t] = '�';
					}
				}
			}
		}
		return new String(array);
	}

	public static void box(final String[] paragraph, final String title) {
		final ArrayList<String> buffer = new ArrayList<String>();
		String at = "";
		final int side1 = (int) Math.round(25.0 - (title.length() + 4) / 2.0);
		final int side2 = (int) (26.0 - (title.length() + 4) / 2.0);
		at = String.valueOf(at) + '+';
		for (int t = 0; t < side1; ++t) {
			at = String.valueOf(at) + '-';
		}
		at = String.valueOf(at) + "{ ";
		at = String.valueOf(at) + title;
		at = String.valueOf(at) + " }";
		for (int t = 0; t < side2; ++t) {
			at = String.valueOf(at) + '-';
		}
		at = String.valueOf(at) + '+';
		buffer.add(at);
		at = "";
		buffer.add("|                                                   |");
		for (final String s : paragraph) {
			at = String.valueOf(at) + "| ";
			int left = 49;
			for (int t2 = 0; t2 < s.length(); ++t2) {
				at = String.valueOf(at) + s.charAt(t2);
				if (--left == 0) {
					at = String.valueOf(at) + " |";
					buffer.add(at);
					at = "";
					at = String.valueOf(at) + "| ";
					left = 49;
				}
			}
			while (left-- > 0) {
				at = String.valueOf(at) + ' ';
			}
			at = String.valueOf(at) + " |";
			buffer.add(at);
			at = "";
		}
		buffer.add("|                                                   |");
		buffer.add("+---------------------------------------------------+");
		System.out.println(" ");
		String[] array;
		for (int length2 = (array = buffer.toArray(new String[buffer.size()])).length, j = 0; j < length2; ++j) {
			final String line = array[j];
			System.out.println(line);
		}
		System.out.println(" ");
	}

	public static String trim(String input) {
		if (input.length() > 16) {
			final String temp = input;
			input = "";
			for (int t = 0; t < 16; ++t) {
				input = String.valueOf(input) + temp.charAt(t);
			}
		}
		return input;
	}

	public static String getValue(String rawValue) {
		if (!rawValue.startsWith("\"") || !rawValue.endsWith("\"")) {
			return rawValue;
		}
		rawValue = rawValue.trim();
		String f1 = "";
		for (int t = 1; t < rawValue.length() - 1; ++t) {
			f1 = String.valueOf(f1) + rawValue.charAt(t);
		}
		return f1;
	}

	public static boolean compareVersion(final String old, final String newer) {
		final ArrayList<Integer> oldValues = new ArrayList<Integer>();
		final ArrayList<Integer> newValues = new ArrayList<Integer>();
		String at = "";
		char[] charArray;
		for (int length = (charArray = old.toCharArray()).length, i = 0; i < length; ++i) {
			final char c = charArray[i];
			if (c != '.') {
				at = String.valueOf(at) + c;
			} else {
				try {
					oldValues.add(Integer.parseInt(at));
				} catch (Exception e) {
					return false;
				}
				at = "";
			}
		}
		try {
			oldValues.add(Integer.parseInt(at));
		} catch (Exception e2) {
			return false;
		}
		at = "";
		char[] charArray2;
		for (int length2 = (charArray2 = newer.toCharArray()).length, j = 0; j < length2; ++j) {
			final char c = charArray2[j];
			if (c != '.') {
				at = String.valueOf(at) + c;
			} else {
				try {
					newValues.add(Integer.parseInt(at));
				} catch (Exception e) {
					return false;
				}
				at = "";
			}
		}
		try {
			newValues.add(Integer.parseInt(at));
		} catch (Exception e2) {
			return false;
		}
		int size = oldValues.size();
		boolean defaultToOld = true;
		if (newValues.size() < size) {
			size = newValues.size();
			defaultToOld = false;
		}
		for (int t = 0; t < size; ++t) {
			if (oldValues.get(t) < newValues.get(t)) {
				return true;
			}
			if (oldValues.get(t) > newValues.get(t)) {
				return false;
			}
		}
		return oldValues.size() != newValues.size() && defaultToOld;
	}
}
