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
	String criterioDeBusqueda;
	ResultSetMetaData metaDatos;
	Vector<Vector<String>> datosDeFilas = new Vector<Vector<String>>();
	Vector<String> nombreColumnas = new Vector<String>();
	ResultSet resultado;
	int cantidadColumnas;
	
	public lector(String nombre, String apellido, String cedula, String fechaNacimiento, String telefono,  String calle ,String sector, String ciudad, String email, int categoria ) throws SQLException{
		sql = "SELECT * FROM lector where nombre ='"+nombre+"' AND apellido = '"+apellido+"'";
		
						
				Statement sentencia = conectado.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
				
				if(!resultado.next())
				{
					sql = "INSERT into lector (nombre, apellido, cedula, FechaNacimiento, telefono, calle, sector, ciudad, email, categoria) "
							+ "VALUES ('"+nombre+"', '"+apellido+"','"+cedula+"',"+fechaNacimiento+"', '"+telefono+"',"+calle+"', '"+sector+"', "+ciudad+"', '"+email+"', '"+categoria+"'";
						
						Statement sentencia1 = conectado.createStatement();
						sentencia1.executeUpdate(sql);
						
						JOptionPane.showMessageDialog(null, "Creacion Exitoso");
						
				}else{
					JOptionPane.showMessageDialog(null, "Lector registrado");
				}	
					
	}

}
