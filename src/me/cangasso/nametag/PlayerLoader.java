package me.cangasso.nametag;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.LinkedHashMap;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerLoader
{
    private static final String PREFIX = "[NAMETAG CONFIG] ";
    private static String path;
    
    static {
        PlayerLoader.path = null;
    }
    
    public static LinkedHashMap<String, LinkedHashMap<String, String>> load(final JavaPlugin plugin) {
        final String folder = "plugins/" + plugin.getName();
        final File folderFile = new File(folder);
        if (!folderFile.exists()) {
            folderFile.mkdir();
        }
        PlayerLoader.path = "plugins/" + plugin.getName() + "/tags.txt";
        final File source = new File(PlayerLoader.path);
        if (source.exists()) {
            return loadConfig();
        }
        try {
            source.createNewFile();
        }
        catch (IOException e) {
            print("Failed to create config file: ");
            e.printStackTrace();
        }
        return generateConfig(source, plugin);
    }
    
    static void addPlayer(final String name, final String operation, String value) {
        final ArrayList<String> buffer = new ArrayList<String>();
        final File file = new File(PlayerLoader.path);
        Scanner in = null;
        PrintWriter out = null;
        value = value.replace("\u00c2§", "&");
        try {
            in = new Scanner(new File(PlayerLoader.path));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (in.hasNext()) {
            buffer.add(in.nextLine());
        }
        in.close();
        try {
            out = new PrintWriter(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] array;
        for (int length = (array = buffer.toArray(new String[buffer.size()])).length, i = 0; i < length; ++i) {
            final String line = array[i];
            out.println(line);
        }
        out.println(String.valueOf(name) + " " + operation + " = \"" + value + "\"");
        out.close();
    }
    
    public static void update(final String name, String prefix, String suffix) {
        final LinkedHashMap<String, String> player = getPlayer(name);
        removePlayer(name, null);
        if (prefix != null && !prefix.isEmpty()) {
            prefix = prefix.replace("\u00c2§", "&");
            addPlayer(name, "prefix", prefix);
        }
        else if (player != null && player.get("prefix") != null) {
            addPlayer(name, "prefix", player.get("prefix"));
        }
        if (suffix != null && !suffix.isEmpty()) {
            suffix = suffix.replace("\u00c2§", "&");
            addPlayer(name, "suffix", suffix);
        }
        else if (player != null && player.get("suffix") != null) {
            addPlayer(name, "suffix", player.get("suffix"));
        }
    }
    
    static void overlap(final String name, String prefix, String suffix) {
        prefix = prefix.replace("\u00c2§", "&");
        suffix = suffix.replace("\u00c2§", "&");
        removePlayer(name, null);
        if (prefix != null && !prefix.isEmpty()) {
            addPlayer(name, "prefix", prefix);
        }
        if (suffix != null && !suffix.isEmpty()) {
            addPlayer(name, "suffix", suffix);
        }
    }
    
    static void removePlayer(final String name, final String operation) {
        final ArrayList<String> buffer = new ArrayList<String>();
        final File file = new File(PlayerLoader.path);
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(new File(PlayerLoader.path));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (in.hasNext()) {
            buffer.add(in.nextLine());
        }
        in.close();
        try {
            out = new PrintWriter(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] array;
        for (int length = (array = buffer.toArray(new String[buffer.size()])).length, i = 0; i < length; ++i) {
            final String line = array[i];
            final Scanner lineScanner = new Scanner(line);
            final String lName = lineScanner.next();
            final String lOperation = lineScanner.next();
            lineScanner.close();
            boolean skip = false;
            if (name.equals(lName)) {
                if (operation != null && operation.equals(lOperation)) {
                    skip = true;
                }
                else if (operation == null) {
                    skip = true;
                }
            }
            if (!skip) {
                out.println(line);
            }
        }
        out.close();
    }
    
    public static LinkedHashMap<String, String> getPlayer(final String name) {
        final LinkedHashMap<String, LinkedHashMap<String, String>> playerMap = loadConfig();
        String[] array;
        for (int length = (array = playerMap.keySet().toArray(new String[playerMap.keySet().size()])).length, i = 0; i < length; ++i) {
            final String key = array[i];
            if (key.equals(name)) {
                return playerMap.get(key);
            }
        }
        return null;
    }
    
    private static LinkedHashMap<String, LinkedHashMap<String, String>> generateConfig(final File target, final JavaPlugin plugin) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(target);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.close();
        return loadConfig();
    }
    
    private static LinkedHashMap<String, LinkedHashMap<String, String>> loadConfig() {
        final File source = new File(PlayerLoader.path);
        Scanner in = null;
        try {
            in = new Scanner(source);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        final LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        boolean syntaxError = false;
        while (in.hasNext()) {
            final String line = in.nextLine();
            if (!line.trim().startsWith("//") && !line.isEmpty()) {
                syntaxError = checkWords(line);
                final Scanner lineScanner = new Scanner(line);
                final String node = lineScanner.next();
                final String operation = lineScanner.next();
                final String equals = lineScanner.next();
                if (!equals.trim().equals("=")) {
                    syntaxError = true;
                    break;
                }
                final String rawValue = lineScanner.nextLine();
                syntaxError = checkValue(rawValue);
                if (syntaxError) {
                    break;
                }
                final String value = getValue(rawValue);
                LinkedHashMap<String, String> entry = new LinkedHashMap<String, String>();
                if (map.get(node) != null) {
                    entry = map.get(node);
                }
                entry.put(operation.toLowerCase(), value);
                if (map.get(node) == null) {
                    map.put(node, entry);
                }
                lineScanner.close();
            }
        }
        in.close();
        if (syntaxError) {
            return new LinkedHashMap<String, LinkedHashMap<String, String>>();
        }
        return map;
    }
    
    private static void print(final String p) {
    }
    
    private static void printDebug(final String p) {
    }
    
    private static boolean checkWords(final String line) {
        int count = 0;
        final Scanner reader = new Scanner(line);
        while (reader.hasNext()) {
            ++count;
            reader.next();
        }
        reader.close();
        return count < 4;
    }
    
    private static boolean checkValue(String rawValue) {
        rawValue = rawValue.trim();
        return !rawValue.startsWith("\"") || !rawValue.endsWith("\"");
    }
    
    private static String getValue(String rawValue) {
        rawValue = rawValue.trim();
        String f1 = "";
        String f2 = "";
        for (int t = 1; t < rawValue.length() - 1; ++t) {
            f1 = String.valueOf(f1) + rawValue.charAt(t);
        }
        for (int t = 0; t < f1.length() && t < 16; ++t) {
            f2 = String.valueOf(f2) + f1.charAt(t);
        }
        return f2;
    }
}
