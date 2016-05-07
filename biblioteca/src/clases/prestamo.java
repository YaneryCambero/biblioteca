package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.xml.ws.FaultAction;

public class prestamo {	
	conectar conexion = new conectar();
	Connection conectado = conexion.conexion();
	String sql="";
	String criterioDeBusqueda;
	ResultSetMetaData metaDatos;
	ResultSet resultado;
	int cantidadColumnas;
	boolean control = false;
	
	public boolean buscarLector(String codigo) throws SQLException{
		sql = "SELECT * FROM lector WHERE id = '"+codigo+"'";
		
		Statement sentencia = conectado.createStatement();
		resultado = sentencia.executeQuery(sql);
		
		if(resultado.next())
		{
		     metaDatos = resultado.getMetaData();
		     control = true;
		}else
		 {
				throw new SQLException("no tenia datos");
		 }
		
		return control;
	}

	public ResultSet obtenerDatosFilas() throws SQLException{
	
		return resultado;
	}

}
