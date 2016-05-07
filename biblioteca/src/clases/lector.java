package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class lector {
	conectar conexion = new conectar();
	Connection conectado = conexion.conexion();
	String sql="";
	
	public lector(String nombre, String apellido, String cedula, String fechaNacimiento, String telefono,  String calle ,String sector, String ciudad, String email, int categoria ) throws SQLException{
		sql = "SELECT * FROM lector where nombre ='"+nombre+"' AND apellido = '"+apellido+"'";
		
						
				Statement sentencia = conectado.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(!resultado.next())
				{
					sql = "INSERT into lector (nombre, apellido, FechaNacimiento, telefono, categoria, cedula, email, calle, sector, ciudad) "
							+ "VALUES ('"+nombre+"', '"+apellido+"','"+fechaNacimiento+"',"+telefono+"', '"+categoria+"',"+cedula+"', '"+email+"', "+calle+"', '"+sector+"', '"+ciudad+"')";
						
						Statement sentencia1 = conectado.createStatement();
						sentencia1.executeUpdate(sql);
						
						JOptionPane.showMessageDialog(null, "Creacion Exitoso");
						
				}else{
					JOptionPane.showMessageDialog(null, "Lector existe........ favor verificar");
				}	
					
	}

}
