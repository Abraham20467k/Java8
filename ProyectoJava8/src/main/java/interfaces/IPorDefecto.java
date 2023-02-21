package interfaces;

public interface IPorDefecto {

	void mostrarNombre(String nombre);
	
	
	//Logica de Negocio
	default String metodoPorDefeto (String nombre) {
		return nombre + "Default";
	}
}
