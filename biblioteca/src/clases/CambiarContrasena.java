package clases;

import java.awt.Dialog.ModalityType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;

import formularios.FrmCambiarContrasena;


public class CambiarContrasena
{
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	
	public CambiarContrasena(String usuario, String contrasena, String nuevaContrasena, String confirmarContrasena)
	{
        sql = "SELECT * FROM login where usuario ='"+usuario+"' and contrasena ='"+contrasena+"'";
		
		try {
						
				Statement sentencia = conexion.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(resultado.next())
				{
					if(nuevaContrasena.equals(confirmarContrasena)){
						sql = "UPDATE login SET contrasena ='"+nuevaContrasena+"' where id ='"+resultado.getObject("id")+"'";
						
						Statement sentencia1 = conexion.createStatement();
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
