package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import clases.Bibliotecario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Dialog.ModalityType;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class FrmBibliotecario extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCalle;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtSector;
	private JTextField txtCiudad;
	private JTextField txtFechaNacimientoAnyo;
	private JTextField txtFechaNacimientoMes;
	private JTextField txtFechaNacimientoDia;
	private JTextField txtFechaRegistroAnyo;
	private JTextField txtFechaRegistroMes;
	private JTextField txtFechaRegistroDia;
	private JTextField txtCedula;

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
		setBounds(100, 100, 430, 416);
		contentPane = new JPanel();
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
		txtEmail.setBounds(139, 290, 163, 20);
		contentPane.add(txtEmail);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(139, 146, 163, 20);
		contentPane.add(txtTelefono);
		
		txtSector = new JTextField();
		txtSector.setBounds(139, 204, 163, 20);
		contentPane.add(txtSector);
		txtSector.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(139, 230, 163, 20);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		txtFechaNacimientoAnyo = new JTextField();
		txtFechaNacimientoAnyo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limiteCaracter = 4;
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir numeros");
				}
				
				if(txtFechaNacimientoAnyo.getText().length() >= limiteCaracter){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir 4 digitos");
				}
			}
		});
		txtFechaNacimientoAnyo.setBounds(139, 90, 33, 20);
		contentPane.add(txtFechaNacimientoAnyo);
		txtFechaNacimientoAnyo.setColumns(10);
		
		txtFechaNacimientoMes = new JTextField();
		txtFechaNacimientoMes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limiteCaracter = 2;
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){ 
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir numeros");
				}
				
				if(txtFechaNacimientoMes.getText().length() >= limiteCaracter){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir 2 digitos");
				}
			}
		});
		txtFechaNacimientoMes.setColumns(10);
		txtFechaNacimientoMes.setBounds(176, 90, 18, 20);
		contentPane.add(txtFechaNacimientoMes);
		
		txtFechaNacimientoDia = new JTextField();
		txtFechaNacimientoDia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limiteCaracter = 2;
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir numeros");
				}
				
				if(txtFechaNacimientoDia.getText().length() >= limiteCaracter){ 
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir 2 digitos");
				}
			}
		});
		txtFechaNacimientoDia.setColumns(10);
		txtFechaNacimientoDia.setBounds(198, 90, 18, 20);
		contentPane.add(txtFechaNacimientoDia);
		
		txtFechaRegistroAnyo = new JTextField();
		txtFechaRegistroAnyo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limiteCaracter = 4;
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir numeros");
				}
				
				if(txtFechaRegistroAnyo.getText().length() >= limiteCaracter){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir 4 digitos");
				}
			}
		});
		txtFechaRegistroAnyo.setColumns(10);
		txtFechaRegistroAnyo.setBounds(139, 265, 33, 20);
		contentPane.add(txtFechaRegistroAnyo);
		
		txtFechaRegistroMes = new JTextField();
		txtFechaRegistroMes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limiteCaracter = 2;
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir numeros");
				}
				
				if(txtFechaRegistroMes.getText().length() >= limiteCaracter){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir 2 digitos");
				}
			}
		});
		txtFechaRegistroMes.setColumns(10);
		txtFechaRegistroMes.setBounds(176, 265, 18, 20);
		contentPane.add(txtFechaRegistroMes);
		
		txtFechaRegistroDia = new JTextField();
		txtFechaRegistroDia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limiteCaracter = 2;
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir numeros");
				}
				
				if(txtFechaRegistroDia.getText().length() >= limiteCaracter){ 
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir 2 digitos");
				}
			}
		});
		txtFechaRegistroDia.setColumns(10);
		txtFechaRegistroDia.setBounds(198, 265, 18, 20);
		contentPane.add(txtFechaRegistroDia);
		
		txtCedula = new JTextField();
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limiteCaracter = 11;
				
				if(txtCedula.getText().length() >= limiteCaracter){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir 11 digitos");
				}
			}
		});
		txtCedula.setBounds(139, 118, 83, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		JComboBox cbxCategoria = new JComboBox();
		cbxCategoria.setModel(new DefaultComboBoxModel(new String[] {"matutino", "vespertino", "nocturno"}));
		cbxCategoria.setBounds(139, 316, 163, 20);
		contentPane.add(cbxCategoria);
		
		JLabel lblRegistroBibliotecario = new JLabel("Registro Bibliotecario");
		lblRegistroBibliotecario.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblRegistroBibliotecario.setBounds(93, 0, 223, 31);
		contentPane.add(lblRegistroBibliotecario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 42, 111, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellios = new JLabel("Apellidos:");
		lblApellios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellios.setBounds(10, 67, 111, 14);
		contentPane.add(lblApellios);
		
		JLabel lblDireccion = new JLabel("Calle:");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 183, 111, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(10, 295, 111, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(10, 149, 111, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de registro:");
		lblFechaDeRegistro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeRegistro.setBounds(10, 269, 111, 14);
		contentPane.add(lblFechaDeRegistro);
		
		JLabel lblCategoria = new JLabel("Tanda:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(10, 319, 111, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setBounds(10, 121, 111, 14);
		contentPane.add(lblCedula);
		
		try {
			MaskFormatter mascaraFecha = new MaskFormatter("####-##-##");
			mascaraFecha.setPlaceholderCharacter('_');
			
			JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
			lblFechaNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFechaNacimiento.setBounds(10, 92, 107, 16);
			contentPane.add(lblFechaNacimiento);
			
			JLabel lblFormatoFecha = new JLabel("AAAA-MM-DD");
			lblFormatoFecha.setBounds(223, 91, 89, 16);
			contentPane.add(lblFormatoFecha);
			
			JLabel label = new JLabel("AAAA-MM-DD");
			label.setBounds(223, 266, 89, 16);
			contentPane.add(label);
			
			MaskFormatter mascaraCedula = new MaskFormatter("###-#######-#");
			mascaraCedula.setPlaceholderCharacter('_');
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNombre.setText("");
				txtApellido.setText("");
				txtCedula.setText("");
				txtCalle.setText("");
				txtEmail.setText("");
				txtFechaNacimientoAnyo.setText("");
				txtFechaNacimientoMes.setText("");
				txtFechaNacimientoDia.setText("");
				txtFechaRegistroAnyo.setText("");
				txtFechaRegistroMes.setText("");
				txtFechaRegistroDia.setText("");
				txtTelefono.setText("");
				cbxCategoria.setSelectedIndex(0);
			}
		});
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSector.setBounds(75, 208, 46, 14);
		contentPane.add(lblSector);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCiudad.setBounds(75, 233, 46, 14);
		contentPane.add(lblCiudad);
		btnNuevo.setBounds(58, 343, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fechaNacimiento = txtFechaNacimientoAnyo.getText() +"-"+ txtFechaNacimientoMes.getText() +"-"+ txtFechaNacimientoDia.getText();
				String fechaRegistro = txtFechaRegistroAnyo.getText() +"-"+ txtFechaRegistroMes.getText() +"-"+ txtFechaRegistroDia.getText();
				
				try {
					Bibliotecario Bibliotecario = new Bibliotecario(txtNombre.getText(),txtApellido.getText(),txtCalle.getText(),txtSector.getText(),txtCiudad.getText(),fechaNacimiento,txtEmail.getText(),txtTelefono.getText(),fechaRegistro,txtCedula.getText(),cbxCategoria.getSelectedIndex());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(159, 343, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmBibliotecario.this.dispose();
			}
		});
		btnSalir.setBounds(261, 343, 89, 23);
		contentPane.add(btnSalir);
		
		
		
		
		
		
		
		
		
		
	}
}
