
package com.register;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Date_Register {
    
    public Date_Register(){
    }
    
    public static String fecha_actual(){
        Date fecha = new Date();
        SimpleDateFormat formato_fecha = new SimpleDateFormat("YYYY");
        
        return formato_fecha.format(fecha);
    }
    

}
