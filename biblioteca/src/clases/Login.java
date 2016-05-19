package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import formularios.FrmLogin;
import formularios.FrmPrincipal;

public class Login 
{
	BaseDeDatos conexion = new BaseDeDatos();
	Connection conectado = conexion.conexion();
	String sql="";
	
	public Login(String usuario, String contrsena)
	{
		sql = "SELECT * FROM login where usuario ='"+usuario+"' and contrasena ='"+contrsena+"'";
		
		try {
						
				Statement sentencia = conectado.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(resultado.next())
				{
					FrmPrincipal principal = new FrmPrincipal();
					principal.setVisible(true);
				}else
				 {
					JOptionPane.showMessageDialog(null, "Usuario no encontrado");
					FrmLogin login = new FrmLogin();
					login.setLocationRelativeTo(null);
					login.setVisible(true);
				 }
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
