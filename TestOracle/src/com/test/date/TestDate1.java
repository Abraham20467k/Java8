package com.test.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TestDate1 {
	
	public static void main(String[] args)  {
		
		
		LocalDate today = LocalDate.now();
		System.out.println(" ano actual "+today.getYear());
		System.out.println(today.toString());
		
//		long years = ChronoUnit.YEARS.between(from, to);
//		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.MM.SSXFF AM");
		String formato = "dd/MM/yyyy hh:mm:ss";
		String formato1 = "dd/MM/yyyy hh:mm:ss:nn";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:nn");
        ///
        String  fechaCadena= "15/01/2037 12:00:01";
        
        System.out.println(Locale.getDefault());
    	SimpleDateFormat formtatoString = new SimpleDateFormat(formato);
    	try {
    		
    		Date fechDate =  formtatoString.parse(fechaCadena);
    		System.out.println(fechDate);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    //	System.out.println(fechDate);

        
        GregorianCalendar fechaFormatoDP = new GregorianCalendar();
        LocalDateTime createdDate= LocalDateTime.now();
//        System.out.println(createdDate);
        
        LocalDateTime now = LocalDateTime.now();
        Date fecha = new Date();
        LocalDateTime now1 = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

//        String formatDateTime = now.format(formatoFecha);

//        System.out.println("After : " + formatDateTime);
	}
	
	
public static String formatearFecha(String msjTxIn, Date fechaDate, String formato) {
		
		String fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat(formato,
				Locale.getDefault());
		try {
			fecha = sdf.format(fechaDate);

		} catch (Exception e) {
//			logger.error(msjTxIn + "ERROR [Exception]: " + e.getMessage(), e);
		} 
		
		return fecha;
	}

}
