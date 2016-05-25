package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ConsultarPrestamo {
	BaseDeDatos conetar = new BaseDeDatos();
	Connection conexion = conetar.conexion();
	String sql="";
	String criterioDeBusqueda;
	ResultSetMetaData metaDatos;
	Vector<Vector<String>> datosDeFilas = new Vector<Vector<String>>();
	Vector<String> nombreColumnas = new Vector<String>();
	ResultSet resultado;
	int cantidadColumnas;
	
	public ConsultarPrestamo(int buscarPor, String informacionBuscar) throws SQLException{
		if(0 == buscarPor){
			criterioDeBusqueda = "id";
		}else if (1 == buscarPor) {
			criterioDeBusqueda = "id_bibliotecario";
		}else if(2 == buscarPor){
			criterioDeBusqueda = "id_libro";
		}else{
			criterioDeBusqueda = "id_lector";
		}
		
		
		
		sql = "SELECT * FROM prestamo WHERE "+criterioDeBusqueda+" = '"+informacionBuscar+"'";
		
			Statement sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(sql);
			
			if(resultado.next())
			{
			     metaDatos = resultado.getMetaData();
			}else
			 {
					throw new SQLException("No tiene datos");
			 }
	}
	
	public Vector<String> obtenerNombreDeColumnas() throws SQLException{
		
		
		
		cantidadColumnas = metaDatos.getColumnCount();
		for(int i =1; i <= cantidadColumnas; i++)
		{
			 nombreColumnas.add(metaDatos.getColumnName(i));
		}
				
	
	return nombreColumnas;
}

public Vector<Vector<String>> obtenerDatosFilas() throws SQLException{
	
		resultado.beforeFirst();
		while(resultado.next())
		{
			Vector<String> temporal = new Vector<>();
			datosDeFilas.add(temporal);
			for(int i = 1; i<= cantidadColumnas;i++ )
			{
			  temporal.add(resultado.getObject(i).toString());
			}
		}
	
	return datosDeFilas;
}

}