package me.cangasso.API;

import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class HorarioAPI
{
    public static SimpleDateFormat sdf;
    public static Calendar ca;
    
    static {
        HorarioAPI.sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        HorarioAPI.ca = new GregorianCalendar(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
    
    public static String getHorario() {
        final TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
        final Calendar calendar = Calendar.getInstance(tz);
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return sdf.format(calendar.getTime());
    }
}
