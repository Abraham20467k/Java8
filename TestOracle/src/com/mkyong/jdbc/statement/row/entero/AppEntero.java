package com.mkyong.jdbc.statement.row.entero;

import java.math.BigDecimal;

public class AppEntero {

	public static void main(String[] args) {

		BigDecimal decimal= new BigDecimal(15);
		System.out.println("Valor bigDecimal : "+ decimal);
		int valor  = 0;
		int resultado = Integer.signum(valor);
		if(resultado == 0) {
			System.out.print(valor + " is Zero"); 
		} else if (resultado == 1) {
			System.out.print(valor + " is positive"); 
		} else {
			System.out.print(valor + " is negative"); 
			
		}
		
	}

}
