package com.model;


public class Person {
	
	
	
	private String nombre;
	private int edad;
	private Long dni;
	
	
	
	public Person() {
		super();
	}


	public Person(String nombre, int edad, Long dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	

}
