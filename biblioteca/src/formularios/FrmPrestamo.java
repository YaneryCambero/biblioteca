package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Dialog.ModalityType;
import javax.swing.JScrollPane;
import java.awt.List;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import java.awt.ScrollPane;

public class FrmPrestamo extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrestamo frame = new FrmPrestamo();
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
	public FrmPrestamo() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrestamo = new JLabel("Prestamo");
		lblPrestamo.setBounds(231, 12, 70, 14);
		contentPane.add(lblPrestamo);
		
		JLabel lblNewLabel = new JLabel("Informacion Lector");
		lblNewLabel.setBounds(205, 37, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCodigoLector = new JLabel("Codigo Lector");
		lblCodigoLector.setBounds(21, 68, 80, 14);
		contentPane.add(lblCodigoLector);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 92, 80, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(21, 117, 56, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 142, 80, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(370, 65, 80, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(370, 90, 80, 14);
		contentPane.add(lblCedula);
		
		JLabel lblDirecccion = new JLabel("Direcccion");
		lblDirecccion.setBounds(370, 114, 80, 14);
		contentPane.add(lblDirecccion);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(370, 139, 80, 14);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(106, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(106, 89, 86, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 114, 86, 20);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 139, 86, 20);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(438, 65, 86, 20);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(438, 89, 86, 20);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(438, 114, 86, 20);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(438, 139, 86, 20);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		
		JLabel lblInformacionDelPrestamo = new JLabel("Informacion del prestamo");
		lblInformacionDelPrestamo.setBounds(175, 183, 154, 14);
		contentPane.add(lblInformacionDelPrestamo);
		
		JLabel lblFechaPrestamo = new JLabel("Fecha Prestamo");
		lblFechaPrestamo.setBounds(21, 228, 93, 14);
		lblFechaPrestamo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblFechaPrestamo);
		
		JLabel lblHoraPrestamo = new JLabel("Hora Prestamo");
		lblHoraPrestamo.setBounds(21, 252, 93, 14);
		lblHoraPrestamo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblHoraPrestamo);
		
		JLabel lblTituloLibro = new JLabel("Titulo Libro:");
		lblTituloLibro.setBounds(148, 319, 69, 14);
		contentPane.add(lblTituloLibro);
		
		JLabel lblEstaddo = new JLabel("Estado");
		lblEstaddo.setBounds(231, 228, 86, 14);
		lblEstaddo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblEstaddo);
		
		JLabel lblPrestadoPor = new JLabel("Prestado Por");
		lblPrestadoPor.setBounds(231, 252, 86, 14);
		lblPrestadoPor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblPrestadoPor);
		
		JLabel lblHoraEntrega = new JLabel("Hora Entrega");
		lblHoraEntrega.setBounds(231, 275, 86, 14);
		lblHoraEntrega.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblHoraEntrega);
		
		textField_8 = new JTextField();
		textField_8.setBounds(127, 222, 86, 20);
		textField_8.setColumns(10);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(127, 246, 86, 20);
		textField_9.setColumns(10);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setBounds(222, 316, 86, 20);
		textField_10.setColumns(10);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(335, 225, 86, 20);
		textField_11.setColumns(10);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setBounds(335, 249, 86, 20);
		textField_12.setColumns(10);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setBounds(335, 275, 86, 20);
		textField_13.setColumns(10);
		contentPane.add(textField_13);
		
		JButton btnAgregar = new JButton("Agregar Libro");
		btnAgregar.setBounds(243, 371, 112, 23);
		contentPane.add(btnAgregar);
		
		JButton btnQuitarLibro = new JButton("Quitar Libro");
		btnQuitarLibro.setBounds(243, 399, 112, 23);
		contentPane.add(btnQuitarLibro);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(137, 468, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(240, 468, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(350, 468, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(317, 315, 93, 23);
		contentPane.add(btnBuscar);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setBounds(202, 61, 89, 23);
		contentPane.add(btnBuscar_1);
		
		
		
		JScrollPane scrollPaneContenidoBusqueda = new JScrollPane();
		scrollPaneContenidoBusqueda.setBounds(105, 359, 112, 80);
		contentPane.add(scrollPaneContenidoBusqueda);
		
		JList JlistContenidoBusqueda = new JList();
		scrollPaneContenidoBusqueda.setViewportView(JlistContenidoBusqueda);
		
		JScrollPane scrollPaneElementosSeleccionados = new JScrollPane();
		scrollPaneElementosSeleccionados.setBounds(370, 359, 112, 80);
		scrollPaneElementosSeleccionados.setBackground(Color.WHITE);
		contentPane.add(scrollPaneElementosSeleccionados);
		
		JList JlistElementosSeleccionados = new JList();
		scrollPaneElementosSeleccionados.setViewportView(JlistElementosSeleccionados);
		
	}
}
