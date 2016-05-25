package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clases.ConsultarBibliotecario;
import clases.ConsultarLector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class FrmConsultaBibliotecario extends JDialog {

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
					FrmConsultaBibliotecario frame = new FrmConsultaBibliotecario();
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
	public FrmConsultaBibliotecario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConsultaBibliotecario.class.getResource("/imagenes/Line Chart.png")));
		setTitle("Bibliotecarios");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 974, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBibliotecarios = new JLabel("Consulta de Bibliotecarios");
		lblBibliotecarios.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblBibliotecarios.setBounds(276, 12, 256, 25);
		contentPane.add(lblBibliotecarios);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("Dialog", Font.BOLD, 12));
		lblBuscarPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscarPor.setBounds(293, 56, 77, 14);
		contentPane.add(lblBuscarPor);
		
		JComboBox cbxBuscarPor = new JComboBox();
		cbxBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Nombre", "Apellido"}));
		cbxBuscarPor.setBounds(391, 53, 173, 20);
		contentPane.add(cbxBuscarPor);
		
		table = new JTable();
		table.setBounds(91, 233, 252, -73);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 120, 934, 212);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaBibliotecario.this.dispose();
			}
		});
		btnSalir.setBounds(620, 52, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbxBuscarPor.setSelectedIndex(0);
				txtBuscarPor.setText("");
				table.setModel(new DefaultTableModel());
			}
		});
		
		JLabel lblTotalDeRegistros = new JLabel("Total de registros:");
		lblTotalDeRegistros.setBounds(12, 344, 103, 16);
		contentPane.add(lblTotalDeRegistros);
		
		JLabel lblCantidadRegistrada = new JLabel("0");
		lblCantidadRegistrada.setBounds(123, 344, 55, 16);
		contentPane.add(lblCantidadRegistrada);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int control = 0;
				ConsultarBibliotecario consulta;
				try {
					consulta = new ConsultarBibliotecario(cbxBuscarPor.getSelectedIndex(),txtBuscarPor.getText());
					nombreColumnas = consulta.obtenerNombreDeColumnas();
					datosDeFilas = consulta.obtenerDatosFilas();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(FrmConsultaBibliotecario.this, "datos no encontrado");
					control = 1;
				}			    
				
				if(control == 0){
					lblCantidadRegistrada.setText(String.valueOf(datosDeFilas.size()));	
				}
				
				modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
				table.setModel(modeloTabla);
			}
		});
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBuscar.setBounds(620, 85, 89, 23);
		contentPane.add(btnBuscar);
		
		
		txtBuscarPor = new JTextField();
		txtBuscarPor.setColumns(10);
		txtBuscarPor.setBounds(388, 88, 176, 20);
		contentPane.add(txtBuscarPor);
		
		JLabel lblCriterio = new JLabel("Informacion a buscar:");
		lblCriterio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCriterio.setBounds(245, 91, 130, 16);
		contentPane.add(lblCriterio);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbxBuscarPor.setSelectedIndex(0);
				txtBuscarPor.setText("");
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton.setBounds(620, 14, 89, 26);
		contentPane.add(btnNewButton);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cbxBuscarPor, txtBuscarPor, btnBuscar, btnNewButton, btnSalir}));
		
		
	}
}
