package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Devolucion {
	private ResultSet resultado;
	private Statement sentencia;
	
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	
	public void mostrarDevolucion(String buscar) throws SQLException{
		
		sql = "select prestamo.id, fecha, horaPrestamo, horaEntrega, estado.condicion, concat(bibliotecario.nombre,' ',bibliotecario.apellido) as Nombre_Bibliotecario, libros.titulo, concat(lector.nombre,' ', lector.apellido) as Nombre_Lector ";
	    sql += "from prestamo, estado, bibliotecario, libros, lector "; 
		sql += "where prestamo.estado = estado.id ";
	    sql += "and prestamo.id_bibliotecario = bibliotecario.id "; 
		sql += "and prestamo.id_libro = libros.id ";
		sql += "and prestamo.id_lector = lector.id ";
		sql += "and prestamo.id_bibliotecario = "+buscar+" ";
		sql += "and prestamo.estado = 1";
		
		
		sentencia = conexion.createStatement();
		resultado = sentencia.executeQuery(sql);
		
		if(!resultado.next())
		{
			throw new SQLException("Datos no encontrados.....");
				
		}	
	}
	
	public ResultSet obtenerDatos(){
		try {
			resultado.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void guardarDatos(String codigoPrestamo) throws SQLException{
		sql = "UPDATE prestamo SET estado = '2' WHERE id = "+codigoPrestamo;
		
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new SQLException("Error sintaxis");
			
		}
		
		sql ="UPDATE libros SET cantidad = cantidad + 1 WHERE libros.id = (SELECT id_libro FROM prestamo WHERE id = "+codigoPrestamo+")";
		
		try {
			ps = conexion.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new SQLException("Error sintaxis");
		}
	}

}
