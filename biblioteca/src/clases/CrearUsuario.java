package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CrearUsuario
{
	BaseDeDatos conexion = new BaseDeDatos();
	Connection conectado = conexion.conexion();
	String sql="";
	
	public CrearUsuario(String usuario, String contrasena, String confirmarContrasena, boolean permisos)
	{
		sql = "SELECT * FROM login where usuario ='"+usuario+"'";
		
		try {
						
				Statement sentencia = conectado.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(!resultado.next())
				{
					if(contrasena.equals(confirmarContrasena)){
						sql = "INSERT into login (usuario, contrasena, permiso) VALUES ('"+usuario+"', '"+contrasena+"', '"+permisos+"')";
						
						Statement sentencia1 = conectado.createStatement();
						sentencia1.executeUpdate(sql);
						
						JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
						
						
					}else
					 {
						JOptionPane.showMessageDialog(null, "Contrasena no concuerdan");
					 }
				}else
				 {
					JOptionPane.showMessageDialog(null, " Este usuario ya esta registrado");
				 }
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
