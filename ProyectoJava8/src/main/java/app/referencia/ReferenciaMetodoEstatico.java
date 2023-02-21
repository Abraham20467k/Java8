package app.referencia;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import interfaces.IUser;
import interfaces.Trabajo;
import interfaces.TtrabajotoString;

public class ReferenciaMetodoEstatico {
	
	public static void main(String[] args) {
		/**
		 * Referencia a static method  Class:staticMethod  Math::abs   n-> Math.abs(n) 
		 */
		
		Trabajo trabajo = new Trabajo() {
			
			@Override
			public void accion() {
				// TODO Auto-generated method stub
				User.referenciaMetodoEstatico();
			}
		};
		
		Trabajo trabajoLambda = () -> 	User.referenciaMetodoEstatico();
		Trabajo trabajoMR  = User::referenciaMetodoEstatico;
		trabajoMR.accion();
//		System.err.println();
		
		/*
		 * Referencia a un      instancia::metodoInstancia	s::toString   ()-> 	"string.toString
		 * metodo de instancia 
		 * de un objeto 
		 * particular  
		 */
		
		User usuario = new User("Alberto");
		Trabajo trabajoL1 = () -> usuario.referenciaMetodoParticular();
		Trabajo trabajoMR2 = usuario::referenciaMetodoParticular;
		trabajoMR2.accion();
		
		/*
		 * Referencia  a un metodo de         Class::metodoInstancia  String::toString 
		 *  instancia de un objeto arbitrario
		 *  de un tipo particular 
		 * */
		
		TtrabajotoString trabajoString = (palabra) -> palabra.toUpperCase();
		TtrabajotoString  trabajoStringMR = String::toUpperCase;
		System.out.println(trabajoStringMR.accion("alberto"));
		
		
		List<User> users = new ArrayList<>();
		users.add(new User("Israel"));
		users.add(new User("Jorge"));
		users.add(new User("Jose"));
		
		users.forEach(nombre -> nombre.mostrarNombre());
		
		users.forEach(User::mostrarNombre);
		/*
		 * Referencia a constructor
		 * */
		
		IUser user = new IUser() {
			
			@Override
			public User crear(String nombre) {
				// TODO Auto-generated method stub
				return new User(nombre);
			}
		};
		
		IUser user2 = (nombre -> new User("Pablo"));
		IUser user3 = User::new;
			
	}

}
