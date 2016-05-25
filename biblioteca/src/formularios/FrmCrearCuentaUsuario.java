package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.tree.DefaultTreeModel;

import clases.CrearUsuario;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalityType;
import java.awt.Toolkit;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class FrmCrearCuentaUsuario extends JDialog {

	private JPanel contentPane;
	private JTextField TxtUsuario;
	private JPasswordField TxtContrasena;
	private JPasswordField TxtConfirmarContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrearCuentaUsuario frame = new FrmCrearCuentaUsuario();
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
	public FrmCrearCuentaUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCrearCuentaUsuario.class.getResource("/imagenes/PNG-32/Profile.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Nuevo Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearNuevaCuenta = new JLabel("Crear nueva cuenta de usuario");
		lblCrearNuevaCuenta.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblCrearNuevaCuenta.setBounds(27, 11, 319, 25);
		contentPane.add(lblCrearNuevaCuenta);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(10, 55, 134, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblNombre = new JLabel("Contrase\u00F1a:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 80, 134, 14);
		contentPane.add(lblNombre);
		
		JLabel lblComprovarContrasena = new JLabel("Comprobar Contrase\u00F1a:");
		lblComprovarContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComprovarContrasena.setBounds(0, 105, 144, 14);
		contentPane.add(lblComprovarContrasena);
		
		JLabel lblPermiso = new JLabel("Permiso");
		lblPermiso.setBounds(10, 130, 68, 14);
		contentPane.add(lblPermiso);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 282, 296, -131);
		contentPane.add(scrollPane);
		
		JCheckBox cbxAdmin = new JCheckBox("Administrador");
		cbxAdmin.setBounds(27, 151, 112, 25);
		contentPane.add(cbxAdmin);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxtUsuario.setText("");
				TxtContrasena.setText("");
				TxtConfirmarContrasena.setText("");
				cbxAdmin.setSelected(false);
			}
		});
		btnNuevo.setBounds(44, 220, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario nuevoUsuario = new CrearUsuario(TxtUsuario.getText(), new String(TxtContrasena.getPassword()), new String(TxtConfirmarContrasena.getPassword()), cbxAdmin.isSelected());
				TxtUsuario.setText("");
				TxtContrasena.setText("");
				TxtConfirmarContrasena.setText("");
				cbxAdmin.setSelected(false);
			}
		});
		btnGuardar.setBounds(141, 220, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCrearCuentaUsuario.this.dispose();
			}
		});
		btnSalir.setBounds(242, 220, 89, 23);
		contentPane.add(btnSalir);
		
		TxtUsuario = new JTextField();
		TxtUsuario.setBounds(150, 55, 181, 20);
		contentPane.add(TxtUsuario);
		TxtUsuario.setColumns(10);
		
		TxtContrasena = new JPasswordField();
		TxtContrasena.setBounds(150, 80, 181, 20);
		contentPane.add(TxtContrasena);
		
		TxtConfirmarContrasena = new JPasswordField();
		TxtConfirmarContrasena.setBounds(150, 105, 181, 20);
		contentPane.add(TxtConfirmarContrasena);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{TxtUsuario, TxtContrasena, TxtConfirmarContrasena, cbxAdmin, btnGuardar, btnNuevo, btnSalir}));
		
		
	}
}
