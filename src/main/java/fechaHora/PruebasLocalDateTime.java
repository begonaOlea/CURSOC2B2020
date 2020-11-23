package fechaHora;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class PruebasLocalDateTime {

    public static void main(String[] args) {

        System.out.println("Fecha actual " + LocalDate.now());
        System.out.println("Hora actual " + LocalTime.now());
        System.out.println("Fecha y hora actual " + LocalDateTime.now());
        
        LocalDate fechaActual =  LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(2001, Month.JANUARY, 16);
        System.out.printf("Nació el  %1$te de %1$tB de %1$tY", fechaNacimiento);
        //salida :   Nació el  16 de enero de 2001
        
/*
Fecha actual 2020-11-23
Hora actual 08:51:37.458
Fecha y hora actual 2020-11-23T08:51:37.458
*/
    


        
    }//fin main
    
}//fin clase
