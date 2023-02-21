package com.test.cadena;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

public class Principal {

	

//	private String cadena1 = "texto1";
	private  double cadena1 = 0.0;
//	private static double cadena2 = 120186.09999999999;
	private static double cadena2 = 120186.46999999999;
	private static String formato_cadena = "%.2f";
	
	
	public static void main(String[] args) {
		if (cadena2 > 0 ) {
			
		}
		
		
		String cadena ="2500098640G152883";
//		System.out.println(cadena.indexOf("G"));
//		System.out.println(cadena.substring(0, cadena.indexOf("G")));
		
		String documento= "CARTGA,SINIES,PRELIQ,LIQCOM";
		System.out.println(documento.indexOf("LIQCOM"));
		
		
//		// TODO Auto-generated method stub
//
//		Principal obj = new Principal();
//		Class class01 =  obj.getClass();
//		double roundOff = Math.round(cadena2*100.0) / 100.0;
//		   DecimalFormat f = new DecimalFormat("##.00");
//		   String dobleFormatado = f.format(cadena2);
////		   System.out.println("valor convertido a doble "+ Double.parseDouble(dobleFormatado));
//		   
//		   
//		   System.out.println(roundOff);
//		   System.out.println("valor doble formateado : "+  dobleFormatado);
//		   System.out.println(f.format(cadena2));
//		   System.out.println(String.format(formato_cadena, cadena2));
//		
//		try {
//			
//			String valor1 ="1";
//			String valor2 ="2";
//			if(valor1.equals("1") && valor2.equals("2")) {
//				System.out.println("Pasaste por aca");
//			}else  {
//				
//				System.out.println("No Pasaste por aca");
//			}
//			
////			Field field = Principal.class.getField("cadena1");
////			Double valor 	=	field.getDouble(obj);
//			Field field =class01.getDeclaredField("cadena1");
////			Field field =class01.getDeclaredField("cadena1");
//			field.setAccessible(true);
//			Double valor = field.getDouble(obj);
////			System.out.println("Atributo encontrado : " + field.getName());
//			System.out.println("Valor encontrado : " + valor);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("ocurrio un error "+ e.getStackTrace());
//		}
//		
//		String vacio="a";
//		
//		char caracter= vacio.isEmpty()	? ' ':vacio.charAt(0);
//		System.out.println(caracter);
		
		
//		String textoFormateado = String.format("%-10s", "ABC").replace(' ','*');        
//		String textoFormateado = String.format("%-10s", "27160").replace(' ','*');        
//		System.out.println("[" + textoFormateado + "]");
		
		
//		String.format("%010d", 4);

//		int resultado= 0000000004;

//		String textoFormateado = String.format("%06d","1234567");
//		System.out.println(textoFormateado);
	}

}
//27160*****
//0001234567