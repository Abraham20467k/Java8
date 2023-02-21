package bean;

public class User {
	
	private String nombre;
	public static  final String EMPTY_USER = "VACIO";
	public User(String nombre) {
		this.nombre = nombre;
		
		
	}
	
	public void referenciaMetodoParticular() {
		System.out.println("Probando a referencia a Metodo de Objeto Particular");
	}
	
	public void mostrarNombre() {
		System.out.println(nombre);
	}
	public static void referenciaMetodoEstatico () {
		System.out.println("Probando referencia a  metodo estatico");
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
