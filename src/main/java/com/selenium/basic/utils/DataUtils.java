package com.selenium.basic.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

    //Faz a busca da data atual e adiciona dias x
    public Date obterDataComDiferencaDias(int dias){
       Calendar calendar = Calendar.getInstance();
       calendar.add(Calendar.DAY_OF_MONTH, dias);
       return calendar.getTime();
    }

    public String obertDataFormatada(Date dat){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dat);
    }
}
