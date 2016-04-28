package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class libro {
	conectar conexion = new conectar();
	Connection conectado = conexion.conexion();
	String sql="";
	String criterioDeBusqueda;
	ResultSetMetaData metaDatos;
	Vector<Vector<String>> datosDeFilas = new Vector<Vector<String>>();
	Vector<String> nombreColumnas = new Vector<String>();
	ResultSet resultado;
	int cantidadColumnas;
	int id;
	
	public libro(String titulo, String autor, String editor, String genero, String subGenero, String idioma, String estado, String categoria, String publicacion, String editorial, int numeroPagina, String estadoFisico, int cantidad, String edicion ) throws SQLException{
		sql = "SELECT id FROM autor where nombre='"+autor+"'";
		
		
		Statement sentencia = conectado.createStatement();
		ResultSet resultado = sentencia.executeQuery(sql);
		
		if(resultado.getInt(1)>0){
			id = resultado.getInt(1);			
		}else{
			throw new SQLException("autor no encontrado");
		}
		
		
		sql = "SELECT * FROM libro where titulo ='"+titulo+"' AND autor ='"+id+"'";
		
		resultado = sentencia.executeQuery(sql);
		
		if(!resultado.next())
		{
			sql = "INSERT into libro (titulo, autor, editor, genero, subgenero, idioma, estado, categoria, publicacion, editorial, numeroPagina, estadoFisico, cantidad, edicion) "
					+ "VALUES ('"+titulo+"', '"+id+"', '"+edicion+"', '"+genero+"', '"+subGenero+"', '"+idioma+"', '"+estado+"', '"+categoria+"', '"+publicacion+"', '"+editorial+"', '"+numeroPagina+"', '"+estadoFisico+"', '"+cantidad+"', '"+edicion+"'";
				
				Statement sentencia1 = conectado.createStatement();
				sentencia1.executeUpdate(sql);
				
				JOptionPane.showMessageDialog(null, "Creacion Exitoso");
				
		}else{
			JOptionPane.showMessageDialog(null, "libro registrado");
		}	
	}

}
