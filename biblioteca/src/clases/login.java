package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import formularios.FrmLogin;
import formularios.FrmPrincipal;

public class login 
{
	conectar conexion = new conectar();
	Connection conectado = conexion.conexion();
	String sql="";
	
	public login(String usu, String pass)
	{
		sql = "SELECT * FROM login where usuario ='"+usu+"' and contrasena ='"+pass+"'";
		
		try {
						
				Statement sentencia = conectado.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(resultado.next())
				{
					FrmPrincipal principal = new FrmPrincipal();
					principal.setVisible(true);
				}else
				 {
					JOptionPane.showMessageDialog(null, "usuario no encontrado");
					FrmLogin login = new FrmLogin();
					login.setVisible(true);
				 }
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
