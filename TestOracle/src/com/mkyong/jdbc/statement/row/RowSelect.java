package com.mkyong.jdbc.statement.row;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mkyong.jdbc.statement.row.bean.Poliza;

public class RowSelect {

	
	public static void main(String[] args) {
		
		String sql = "SELECT * FROM Poliza_Pc_Test";
		
		long duracion = System.currentTimeMillis();
		
		   try (Connection conn = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521:XE", "system", "weblogic123");

				   
				   Statement statement = conn.createStatement()) {

	            ResultSet resultSet = statement.executeQuery(sql);
	            ResultSetMetaData rsmd = resultSet.getMetaData();
	            List<String> columns = new ArrayList<String>(rsmd.getColumnCount());
	            for(int i = 1; i <= rsmd.getColumnCount(); i++){
	                columns.add(rsmd.getColumnName(i));
	            }
	            
	            List<Map<String,String>> data = new ArrayList<Map<String,String>>();
	            
	            while (resultSet.next()) {
	            	        Map<String,String> row = new HashMap<String, String>(columns.size());
	            	        for(String col : columns) {
	            	            row.put(col, resultSet.getString(col));
	            	           
//	            	            row.get(resultSet.getString(col));
	            	            	
	            	        }
	            	        data.add(row);
	            	        
//	            	    System.out.println(data);
	            	
/*
	                String fechaInicio = resultSet.getString("FECINIVIG");
	                String fechaFin	  = resultSet.getString("FECFINVIG");
	                String fechaRegistro	  = resultSet.getString	("FECREG");
	                String fechaModificacion	  = resultSet.getString	("FECMOD");
	                String fechaCotizacion	  = resultSet.getString("FECCOT");
	                BigDecimal tasa = resultSet.getBigDecimal("TASA");
	                BigDecimal primaPoliza = resultSet.getBigDecimal("PRIMAPOLTRANSAC");
	                //char indfact = resultSet.getString("INDFACT").charAt(0);
	                	String indfact =  resultSet.getString("INDFACT");
	                System.out.println(indfact);
//	                Poliza obj = new Poliza();
//	                // 1377
//	             //   obj.setFECFINVIG(fechaInicio);
//	                obj.setFECFINVIG(fechaFin);
//	                obj.setFECREG(fechaRegistro.toLocalDateTime());
//	                obj.setFECMOD(fechaModificacion.toLocalDateTime());
//	                obj.setTASA(tasa);
//	                // Timestamp -> LocalDateTime
//	              
//	                obj.setPRIMAPOLTRANSAC(primaPoliza);

//	                System.out.println(obj);
 * 
 * */

	            }
		   } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		   
		   System.out.println(System.currentTimeMillis() - duracion);

    }
}	            
