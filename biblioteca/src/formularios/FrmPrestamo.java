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

import clases.Prestamo;

import javax.swing.ListSelectionModel;
import java.awt.Dialog.ModalityType;
import javax.swing.JScrollPane;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class FrmPrestamo extends JDialog {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCategoria;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private static JTextField txtFechaPrestamo;
	private JTextField txtHoraPrestamo;
	private JTextField txtTituloLibro;
	private JTextField txtEstado;
	private JTextField txtIdBibliotecario;
	private JTextField txtHoraEntrega;
	private boolean control;
	private ResultSet datosDeFilas;
	Prestamo prestamoLibro;
	private DefaultListModel modeloLista=new DefaultListModel();

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
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(105, 107, 141, 20);
		panel.add(txtTelefono);
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(105, 82, 141, 20);
		panel.add(txtApellido);
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(105, 57, 141, 20);
		panel.add(txtNombre);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(105, 33, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prestamo Prestamo = new Prestamo();
				Calendar fecha = Calendar.getInstance();
				
			    try {
					control = Prestamo.buscarLector(txtCodigo.getText());
				} catch (SQLException e1) {
					JOptionPane.showConfirmDialog(null, e1, "error",JOptionPane.DEFAULT_OPTION);
				}
			    
			    if(control){
			    	try {
						datosDeFilas = Prestamo.obtenerDatosLector();
			
						txtNombre.setText(datosDeFilas.getString(2));
						txtApellido.setText(datosDeFilas.getString(3));
						txtTelefono.setText(datosDeFilas.getString(5));
						txtCategoria.setText(datosDeFilas.getString(6));
						txtCedula.setText(datosDeFilas.getString(7));
						txtDireccion.setText(datosDeFilas.getString(9) +" "+ datosDeFilas.getString(10) +" "+ datosDeFilas.getString(11));
						txtEmail.setText(datosDeFilas.getString(8));
			        
					} catch (SQLException e1) {
						
					}
			    }
			}
		});
		btnBuscar_1.setBounds(201, 29, 89, 23);
		panel.add(btnBuscar_1);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(308, 35, 92, 14);
		panel.add(lblCategoria);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setBounds(308, 60, 92, 14);
		panel.add(lblCedula);
		
		JLabel lblDirecccion = new JLabel("Direcccion:");
		lblDirecccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDirecccion.setBounds(308, 85, 92, 14);
		panel.add(lblDirecccion);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(308, 110, 92, 14);
		panel.add(lblEmail);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(418, 30, 141, 20);
		panel.add(txtCategoria);
		txtCategoria.setEditable(false);
		txtCategoria.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(418, 54, 141, 20);
		panel.add(txtCedula);
		txtCedula.setEditable(false);
		txtCedula.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(418, 79, 141, 20);
		panel.add(txtDireccion);
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(418, 104, 141, 20);
		panel.add(txtEmail);
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 175, 571, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblInformacionDelPrestamo = new JLabel("Informacion del prestamo");
		lblInformacionDelPrestamo.setBounds(225, 12, 149, 14);
		panel_1.add(lblInformacionDelPrestamo);
		
		JLabel lblFechaPrestamo = new JLabel("Fecha Prestamo:");
		lblFechaPrestamo.setBounds(82, 45, 93, 14);
		panel_1.add(lblFechaPrestamo);
		lblFechaPrestamo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHoraPrestamo = new JLabel("Hora Prestamo:");
		lblHoraPrestamo.setBounds(82, 69, 93, 14);
		panel_1.add(lblHoraPrestamo);
		lblHoraPrestamo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtHoraPrestamo = new JTextField();
		txtHoraPrestamo.setBounds(188, 63, 86, 20);
		panel_1.add(txtHoraPrestamo);
		txtHoraPrestamo.setColumns(10);
		
		txtFechaPrestamo = new JTextField();
		txtFechaPrestamo.setBounds(188, 39, 86, 20);
		panel_1.add(txtFechaPrestamo);
		txtFechaPrestamo.setColumns(10);
		
		JLabel lblEstaddo = new JLabel("Estado:");
		lblEstaddo.setBounds(292, 42, 86, 14);
		panel_1.add(lblEstaddo);
		lblEstaddo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblPrestadoPor = new JLabel("Id Bibliotecario:");
		lblPrestadoPor.setBounds(292, 64, 86, 14);
		panel_1.add(lblPrestadoPor);
		lblPrestadoPor.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHoraEntrega = new JLabel("Hora Entrega:");
		lblHoraEntrega.setBounds(292, 92, 86, 14);
		panel_1.add(lblHoraEntrega);
		lblHoraEntrega.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(396, 38, 86, 20);
		panel_1.add(txtEstado);
		txtEstado.setColumns(10);
		
		txtIdBibliotecario = new JTextField();
		txtIdBibliotecario.setBounds(396, 63, 86, 20);
		panel_1.add(txtIdBibliotecario);
		txtIdBibliotecario.setColumns(10);
		
		txtHoraEntrega = new JTextField();
		txtHoraEntrega.setBounds(396, 90, 86, 20);
		panel_1.add(txtHoraEntrega);
		txtHoraEntrega.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 311, 571, 146);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JList JlistContenidoBusqueda = new JList();
		JlistContenidoBusqueda.setBounds(22, 57, 176, 78);
		panel_2.add(JlistContenidoBusqueda);
		
		
		
		JScrollPane scrollPaneContenidoBusqueda = new JScrollPane();
		scrollPaneContenidoBusqueda.setBounds(22, 57, 178, 80);
		panel_2.add(scrollPaneContenidoBusqueda);
		
		txtTituloLibro = new JTextField();
		txtTituloLibro.setBounds(208, 8, 140, 20);
		panel_2.add(txtTituloLibro);
		txtTituloLibro.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					prestamoLibro = new Prestamo();
					control = prestamoLibro.buscarLibros(txtTituloLibro.getText());
					
					if(control){
						datosDeFilas = prestamoLibro.obtenerDatosLibros();
						
						modeloLista.removeAllElements();
						JlistContenidoBusqueda.setModel(modeloLista);
						
						do{
							
							modeloLista.addElement(datosDeFilas.getString("titulo"));
							
						}while(datosDeFilas.next());
						JlistContenidoBusqueda.setModel(modeloLista);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(358, 7, 93, 23);
		panel_2.add(btnBuscar);
		
		JList JlistElementosSeleccionados = new JList();
		JlistElementosSeleccionados.setBounds(358, 57, 178, 78);
		panel_2.add(JlistElementosSeleccionados);
		
		JScrollPane scrollPaneElementosSeleccionados = new JScrollPane();
		scrollPaneElementosSeleccionados.setBounds(358, 57, 178, 80);
		panel_2.add(scrollPaneElementosSeleccionados);
		scrollPaneElementosSeleccionados.setBackground(Color.WHITE);
		
		JButton btnAgregar = new JButton("Agregar Libro");
		btnAgregar.setBounds(220, 54, 112, 23);
		panel_2.add(btnAgregar);
		
		JButton btnQuitarLibro = new JButton("Quitar Libro");
		btnQuitarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel borrarLista = new DefaultListModel();
				borrarLista.removeAllElements();
				
				JlistElementosSeleccionados.setModel(borrarLista);
			}
		});
		btnQuitarLibro.setBounds(220, 83, 112, 23);
		panel_2.add(btnQuitarLibro);
		
		JLabel lblTituloLibro = new JLabel("Titulo Libro:");
		lblTituloLibro.setBounds(129, 11, 69, 14);
		panel_2.add(lblTituloLibro);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JlistElementosSeleccionados.setListData(JlistContenidoBusqueda.getSelectedValues());
				JlistElementosSeleccionados.setSelectedIndex(0);
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Prestamo crearPrestamo = new Prestamo();
				try {
					crearPrestamo.crearPrestamo(txtFechaPrestamo.getText(), txtHoraPrestamo.getText(), txtHoraEntrega.getText(), txtEstado.getText(),Integer.parseInt(txtIdBibliotecario.getText()), JlistElementosSeleccionados.getSelectedValue().toString(), Integer.parseInt(txtCodigo.getText()));

				} catch (SQLException e) {
					JOptionPane.showConfirmDialog(null, e,"Error",JOptionPane.DEFAULT_OPTION);
				}
				
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmPrestamo.this.dispose();
			}
		});
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtTelefono.setText("");
				txtCategoria.setText("");
				txtCedula.setText("");
				txtDireccion.setText("");
				txtEmail.setText("");
				
				txtFechaPrestamo.setText("");
				txtHoraPrestamo.setText("");
				txtEstado.setText("");
				txtIdBibliotecario.setText("");
				txtHoraEntrega.setText("");
				
				txtTituloLibro.setText("");
				
				DefaultListModel borrarLista = new DefaultListModel();
				borrarLista.removeAllElements();
				
				JlistElementosSeleccionados.setModel(borrarLista);
				JlistContenidoBusqueda.setModel(borrarLista);
				
				txtCodigo.requestFocus();
			}
		});
		btnNuevo.setBounds(137, 468, 89, 23);
		contentPane.add(btnNuevo);
		btnSalir.setBounds(350, 468, 89, 23);
		contentPane.add(btnSalir);
		btnGuardar.setBounds(240, 468, 89, 23);
		contentPane.add(btnGuardar);
		
	}
}
