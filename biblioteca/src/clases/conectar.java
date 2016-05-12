package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conectar 
{
	Connection con = null;
	
	public Connection conexion()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","");
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "error de conexion");
		}
		
		return con;
	}
}
