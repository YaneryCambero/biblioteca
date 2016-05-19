package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;
import javax.xml.ws.FaultAction;

public class Prestamo {	
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	ResultSetMetaData metaDatos;
	ResultSet resultado;
	boolean control = false;
	
	public boolean buscarLector(String codigo) throws SQLException{
		sql = "SELECT * FROM lector WHERE id = '"+codigo+"'";
		
		Statement sentencia = conexion.createStatement();
		resultado = sentencia.executeQuery(sql);
		
		if(resultado.next())
		{
		     control = true;
		}else
		 {
				JOptionPane.showMessageDialog(null, "No hay datos");
		 }
		
		return control;
	}

	public ResultSet obtenerDatosFilas() throws SQLException{
	
		return resultado;
	}

}
