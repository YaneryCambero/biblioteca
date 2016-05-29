package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Autor {
	BaseDeDatos conexion = new BaseDeDatos();
	Connection conectado = conexion.conexion();
	String sql="";
	
	public Autor(String nombre, String apellido, String nacionalidad) throws SQLException{ 
		sql = "SELECT * FROM autor where nombre ='"+nombre+"' AND apellido = '"+apellido+"'";
		
		
		Statement sentencia = conectado.createStatement();
		ResultSet resultado = sentencia.executeQuery(sql);
		
		if(!resultado.next())
		{
			sql = "INSERT into autor (nombre, apellido, nacionalidad) "
					+ "VALUES ('"+nombre+"', '"+apellido+"', '"+nacionalidad+"')";
				
				Statement sentencia1 = conectado.createStatement();
				sentencia1.executeUpdate(sql);
				
				
				
		}else{
			throw new SQLException("Autor existe...... favor de verificar");
		}	
	}

}
