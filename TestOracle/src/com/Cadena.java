package com;

public class Cadena {

	public static void main(String[] args) {
	 Cadena obj= new Cadena();
	 obj.distancia("sol", "tal");
	}
	
	public int distancia (String cadena1 , String cadena2) {
		 char[] objcadena1=  cadena1.toCharArray();
		 char[] objcadena2 = cadena2.toCharArray();
		 int contador = 0;
		 
		 for (int i = 0; i < objcadena2.length; i++) {
			 if(objcadena1[i] != objcadena2[i]) {
				 contador++;
			 }
		}
		 System.out.println("cantidad de variables diferentes : "+ contador);
		 
//		 for ( char arrayList : objcadena1) {
//			System.out.println(arrayList);
//		}
		
		
		return 0;
	}
}




