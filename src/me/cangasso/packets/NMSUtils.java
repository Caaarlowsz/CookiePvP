package me.cangasso.packets;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.bukkit.Bukkit;
import java.lang.reflect.Method;

public class NMSUtils
{
    private static String version;
    private static Class<?> c;
    private static Method m;
    
    static {
        NMSUtils.version = getVersion();
        NMSUtils.c = getOBCClass("block.CraftBlock");
        NMSUtils.m = getMethod(NMSUtils.c, "getNMSBlock", (Class<?>[])new Class[0]);
    }
    
    public static String getVersion() {
        if (NMSUtils.version != null) {
            return NMSUtils.version;
        }
        final String name = Bukkit.getServer().getClass().getPackage().getName();
        final String version = String.valueOf(name.substring(name.lastIndexOf(46) + 1)) + ".";
        return version;
    }
    
    public static Class<?> getNMSClassWithException(final String className) throws Exception {
        final String fullName = "net.minecraft.server." + getVersion() + className;
        return Class.forName(fullName);
    }
    
    public static Class<?> getNMSClass(final String className) {
        Class<?> clazz = null;
        try {
            clazz = getNMSClassWithException(className);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return clazz;
    }
    
    public static Class<?> getOBCClassWithException(final String className) throws Exception {
        final String fullName = "org.bukkit.craftbukkit." + getVersion() + className;
        return Class.forName(fullName);
    }
    
    public static Class<?> getOBCClass(final String className) {
        Class<?> clazz = null;
        try {
            clazz = getOBCClassWithException(className);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return clazz;
    }
    
    public static Object getHandle(final Object obj) {
        try {
            return getMethod(obj.getClass(), "getHandle", (Class<?>[])new Class[0]).invoke(obj, new Object[0]);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Object getBlockHandleWithException(final Object obj) throws Exception {
        return NMSUtils.m.invoke(obj, new Object[0]);
    }
    
    public static Object getBlockHandle(final Object obj) {
        try {
            return NMSUtils.m.invoke(obj, new Object[0]);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Field getFieldWithException(final Class<?> clazz, final String name) throws Exception {
        final Field field = clazz.getDeclaredField(name);
        field.setAccessible(true);
        final Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        int modifiers = modifiersField.getInt(field);
        modifiers &= 0xFFFFFFEF;
        modifiersField.setInt(field, modifiers);
        return field;
    }
    
    public static Field getField(final Class<?> clazz, final String name) {
        try {
            return getFieldWithException(clazz, name);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Field getFieldOfTypeWithException(final Class<?> clazz, final Class<?> type, final String name) throws Exception {
        final Field field = clazz.getDeclaredField(name);
        if (!field.getType().equals(type)) {
            throw new Exception("Field Not Found");
        }
        field.setAccessible(true);
        final Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        int modifiers = modifiersField.getInt(field);
        modifiers &= 0xFFFFFFEF;
        modifiersField.setInt(field, modifiers);
        return field;
    }
    
    public static Field getFieldOfType(final Class<?> clazz, final Class<?> type, final String name) {
        try {
            return getFieldOfTypeWithException(clazz, type, name);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Field getFirstFieldOfTypeWithException(final Class<?> clazz, final Class<?> type) throws Exception {
        Field[] declaredFields;
        for (int length = (declaredFields = clazz.getDeclaredFields()).length, i = 0; i < length; ++i) {
            final Field field = declaredFields[i];
            if (field.getType().equals(type)) {
                field.setAccessible(true);
                final Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                int modifiers = modifiersField.getInt(field);
                modifiers &= 0xFFFFFFEF;
                modifiersField.setInt(field, modifiers);
                return field;
            }
        }
        throw new Exception("Field Not Found");
    }
    
    public static Field getFirstFieldOfType(final Class<?> clazz, final Class<?> type) {
        try {
            return getFirstFieldOfTypeWithException(clazz, type);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Field getLastFieldOfTypeWithException(final Class<?> clazz, final Class<?> type) throws Exception {
        Field field = null;
        Field[] declaredFields;
        for (int length = (declaredFields = clazz.getDeclaredFields()).length, i = 0; i < length; ++i) {
            final Field f = declaredFields[i];
            if (f.getType().equals(type)) {
                field = f;
            }
        }
        if (field == null) {
            throw new Exception("Field Not Found");
        }
        field.setAccessible(true);
        final Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        int modifiers = modifiersField.getInt(field);
        modifiers &= 0xFFFFFFEF;
        modifiersField.setInt(field, modifiers);
        return field;
    }
    
    public static Field getLastFieldOfType(final Class<?> clazz, final Class<?> type) {
        try {
            return getLastFieldOfTypeWithException(clazz, type);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Method getMethod(final Class<?> clazz, final String name, final Class<?>... args) {
        Method[] methods;
        for (int length = (methods = clazz.getMethods()).length, i = 0; i < length; ++i) {
            final Method m = methods[i];
            if (m.getName().equals(name) && (args.length == 0 || ClassListEqual(args, m.getParameterTypes()))) {
                m.setAccessible(true);
                return m;
            }
        }
        Method[] declaredMethods;
        for (int length2 = (declaredMethods = clazz.getDeclaredMethods()).length, j = 0; j < length2; ++j) {
            final Method m = declaredMethods[j];
            if (m.getName().equals(name) && (args.length == 0 || ClassListEqual(args, m.getParameterTypes()))) {
                m.setAccessible(true);
                return m;
            }
        }
        return null;
    }
    
    public static boolean ClassListEqual(final Class<?>[] l1, final Class<?>[] l2) {
        boolean equal = true;
        if (l1.length != l2.length) {
            return false;
        }
        for (int i = 0; i < l1.length; ++i) {
            if (l1[i] != l2[i]) {
                equal = false;
                break;
            }
        }
        return equal;
    }
    
    public static Class<?> getInnerClass(final Class<?> c, final String className) {
        Class<?> clazz = null;
        try {
            Class<?>[] declaredClasses;
            for (int length = (declaredClasses = c.getDeclaredClasses()).length, i = 0; i < length; ++i) {
                final Class<?> cl = declaredClasses[i];
                if (cl.getSimpleName().equals(className)) {
                    clazz = cl;
                    break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return clazz;
    }
    
    public static Constructor<?> getConstructor(final Class<?> clazz, final Class<?>... args) {
        Constructor<?>[] constructors;
        for (int length = (constructors = clazz.getConstructors()).length, i = 0; i < length; ++i) {
            final Constructor<?> c = constructors[i];
            if (args.length == 0 || ClassListEqual(args, c.getParameterTypes())) {
                c.setAccessible(true);
                return c;
            }
        }
        Constructor<?>[] declaredConstructors;
        for (int length2 = (declaredConstructors = clazz.getDeclaredConstructors()).length, j = 0; j < length2; ++j) {
            final Constructor<?> c = declaredConstructors[j];
            if (args.length == 0 || ClassListEqual(args, c.getParameterTypes())) {
                c.setAccessible(true);
                return c;
            }
        }
        return null;
    }
}
