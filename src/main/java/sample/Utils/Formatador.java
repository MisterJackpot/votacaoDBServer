package sample.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Formatador {

    private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat horas = new SimpleDateFormat("HH:mm");
    private static Calendar c = Calendar.getInstance();


    public static String formatarData(Date data){

        return formato.format(data);
    }

    public static Date parseData(String data){
        Date dataFormatada = null;
        try {
            dataFormatada = formato.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return dataFormatada;
    }

    public static String formatarHoras(Date date){
        return horas.format(date);
    }

    public static Date parseHoras(String data){
        Date h = null;
        try{
            h = horas.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return h;
    }

    public static Date adicionarDia(Date date){
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    public static int getSemana(Date data){
        c.setTime(data);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

}
