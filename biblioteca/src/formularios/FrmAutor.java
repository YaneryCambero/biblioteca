package formularios;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import clases.Autor;

@SuppressWarnings("serial")
public class FrmAutor extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNacionalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAutor frame = new FrmAutor();
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
	public FrmAutor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAutor.class.getResource("/imagenes/Profile.png")));
		setTitle("Autor");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(71, 57, 57, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblApelido = new JLabel("Apelido:");
		lblApelido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApelido.setBounds(71, 85, 57, 14);
		contentPane.add(lblApelido);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNacionalidad.setBounds(42, 113, 86, 14);
		contentPane.add(lblNacionalidad);
		
		JLabel lblNewLabel_1 = new JLabel("Registro Autor");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel_1.setBounds(130, 11, 156, 32);
		contentPane.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(138, 54, 115, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(138, 82, 115, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(139, 110, 114, 20);
		contentPane.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNombre.setText("");
				txtApellido.setText("");
				txtNacionalidad.setText("");
			}
		});
		btnNuevo.setBounds(71, 165, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					@SuppressWarnings("unused")
					Autor Autor = new Autor(txtNombre.getText(), txtApellido.getText(), txtNacionalidad.getText());
					JOptionPane.showMessageDialog(FrmAutor.this, "Datos Guardados Correctamente");
					
					txtNombre.setText("");
					txtApellido.setText("");
					txtNacionalidad.setText("");
				} catch (SQLException e1) {
					JOptionPane.showConfirmDialog(null, e,"Error",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		btnGuardar.setBounds(170, 165, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAutor.this.dispose();
			}
		});
		btnSalir.setBounds(268, 165, 89, 23);
		contentPane.add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(270, 44, 133, 97);
		contentPane.add(panel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNombre, txtApellido, txtNacionalidad, btnGuardar, btnNuevo, btnSalir}));
	}
}
