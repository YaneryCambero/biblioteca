package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.EstadoSistema;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Dialog.ModalityType;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEstadoSistema extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEstadoSistema frame = new FrmEstadoSistema();
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
	public FrmEstadoSistema() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstadoDelSistema = new JLabel("Estado del sistema");
		lblEstadoDelSistema.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblEstadoDelSistema.setBounds(121, 24, 197, 23);
		contentPane.add(lblEstadoDelSistema);
		
		JLabel lblTotalDeLibros = new JLabel("Total de Libros:");
		lblTotalDeLibros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalDeLibros.setBounds(22, 89, 107, 14);
		contentPane.add(lblTotalDeLibros);
		
		JLabel lblLibrosPrestados = new JLabel("Libros Prestados:");
		lblLibrosPrestados.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLibrosPrestados.setBounds(22, 127, 107, 14);
		contentPane.add(lblLibrosPrestados);
		
		JLabel lblLibrosEn = new JLabel("Libros en Recepcion:");
		lblLibrosEn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLibrosEn.setBounds(210, 89, 129, 14);
		contentPane.add(lblLibrosEn);
		
		JLabel lblLectoresActivos = new JLabel("Lectores Activos:");
		lblLectoresActivos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLectoresActivos.setBounds(210, 127, 129, 14);
		contentPane.add(lblLectoresActivos);
		
		EstadoSistema cantidadLibros = new EstadoSistema();
		
		JLabel lblCantidadLibros = new JLabel(Integer.toString(cantidadLibros.mostrarLibros()));
		lblCantidadLibros.setBounds(152, 89, 46, 14);
		contentPane.add(lblCantidadLibros);
		
		EstadoSistema cantidadLibrosPrestado = new EstadoSistema();
		
		JLabel lblCantidadLibrosPrestados = new JLabel(Integer.toString(cantidadLibrosPrestado.mostrarLibrosPrestados()));
		lblCantidadLibrosPrestados.setBounds(152, 127, 46, 14);
		contentPane.add(lblCantidadLibrosPrestados);
		
		EstadoSistema cantidadLibrosEnRecepcion = new EstadoSistema();
		
		JLabel lblCantidadLibrosRecepcion = new JLabel(Integer.toString(cantidadLibrosEnRecepcion.mostrarLibrosEnRecepccion()));
		lblCantidadLibrosRecepcion.setBounds(355, 89, 46, 14);
		contentPane.add(lblCantidadLibrosRecepcion);
		
		EstadoSistema cantidadLectores = new EstadoSistema();
		
		JLabel lblCantidadLectoresActivos = new JLabel(Integer.toString(cantidadLectores.mostrarLector()));
		lblCantidadLectoresActivos.setBounds(355, 127, 46, 14);
		contentPane.add(lblCantidadLectoresActivos);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmEstadoSistema.this.dispose();
			//	JOptionPane.showMessageDialog(null, "Sistema Actualizado");
				FrmEstadoSistema.this.setVisible(true);
			
			}
		});
		btnActualizar.setBounds(107, 188, 110, 23);
		contentPane.add(btnActualizar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmEstadoSistema.this.dispose();
			}
		});
		btnSalir.setBounds(229, 188, 89, 23);
		contentPane.add(btnSalir);
	}

}
