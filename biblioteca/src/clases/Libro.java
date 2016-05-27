package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Libro {
	BaseDeDatos conectar = new BaseDeDatos();
	Connection conexion = conectar.conexion();
	String sql="";
	int id;
	ResultSet resultadoAutores;
	
	public Libro(String titulo, String autor, String editor, String genero, String subGenero, String idioma, int estado, String categoria, String publicacion, String editorial, int numeroPagina, String estadoFisico, int cantidad, String edicion ) throws SQLException{
		sql = "SELECT id, nombre, apellido FROM autor";
		
		
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery(sql);
		
		if(resultado.next()){
			if(String.format("%s %s", resultado.getString(2), resultado.getString(3)).equals(autor)){
				id = resultado.getInt(1);
			}
		}else{
			throw new SQLException("autor no encontrado");
		}
		
		
		sql = "SELECT * FROM libros where titulo ='"+titulo+"' AND id_autor ='"+id+"'";
		
		resultado = sentencia.executeQuery(sql);
		
		if(!resultado.next())
		{
			String sql1 = "INSERT INTO libros (titulo, id_autor, editor, genero, subgenero, idioma, id_estado, categoria, publicacion, editorial, numeroPagina, estadoFisico, cantidad, edicion) VALUES ('"+titulo+"','"+id+"','"+editor+"','"+genero+"','"+subGenero+"','"+idioma+"','"+estado+"','"+categoria+"','"+publicacion+"','"+editorial+"','"+numeroPagina+"','"+estadoFisico+"','"+cantidad+"','"+edicion+"')";
				
				PreparedStatement sentencia1 = conexion.prepareStatement(sql1);
				sentencia1.executeUpdate();
				
				JOptionPane.showConfirmDialog(null, "Datos Guardados Correctamente","Confirmacion de guardado",JOptionPane.DEFAULT_OPTION);
				
		}else{
			JOptionPane.showConfirmDialog(null, "El libro existe........ favor verificar","Confirmacion libro existe", JOptionPane.DEFAULT_OPTION);
		} 	
	}
	
	public Libro() throws SQLException{
        sql = "SELECT nombre, apellido FROM autor";
		
		Statement sentencia = conexion.createStatement();
	    resultadoAutores = sentencia.executeQuery(sql);
	}
	
	public ResultSet mostrarAutor()throws SQLException{
		
		if(!resultadoAutores.next()){
			
			throw new SQLException("Autor no encontrado");
		}
		
		return resultadoAutores;
		
	}

}
