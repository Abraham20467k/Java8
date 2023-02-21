package com.pe.nhtk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.nhtk.exception.ResourceNotFoundException;
import com.pe.nhtk.model.Departments;
import com.pe.nhtk.model.DepartmentsResponse;
import com.pe.nhtk.repository.DepartmentsRepository;


@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	
	
	DepartmentsRepository departmentRepository;
	
	public DepartmentController(DepartmentsRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}


	
	
	@GetMapping("/employees")
	public List<Departments> getAllDepartments() {
		return departmentRepository.findAll();
	}

	
	@GetMapping("/getDepartment/{id}")
	public ResponseEntity<DepartmentsResponse> departament(@PathVariable(value = "id")Long departmentid) throws ResourceNotFoundException{
		Optional<String> department = Optional.ofNullable(departmentRepository.getDepartamente(departmentid));
		DepartmentsResponse response = new  DepartmentsResponse();
		if(department.isPresent()) {
			response.setNomDepartmeno(department.get());
		}
		
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/getDepartment/{idDepartment}/{idLocation}")
	public ResponseEntity<DepartmentsResponse> departamentwithFilter(@PathVariable(value = "idDepartment")Long departmentid, @PathVariable(value = "idLocation")Integer locationid) 
			throws ResourceNotFoundException
	{
		Optional<String> department = Optional.ofNullable(departmentRepository.getDepartamentwithFilter(departmentid, locationid));
		DepartmentsResponse response = new  DepartmentsResponse();
		if(department.isPresent()) {
			response.setNomDepartmeno(department.get());
		}
		
		return ResponseEntity.ok(response);
		
		
	}

	
	@GetMapping("/getDepartments/{idLocation1}/{idDepartment}")
	public ResponseEntity<List<Departments>> departamentwithFilterField(@PathVariable(value = "idLocation1")Long idLocation, @PathVariable(value = "idDepartment")Integer nombreDepartamento) throws ResourceNotFoundException{
//		public ResponseEntity<List<DepartmentsResponse>> departamentwithFilterField(@PathVariable(value = "idLocation1")Long idLocation, @PathVariable(value = "idDepartment")Integer nombreDepartamento) throws ResourceNotFoundException{
	
	
		List<Departments> department = departmentRepository.findByIdDepartamentoAndIdLocacion(idLocation, nombreDepartamento);
//		Optional<List<Departments>> department = Optional.ofNullable(departmentRepository.findByIdDepartamnetoAndIdLocacion(idLocation, nombreDepartamento));
//		Optional<List<Departments>> department = Optional.ofNullable(departmentRepository.findByIdDepartamnetoAndIdLocacion(idLocation, nombreDepartamento));
//		Optional<List<Departments>> department = Optional.ofNullable(departmentRepository.findByCodDepart(idLocation, nombreDepartamento));
//		Optional<List<Departments>> department = Optional.ofNullable(departmentRepository.findByIdLocacionAndIdDepartamento(idLocation, nombreDepartamento));
		
		
//		departmentRepository.findByIdDepartamentoAndIdLocacion(idLocation, nombreDepartamento).stream().forEach(e -> System.out.print(e.getNombreDepartamento()));;
//		List<Departments> objLista = new ArrayList<>();
//		List<DepartmentsResponse> objListResponse  = new ArrayList<DepartmentsResponse>();
//		 departmentRepository.findByIdDepartamentoAndIdLocacion(idLocation, nombreDepartamento).stream().forEach(t -> 
////		 departmentRepository.findByCodDepart(idLocation, nombreDepartamento).stream().forEach(t -> 
////		 departmentRepository.findByIdLocacionAndIdDepartamento(idLocation, nombreDepartamento).stream().forEach(t -> 
//		 {
////			 DepartmentsResponse objDepart = new DepartmentsResponse();
////			 objDepart.setIdDepartamento(String.valueOf(t.getIdDepartamento()));
////			 objDepart.setNomDepartmeno(t.getNombreDepartamento());
////			 objDepart.setUbicacion(String.valueOf(t.getIdLocacion()));
////			 objListResponse.add(objDepart);
//			 
//			 DepartmentsResponse objDepart = new DepartmentsResponse();
//			 objDepart.setIdDepartamento(String.valueOf(t.getIdDepartamento()));
////			 objDepart.setNomDepartmeno(t.getNombreDepartamento());
//			 objDepart.setNomDepartmeno(t.getNombreDepartamento());
//			 objDepart.setUbicacion(String.valueOf(t.getIdLocacion()));
//			 objListResponse.add(objDepart);
//			 
//		 });
//		
//		objListResponse.stream()
////		.filter(x -> x.getNomDepartmeno().equalsIgnoreCase("Test"))
//		.forEach((e ) -> System.out.println(e.getUbicacion()+" " + e.getIdDepartamento()+ " "+ e.getNomDepartmeno()));
//		objListResponse.stream().forEach((e ) -> System.out.println(e.getUbicacion()+" " + e.getIdDepartamento()+ " "+ e.getUbicacion()));
//		objListResponse.stream().forEach((e ) -> System.out.println(e.getUbicacion()+" " + e.getIdDepartamento()+ " "+ e.getUbicacion()));
		 
//		for (int i = 0; i < objLista.size(); i++) {
//			System.out.println(objLista.get(i).getNombreDepartamento());
//		}
//		
//		
//		int size = department.get().size();
//		for (int i = 0; i < size; i++) {
//			System.out.println(department.get().get(i));
//		}
		
//		List<DepartmentsResponse> listDept = new ArrayList<>();
//		  department.get()
//		  .forEach(e -> System.out.println(e.getNombreDepartamento()));
		
//		for (Departments departmentsResp : department.get()) {
//			listDept.add(new DepartmentsResponse(String.valueOf(departmentsResp.getIdDepartamento()),departmentsResp.getNombreDepartamento(), String.valueOf(departmentsResp.getIdLocacion())));
//			 
//		}
		
		 
		
//		 department.get().stream().map(t -> 
//		new DepartmentsResponse(String.valueOf(t.getIdDepartamento()), t.getNombreDepartamento(), String.valueOf(t.getIdLocacion())))
//			 .forEach(t -> listDept.add(t));
		
		return ResponseEntity.ok(department);
//		return ResponseEntity.ok(listDept);
		//		flatMap(dept -> new DepartmentsResponse(dept., nomDepartmeno, ubicacion))
//		return ResponseEntity.ok((department.get()));
//		System.err.println("tamano de archivo : "+department.get().size());
//		DepartmentsResponse response = new  DepartmentsResponse();
//		Field[]   DeclaredFields= department.get().getClass().getDeclaredFields();
//	
////		for (Field field : DeclaredFields) {
////			System.err.println(" fields "  + field.getName().toString().getClass().getName());
////			
////		}
//		
//		
//		Map<String, String> diccionario2 = department.get().stream().filter( map -> map.getClass().getDeclaredFields().getClass().getName().indexOf("id")>=1)
//				.collect(Collectors.toMap(map -> map.getClass().getDeclaredFields().getClass().getName(), Departments::getNombreDepartamento ));
//		
//		
//		diccionario2.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
//		
//		Map<Long, String> diccionario = department.get().stream().collect(Collectors.toMap(Departments::getIdDepartamento, Departments::getNombreDepartamento));
//		
//		System.err.println("tamano de archivo Mapa : "+ diccionario.size());
//		
////		Map<String, String> diccionario = new HashMap<>();
////		diccionario.put("idDepartamento", String.valueOf((department.get().get(0).getIdDepartamento())));
////		diccionario.put("idLocacion", String.valueOf((department.get().get(0).getIdLocacion())));
//////		diccionario.put("idLocacion", 1);
////		diccionario.put("nombreDepartamento", department.get().get(0).getNombreDepartamento());
//////		diccionario.put("nombreDepartamento", 2);
//		
//		   
//		if(department.isPresent()) {
//			
//			diccionario.forEach(
//				          (k, v) -> {
//				              // yes, we can put logic here
//				              if (k != null){
//				                  System.out.println("Key : " + k + ", Value : " + v);
//				              }
//				          }
//				      );
//			
//		
////			Map<Long, String>  result= diccionario.entrySet()
////					   .stream()
////					   .filter(map-> nombreDepartamento.equals(map.getValue()))
////					   .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
////			
//			
//			String valor = diccionario.entrySet()
//					   .stream()
//					   .filter(map-> nombreDepartamento.equals(String.valueOf(map.getKey())))
//					   .map(map -> map.getValue())
//					   .sorted()
//					   .collect(Collectors.joining());
//			
//		
//		
//			System.out.println("Obteniendo valor de llave"+ valor);
////		String valorfiltrado = (String) result.get(0);
//			
////		System.out.println("valor filtrado : " + valorfiltrado);
////			System.out.println("tamaño de arreglo filtrado"+result.size());
//			
//			
//			
////			response.setIdDepartamento(String.valueOf(llave));
//			response.setNomDepartmeno(valor);
//		}
//		
//		return ResponseEntity.ok(response);
		
	}
	
	
	@GetMapping("/getDepartmentDinamic/{idDepartment}/{nombreDepartamento}")
	public ResponseEntity<DepartmentsResponse> departamentDinamic(@PathVariable(value = "idDepartment")Long departmentid, @PathVariable(value = "nombreDepartamento")String nombreDepartamento) 
			throws ResourceNotFoundException
	{
		Optional<String> department =  Optional.ofNullable(departmentRepository.getidLocation(departmentid, nombreDepartamento));
		DepartmentsResponse response = new  DepartmentsResponse();
		if(department.isPresent()) {
			response.setNomDepartmeno(department.get());
		}
		
		return ResponseEntity.ok(response);
		
		
	}

}



