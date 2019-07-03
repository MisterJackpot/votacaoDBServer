package sample.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatador {

    private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

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


}
