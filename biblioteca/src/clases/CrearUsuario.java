package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearUsuario
{
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	
	public CrearUsuario (String usuario, String contrasena, String confirmarContrasena, boolean permisos) throws SQLException
	{
		sql = "SELECT * FROM login where usuario ='"+usuario+"'";
		
						
				Statement sentencia = conexion.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(!resultado.next())
				{
					if(contrasena.equals(confirmarContrasena)){
						sql = "INSERT into login (usuario, contrasena, permiso) VALUES ('"+usuario+"', '"+contrasena+"', '"+permisos+"')";
						
						Statement sentencia1 = conexion.createStatement();
						sentencia1.executeUpdate(sql);
						
					}else
					 {
						throw new SQLException("Contrasena no concuerdan");
					 }
				}else
				 {
					throw new SQLException("Este usuario ya esta registrado");
				 }
	}

}
