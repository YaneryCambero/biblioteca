package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BaseDeDatos 
{
	Connection conexion = null;
	
	public Connection conexion()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/biblioteca","root","1234");
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Error de conexion");
		}
		
		return conexion;
	}
}
