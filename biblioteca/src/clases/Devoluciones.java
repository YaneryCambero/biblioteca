package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Devoluciones {
	
	private ResultSet resultado;
	private Statement sentencia;
	
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	
	public void buscarDatos(int criterioBusqueda, String busqueda) throws SQLException{
		if(criterioBusqueda == 0){
			sql = "SELECT * FROM prestamo WHERE fecha = '"+busqueda+"'"; 
		}else if(criterioBusqueda == 1){
			sql = "SELECT * FROM prestamo WHERE id = '"+busqueda+"'";
		}else{
			JOptionPane.showConfirmDialog(null, "verifique los datos....","Datos no encontrado",JOptionPane.DEFAULT_OPTION);
		}
		
		sentencia = conexion.createStatement();
		resultado = sentencia.executeQuery(sql);
		
		if(!resultado.next())
		{
			throw new SQLException();
				
		}	
	}
	
	public ResultSet obtenerDatos(){
		try {
			resultado.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
