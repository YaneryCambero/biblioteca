package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class EstadoSistema {
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	ResultSetMetaData metaDatos;
	ResultSet resultado;
	int CantidadFilas = 0;
	
	public int mostrarLector(){ 
		sql = "SELECT * FROM lector";
		
		
		Statement sentencia;
		try {
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(sql);
			
			if(resultado.next()){ 
				CantidadFilas = resultado.getRow();
			}
		} catch (SQLException e) {
		  
		}
		
		
		return CantidadFilas;
		
	}
	
	public int mostrarLibros(){ 
		sql = "SELECT * FROM libros";
		Statement sentencia;
		try {
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(sql);
			
			if(resultado.next()){ 
				CantidadFilas = resultado.getRow();
			}
		} catch (SQLException e) {
		  
		}

		return CantidadFilas;
	}
		public int mostrarLibrosPrestados(){ 
			sql = "SELECT * FROM prestamo";
			
			
			Statement sentencia;
			try {
				sentencia = conexion.createStatement();
				resultado = sentencia.executeQuery(sql);
				
				if(resultado.next()){ 
					CantidadFilas = resultado.getRow();
				}
			} catch (SQLException e) {
			  
			}
			
			
			return CantidadFilas;
			
		}
		public int mostrarLibrosEnRecepccion(){
			
			return (mostrarLibros() - mostrarLibrosPrestados());
		}
		
		
}
