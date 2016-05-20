package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import com.alee.laf.WebLookAndFeel;

import clases.Login;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private LookAndFeelInfo[] apariencias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setLocationRelativeTo(null);
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
	public FrmPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {				
				confirmarCierre();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/imagenes/Loading.png")));
		setType(Type.POPUP);
		setTitle("Sistema Biblioteca");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenuItem mntmCambiarContasena = new JMenuItem("Cambiar contasena");
		mntmCambiarContasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmCambiarContrasena cambiarContrasena = new FrmCambiarContrasena();
				cambiarContrasena.setAlwaysOnTop(true);
				cambiarContrasena.setLocationRelativeTo(null);
				cambiarContrasena.setVisible(true);
			}
		});
		mnSistema.add(mntmCambiarContasena);
		
		JMenuItem mntmCrearUsuario = new JMenuItem("Crear usuario");
		mntmCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCrearCuentaUsuario crearCuentaUsuario = new FrmCrearCuentaUsuario();
				crearCuentaUsuario.setAlwaysOnTop(true);
				crearCuentaUsuario.setLocationRelativeTo(null);
				crearCuentaUsuario.setVisible(true);
			}
		});
		mnSistema.add(mntmCrearUsuario);
		
		JMenuItem mntmCambiarUsuario = new JMenuItem("Cambiar usuario");
		mntmCambiarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLogin login = new FrmLogin();
				FrmPrincipal.this.dispose();
				login.setLocationRelativeTo(null);
				login.setVisible(true);
				
			}
		});
		mnSistema.add(mntmCambiarUsuario);
		
		JSeparator separator = new JSeparator();
		mnSistema.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarCierre();
			}
		});
		mnSistema.add(mntmSalir);
		
		JMenu mnNewMenu = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmBibliliotecario = new JMenuItem("Bibliliotecario");
		mntmBibliliotecario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBibliotecario bibliotecario = new FrmBibliotecario();
				bibliotecario.setAlwaysOnTop(true);
				bibliotecario.setLocationRelativeTo(null);
			    bibliotecario.setVisible(true);	
			}
		});
		mnNewMenu.add(mntmBibliliotecario);
		
		JMenuItem mntmLibro = new JMenuItem("Libro");
		mntmLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmLibro libro = new FrmLibro();
				libro.setAlwaysOnTop(true);
				libro.setLocationRelativeTo(null);
				libro.setVisible(true);
			}
		});
		mnNewMenu.add(mntmLibro);
		
		JMenuItem mntmAutor = new JMenuItem("Autor");
		mntmAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAutor autor = new FrmAutor();
				autor.setAlwaysOnTop(true);
				autor.setLocationRelativeTo(null);
				autor.setVisible(true);
			}
		});
		mnNewMenu.add(mntmAutor);
		
		JMenuItem mntmPrestamo = new JMenuItem("Prestamo");
		mntmPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmPrestamo prestamo = new FrmPrestamo();
				prestamo.setAlwaysOnTop(true);
				prestamo.setLocationRelativeTo(null);
				prestamo.setVisible(true);
			}
		});
		mnNewMenu.add(mntmPrestamo);
		
		JMenuItem mntmLector = new JMenuItem("Lector");
		mntmLector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 FrmLector lector = new FrmLector();
				 lector.setAlwaysOnTop(true);
				 lector.setLocationRelativeTo(null);
				 lector.setVisible(true);
			}
		});
		mnNewMenu.add(mntmLector);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmBibliotecario = new JMenuItem("Bibliotecario");
		mntmBibliotecario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaBibliotecario bibliotecario = new FrmConsultaBibliotecario();
				bibliotecario.setAlwaysOnTop(true);
				bibliotecario.setLocationRelativeTo(null);
				bibliotecario.setVisible(true);
			}
		});
		mnConsultas.add(mntmBibliotecario);
		
		JMenuItem mntmLibros = new JMenuItem("Libros");
		mntmLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaLibros libros = new FrmConsultaLibros();
				libros.setAlwaysOnTop(true);
				libros.setLocationRelativeTo(null);
				libros.setVisible(true);
			}
		});
		mnConsultas.add(mntmLibros);
		
		JMenuItem mntmPrestamos = new JMenuItem("Prestamos");
		mntmPrestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaPrestamo prestamo = new FrmConsultaPrestamo();
				prestamo.setAlwaysOnTop(true);
				prestamo.setLocationRelativeTo(null);
				prestamo.setVisible(true);
			}
		});
		mnConsultas.add(mntmPrestamos);
		
		JMenuItem mntmUsuarioss = new JMenuItem("Lector");
		mntmUsuarioss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaLector consultaLector = new FrmConsultaLector();
				consultaLector.setAlwaysOnTop(true);
				consultaLector.setLocationRelativeTo(null);
				consultaLector.setVisible(true);
			}
		});
		mnConsultas.add(mntmUsuarioss);
		
		JMenuItem mntmDevoluciones = new JMenuItem("Devoluciones");
		mntmDevoluciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmDevoluciones devoluciones = new FrmDevoluciones();
				devoluciones.setAlwaysOnTop(true);
				devoluciones.setLocationRelativeTo(null);
				devoluciones.setVisible(true);
			}
		});
		mnConsultas.add(mntmDevoluciones);
		
		JMenuItem mntmHistorialPrestamo = new JMenuItem("Historial Prestamo");
		mntmHistorialPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmHistorialPrestamo historialPrestamo = new FrmHistorialPrestamo();
				historialPrestamo.setAlwaysOnTop(true);
				historialPrestamo.setLocationRelativeTo(null);
				historialPrestamo.setVisible(true);
			}
		});
		mnConsultas.add(mntmHistorialPrestamo);
		
		JMenuItem mntmEstadoDelSistema = new JMenuItem("Estado del sistema");
		mntmEstadoDelSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmEstadoSistema estadoSistema = new FrmEstadoSistema();
				estadoSistema.setAlwaysOnTop(true);
				estadoSistema.setLocationRelativeTo(null);
				estadoSistema.setVisible(true);
			}
		});
		mnConsultas.add(mntmEstadoDelSistema);
		
		JMenu menuUtilitarios = new JMenu("Utilitarios");
		menuBar.add(menuUtilitarios);
		
		JMenuItem mntmRealizarCopiaDe = new JMenuItem("Realizar copia de seguridad");
		menuUtilitarios.add(mntmRealizarCopiaDe);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmInformacionDelSistema = new JMenuItem("Informacion del sistema");
		mntmInformacionDelSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Los creadores del sistema son:\n\n Nombre                                   Matricula\n"
						+ "\n Heriberto Espino                 100040664"
						+ "\n Wendy Rodriguez               100071795"
						+ "\n Francisco Moran     "
						+ "\n Yanery R. Cambero Hez    100159623");
			}
		});
		mnAyuda.add(mntmInformacionDelSistema);
		contentPane = new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/conmutacion_bibliografica.jpg"));
				g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Biblioteca");
		label.setFont(new Font("Segoe Print", Font.BOLD, 50));
		label.setBounds(215, 58, 259, 61);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Biblioteca");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 50));
		lblNewLabel_1.setBounds(211, 61, 259, 61);
		contentPane.add(lblNewLabel_1);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		apariencias = UIManager.getInstalledLookAndFeels();
		apariencias = Arrays.copyOf( apariencias, apariencias.length + 1 );
		
		LookAndFeelInfo webLAF = new LookAndFeelInfo( "WebLAF", WebLookAndFeel.class.getCanonicalName());
		apariencias[apariencias.length - 1] = webLAF;	
		
		//crear los elementos del menu necesarios para cambiar la apariencia visual de la aplicacion.
		JMenu menuTemas = new JMenu("Temas");
		menuUtilitarios.add(menuTemas);
		
		for (int i = 0; i < apariencias.length; i++) {		
			final JMenuItem menuItemActual = new JMenuItem( apariencias[i].getName() );
			menuTemas.add(menuItemActual);
			menuItemActual.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					cambiarAparienciaVisual( menuItemActual.getText(), apariencias );					
				}
			});
		}		
		cambiarAparienciaVisual("Windows", apariencias);
	}
	
	private void cambiarAparienciaVisual(String apariencia, LookAndFeelInfo[] apariencias) {
		LookAndFeelInfo aparienciaActual = null;
		
		for (int i = 0; i < apariencias.length; i++) {
			if( apariencias[i].getName().equals(apariencia) )			{
				aparienciaActual = apariencias[i];
				break;
			}
		}
		
		if(aparienciaActual != null) {
			
				try {
					UIManager.setLookAndFeel( aparienciaActual.getClassName() );
					SwingUtilities.updateComponentTreeUI(this);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				
					e.printStackTrace();
				}
				
		}
	}

	private void confirmarCierre() {
		int opcion = JOptionPane.showConfirmDialog(this,"desea salir del sistema?","Confirmacion",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if(opcion == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
}
