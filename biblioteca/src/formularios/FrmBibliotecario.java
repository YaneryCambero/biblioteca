package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import clases.bibliotecario;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dialog.ModalityType;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import java.awt.Toolkit;



public class FrmBibliotecario extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCalle;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JFormattedTextField ftfFechaNacimiento;
	private JFormattedTextField ftfFechaRegistro;
	private JFormattedTextField ftfCedula;
	private JTextField txtSector;
	private JTextField txtCiudad;

	
	public Image ImagenFondo;
	public URL Fondo;




	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBibliotecario frame = new FrmBibliotecario();
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
	public FrmBibliotecario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmBibliotecario.class.getResource("/imagenes/PNG-32/Profile.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Registro Bibliotecario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 415);
		//contentPane = new JPanel();
		
		contentPane = new JPanel(){
			
			
			public void paintComponent (Graphics g){
				
				   g.drawImage(ImagenFondo, 0, 0, getWidth(),getHeight(),this);
				
				
			}			
			
		};


      	Fondo = this.getClass().getResource("/imagenes/images (11).jpg");
      	ImagenFondo = new ImageIcon(Fondo).getImage();
      	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(139, 34, 163, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(139, 59, 163, 20);
		contentPane.add(txtApellido);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(139, 177, 163, 20);
		contentPane.add(txtCalle);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(139, 294, 163, 20);
		contentPane.add(txtEmail);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(139, 146, 163, 20);
		contentPane.add(txtTelefono);
		
		JComboBox cbxCategoria = new JComboBox();
		cbxCategoria.setModel(new DefaultComboBoxModel(new String[] {"matutino", "vespertino", "nocturno"}));
		cbxCategoria.setBounds(139, 316, 163, 20);
		contentPane.add(cbxCategoria);
		
		JLabel lblRegistroBibliotecario = new JLabel("Registro Bibliotecario");
		lblRegistroBibliotecario.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblRegistroBibliotecario.setBounds(42, 6, 223, 31);
		contentPane.add(lblRegistroBibliotecario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 42, 111, 14);
		lblNombre.setForeground(getBackground().black.darker());;
		contentPane.add(lblNombre);
		
		JLabel lblApellios = new JLabel("Apellidos:");
		lblApellios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellios.setBounds(10, 67, 111, 14);
		lblApellios.setForeground(getBackground().black.darker());;
		contentPane.add(lblApellios);
		
		JLabel lblDireccion = new JLabel("Calle:");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 183, 111, 14);
		lblDireccion.setForeground(getBackground().black.darker());;
		contentPane.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(10, 297, 111, 14);
		lblEmail.setForeground(getBackground().black.darker());;
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(10, 149, 111, 14);
		lblTelefono.setForeground(getBackground().black.darker());;
		contentPane.add(lblTelefono);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de registro:");
		lblFechaDeRegistro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeRegistro.setBounds(10, 269, 111, 14);
		lblFechaDeRegistro.setForeground(getBackground().black.darker());;
		contentPane.add(lblFechaDeRegistro);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(10, 319, 111, 14);
		lblCategoria.setForeground(getBackground().black.darker());;
		contentPane.add(lblCategoria);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setBounds(10, 121, 111, 14);
		lblCedula.setForeground(getBackground().black.darker());;
		contentPane.add(lblCedula);
		
		try {
			MaskFormatter mascaraFecha = new MaskFormatter("####-##-##");
			mascaraFecha.setPlaceholderCharacter('_');
			
			JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
			lblFechaNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFechaNacimiento.setBounds(10, 92, 107, 16);
			contentPane.add(lblFechaNacimiento);
			
			JLabel lblFormatoFecha = new JLabel("AAAA-MM-DD");
			lblFormatoFecha.setBounds(213, 90, 89, 16);
			contentPane.add(lblFormatoFecha);
			
			JLabel label = new JLabel("AAAA-MM-DD");
			label.setBounds(213, 267, 89, 16);
			contentPane.add(label);
			ftfFechaNacimiento = new JFormattedTextField(mascaraFecha);
			ftfFechaNacimiento.setBounds(139, 90, 70, 20);
			contentPane.add(ftfFechaNacimiento);
			
			ftfFechaRegistro = new JFormattedTextField(mascaraFecha);
			ftfFechaRegistro.setBounds(139, 263, 70, 20);
			contentPane.add(ftfFechaRegistro);
			
			MaskFormatter mascaraCedula = new MaskFormatter("###-#######-#");
			mascaraCedula.setPlaceholderCharacter('_');
			JFormattedTextField ftfCedula = new JFormattedTextField(mascaraCedula);
			ftfCedula.setBounds(139, 118, 98, 20);
			contentPane.add(ftfCedula);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNombre.setText("");
				txtApellido.setText("");
				ftfCedula.setText("");
				txtCalle.setText("");
				txtEmail.setText("");
				ftfFechaNacimiento.setText("");
				ftfFechaRegistro.setText("");
				txtTelefono.setText("");
				cbxCategoria.setSelectedIndex(0);
			}
		});
		btnNuevo.setBounds(58, 343, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bibliotecario Bibliotecario = new bibliotecario(txtNombre.getText(),txtApellido.getText(),txtCalle.getText(),txtSector.getText(),txtCiudad.getText(),ftfFechaNacimiento.getText(),txtEmail.getText(),txtTelefono.getText(),ftfFechaRegistro.getText(),ftfCedula.getText(),cbxCategoria.getSelectedIndex());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(167, 343, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmBibliotecario.this.dispose();
			}
		});
		btnSalir.setBounds(261, 343, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSector.setBounds(75, 208, 46, 14);
		lblSector.setForeground(getBackground().black.darker());;
		contentPane.add(lblSector);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCiudad.setBounds(75, 233, 46, 14);
		lblCiudad.setForeground(getBackground().black.darker());;
		contentPane.add(lblCiudad);
		
		txtSector = new JTextField();
		txtSector.setBounds(139, 204, 163, 20);
		
		contentPane.add(txtSector);
		txtSector.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(139, 230, 163, 20);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		
		
		
		
		
		
		
		
		
	}
}
