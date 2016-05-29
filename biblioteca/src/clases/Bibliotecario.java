package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Bibliotecario {
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	
	public Bibliotecario(String nombre, String apellido, String calle,String sector, String ciudad, String fechaNacimiento, String email, String telefono, String fechaIngreso, String cedula, String tanda) throws SQLException{
		sql = "SELECT * FROM bibliotecario where nombre = '"+nombre+"' AND apellido = '"+apellido+"'";
		
						
				Statement sentencia = conexion.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(!resultado.next())
				{
					
				        String sql1 = "INSERT INTO bibliotecario (nombre, apellido, FechaNacimiento, email, telefono, fechaIngreso, cedula, tanda, calle, sector, ciudad) VALUES ('"+nombre+"', '"+apellido+"', '"+fechaNacimiento+"', '"+email+"', '"+telefono+"', '"+fechaIngreso+"', '"+cedula+"', '"+tanda+"', '"+calle+"', '"+sector+"', '"+ciudad+"')";
						
				        PreparedStatement sentencia1 = conexion.prepareStatement(sql1);
						sentencia1.executeUpdate();
						
						
						
						
				}else{
					throw new SQLException("Bibliotecario existe....... favor de verificar");
				}	
					
	}

}
