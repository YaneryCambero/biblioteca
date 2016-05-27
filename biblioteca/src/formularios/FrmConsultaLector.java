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

import clases.ConsultarLector;

@SuppressWarnings("serial")
public class FrmConsultaLector extends JDialog {

	private JPanel contentPane;
	Vector<Vector<String>> datosDeFilas = new Vector<Vector<String>>();
	Vector<String> nombreColumnas = new Vector<String>();
	private JTextField txtBuscarPor;
	private JTable table;
	DefaultTableModel modeloTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaLector frame = new FrmConsultaLector();
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
	public FrmConsultaLector() {
		setTitle("Lectores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConsultaLector.class.getResource("/imagenes/Line Chart.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 974, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLectores = new JLabel("Consulta de Lectores");
		lblLectores.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblLectores.setBounds(297, 16, 230, 19);
		contentPane.add(lblLectores);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscarPor.setBounds(257, 48, 119, 14);
		contentPane.add(lblBuscarPor);
		
		JComboBox<Object> cbxBuscarPor = new JComboBox<Object>();
		cbxBuscarPor.setModel(new DefaultComboBoxModel<Object>(new String[] {"Codigo", "Nombre", "Apellido"}));
		cbxBuscarPor.setBounds(394, 45, 193, 20);
		contentPane.add(cbxBuscarPor);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbxBuscarPor.setSelectedIndex(0);
				txtBuscarPor.setText("");
				table.setModel(new DefaultTableModel());
			}
		});
		btnNuevo.setBounds(599, 12, 81, 23);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaLector.this.dispose();
			}
		});
		btnSalir.setBounds(599, 44, 81, 23);
		contentPane.add(btnSalir);
		
		table = new JTable(modeloTabla);
		table.setBounds(91, 233, 252, -73);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 120, 935, 200);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);
				
		
		JLabel lblTotalDeRegistros = new JLabel("Total de registros:");
		lblTotalDeRegistros.setBounds(12, 345, 103, 14);
		contentPane.add(lblTotalDeRegistros);
		
		txtBuscarPor = new JTextField();
		txtBuscarPor.setBounds(394, 77, 193, 20);
		contentPane.add(txtBuscarPor);
		txtBuscarPor.setColumns(10);
		
		JLabel lblCriterio = new JLabel("Informacion a buscar:");
		lblCriterio.setBounds(254, 79, 133, 14);
		contentPane.add(lblCriterio);
		
		JLabel lblCantidadRegistrada = new JLabel("0");
		lblCantidadRegistrada.setBounds(122, 344, 55, 16);
		contentPane.add(lblCantidadRegistrada);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarLector consulta;
				int control = 0;
				
				try {
					consulta = new ConsultarLector(cbxBuscarPor.getSelectedIndex(),txtBuscarPor.getText());
					nombreColumnas = consulta.obtenerNombreDeColumnas();
					datosDeFilas = consulta.obtenerDatosFilas();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(FrmConsultaLector.this, "datos no encontrado");
					control = 1;
				}
				if(control == 0){
					lblCantidadRegistrada.setText(String.valueOf(datosDeFilas.size()));	
				}
				
				modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
				table.setModel(modeloTabla);
			}
		});
		btnBuscar.setBounds(599, 76, 81, 23);
		contentPane.add(btnBuscar);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cbxBuscarPor, txtBuscarPor, btnBuscar, btnNuevo, btnSalir}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cbxBuscarPor, txtBuscarPor, btnBuscar, btnNuevo, btnSalir}));
	}
}
