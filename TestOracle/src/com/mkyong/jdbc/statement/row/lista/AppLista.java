package com.mkyong.jdbc.statement.row.lista;

import java.util.ArrayList;
import java.util.List;

public class AppLista {
	
	public static void main(String[] args) {
		
		String cadena = "<< Validator Código >>[1164]";
		System.out.println("valor caracter : "+ cadena.indexOf("[")	);
		
		List<String> list = new ArrayList<String>();
        list.add("Text 1");
        list.add("Text 2");
        list.add("Text 3");

        System.out.println("#1 normal for loop");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
	}

}
