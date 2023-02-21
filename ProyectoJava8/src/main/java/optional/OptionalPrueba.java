package optional;

import java.util.Optional;

public class OptionalPrueba {
	
	public static void main(String[] args) {
//		probarOptional(null);
		orElseOptional(null);
		
	}
	
	public static void probarOptional(String nombre) {
		System.out.println(nombre.length());
	}
	
	public static void crearOptional () {
		Optional<?> optional  = Optional.empty();
		optional.get();
	}

	
	
	
	public static <T extends String> void orElseOptional(T  nombre) {
		Optional<String > optional = Optional.ofNullable(nombre);
		//Optional<String> optional1 = Optional.of(nombre);
		
		String nombreofNullabe = optional.orElse("Vacio");
		//String nombreOf = optional1.orElse("Vacio");
		System.out.println(nombreofNullabe);
	//	System.out.println(nombreOf);
		
		
		
	}
	
	public static void orElseThrow(String nombre) {
		Optional<String> optional = Optional.ofNullable(nombre);
		optional.orElseThrow(NullPointerException::new);
		String nombre1= optional.get();
		System.out.println(nombre1);
	}
	
	public static void isPresent(String nombre) {
		Optional <String> optional = Optional.ofNullable(nombre);
		System.out.println(optional.isPresent());
	}
}
