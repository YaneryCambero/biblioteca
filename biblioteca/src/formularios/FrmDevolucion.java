package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clases.Devolucion;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class FrmDevolucion extends JDialog {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable table;
	private ResultSet resultado;
	private ResultSetMetaData metaDatos;
	private int cantidadColumnas;
	private Vector<Vector<String>> datosDeFilas = new Vector<Vector<String>>();
	private Vector<String> nombreColumnas = new Vector<String>();
	private DefaultTableModel modeloTabla;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDevolucion frame = new FrmDevolucion();
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
	public FrmDevolucion() {
		setTitle("Devolucion Libros");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 974, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(328, 68, 293, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Devolucion consulta = new Devolucion();
					consulta.mostrarDevolucion(txtBuscar.getText());
					resultado = consulta.obtenerDatos();
					
					datosDeFilas.removeAllElements();
					nombreColumnas.removeAllElements();
					txtCodigo.setText("");
					
					if(resultado.next())
					{
					     metaDatos = resultado.getMetaData();
					     
					     cantidadColumnas = metaDatos.getColumnCount();
							for(int i =1; i <= cantidadColumnas; i++)
							{
								 nombreColumnas.add(metaDatos.getColumnName(i));
							}
							
							resultado.beforeFirst();
							while(resultado.next())
							{
								Vector<String> temporal = new Vector<>();
								datosDeFilas.add(temporal);
								for(int i = 1; i<= cantidadColumnas;i++ )
								{
								  temporal.add(resultado.getObject(i).toString());
								}
							}
					}else
					 {
							JOptionPane.showConfirmDialog(null, "Verifique solicitud","No hay datos",JOptionPane.DEFAULT_OPTION);
					 }
					
					
					
					modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
					table.setModel(modeloTabla);
					
					
				} catch (SQLException e) {
					JOptionPane.showConfirmDialog(null, e, "Error",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		btnBuscar.setBounds(633, 67, 89, 23);
		contentPane.add(btnBuscar);
		
		txtCodigo = new JTextField();
		txtCodigo.setVisible(false);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(10, 115, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodigo.setText("");
				
				int row = table.rowAtPoint(e.getPoint());
				
				txtCodigo.setText(table.getValueAt(row, 0).toString());
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setBounds(30, 335, 458, -200);
		
		JScrollPane scrollPane = new JScrollPane(table);;
		scrollPane.setBounds(10, 146, 935, 200);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBackground(Color.BLUE);
		contentPane.add(scrollPane);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscar.setText("");
				txtCodigo.setText("");
				
				datosDeFilas.removeAllElements();
				nombreColumnas.removeAllElements();
				
				modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
				table.setModel(modeloTabla);
			}
		});
		btnNuevo.setBounds(277, 367, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtCodigo.getText().equals("")){
					try {
						Devolucion guardar = new Devolucion();
						guardar.guardarDatos(txtCodigo.getText());
						
						JOptionPane.showConfirmDialog(null, "Datos guardados exitosamente......","Exitoso",JOptionPane.DEFAULT_OPTION);
						
						txtBuscar.setText("");
						txtCodigo.setText("");
						
						datosDeFilas.removeAllElements();
						nombreColumnas.removeAllElements();
						
						modeloTabla = new DefaultTableModel(datosDeFilas, nombreColumnas);
						table.setModel(modeloTabla);
						
					} catch (Exception e1) {
						
					}
				}else{
					JOptionPane.showConfirmDialog(null, "No ha seleccionado ningun elemento","Error",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		btnGuardar.setBounds(443, 367, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmDevolucion.this.dispose();
			}
		});
		btnSalir.setBounds(633, 367, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblIdBibliotecario = new JLabel("Id Bibliotecario:");
		lblIdBibliotecario.setBounds(221, 70, 89, 16);
		contentPane.add(lblIdBibliotecario);
		
		JLabel lblNewLabel = new JLabel("Devolucion");
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel.setBounds(411, 12, 121, 32);
		contentPane.add(lblNewLabel);
		

	}
}
