package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import java.awt.Dialog.ModalityType;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class FrmDevoluciones extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDevoluciones frame = new FrmDevoluciones();
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
	public FrmDevoluciones() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDevoluciones = new JLabel("Devoluciones");
		lblDevoluciones.setBounds(413, 11, 89, 14);
		contentPane.add(lblDevoluciones);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 133, 934, 199);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);
		
		JButton btnDevolverAlEstante = new JButton("Buscar");
		btnDevolverAlEstante.setBounds(548, 65, 89, 23);
		contentPane.add(btnDevolverAlEstante);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(548, 99, 89, 23);
		contentPane.add(btnSalir);
		
		table = new JTable();
		table.setBounds(20, 238, 387, -132);
		scrollPane.add(table);
		
		JLabel lblBuscarPor = new JLabel("Buscar Por");
		lblBuscarPor.setBounds(277, 69, 67, 14);
		contentPane.add(lblBuscarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fecha", "Codigo"}));
		comboBox.setBounds(413, 66, 94, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(409, 97, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInformacionABuscar = new JLabel("Informacion a Buscar");
		lblInformacionABuscar.setBounds(277, 103, 113, 14);
		contentPane.add(lblInformacionABuscar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(548, 31, 89, 23);
		contentPane.add(btnNuevo);
		
		JLabel lblNewLabel = new JLabel("Total de registros");
		lblNewLabel.setBounds(12, 349, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("0");
		label.setBounds(117, 349, 33, 14);
		contentPane.add(label);
	}
}
