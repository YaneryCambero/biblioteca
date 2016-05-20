package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clases.ConsultaAutor;
import clases.ConsultarBibliotecario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class FrmConsultaAutor extends JFrame {

	private JPanel contentPane;
	Vector<String> nombreColumnas;
	Vector<Vector<String>> datosDeFilas;
	DefaultTableModel modeloTabla;
	private JTextField txtBuscarPor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaAutor frame = new FrmConsultaAutor();
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
	public FrmConsultaAutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaAutor = new JLabel("Consulta Autor");
		lblConsultaAutor.setBounds(140, 11, 102, 14);
		contentPane.add(lblConsultaAutor);
		
		JLabel lblBuscarPor = new JLabel("Buscar por");
		lblBuscarPor.setBounds(60, 54, 71, 14);
		contentPane.add(lblBuscarPor);
		
		JLabel lblCantidadRegistrada = new JLabel("0");
		lblCantidadRegistrada.setBounds(130, 268, 55, 16);
		contentPane.add(lblCantidadRegistrada);
		
		JComboBox cbxBuscarPor = new JComboBox();
		cbxBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Nombre", "Apellido"}));
		cbxBuscarPor.setBounds(140, 48, 87, 20);
		contentPane.add(cbxBuscarPor);
		
		txtBuscarPor = new JTextField();
		txtBuscarPor.setBounds(140, 80, 114, 20);
		contentPane.add(txtBuscarPor);
		txtBuscarPor.setColumns(10);
		
		table = new JTable(modeloTabla);
		table.setBounds(91, 200, 252, -73);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 112, 559, 151);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);

		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int control = 0;
				ConsultaAutor consulta;
				try {
					consulta = new ConsultaAutor(cbxBuscarPor.getSelectedIndex(),txtBuscarPor.getText());
					nombreColumnas = consulta.obtenerNombreDeColumnas();
					datosDeFilas = consulta.obtenerDatosFilas();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(FrmConsultaAutor.this, "Datos no encontrado");
					control = 1;
				}			    
				
				if(control == 0){
					lblCantidadRegistrada.setText(String.valueOf(datosDeFilas.size()));	
				}
				
				modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
				table.setModel(modeloTabla);
			}
		});
		btnBuscar.setBounds(271, 37, 98, 26);
		contentPane.add(btnBuscar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(379, 37, 98, 26);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaAutor.this.dispose();
			}
		});
		btnSalir.setBounds(379, 74, 98, 26);
		contentPane.add(btnSalir);
		
		JLabel lblInformacionABuscar = new JLabel("Informacion a Buscar");
		lblInformacionABuscar.setBounds(10, 82, 131, 16);
		contentPane.add(lblInformacionABuscar);
		
		JLabel lblTotalDeRegistro = new JLabel("Total de registro");
		lblTotalDeRegistro.setBounds(10, 268, 108, 16);
		contentPane.add(lblTotalDeRegistro);
		
		
	}
}
