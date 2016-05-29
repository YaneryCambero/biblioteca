package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CambiarContrasena
{
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	
	public CambiarContrasena(String usuario, String contrasena, String nuevaContrasena, String confirmarContrasena) throws SQLException
	{
        sql = "SELECT * FROM login where usuario ='"+usuario+"' and contrasena ='"+contrasena+"'";
		
				
				Statement sentencia = conexion.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(resultado.next())
				{
					if(nuevaContrasena.equals(confirmarContrasena)){
						sql = "UPDATE login SET contrasena ='"+nuevaContrasena+"' where id ='"+resultado.getObject("id")+"'";
						
						Statement sentencia1 = conexion.createStatement();
						sentencia1.executeUpdate(sql);
						
						
						
						
					}else
					 {
						throw new SQLException("verifique las contrasena");
					 }
				}else
				 {
					throw new SQLException("verifique los datos subministrados");
				 }
			
		
	}

}
