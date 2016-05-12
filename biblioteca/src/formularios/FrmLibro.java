package formularios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.libro;

public class FrmLibro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditor;
	private JTextField txtGenero;
	private JTextField txtSubGenero;
	private JTextField txtIdioma;
	private JTextField txtCondicionesFisicas;
	private JTextField txtCategoria;
	private JTextField txtPublicacion;
	private JTextField txtEditorial;
	private JTextField txtNumeroDePaginas;
	private JTextField txtCantidad;
	private JTextField txtEdicion;

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
	public FrmLibro() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibro = new JLabel("Libro");
		lblLibro.setBounds(230, 13, 46, 14);
		contentPane.add(lblLibro);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(85, 38, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutor.setBounds(85, 63, 46, 14);
		contentPane.add(lblAutor);
		
		JLabel lblEditor = new JLabel("Editor:");
		lblEditor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditor.setBounds(85, 88, 46, 14);
		contentPane.add(lblEditor);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setBounds(85, 112, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblSubgenero = new JLabel("SubGenero:");
		lblSubgenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubgenero.setBounds(55, 139, 76, 14);
		contentPane.add(lblSubgenero);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdioma.setBounds(69, 164, 62, 14);
		contentPane.add(lblIdioma);
		
		JLabel lblCondicionesFicicas = new JLabel("Condiciones fisicas: ");
		lblCondicionesFicicas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCondicionesFicicas.setBounds(10, 189, 121, 14);
		contentPane.add(lblCondicionesFicicas);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(55, 216, 76, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblPublicacion = new JLabel("Publicacion:");
		lblPublicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPublicacion.setBounds(303, 38, 76, 14);
		contentPane.add(lblPublicacion);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditorial.setBounds(317, 63, 62, 14);
		contentPane.add(lblEditorial);
		
		JLabel lblNumeroDePaginas = new JLabel("Numero de paginas:");
		lblNumeroDePaginas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDePaginas.setBounds(255, 88, 124, 14);
		contentPane.add(lblNumeroDePaginas);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setBounds(314, 112, 65, 14);
		contentPane.add(lblCantidad);
		
		JLabel lblEdicion = new JLabel("Edicion:");
		lblEdicion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdicion.setBounds(330, 137, 49, 14);
		contentPane.add(lblEdicion);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTitulo.setText("");
				txtAutor.setText("");
				txtEditor.setText("");
				txtGenero.setText("");
				txtSubGenero.setText("");
				txtIdioma.setText("");
				txtCondicionesFisicas.setText("");
				txtCategoria.setText("");
				txtPublicacion.setText("");
				txtEditorial.setText("");
				txtNumeroDePaginas.setText("");
				txtCantidad.setText("");
				txtEdicion.setText("");				
			}
		});
		btnNuevo.setBounds(132, 244, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			private libro libro;

			public void actionPerformed(ActionEvent e) {
				try {
			int estado = 1;
			int Cantidad = Integer.parseInt(txtCantidad.getText());
			int numeroPagina = Integer.parseInt(txtNumeroDePaginas.getText());

					setLibro(new libro(txtTitulo.getText(), txtAutor.getText(), txtEditor.getText(), txtGenero.getText(), txtSubGenero.getText(), txtIdioma.getText(), estado, txtCategoria.getText(),txtPublicacion.getText(), txtEditorial.getText(), numeroPagina, txtCondicionesFisicas.getText(),Cantidad, txtEdicion.getText()));
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(FrmLibro.this, e2);
				}
			}

			@SuppressWarnings("unused")
			public libro getLibro() {
				return libro;
			}

			public void setLibro(libro libro) {
				this.libro = libro;
			}
		});
		btnGuardar.setBounds(243, 244, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLibro.this.dispose();
			}
		});
		btnSalir.setBounds(355, 244, 89, 23);
		contentPane.add(btnSalir);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(157, 40, 86, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(157, 62, 86, 20);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtEditor = new JTextField();
		txtEditor.setColumns(10);
		txtEditor.setBounds(157, 87, 86, 20);
		contentPane.add(txtEditor);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(157, 111, 86, 20);
		contentPane.add(txtGenero);
		
		txtSubGenero = new JTextField();
		txtSubGenero.setColumns(10);
		txtSubGenero.setBounds(157, 136, 86, 20);
		contentPane.add(txtSubGenero);
		
		txtIdioma = new JTextField();
		txtIdioma.setColumns(10);
		txtIdioma.setBounds(157, 163, 86, 20);
		contentPane.add(txtIdioma);
		
		txtCondicionesFisicas = new JTextField();
		txtCondicionesFisicas.setColumns(10);
		txtCondicionesFisicas.setBounds(157, 188, 86, 20);
		contentPane.add(txtCondicionesFisicas);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(157, 213, 86, 20);
		contentPane.add(txtCategoria);
		
		txtPublicacion = new JTextField();
		txtPublicacion.setColumns(10);
		txtPublicacion.setBounds(403, 38, 86, 20);
		contentPane.add(txtPublicacion);
		
		txtEditorial = new JTextField();
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(403, 63, 86, 20);
		contentPane.add(txtEditorial);
		
		txtNumeroDePaginas = new JTextField();
		txtNumeroDePaginas.setColumns(10);
		txtNumeroDePaginas.setBounds(403, 88, 86, 20);
		contentPane.add(txtNumeroDePaginas);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(403, 112, 86, 20);
		contentPane.add(txtCantidad);
		
		txtEdicion = new JTextField();
		txtEdicion.setColumns(10);
		txtEdicion.setBounds(403, 137, 86, 20);
		contentPane.add(txtEdicion);
	}

}
