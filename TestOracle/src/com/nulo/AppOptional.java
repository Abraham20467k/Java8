package com.nulo;

import java.util.Optional;

import com.model.Person;

public class AppOptional<T> {

	public static void main(String[] args) {
		
		String vacio ="";
//		System.out.println(vacio.length());
		Person p = null;
		String texto = null;
		Optional<Person> op = Optional.ofNullable(p); 
//		Optional<String> cadena1 = Optional.of(texto); 
		Optional<String> opTexto = Optional.ofNullable(texto); 
		System.out.println(Optional.ofNullable(texto).orElse("vacio"));
//		Optional<Person> op2 = Optional.empty();
		System.out.println("valor  nulo "+opTexto.orElse("soy nulo").toUpperCase());
//		System.out.println(cadena1.orElse("soy nulo").toUpperCase());
//		System.out.println("Valor presente "+op.isPresent());
//		AppOptional<Person> app = new AppOptional<>();
//	System.out.println((app.validarNulo(op)));
//	System.out.println("nuevo valor");
//	System.out.println(Boolean.parseBoolean(texto));
	
	}

	
	public <T> boolean validarNulo (Optional<T> objeto) {
		return objeto.isPresent();
		
	}
}
