package formularios;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import clases.ConsultarLibros;

@SuppressWarnings("serial")
public class FrmConsultaLibros extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtBuscarPor;
	DefaultTableModel modeloTabla;
	Vector<String> nombreColumnas;
	Vector<Vector<String>> datosDeFilas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaLibros frame = new FrmConsultaLibros();
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
	public FrmConsultaLibros() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConsultaLibros.class.getResource("/imagenes/Line Chart.png")));
		setTitle("Libros");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 974, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<Object> cbxBuscarPor = new JComboBox<Object>();
		cbxBuscarPor.setModel(new DefaultComboBoxModel<Object>(new String[] {"Codigo", "Titulo", "Autor"}));
		cbxBuscarPor.setBounds(363, 53, 186, 20);
		contentPane.add(cbxBuscarPor);
		
		JLabel lblLibros = new JLabel("Consulta de libros");
		lblLibros.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblLibros.setBounds(313, 16, 202, 24);
		contentPane.add(lblLibros);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscarPor.setBounds(275, 56, 78, 14);
		contentPane.add(lblBuscarPor);
		
		JLabel lblTotalDeRegistros = new JLabel("Total de registros:");
		lblTotalDeRegistros.setBounds(12, 346, 103, 14);
		contentPane.add(lblTotalDeRegistros);
		
		JLabel lblCantidadRegistrada = new JLabel("0");
		lblCantidadRegistrada.setBounds(127, 346, 46, 14);
		contentPane.add(lblCantidadRegistrada);
		
		JButton btnBuscar = new JButton("Buscar ");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarLibros consulta;
				int control = 0;
				
				try {
					consulta = new ConsultarLibros(cbxBuscarPor.getSelectedIndex(),txtBuscarPor.getText());
					nombreColumnas = consulta.obtenerNombreDeColumnas();
					datosDeFilas = consulta.obtenerDatosFilas();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(FrmConsultaLibros.this, "datos no encontrado");
					control = 1;
				}
				if(control == 0){
					lblCantidadRegistrada.setText(String.valueOf(datosDeFilas.size()));	
				}
				
				modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
				table.setModel(modeloTabla);
			}
		});
		btnBuscar.setBounds(586, 81, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaLibros.this.dispose();
			}
		});
		btnSalir.setBounds(586, 47, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbxBuscarPor.setSelectedIndex(0);
				txtBuscarPor.setText("");
				table.setModel(new DefaultTableModel());
			}
		});
		btnNuevo.setBounds(586, 12, 89, 23);
		contentPane.add(btnNuevo);
		
		table = new JTable();
		table.setBounds(21, 317, 521, -189);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 120, 935, 200);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);
		
		JLabel lblCriterio = new JLabel("Informacion a buscar:");
		lblCriterio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCriterio.setBounds(219, 82, 134, 16);
		contentPane.add(lblCriterio);
		
		txtBuscarPor = new JTextField();
		txtBuscarPor.setBounds(363, 85, 186, 20);
		contentPane.add(txtBuscarPor);
		txtBuscarPor.setColumns(10);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cbxBuscarPor, txtBuscarPor, btnBuscar, btnNuevo, btnSalir}));
		
		
	}
}
