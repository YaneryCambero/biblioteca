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
		sql = "SELECT * FROM lector";
		
		
		Statement sentencia;
		try {
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(sql);
			
			if(resultado.next()){ 
				CantidadLectores = resultado.getRow();
			}
		} catch (SQLException e) {
		  CantidadLectores = 0;
		}
		
		
		return CantidadLectores;
		
	}
	
	public int mostrarLibros(){ 
		int CantidadLibros = 0;
		sql = "SELECT * FROM libros";
		Statement sentencia;
		try {
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(sql);
			
			if(resultado.next()){ 
				CantidadLibros = resultado.getRow();
			}
		} catch (SQLException e) {
		  CantidadLibros = 0;
		}

		return CantidadLibros;
	}
		public int mostrarLibrosPrestados(){ 
			int CantidadLibrosPrestado = 0;
			sql = "SELECT * FROM prestamo";
			
			
			Statement sentencia;
			try {
				sentencia = conexion.createStatement();
				resultado = sentencia.executeQuery(sql);
				
				if(resultado.next()){ 
					CantidadLibrosPrestado = resultado.getRow();
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
