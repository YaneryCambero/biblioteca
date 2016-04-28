package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;


public class bibliotecario {
	conectar conexion = new conectar();
	Connection conectado = conexion.conexion();
	String sql="";
	String criterioDeBusqueda;
	ResultSetMetaData metaDatos;
	Vector<Vector<String>> datosDeFilas = new Vector<Vector<String>>();
	Vector<String> nombreColumnas = new Vector<String>();
	ResultSet resultado;
	int cantidadColumnas;
	
	public bibliotecario(String nombre, String apellido, String calle,String sector, String ciudad, String fechaNacimiento, String email, String telefono, String fechaIngreso, String cedula, int categoria) throws SQLException{
		sql = "SELECT * FROM bibliotecario where nombre ='"+nombre+"' AND apellido = '"+apellido+"'";
		
						
				Statement sentencia = conectado.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(!resultado.next())
				{
					sql = "INSERT into login (nombre, apellido, calle, sector, ciudad, FechaNacimiento, email, telefono, fechaIngreso, cedula, categoria) "
							+ "VALUES ('"+nombre+"', '"+apellido+"', '"+calle+"', '"+sector+"', "+ciudad+"', "+fechaNacimiento+"', '"+email+"', '"+telefono+"', '"+fechaIngreso+"', '"+cedula+"', '"+categoria+"'";
						
						Statement sentencia1 = conectado.createStatement();
						sentencia1.executeUpdate(sql);
						
						JOptionPane.showMessageDialog(null, "Creacion Exitoso");
						
				}else{
					JOptionPane.showMessageDialog(null, "Bibliotecario registrado");
				}	
					
	}

}
