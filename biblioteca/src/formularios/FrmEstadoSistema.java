package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Dialog.ModalityType;

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
		lblEstadoDelSistema.setBounds(143, 26, 89, 14);
		contentPane.add(lblEstadoDelSistema);
		
		JLabel lblTotalDeLibros = new JLabel("Total de Libros");
		lblTotalDeLibros.setBounds(22, 89, 82, 14);
		contentPane.add(lblTotalDeLibros);
		
		JLabel lblLibrosPrestados = new JLabel("Libros Prestados");
		lblLibrosPrestados.setBounds(22, 127, 82, 14);
		contentPane.add(lblLibrosPrestados);
		
		JLabel lblLibrosEn = new JLabel("Libros en Recepcion");
		lblLibrosEn.setBounds(232, 89, 107, 14);
		contentPane.add(lblLibrosEn);
		
		JLabel lblLectoresActivos = new JLabel("Lectores Activos");
		lblLectoresActivos.setBounds(232, 127, 89, 14);
		contentPane.add(lblLectoresActivos);
		
		JLabel label = new JLabel("0");
		label.setBounds(107, 89, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("0");
		label_1.setBounds(107, 127, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("0");
		label_2.setBounds(355, 89, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("0");
		label_3.setBounds(355, 127, 46, 14);
		contentPane.add(label_3);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(39, 191, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(161, 191, 89, 23);
		contentPane.add(btnSalir);
	}

}
