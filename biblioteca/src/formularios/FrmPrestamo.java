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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("Prestamo");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 571, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigoLector = new JLabel("Codigo Lector:");
		lblCodigoLector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoLector.setBounds(11, 35, 89, 14);
		panel.add(lblCodigoLector);
		
		JLabel lblNewLabel = new JLabel("Informacion Lector");
		lblNewLabel.setBounds(242, 4, 124, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(20, 60, 80, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(20, 85, 80, 14);
		panel.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(20, 110, 80, 14);
		panel.add(lblTelefono);
		
		textField_3 = new JTextField();
		textField_3.setBounds(105, 107, 86, 20);
		panel.add(textField_3);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 82, 86, 20);
		panel.add(textField_2);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 57, 86, 20);
		panel.add(textField_1);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(105, 33, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setBounds(201, 29, 89, 23);
		panel.add(btnBuscar_1);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(338, 35, 92, 14);
		panel.add(lblCategoria);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setBounds(338, 60, 92, 14);
		panel.add(lblCedula);
		
		JLabel lblDirecccion = new JLabel("Direcccion:");
		lblDirecccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDirecccion.setBounds(338, 85, 92, 14);
		panel.add(lblDirecccion);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(338, 110, 92, 14);
		panel.add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setBounds(437, 33, 86, 20);
		panel.add(textField_4);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(437, 57, 86, 20);
		panel.add(textField_5);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(437, 82, 86, 20);
		panel.add(textField_6);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(437, 107, 86, 20);
		panel.add(textField_7);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(137, 468, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(240, 468, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(350, 468, 89, 23);
		contentPane.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 175, 571, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblInformacionDelPrestamo = new JLabel("Informacion del prestamo");
		lblInformacionDelPrestamo.setBounds(224, 5, 149, 14);
		panel_1.add(lblInformacionDelPrestamo);
		
		JLabel lblFechaPrestamo = new JLabel("Fecha Prestamo");
		lblFechaPrestamo.setBounds(82, 45, 93, 14);
		panel_1.add(lblFechaPrestamo);
		lblFechaPrestamo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHoraPrestamo = new JLabel("Hora Prestamo");
		lblHoraPrestamo.setBounds(82, 69, 93, 14);
		panel_1.add(lblHoraPrestamo);
		lblHoraPrestamo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_9 = new JTextField();
		textField_9.setBounds(188, 63, 86, 20);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(188, 39, 86, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblEstaddo = new JLabel("Estado");
		lblEstaddo.setBounds(292, 42, 86, 14);
		panel_1.add(lblEstaddo);
		lblEstaddo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblPrestadoPor = new JLabel("Prestado Por");
		lblPrestadoPor.setBounds(292, 64, 86, 14);
		panel_1.add(lblPrestadoPor);
		lblPrestadoPor.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHoraEntrega = new JLabel("Hora Entrega");
		lblHoraEntrega.setBounds(292, 92, 86, 14);
		panel_1.add(lblHoraEntrega);
		lblHoraEntrega.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_11 = new JTextField();
		textField_11.setBounds(396, 38, 86, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(396, 63, 86, 20);
		panel_1.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(396, 90, 86, 20);
		panel_1.add(textField_13);
		textField_13.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 311, 571, 146);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JList JlistContenidoBusqueda = new JList();
		JlistContenidoBusqueda.setBounds(88, 57, 110, 78);
		panel_2.add(JlistContenidoBusqueda);
		
		
		
		JScrollPane scrollPaneContenidoBusqueda = new JScrollPane();
		scrollPaneContenidoBusqueda.setBounds(88, 57, 112, 80);
		panel_2.add(scrollPaneContenidoBusqueda);
		
		textField_10 = new JTextField();
		textField_10.setBounds(208, 8, 140, 20);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(358, 7, 93, 23);
		panel_2.add(btnBuscar);
		
		JList JlistElementosSeleccionados = new JList();
		JlistElementosSeleccionados.setBounds(358, 57, 110, 78);
		panel_2.add(JlistElementosSeleccionados);
		
		JScrollPane scrollPaneElementosSeleccionados = new JScrollPane();
		scrollPaneElementosSeleccionados.setBounds(358, 57, 112, 80);
		panel_2.add(scrollPaneElementosSeleccionados);
		scrollPaneElementosSeleccionados.setBackground(Color.WHITE);
		
		JButton btnAgregar = new JButton("Agregar Libro");
		btnAgregar.setBounds(220, 54, 112, 23);
		panel_2.add(btnAgregar);
		
		JButton btnQuitarLibro = new JButton("Quitar Libro");
		btnQuitarLibro.setBounds(220, 83, 112, 23);
		panel_2.add(btnQuitarLibro);
		
		JLabel lblTituloLibro = new JLabel("Titulo Libro:");
		lblTituloLibro.setBounds(129, 11, 69, 14);
		panel_2.add(lblTituloLibro);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
	}
}
