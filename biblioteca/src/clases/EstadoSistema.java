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
	
	public int mostrarLector(){ 
		int CantidadLectores = 0;
		sql = "SELECT COUNT(id) FROM lector";
		
		
		Statement sentencia;
		try {
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(sql);
			
			if(resultado.next()){ 
				CantidadLectores = resultado.getInt(1);
			}
		} catch (SQLException e) {
		  CantidadLectores = 0;
		}
		
		
		return CantidadLectores;
		
	}
	
	public int mostrarLibros(){ 
		int CantidadLibros = 0;
		String sql1 = "SELECT COUNT(id) FROM libros";
		Statement sentencia;
		try {
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(sql1);
			
			if(resultado.next()){ 
				CantidadLibros = resultado.getInt(1);
			}
			
		} catch (SQLException e) {
		  CantidadLibros = 0;
		}

		return CantidadLibros;
	}
		public int mostrarLibrosPrestados(){ 
			int CantidadLibrosPrestado = 0;
			sql = "SELECT COUNT(id) FROM prestamo";
			
			
			Statement sentencia;
			try {
				sentencia = conexion.createStatement();
				resultado = sentencia.executeQuery(sql);
				
				if(resultado.next()){ 
					CantidadLibrosPrestado = resultado.getInt(1);
				}
			} catch (SQLException e) {
			  CantidadLibrosPrestado = 0;
			}
			
			
			return CantidadLibrosPrestado;
			
		}
		public int mostrarLibrosEnRecepccion(){
			
			int librosRecepcion = mostrarLibros() - mostrarLibrosPrestados();
			
			return (librosRecepcion);
		}
		
		
}
