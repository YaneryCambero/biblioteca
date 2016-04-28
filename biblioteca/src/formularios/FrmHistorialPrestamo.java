package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Dialog.ModalityType;

public class FrmHistorialPrestamo extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHistorialPrestamo frame = new FrmHistorialPrestamo();
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
	public FrmHistorialPrestamo() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 974, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHistorialDePrestamos = new JLabel("Historial de Prestamos");
		lblHistorialDePrestamos.setBounds(395, 11, 129, 14);
		contentPane.add(lblHistorialDePrestamos);
		
		JLabel lblEscribaElCodigo = new JLabel("Escriba el codigo del prestamo");
		lblEscribaElCodigo.setBounds(292, 50, 165, 14);
		contentPane.add(lblEscribaElCodigo);
		
		textField = new JTextField();
		textField.setBounds(480, 47, 106, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 120, 934, 212);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(22, 237, 402, -114);
		scrollPane.add(table);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(604, 22, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(604, 46, 89, 23);
		contentPane.add(btnSalir);
	}

}
