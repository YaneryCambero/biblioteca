package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;


public class libro {
	conectar conexion = new conectar();
	Connection conectado = conexion.conexion();
	String sql="";
	int id;
	
	public libro(String titulo, String autor, String editor, String genero, String subGenero, String idioma, int estado, String categoria, String publicacion, String editorial, int numeroPagina, String estadoFisico, int cantidad, String edicion ) throws SQLException{
		sql = "SELECT id FROM autor where nombre ='"+autor+"'";
		
		
		Statement sentencia = conectado.createStatement();
		ResultSet resultado = sentencia.executeQuery(sql);
		
		if(resultado.next()){
			id = Integer.parseInt(resultado.getObject(1).toString());
		}else{
			throw new SQLException("autor no encontrado");
		}
		
		
		sql = "SELECT * FROM libros where titulo ='"+titulo+"' AND id_autor ='"+id+"'";
		
		resultado = sentencia.executeQuery(sql);
		
		if(!resultado.next())
		{
			String sql1 = "INSERT INTO libros (titulo, id_autor, editor, genero, subgenero, idioma, id_estado, categoria, publicacion, editorial, numeroPagina, estadoFisico, cantidad, edicion) VALUES ('"+titulo+"','"+id+"','"+editor+"','"+genero+"','"+subGenero+"','"+idioma+"','"+estado+"','"+categoria+"','"+publicacion+"','"+editorial+"','"+numeroPagina+"','"+estadoFisico+"','"+cantidad+"','"+edicion+"')";
				
				PreparedStatement sentencia1 = conectado.prepareStatement(sql1);
				sentencia1.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Creacion Exitoso");
				
		}else{
			JOptionPane.showMessageDialog(null, "libro existe........ favor verificar");
		} 	
	}

}
