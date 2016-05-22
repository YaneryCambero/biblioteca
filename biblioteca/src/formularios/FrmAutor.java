package formularios;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;


public class FrmAutor extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	
	
	//------------
	
	public Image ImagenFondo;
	public URL Fondo;

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
		

		
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
			
		
		//contentPane = new JPanel();
		
		
		contentPane = new JPanel(){
			
			
			public void paintComponent (Graphics g){
				
				   g.drawImage(ImagenFondo, 0, 0, getWidth(),getHeight(),this);
				
				
			}			
			
		};
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(33, 70, 46, 14);
		lblNewLabel.setForeground(getBackground().pink.darker());;
		contentPane.add(lblNewLabel);

		JLabel lblApelido = new JLabel("Apelido");
		lblApelido.setBounds(33, 95, 46, 14);
		lblApelido.setForeground(getBackground().pink.darker());;
		contentPane.add(lblApelido);

		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(33, 120, 86, 14);
		lblNacionalidad.setForeground(getBackground().pink.darker());;
		contentPane.add(lblNacionalidad);

		textField = new JTextField();
		textField.setBounds(111, 67, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(111, 92, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(112, 117, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(10, 167, 89, 23);
		btnNuevo.setForeground(getBackground().blue.darker());
		contentPane.add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(117, 167, 89, 23);
		btnGuardar.setForeground(getBackground().blue.darker());
		contentPane.add(btnGuardar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(215, 167, 89, 23);
		btnSalir.setForeground(getBackground().blue.darker());
		contentPane.add(btnSalir);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(282, 44, 142, 105);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Registro Autor");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1.setBounds(120, 11, 195, 32);
		contentPane.add(lblNewLabel_1);
		
		//-------------------------
		
		
      	Fondo = this.getClass().getResource("/imagenes/img17.jpg");
      	ImagenFondo = new ImageIcon(Fondo).getImage();
      	
      	
      	
	}
	

	private void setOpaque(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
