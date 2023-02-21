package com.test.lista;

import java.util.ArrayList;
import java.util.List;

public class ListaSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String cadena1 ="12312312";
//		System.out.println(cadena1.indexOf("1"));
//		
//		Set<String> estadosIds = new HashSet<String>();
//		estadosIds.add("V");
//		estadosIds.add("ACT");
//		System.out.println(estadosIds);
////		for (String cadena : estadosIds) {
////			System.out.println(cadena);
////		}
		
		String  texto ="1";
		String  texto3 ="2";
		String  texto2 ="4";
		List<String> objArray = new ArrayList<>();
		objArray.add(texto3);
		objArray.add(texto);
		objArray.add(texto2);
		
		objArray.forEach(s -> System.out.println(s));
//		department.get().stream().forEach(e -> System.out.println(e.getIdDepartamento()));
	}

}
