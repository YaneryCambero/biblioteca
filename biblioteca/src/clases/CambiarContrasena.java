package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class CambiarContrasena
{
	BaseDeDatos conexion = new BaseDeDatos();
	Connection conectado = conexion.conexion();
	String sql="";
	
	public CambiarContrasena(String usuario, String contrasena, String nuevaContrasena, String confirmarContrasena)
	{
        sql = "SELECT * FROM login where usuario ='"+usuario+"' and contrasena ='"+contrasena+"'";
		
		try {
						
				Statement sentencia = conectado.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(resultado.next())
				{
					if(nuevaContrasena.equals(confirmarContrasena)){
						sql = "UPDATE login SET contrasena ='"+nuevaContrasena+"' where id ='"+resultado.getObject("id")+"'";
						
						Statement sentencia1 = conectado.createStatement();
						sentencia1.executeUpdate(sql);
						
						JOptionPane.showMessageDialog(null, "Cambio Exitoso");
						
						
					}else
					 {
						JOptionPane.showMessageDialog(null, "contrasena no concuerdan");
					 }
				}else
				 {
					JOptionPane.showMessageDialog(null, "usuario y contrasena no encontrado");
				 }
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
