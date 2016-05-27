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

import javax.swing.JButton;
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

import clases.historialPrestamo;

@SuppressWarnings("serial")
public class FrmHistorialPrestamo extends JDialog {

	private JPanel contentPane;
	private JTextField txtCodigoBibliotecario;
	DefaultTableModel modeloTabla;
	Vector<String> nombreColumnas;
	Vector<Vector<String>> datosDeFilas;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmHistorialPrestamo.class.getResource("/imagenes/Line Chart.png")));
		setTitle("Prestamo");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 974, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalDeRegistros = new JLabel("Total de registros:");
		lblTotalDeRegistros.setBounds(12, 344, 103, 14);
		contentPane.add(lblTotalDeRegistros);
		
		JLabel lblCantidadRegistrada = new JLabel("0");
		lblCantidadRegistrada.setBounds(127, 344, 46, 14);
		contentPane.add(lblCantidadRegistrada);
		
		JLabel lblHistorialDePrestamos = new JLabel("Historial de Prestamos");
		lblHistorialDePrestamos.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblHistorialDePrestamos.setBounds(340, 11, 237, 31);
		contentPane.add(lblHistorialDePrestamos);
		
		JLabel lblEscribaElCodigo = new JLabel("Escriba el codigo del bibliotecario:");
		lblEscribaElCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEscribaElCodigo.setBounds(188, 74, 207, 14);
		contentPane.add(lblEscribaElCodigo);
		
		txtCodigoBibliotecario = new JTextField();
		txtCodigoBibliotecario.setBounds(405, 71, 189, 20);
		contentPane.add(txtCodigoBibliotecario);
		txtCodigoBibliotecario.setColumns(10);
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 120, 934, 212);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				historialPrestamo consultaHistorial;
				
				int control = 0;
				
				try {
					consultaHistorial = new historialPrestamo(Integer.parseInt(txtCodigoBibliotecario.getText()));
					nombreColumnas = consultaHistorial.obtenerNombreDeColumnas();
					datosDeFilas = consultaHistorial.obtenerDatosFilas();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(FrmHistorialPrestamo.this, "datos no encontrado");
					control = 1;
				}
				if(control == 0){
					lblCantidadRegistrada.setText(String.valueOf(datosDeFilas.size()));	
				}
				
				modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
				table.setModel(modeloTabla);
			}
		});
		btnBuscar.setBounds(604, 70, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmHistorialPrestamo.this.dispose();
			}
		});
		btnSalir.setBounds(604, 42, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodigoBibliotecario.setText("");
			}
		});
		btnNuevo.setBounds(604, 14, 89, 23);
		contentPane.add(btnNuevo);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtCodigoBibliotecario, btnBuscar, btnSalir, btnNuevo}));
	}
}
