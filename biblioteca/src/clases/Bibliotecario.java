package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;


public class Bibliotecario {
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	
	public Bibliotecario(String nombre, String apellido, String calle,String sector, String ciudad, String fechaNacimiento, String email, String telefono, String fechaIngreso, String cedula, int tanda) throws SQLException{
		sql = "SELECT * FROM bibliotecario where nombre ='"+nombre+"' AND apellido = '"+apellido+"'";
		
						
				Statement sentencia = conexion.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(!resultado.next())
				{
					sql = "INSERT into bibliotecario (nombre, apellido, FechaNacimiento, email, telefono, fechaIngreso, cedula, tanda, calle, sector, ciudad) "
							+ "VALUES ('"+nombre+"', '"+apellido+"', '"+fechaNacimiento+"', '"+email+"', "+telefono+"', "+fechaIngreso+"', '"+cedula+"', '"+tanda+"', '"+calle+"', '"+sector+"', '"+ciudad+"')";
						
						Statement sentencia1 = conexion.createStatement();
						sentencia1.executeUpdate(sql);
						
						JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
						
				}else{
					JOptionPane.showMessageDialog(null, "Bibliotecario existe....... favor de verificar");
				}	
					
	}

}
