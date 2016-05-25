package formularios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import clases.Lector;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class FrmLector extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCiudad;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtCalle;
	private JTextField txtSector;
	private JTextField ftfCedula;
	private JTextField txtFechaNacimientoAnyo;
	private JTextField txtFechaNacimientoMes;
	private JTextField txtFechaNacimientoDia;
	private JTextField txtCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLector frame = new FrmLector();
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
	public FrmLector() {
		setTitle("Lector");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLector.class.getResource("/imagenes/Profile.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeLectores = new JLabel("Registro de Lector");
		lblRegistroDeLectores.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblRegistroDeLectores.setBounds(111, 0, 199, 28);
		contentPane.add(lblRegistroDeLectores);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(35, 39, 138, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(35, 67, 138, 14);
		contentPane.add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(101, 272, 72, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(35, 151, 138, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setBounds(35, 95, 138, 14);
		contentPane.add(lblCedula);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeNacimiento.setBounds(35, 126, 138, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(95, 305, 78, 14);
		contentPane.add(lblCategoria);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(179, 36, 176, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(179, 64, 176, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(179, 238, 176, 20);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(179, 269, 176, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(179, 150, 176, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		/*ftfFechaNacimiento = new JTextField();
		ftfFechaNacimiento.setBounds(123, 109, 86, 20);
		contentPane.add(ftfFechaNacimiento);
		ftfFechaNacimiento.setColumns(10);*/
		
		JComboBox cbbCategoria = new JComboBox();
		cbbCategoria.setModel(new DefaultComboBoxModel<Object>(new String[] {"Estudiante", "Profesor"}));
		cbbCategoria.setBounds(179, 302, 130, 20);
		contentPane.add(cbbCategoria);
		
		try {
			MaskFormatter mascaraFecha = new MaskFormatter("####-##-##");
			mascaraFecha.setPlaceholderCharacter('_');
			
			MaskFormatter mascaraCedula = new MaskFormatter("###-#######-#");
			mascaraCedula.setPlaceholderCharacter('_');
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNombre.setText("");
				txtApellido.setText("");
				txtCiudad.setText("");
				ftfCedula.setText("");
				txtFechaNacimientoAnyo.setText("");
				txtFechaNacimientoMes.setText("");
				txtFechaNacimientoDia.setText("");
				txtCalle.setText("");
				txtSector.setText("");
				txtCiudad.setText("");
				txtTelefono.setText("");
				txtEmail.setText("");
				
				cbbCategoria.setSelectedIndex(0);
				
			}
		});
		btnNuevo.setBounds(58, 344, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fechaNacimiento = txtFechaNacimientoAnyo +"-"+ txtFechaNacimientoMes.getText() +"-"+ txtFechaNacimientoDia.getText();
				try{
					
					Lector Lector = new Lector(txtNombre.getText(), txtApellido.getText(),ftfCedula.getText(), fechaNacimiento, txtTelefono.getText(), txtCalle.getText(), txtSector.getText(), txtCiudad.getText(), txtEmail.getText(), cbbCategoria.getSelectedIndex());
				
				}catch (SQLException e)
				{
				   JOptionPane.showConfirmDialog(null, e,"Error",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		btnGuardar.setBounds(157, 344, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLector.this.dispose();
			}
		});
		btnSalir.setBounds(256, 344, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel label = new JLabel("Calle:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(37, 185, 136, 14);
		contentPane.add(label);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(179, 180, 176, 20);
		contentPane.add(txtCalle);
		
		JLabel label_1 = new JLabel("Sector:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(29, 210, 144, 14);
		contentPane.add(label_1);
		
		txtSector = new JTextField();
		txtSector.setColumns(10);
		txtSector.setBounds(179, 208, 176, 20);
		contentPane.add(txtSector);
		
		JLabel label_2 = new JLabel("Ciudad:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(35, 243, 138, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("AAAA-MM-DD");
		label_3.setBounds(266, 125, 89, 16);
		contentPane.add(label_3);
		
		txtFechaNacimientoAnyo = new JTextField();
		txtFechaNacimientoAnyo.setColumns(10);
		txtFechaNacimientoAnyo.setBounds(179, 123, 33, 20);
		contentPane.add(txtFechaNacimientoAnyo);
		
		txtFechaNacimientoMes = new JTextField();
		txtFechaNacimientoMes.setColumns(10);
		txtFechaNacimientoMes.setBounds(216, 123, 18, 20);
		contentPane.add(txtFechaNacimientoMes);
		
		txtFechaNacimientoDia = new JTextField();
		txtFechaNacimientoDia.setColumns(10);
		txtFechaNacimientoDia.setBounds(238, 123, 18, 20);
		contentPane.add(txtFechaNacimientoDia);
		
		txtCedula = new JTextField();
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limiteCaracter = 11;
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){ 
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir numero");
				}
				
				if(txtCedula.getText().length() >= limiteCaracter){ 
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "solo puede introducir 11 digitos");
				}
			}
		});
		txtCedula.setBounds(179, 92, 89, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
	}
}
