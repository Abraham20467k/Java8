package util;

import java.util.Optional;

import bean.User;

public class Utilitario {
	
	
	public static void main(String[] args) {
		User usuario = new User(null);
		
//		Optional<User> optUser = Optional.ofNullable(usuario);
		
//		if(optUser.isPresent()) {
//			System.out.println(optUser.get().getNombre());
//		}
		
//		System.out.println(optUser.orElse(User.EMPTY_USER).getNombre());
		String valorString = null ;
		boolean v1 = validarNulo(valorString);
		
		boolean valor=validarNulo(usuario);
		System.out.println(valor);
		System.out.println(v1);
	}
	
	
	public static <T> boolean validarNulo(T nombreClase){
		
		boolean validar = false;
		T usernulo =null;
		Optional<T> optValidar = Optional.ofNullable(usernulo);
		
		if (optValidar.isPresent()) {
			validar= true;
		} else {
			validar = false;
		}
		return validar;
	}

	

}
