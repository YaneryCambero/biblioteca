package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmDevoluciones extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtBuscar;
	private Vector<Vector<String>> datosDeFilas = new Vector<Vector<String>>();
	private Vector<String> nombreColumnas = new Vector<String>();
	private DefaultTableModel modeloTabla;

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
		setTitle("Devoluciones");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmDevoluciones.class.getResource("/imagenes/Line Chart.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDevoluciones = new JLabel("Consulta Devoluciones");
		lblDevoluciones.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblDevoluciones.setBounds(277, 11, 246, 23);
		contentPane.add(lblDevoluciones);
		
		JLabel lblNewLabel = new JLabel("Total de registros");
		lblNewLabel.setBounds(12, 349, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("0");
		label.setBounds(117, 349, 33, 14);
		contentPane.add(label);
		
		JLabel lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscarPor.setBounds(277, 69, 113, 14);
		contentPane.add(lblBuscarPor);
		
		JLabel lblInformacionABuscar = new JLabel("Informacion a Buscar:");
		lblInformacionABuscar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInformacionABuscar.setBounds(223, 103, 167, 14);
		contentPane.add(lblInformacionABuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(409, 97, 114, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 133, 934, 199);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);
		
		JComboBox cbxBuscarPor = new JComboBox();
		cbxBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Fecha", "Codigo"}));
		cbxBuscarPor.setBounds(410, 66, 113, 20);
		contentPane.add(cbxBuscarPor);
		
		JButton btnDevolverAlEstante = new JButton("Buscar");
		btnDevolverAlEstante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDevolverAlEstante.setBounds(548, 96, 89, 23);
		contentPane.add(btnDevolverAlEstante);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmDevoluciones.this.dispose();
			}
		});
		btnSalir.setBounds(548, 65, 89, 23);
		contentPane.add(btnSalir);
		
		table = new JTable();
		table.setBounds(20, 238, 387, -132);
		scrollPane.add(table);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtBuscar.setText("");
				cbxBuscarPor.setSelectedIndex(0);
				
				datosDeFilas.removeAllElements();
				nombreColumnas.removeAllElements();
				modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
				table.setModel(modeloTabla);
				
			}
		});
		btnNuevo.setBounds(548, 31, 89, 23);
		contentPane.add(btnNuevo);
		
		
	}
}
