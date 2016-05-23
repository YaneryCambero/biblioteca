package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import javax.swing.SwingConstants;

public class FrmLogin extends JDialog {

	private JPanel contentPane;
	private JTextField TxtUsuario;
	private JPasswordField TxtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setLocationRelativeTo(null);
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
	public FrmLogin() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/imagenes/PNG-32/Profile.png")));
		setTitle("Login");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 206);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(45, 47, 66, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setBounds(27, 75, 84, 14);
		contentPane.add(lblContrasena);
		
		TxtUsuario = new JTextField();
		TxtUsuario.setBounds(122, 43, 173, 20);
		contentPane.add(TxtUsuario);
		TxtUsuario.setColumns(10);
		
		TxtContrasena = new JPasswordField();
		TxtContrasena.setBounds(122, 72, 173, 20);
		contentPane.add(TxtContrasena);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setIcon(new ImageIcon(FrmLogin.class.getResource("/imagenes/apply.gif")));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String usuario = TxtUsuario.getText();
				String contrasena = new String(TxtContrasena.getPassword());
				
				if(usuario.equals("")||contrasena.equals(""))
				{
					JOptionPane.showConfirmDialog(null, "Por favor llenar campos","Campos vacios",JOptionPane.DEFAULT_OPTION);
				}else
				 {
					FrmLogin.this.dispose();
					Login inicio = new Login(usuario,contrasena);
				 }
			}
		});
		
		btnEntrar.setBounds(97, 117, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/imagenes/Login-Manager.png")));
		lblNewLabel.setBounds(303, 11, 128, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblLogin.setBounds(177, 0, 89, 33);
		contentPane.add(lblLogin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmLogin.this.dispose();
				
				/*FrmPrincipal formularioPrincipal = new FrmPrincipal();
				formularioPrincipal.setAlwaysOnTop(true);
				formularioPrincipal.setLocationRelativeTo(null);
				formularioPrincipal.setVisible(true);*/
			}
		});
		btnCancelar.setBounds(197, 115, 98, 26);
		contentPane.add(btnCancelar);
		
	}
}
