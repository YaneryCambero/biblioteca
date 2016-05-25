package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import clases.CambiarContrasena;

import java.awt.Component;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class FrmCambiarContrasena extends JDialog {

	private JPanel contentPane;
	private JTextField TxtUsuario;
	private JPasswordField TxtContrasenaActual;
	private JPasswordField TxtNuevoContrasena;
	private JPasswordField TxtConfirmarContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCambiarContrasena frame = new FrmCambiarContrasena();
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
	public FrmCambiarContrasena() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCambiarContrasena.class.getResource("/imagenes/PNG-32/Profile.png")));
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setTitle("Cambiar Contrase\u00F1a");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		JLabel lblCambiarConatrena = new JLabel("Cambiar contrase\u00F1a");
		lblCambiarConatrena.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblCambiarConatrena.setBounds(67, 11, 274, 33);
		contentPane.add(lblCambiarConatrena);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(10, 69, 148, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a Actual:");
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setBounds(10, 94, 148, 14);
		contentPane.add(lblContrasena);
		
		JLabel lblNuevaContrasena = new JLabel("Nueva Contrase\u00F1a:");
		lblNuevaContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuevaContrasena.setBounds(10, 119, 148, 14);
		contentPane.add(lblNuevaContrasena);
		
		JLabel lblComprovarContrasena = new JLabel("Comprobar Contrase\u00F1a:");
		lblComprovarContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComprovarContrasena.setBounds(10, 144, 148, 14);
		contentPane.add(lblComprovarContrasena);
		
		TxtUsuario = new JTextField();
		TxtUsuario.setBounds(164, 63, 204, 20);
		contentPane.add(TxtUsuario);
		TxtUsuario.setColumns(10);
		
		TxtContrasenaActual = new JPasswordField();
		TxtContrasenaActual.setBounds(164, 91, 204, 20);
		contentPane.add(TxtContrasenaActual);
		
		TxtNuevoContrasena = new JPasswordField();
		TxtNuevoContrasena.setBounds(164, 116, 204, 20);
		contentPane.add(TxtNuevoContrasena);
		
		TxtConfirmarContrasena = new JPasswordField();
		TxtConfirmarContrasena.setBounds(164, 141, 204, 20);
		contentPane.add(TxtConfirmarContrasena);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TxtUsuario.setText("");
				TxtContrasenaActual.setText("");
				TxtNuevoContrasena.setText("");
				TxtConfirmarContrasena.setText("");
			}
		});
		btnNuevo.setBounds(130, 194, 75, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CambiarContrasena cambiar = new CambiarContrasena(TxtUsuario.getText(), new String(TxtContrasenaActual.getPassword()), new String(TxtNuevoContrasena.getPassword()), new String(TxtConfirmarContrasena.getPassword()));
				TxtUsuario.setText("");
				TxtContrasenaActual.setText("");
				TxtNuevoContrasena.setText("");
				TxtConfirmarContrasena.setText("");
			}
		});
		btnGuardar.setBounds(215, 194, 80, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCambiarContrasena.this.dispose();
			}
		});
		btnSalir.setBounds(306, 194, 64, 23);
		contentPane.add(btnSalir);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{TxtUsuario, TxtContrasenaActual, TxtNuevoContrasena, TxtConfirmarContrasena, btnGuardar, btnNuevo, btnSalir}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{TxtUsuario, TxtContrasenaActual, TxtNuevoContrasena, TxtConfirmarContrasena, btnGuardar, btnNuevo, btnSalir}));
	}
}
