package fechaHora;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

public class PruebasLocalDateTime {

    public static void main(String[] args) {

        System.out.println("Fecha actual " + LocalDate.now());
        System.out.println("Hora actual " + LocalTime.now());
        System.out.println("Fecha y hora actual " + LocalDateTime.now());

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(2001, Month.JANUARY, 16);
        System.out.printf("Nació el  %1$te de %1$tB de %1$tY  %n", fechaNacimiento);
        //salida :   Nació el  16 de enero de 2001

        LocalTime hora = LocalTime.of(6, 15, 30, 200);
        System.out.println(hora);
        System.out.printf("Hora es %1$tHh %1$tMm %1$tSs  %n", hora);

        /*
Fecha actual 2020-11-23
Hora actual 08:51:37.458
Fecha y hora actual 2020-11-23T08:51:37.458
         */
        System.out.println("... java.util.Date ");
        Date fecha = new Date(120, 0, 32);
        System.out.println("fecha es " + fecha);
        //salida : fecha es Sat Feb 01 00:00:00 CET 2020

        //lanza una excepcion  java.time.DateTimeException
        //  LocalDate fecha2 = LocalDate.of(2015, Month.JANUARY, 32);
        // System.out.println("fecha2 es " + fecha2);
        //antes 
        Calendar c = Calendar.getInstance();
        c.set(2020, Calendar.NOVEMBER, 23);
        Date fecha3 = c.getTime();
        c.add(Calendar.YEAR, 2); //suma 2 años

        //ahora
        LocalDate fecha4 = LocalDate.of(2000, Month.MARCH, 10);
        LocalDate fecha4Mas4Semanas = fecha4.plusWeeks(4).plusDays(1);
        System.out.printf("Fecha4 el  %1$te de %1$tB de %1$tY  %n", fecha4);
        System.out.printf("Fecha4 + 4 semanas  %1$te de %1$tB de %1$tY  %n", fecha4Mas4Semanas);

        //Period
        Period trimestral = Period.ofMonths(3);

        LocalDate fecha5 = fecha4.plus(trimestral);

        System.out.printf("Fecha5 %1$te de %1$tB de %1$tY  %n", fecha5);

        //Uso de TimeZone
        ZoneId zoneIdMx = ZoneId.of("America/Mexico_City");
        ZoneId zoneIdAm = ZoneId.of("Europe/Amsterdam");
        ZonedDateTime salida = ZonedDateTime.of(2018, 10, 31, 2, 39, 0, 0, zoneIdMx);

        System.out.println("Departure date: " + salida);
        System.out.println("Arrival in México time: " + salida.plusHours(12));
        
        ZonedDateTime llegadaAmsterdam = 
                ZonedDateTime.ofInstant(salida.plusHours(12).toInstant(), zoneIdAm);
                
        System.out.println("Arrival in Amsterdam time: " +  llegadaAmsterdam);
               

    }//fin main

}//fin clase
