package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clases.ConsultarLector;
import clases.ConsultarPrestamo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dialog.ModalityType;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;

public class FrmConsultaPrestamo extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtBuscarPor;
	Vector<String> nombreColumnas;
	Vector<Vector<String>> datosDeFilas;
	DefaultTableModel modeloTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaPrestamo frame = new FrmConsultaPrestamo();
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
	public FrmConsultaPrestamo() {
		setTitle("Prestamos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConsultaPrestamo.class.getResource("/imagenes/Line Chart.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 974, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrestamos = new JLabel("Consulta de prestamos");
		lblPrestamos.setBounds(386, 12, 136, 20);
		contentPane.add(lblPrestamos);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(284, 49, 69, 14);
		contentPane.add(lblBuscarPor);
		
		JLabel lblTotalDeRegistros = new JLabel("Total de registros:");
		lblTotalDeRegistros.setBounds(10, 344, 110, 14);
		contentPane.add(lblTotalDeRegistros);
		
		JLabel lblCantidadRegistrada = new JLabel("0");
		lblCantidadRegistrada.setBounds(132, 344, 46, 14);
		contentPane.add(lblCantidadRegistrada);
		
		JLabel lblNewLabel = new JLabel("Informacion a buscar:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(229, 82, 124, 16);
		contentPane.add(lblNewLabel);
		
		JComboBox cbxBuscarPor = new JComboBox();
		cbxBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Codigo de prestamo", "Codigo de bibliotecario", "Codigo de libro", "Codigo de lector"}));
		cbxBuscarPor.setBounds(371, 46, 178, 20);
		contentPane.add(cbxBuscarPor);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPrestamo consulta;
				int control = 0;
				
				try {
					consulta = new ConsultarPrestamo(cbxBuscarPor.getSelectedIndex(),txtBuscarPor.getText());
					nombreColumnas = consulta.obtenerNombreDeColumnas();
					datosDeFilas = consulta.obtenerDatosFilas();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(FrmConsultaPrestamo.this, "datos no encontrado");
					control = 1;
				}
				if(control == 0){
					lblCantidadRegistrada.setText(String.valueOf(datosDeFilas.size()));	
				}
				
				modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
				table.setModel(modeloTabla);
			}
		});
		btnBuscar.setBounds(588, 79, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSalir = new JButton("Nuevo");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxBuscarPor.setSelectedIndex(0);
				txtBuscarPor.setText("");
				table.setModel(new DefaultTableModel());
			}
		});
		btnSalir.setBounds(588, 12, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaPrestamo.this.dispose();
			}
		});
		btnNewButton.setBounds(588, 45, 89, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(30, 335, 458, -200);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 120, 935, 200);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);
		
		txtBuscarPor = new JTextField();
		txtBuscarPor.setBounds(371, 80, 178, 20);
		contentPane.add(txtBuscarPor);
		txtBuscarPor.setColumns(10);
	}

}
