package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private String sql;
	private int id;
	
	public void crearPrestamo(String fecha, String horaPrestamo, String horaEntrega, String estado, int id_bibliotecario, String titulo, int id_lector) throws SQLException{
		sql = "SELECT id FROM libros where titulo = '"+titulo+"'";
		
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery(sql);
		
		if(resultado.next()){
				id = resultado.getInt(1);
		}else{
			throw new SQLException("autor no encontrado");
		}
		
		sql ="SELECT * FROM libros where id_bibliotecario = '"+id_bibliotecario+"' AND id_libro = '"+id+"' AND id_lector = '"+id_lector+"'";
		
		Statement sentencia1 = conexion.createStatement();
		ResultSet resultado1 = sentencia1.executeQuery(sql);
		
		if(!resultado.next())
		{
			String sql1 = "INSERT INTO libros ( fecha, horaPrestamo, horaEntrega, estado, id_bibliotecario, id_libro, id_lector) VALUES ('"+fecha+"', '"+horaPrestamo+"', '"+horaEntrega+"', '"+estado+"', '"+id_bibliotecario+"', '"+id+"', '"+id_lector+"')";
				
				PreparedStatement sentencia2 = conexion.prepareStatement(sql1);
				sentencia2.executeUpdate();
				
				JOptionPane.showConfirmDialog(null, "Datos Guardados Correctamente","Confirmacion de guardado",JOptionPane.DEFAULT_OPTION);
				
		}else{
			JOptionPane.showConfirmDialog(null, "El Prestamo existe........ favor verificar","Confirmacion Prestamo existe", JOptionPane.DEFAULT_OPTION);
		} 	
	}
	
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
