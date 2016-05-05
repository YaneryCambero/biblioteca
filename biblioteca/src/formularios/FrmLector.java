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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import clases.lector;

public class FrmLector extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCiudad;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField ftfFechaNacimiento;
	private JTextField txtCalle;
	private JTextField txtSector;
	private JTextField ftfCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLector frame = new FrmLector();
					
					LookAndFeelInfo[] apariencias = UIManager.getInstalledLookAndFeels();
					
					LookAndFeelInfo aparienciaActual = apariencias[0];
										
					for (int i = 0; i < apariencias.length; i++) {
						System.out.println(apariencias[i].getClassName());
						if (apariencias[i].getClassName().indexOf("WindowsLookAndFeel") >= 0){
							aparienciaActual=apariencias[i];
						}
					}
					
					UIManager.setLookAndFeel(aparienciaActual.getClassName());
					SwingUtilities.updateComponentTreeUI(frame);
					
					frame.setVisible(true);
					System.out.println(apariencias.length);
				
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
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeLectores = new JLabel("Registro de Lector");
		lblRegistroDeLectores.setBounds(175, 0, 109, 14);
		contentPane.add(lblRegistroDeLectores);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 28, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 56, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(24, 258, 32, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 140, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(10, 84, 46, 14);
		contentPane.add(lblCedula);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(10, 112, 119, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 283, 78, 14);
		contentPane.add(lblCategoria);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(58, 25, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(58, 53, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(58, 223, 86, 20);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(52, 255, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(58, 137, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		/*ftfFechaNacimiento = new JTextField();
		ftfFechaNacimiento.setBounds(123, 109, 86, 20);
		contentPane.add(ftfFechaNacimiento);
		ftfFechaNacimiento.setColumns(10);*/
		
		JComboBox cbbCategoria = new JComboBox();
		cbbCategoria.setModel(new DefaultComboBoxModel<Object>(new String[] {"Estudiante", "Profesor"}));
		cbbCategoria.setBounds(66, 283, 78, 20);
		contentPane.add(cbbCategoria);
		
		try {
			MaskFormatter mascaraFecha = new MaskFormatter("####-##-##");
			mascaraFecha.setPlaceholderCharacter('_');
			ftfFechaNacimiento = new JFormattedTextField(mascaraFecha);
			ftfFechaNacimiento.setBounds(152, 109, 70, 20);
			contentPane.add(ftfFechaNacimiento);
			
			MaskFormatter mascaraCedula = new MaskFormatter("###-#######-#");
			mascaraCedula.setPlaceholderCharacter('_');
			JFormattedTextField ftfCedula = new JFormattedTextField(mascaraCedula);
			ftfCedula.setBounds(58, 81, 98, 20);
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
				txtCiudad.setText("");
				ftfCedula.setText("");
				ftfFechaNacimiento.setText("");
				txtCalle.setText("");
				txtSector.setText("");
				txtCiudad.setText("");
				txtTelefono.setText("");
				txtEmail.setText("");
				
				cbbCategoria.setSelectedIndex(0);
				
			}
		});
		btnNuevo.setBounds(76, 312, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					lector Lector = new lector(txtNombre.getText(), txtApellido.getText(),ftfCedula.getText(), ftfFechaNacimiento.getText(), txtTelefono.getText(), txtCalle.getText(), txtSector.getText(), txtCiudad.getText(), txtEmail.getText(), cbbCategoria.getSelectedIndex());
				
				}catch (SQLException e)
				{
				   e.printStackTrace();	
				}
			}
		});
		btnGuardar.setBounds(175, 312, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLector.this.dispose();
			}
		});
		btnSalir.setBounds(278, 312, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel label = new JLabel("Calle:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(12, 174, 38, 14);
		contentPane.add(label);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(58, 165, 163, 20);
		contentPane.add(txtCalle);
		
		JLabel label_1 = new JLabel("Sector:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(4, 199, 46, 14);
		contentPane.add(label_1);
		
		txtSector = new JTextField();
		txtSector.setColumns(10);
		txtSector.setBounds(59, 192, 163, 20);
		contentPane.add(txtSector);
		
		JLabel label_2 = new JLabel("Ciudad:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(10, 226, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("AAAA-MM-DD");
		label_3.setBounds(232, 111, 89, 16);
		contentPane.add(label_3);
	}
}
