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
	ResultSetMetaData metaDatos;
	boolean control = false;
	private ResultSet resultadoBuscarLector;
	private ResultSet resultadoBuscarLibros;
	
	public boolean buscarLector(String codigo) throws SQLException{
		String sqlBuscarLector = "SELECT * FROM lector WHERE id = '"+codigo+"'";
		
		Statement sentenciaBuscarLector = conexion.createStatement();
		resultadoBuscarLector = sentenciaBuscarLector.executeQuery(sqlBuscarLector);
		
		if(resultadoBuscarLector.next())
		{
		     control = true;
		}else
		 {
			 JOptionPane.showConfirmDialog(null, "Lector no encontrado","No hay datos",JOptionPane.DEFAULT_OPTION);
		 }
		
		return control;
	}
	
	public boolean buscarLibros(String titulo) throws SQLException{
    String sqlBuscarLibros = "SELECT * FROM libros WHERE titulo like '"+ titulo +"%'";
		
		Statement sentenciaBuscarLibros = conexion.createStatement();
		resultadoBuscarLibros = sentenciaBuscarLibros.executeQuery(sqlBuscarLibros);
		
		if(resultadoBuscarLibros.next())
		{
			control = true;
		     
		}else{
			JOptionPane.showConfirmDialog(null, "Nombre no encontrado","No hay Datos",JOptionPane.DEFAULT_OPTION);
		}
		
		return control;
	}
	
	public ResultSet obtenerDatosLibros(){
		
		return resultadoBuscarLibros;
	}

	public ResultSet obtenerDatosLector(){
	
		return resultadoBuscarLector;
	}

}
