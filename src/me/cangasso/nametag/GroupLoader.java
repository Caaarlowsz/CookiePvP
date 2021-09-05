package me.cangasso.nametag;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.LinkedHashMap;
import org.bukkit.plugin.java.JavaPlugin;

public class GroupLoader
{
    private static final String PREFIX = "[NAMETAG CONFIG] ";
    static final boolean DEBUG = true;
    
    public static LinkedHashMap<String, LinkedHashMap<String, String>> Carregar(final JavaPlugin Plugin) {
        final String folder = "plugins/" + Plugin.getName();
        final File folderFile = new File(folder);
        if (!folderFile.exists()) {
            folderFile.mkdir();
        }
        final String path = "plugins/" + Plugin.getName() + "/groups.txt";
        final File source = new File(path);
        if (source.exists()) {
            return CarregarConfig(source);
        }
        try {
            source.createNewFile();
        }
        catch (IOException e) {
            Print("Failed to create config file: ");
            e.printStackTrace();
        }
        return CriarConfig(source);
    }
    
    private static LinkedHashMap<String, LinkedHashMap<String, String>> CriarConfig(final File target) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(target);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println("// This file declares custom permissions and ties prefixes and suffixes to them.");
        out.println("// Players who possess these permissions will have the prefix and suffix assigned to the given permission.");
        out.println("nametag.group.admin prefix = \"[&cAdmin&f] \"");
        out.println("nametag.group.mod prefix = \"[&bMod&f] \"");
        out.println("nametag.group.member prefix = \"[&eMember&f] \"");
        out.println("nametag.group.swag prefix = \"&eThe &b\"");
        out.println("nametag.group.swag suffix = \" &cSwagmaster\"");
        final LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        final LinkedHashMap<String, String> admin = new LinkedHashMap<String, String>();
        admin.put("prefix", "[&cAdmin&f] ");
        map.put("nametag.group.admin", admin);
        final LinkedHashMap<String, String> mod = new LinkedHashMap<String, String>();
        mod.put("prefix", "[&bMod&f] ");
        map.put("nametag.group.mod", mod);
        final LinkedHashMap<String, String> member = new LinkedHashMap<String, String>();
        member.put("prefix", "[&eMember&f] ");
        map.put("nametag.group.member", member);
        final LinkedHashMap<String, String> swag = new LinkedHashMap<String, String>();
        swag.put("prefix", "&eThe &b");
        swag.put("suffix", " &cSwagmaster");
        map.put("nametag.group.swag", swag);
        out.close();
        return map;
    }
    
    public static LinkedHashMap<String, LinkedHashMap<String, String>> CarregarConfig(final File source) {
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
                syntaxError = CheckWords(line);
                if (syntaxError) {
                    Print("Error in syntax, not enough elements on line!");
                }
                final Scanner lineScanner = new Scanner(line);
                final String node = lineScanner.next();
                final String operation = lineScanner.next();
                final String equals = lineScanner.next();
                if (!equals.trim().equals("=")) {
                    Print("Error in syntax, \"=\" expected at third element, \"" + equals + "\" given.");
                    syntaxError = true;
                    break;
                }
                final String rawValue = lineScanner.nextLine();
                syntaxError = CheckValue(rawValue);
                if (syntaxError) {
                    Print("Error in syntax, value not encased in quotation marks!");
                    break;
                }
                final String value = PegarValue(rawValue);
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
    
    private static void Print(final String Jogador) {
        System.out.println("[NAMETAG CONFIG] " + Jogador);
    }
    
    private static void PrintDebug(final String Jogador) {
        System.out.println("[NAMETAG CONFIG] " + Jogador);
    }
    
    private static boolean CheckWords(final String line) {
        int count = 0;
        final Scanner reader = new Scanner(line);
        while (reader.hasNext()) {
            ++count;
            reader.next();
        }
        reader.close();
        return count < 4;
    }
    
    private static boolean CheckValue(String rawValue) {
        rawValue = rawValue.trim();
        return !rawValue.startsWith("\"") || !rawValue.endsWith("\"");
    }
    
    private static String PegarValue(String rawValue) {
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
