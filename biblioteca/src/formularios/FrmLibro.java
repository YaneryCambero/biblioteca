package formularios;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import clases.Libro;

@SuppressWarnings("serial")
public class FrmLibro extends JDialog {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtEditor;
	private JTextField txtPublicacion;
	private JTextField txtEditorial;
	private JTextField txtNumeroDePaginas;
	private JTextField txtCantidad;
	private JTextField txtEdicion;
	private ResultSet autor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLibro frame = new FrmLibro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrmLibro() {
		setTitle("Libros");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLibro.class.getResource("/imagenes/icono_dduv_libros.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibro = new JLabel("Registro de Libros");
		lblLibro.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblLibro.setBounds(205, 0, 187, 40);
		contentPane.add(lblLibro);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(68, 39, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutor.setBounds(68, 64, 46, 14);
		contentPane.add(lblAutor);
		
		JLabel lblEditor = new JLabel("Editor:");
		lblEditor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditor.setBounds(68, 89, 46, 14);
		contentPane.add(lblEditor);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setBounds(68, 114, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblSubgenero = new JLabel("SubGenero:");
		lblSubgenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubgenero.setBounds(38, 139, 76, 14);
		contentPane.add(lblSubgenero);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdioma.setBounds(52, 164, 62, 14);
		contentPane.add(lblIdioma);
		
		JLabel lblCondicionesFicicas = new JLabel("Condiciones fisicas:");
		lblCondicionesFicicas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCondicionesFicicas.setBounds(0, 189, 114, 14);
		contentPane.add(lblCondicionesFicicas);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(33, 216, 81, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblPublicacion = new JLabel("Publicacion:");
		lblPublicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPublicacion.setBounds(316, 89, 76, 14);
		contentPane.add(lblPublicacion);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditorial.setBounds(330, 114, 62, 14);
		contentPane.add(lblEditorial);
		
		JLabel lblNumeroDePaginas = new JLabel("Numero de paginas:");
		lblNumeroDePaginas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDePaginas.setBounds(268, 139, 124, 14);
		contentPane.add(lblNumeroDePaginas);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setBounds(327, 164, 65, 14);
		contentPane.add(lblCantidad);
		
		JLabel lblEdicion = new JLabel("Edicion:");
		lblEdicion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdicion.setBounds(343, 189, 49, 14);
		contentPane.add(lblEdicion);
		
		JComboBox cbxAutor = new JComboBox();
		cbxAutor.setBounds(124, 61, 167, 20);
		contentPane.add(cbxAutor);
		
		JComboBox cbxCategoria = new JComboBox();
		cbxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Estudiante", "Profesor"}));
		cbxCategoria.setBounds(124, 213, 124, 20);
		contentPane.add(cbxCategoria);
		
		JComboBox cbxCondicionesFisicas = new JComboBox();
		cbxCondicionesFisicas.setModel(new DefaultComboBoxModel(new String[] {"Excelente", "Regular", "Malo"}));
		cbxCondicionesFisicas.setBounds(124, 186, 124, 20);
		contentPane.add(cbxCondicionesFisicas);
		
		JComboBox cbxIdioma = new JComboBox();
		cbxIdioma.setModel(new DefaultComboBoxModel(new String[] {"Espa\u00F1ol", "Ingles", "Frances"}));
		cbxIdioma.setBounds(124, 161, 124, 20);
		contentPane.add(cbxIdioma);
		
		JComboBox cbxSubGenero = new JComboBox();
		cbxSubGenero.setBounds(124, 136, 124, 20);
		contentPane.add(cbxSubGenero);
		
		JComboBox cbxGenero = new JComboBox();
		cbxGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbxGenero.getSelectedIndex() == 0){
					cbxSubGenero.removeAllItems();
					cbxSubGenero.addItem("Tragedia");
					cbxSubGenero.addItem("Comedia");
					cbxSubGenero.addItem("Melodrama");
					cbxSubGenero.addItem("Tragicomedia");
					cbxSubGenero.addItem("Farsa");
				}else if(cbxGenero.getSelectedIndex() == 1){
					cbxSubGenero.removeAllItems();
					cbxSubGenero.addItem("Epica");
					cbxSubGenero.addItem("Epopeya");
					cbxSubGenero.addItem("Cantar de gesta");
					cbxSubGenero.addItem("Cuento");
					cbxSubGenero.addItem("Novela");
					cbxSubGenero.addItem("Fabula");
				}else{
					cbxSubGenero.removeAllItems();
					cbxSubGenero.addItem("Cancion");
					cbxSubGenero.addItem("Himno");
					cbxSubGenero.addItem("Oda");
					cbxSubGenero.addItem("Elegia");
					cbxSubGenero.addItem("Egioga");
					cbxSubGenero.addItem("Satira");
					cbxSubGenero.addItem("Romance");
				}
			}
		});
		
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"Dramatico", "Epico", "Lirico"}));
		cbxGenero.setSelectedIndex(0);
		cbxGenero.setBounds(124, 111, 124, 20);
		contentPane.add(cbxGenero);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTitulo.setText("");
				cbxAutor.setSelectedIndex(0);
				txtEditor.setText("");
				cbxGenero.setSelectedIndex(0);
				cbxSubGenero.removeAllItems();
				cbxIdioma.setSelectedIndex(0);
				cbxCondicionesFisicas.setSelectedIndex(0);
				cbxCategoria.setSelectedIndex(0);
				txtPublicacion.setText("");
				txtEditorial.setText("");
				txtNumeroDePaginas.setText("");
				txtCantidad.setText("");
				txtEdicion.setText("");				
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			int estado = 1;
			int Cantidad = Integer.parseInt(txtCantidad.getText());
			int numeroPagina = Integer.parseInt(txtNumeroDePaginas.getText());

					@SuppressWarnings("unused")
					Libro Libro = new Libro(txtTitulo.getText(), cbxAutor.getSelectedItem().toString(), txtEditor.getText(), cbxGenero.getSelectedItem().toString(), cbxSubGenero.getSelectedItem().toString(), cbxIdioma.getSelectedItem().toString(), estado, cbxCategoria.getSelectedItem().toString(),txtPublicacion.getText(), txtEditorial.getText(), numeroPagina,cbxCondicionesFisicas.getSelectedItem().toString(),Cantidad, txtEdicion.getText());
					
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, e2,"Error",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		
		
		btnGuardar.setBounds(253, 278, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLibro.this.dispose();
			}
		});
		btnSalir.setBounds(365, 278, 89, 23);
		contentPane.add(btnSalir);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(124, 36, 167, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtEditor = new JTextField();
		txtEditor.setColumns(10);
		txtEditor.setBounds(124, 86, 124, 20);
		contentPane.add(txtEditor);
		
		txtPublicacion = new JTextField();
		txtPublicacion.setColumns(10);
		txtPublicacion.setBounds(416, 86, 124, 20);
		contentPane.add(txtPublicacion);
		
		txtEditorial = new JTextField();
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(416, 111, 124, 20);
		contentPane.add(txtEditorial);
		
		txtNumeroDePaginas = new JTextField();
		txtNumeroDePaginas.setColumns(10);
		txtNumeroDePaginas.setBounds(416, 136, 124, 20);
		contentPane.add(txtNumeroDePaginas);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(416, 161, 124, 20);
		contentPane.add(txtCantidad);
		
		txtEdicion = new JTextField();
		txtEdicion.setColumns(10);
		txtEdicion.setBounds(416, 186, 124, 20);
		contentPane.add(txtEdicion);
		
		btnNuevo.setBounds(142, 278, 89, 23);
		contentPane.add(btnNuevo);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtTitulo, cbxAutor, txtEditor, cbxGenero, cbxSubGenero, cbxIdioma, cbxCondicionesFisicas, cbxCategoria, txtPublicacion, txtEditorial, txtNumeroDePaginas, txtCantidad, txtEdicion, btnGuardar, btnNuevo, btnSalir}));
		
		
		
		
		
		try {
			Libro autores = new Libro();
			
			autor = autores.mostrarAutor();
			
			do{
				cbxAutor.addItem(autor.getObject(1).toString() +" "+ autor.getObject(2).toString());
			}while(autor.next());
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
		
	}
}
