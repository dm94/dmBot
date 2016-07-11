package interfaz;
import gestion.*;
import data.Idioma;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;

import javax.swing.JToggleButton;

public class Interfaz {
	
	private static String fConfig = "config.txt";
	private static TwitchBot bot;
	private static File f;
	private static BufferedReader in;
	private JFrame frmDmbot;
	private static JTextField txtCanal;
	private static JTextField txtUsuario;
	private static JTextField txtContra;
	private static JLabel estadoGenKey;
	private static JLabel estadoModLinks;
	private static JLabel estadoBot;
	private static JTextField txtAdmin;
	private static JComboBox cbIdioma;
	private static JComboBox cbIdiomaBot;
	private JTextField txtKeyWord;
	private static JLabel estadoSorteo;
	private static JCheckBox checkAviso;
	private static JCheckBox checkAutoSaludo;
	private static JCheckBox checkSiempreVisible;
	private static JLabel lblSorteoGanador;
	private JTextField txtFraseVotacion;
	private static JLabel estadoVotacion;
	private PantallaCrearCuenta crearCuenta=new PantallaCrearCuenta();
	private static IConfigBD pantallaBD=new IConfigBD();
	private static PantallaError pantallaError=new PantallaError();
	private static JList listApuntados;
	private static DefaultListModel listadoDeApuntados = new DefaultListModel();
	private static JTextField txtVTotal;
	private static JTextField txtVAFavor;
	private static JTextField txtVContra;
	private static JTextField txtMSGEnviar;
	private static JList listChat;
	private static DefaultListModel listaMensajesChat = new DefaultListModel();
	private static JScrollPane sPChat;
	private static JTextField txtEstadoCanal;
	private static JTextField txtEstadoViews;
	private static JTextField txtEstadoSeguidores;
	private static JTextField txtEstadoJuego;
	private static JTextField txtEstadoViewsTotales;
	private boolean actulizadorEncendido=false;
	private boolean debug=true;
	private static Idioma idioma=new Idioma("");
	private static Interfaz window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Interfaz("English");
					window.frmDmbot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz(String lenguaje) {
		idioma=new Idioma(lenguaje);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDmbot = new JFrame();
		frmDmbot.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frmDmbot.setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/data/logo.png")));
		frmDmbot.setResizable(false);
		frmDmbot.setTitle("dmBot 3.4 - Made by Dm94 (Twitter: @dm94dani)");
		frmDmbot.setBounds(100, 100, 447, 298);
		frmDmbot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDmbot.getContentPane().setLayout(null);
		
		JTabbedPane panelPrincipal = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		panelPrincipal.setBorder(null);
		panelPrincipal.setBounds(0, 0, 444, 271);
		frmDmbot.getContentPane().add(panelPrincipal);
		
		JPanel panelInfo = new JPanel();
		panelPrincipal.addTab("Info", null, panelInfo, null);
		panelInfo.setLayout(null);
		
		JLabel lblEstado_1 = new JLabel(idioma.getProperty("lbestado"));
		lblEstado_1.setBounds(10, 38, 86, 17);
		panelInfo.add(lblEstado_1);
		
		txtEstadoCanal = new JTextField();
		txtEstadoCanal.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadoCanal.setForeground(new Color(0, 0, 0));
		txtEstadoCanal.setEditable(false);
		txtEstadoCanal.setBounds(106, 36, 71, 20);
		panelInfo.add(txtEstadoCanal);
		txtEstadoCanal.setColumns(10);
		
		JLabel lblViews = new JLabel(idioma.getProperty("lbviewers"));
		lblViews.setBounds(10, 61, 86, 20);
		panelInfo.add(lblViews);
		
		txtEstadoViews = new JTextField();
		txtEstadoViews.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadoViews.setEditable(false);
		txtEstadoViews.setBounds(106, 61, 71, 20);
		panelInfo.add(txtEstadoViews);
		txtEstadoViews.setColumns(10);
		
		JLabel lblSeguidores = new JLabel(idioma.getProperty("lbseguidores"));
		lblSeguidores.setBounds(10, 86, 86, 20);
		panelInfo.add(lblSeguidores);
		
		txtEstadoSeguidores = new JTextField();
		txtEstadoSeguidores.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadoSeguidores.setEditable(false);
		txtEstadoSeguidores.setBounds(106, 86, 71, 20);
		panelInfo.add(txtEstadoSeguidores);
		txtEstadoSeguidores.setColumns(10);
		
		JLabel lblJuego = new JLabel(idioma.getProperty("lbjuego"));
		lblJuego.setBounds(10, 120, 76, 14);
		panelInfo.add(lblJuego);
		
		txtEstadoJuego = new JTextField();
		txtEstadoJuego.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadoJuego.setEditable(false);
		txtEstadoJuego.setBounds(106, 117, 323, 20);
		panelInfo.add(txtEstadoJuego);
		txtEstadoJuego.setColumns(10);
		
		JLabel lblBot = new JLabel(idioma.getProperty("lblbot"));
		lblBot.setBounds(138, 160, 66, 22);
		panelInfo.add(lblBot);
		lblBot.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblModLinks = new JLabel(idioma.getProperty("lblmodlinks"));
		lblModLinks.setBounds(138, 184, 66, 23);
		panelInfo.add(lblModLinks);
		lblModLinks.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblGenkey = new JLabel(idioma.getProperty("lblgenkey"));
		lblGenkey.setBounds(138, 209, 66, 23);
		panelInfo.add(lblGenkey);
		lblGenkey.setHorizontalAlignment(SwingConstants.RIGHT);
		
		estadoBot = new JLabel(idioma.getProperty("off"));
		estadoBot.setBounds(219, 160, 29, 22);
		panelInfo.add(estadoBot);
		estadoBot.setHorizontalAlignment(SwingConstants.CENTER);
		
		estadoModLinks = new JLabel(idioma.getProperty("off"));
		estadoModLinks.setBounds(219, 184, 29, 23);
		panelInfo.add(estadoModLinks);
		estadoModLinks.setHorizontalAlignment(SwingConstants.CENTER);
		
		estadoGenKey = new JLabel(idioma.getProperty("off"));
		estadoGenKey.setBounds(219, 209, 29, 23);
		panelInfo.add(estadoGenKey);
		estadoGenKey.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bIniciar = new JButton(idioma.getProperty("biniciar"));
		bIniciar.setBounds(281, 160, 148, 23);
		panelInfo.add(bIniciar);
		
		JButton bModsLinks = new JButton(idioma.getProperty("bmodlinks"));
		bModsLinks.setBounds(281, 184, 148, 23);
		panelInfo.add(bModsLinks);
		
		JButton bGenKey = new JButton(idioma.getProperty("bgenkey"));
		bGenKey.setBounds(281, 209, 148, 23);
		panelInfo.add(bGenKey);
		
		JLabel lblViewsT = new JLabel(idioma.getProperty("lblviewst"));
		lblViewsT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblViewsT.setBounds(187, 39, 116, 14);
		panelInfo.add(lblViewsT);
		
		txtEstadoViewsTotales = new JTextField();
		txtEstadoViewsTotales.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadoViewsTotales.setEditable(false);
		txtEstadoViewsTotales.setBounds(305, 36, 124, 20);
		panelInfo.add(txtEstadoViewsTotales);
		txtEstadoViewsTotales.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(idioma.getProperty("lbldatoscanal"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 419, 14);
		panelInfo.add(lblNewLabel_2);
		
		JButton btnIrAlCanal = new JButton(idioma.getProperty("biracanal"));
		btnIrAlCanal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop enlace=Desktop.getDesktop();
		        try {
					enlace.browse(new URI("http://adf.ly/9079441/www.azubu.tv/"+Canal.getCanal()));
				} catch (IOException e1) {
				} catch (URISyntaxException e1) {
				}
			}
		});
		btnIrAlCanal.setBounds(10, 209, 118, 23);
		panelInfo.add(btnIrAlCanal);
		bGenKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isGenKey()){
					Config.desactivarGenKey();
				}else{
					Config.activarGenKey();
				}
				actualizarEstados();
			}
		});
		bModsLinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isModLinks()){
					Config.desactivarModLinks();
				}else{
					Config.activarModLinks();
				}
				actualizarEstados();
			}
		});
		bIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isBot()){
					pararBot();
				}else{
					String admin;
					if(txtAdmin.getText().length()>0){
						admin = txtAdmin.getText();
					}else{
						admin = txtCanal.getText();
					}
					
					if(actulizadorEncendido){
						mostrarError(idioma.getProperty("errorautoupdateencendido"));
					}else{
						Canal.setCanal(txtCanal.getText());
						ActualizadorEstado actu=new ActualizadorEstado();
						actu.run();
						actulizadorEncendido=true;
					}
					try {
						crearBot(Canal.getCanal(),Canal.getIdiomaIRC(),Canal.getUsuarioIRC(),Canal.getPassIRC(),admin);
						Config.activarBot();
						actualizarEstados();
					} catch (NickAlreadyInUseException e1) {
						mostrarError(idioma.getProperty("erroryaexisteusuario"));
					} catch (IOException e1) {
						e1.printStackTrace();
						mostrarError(idioma.getProperty("errorleerdatos"));
					} catch (IrcException e1) {
						mostrarError(idioma.getProperty("errorconexion"));
					}
				}
			}
		});
		
		JPanel panelConfig = new JPanel();
		panelConfig.setBorder(null);
		panelConfig.setForeground(Color.WHITE);
		panelPrincipal.addTab(idioma.getProperty("config"), null, panelConfig, idioma.getProperty("lblconfigbot"));
		panelConfig.setLayout(null);
		
		JButton bCrearCuenta = new JButton(idioma.getProperty("lblcrearcuenta"));
		bCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCuenta.setVisible(true);
				crearCuenta.hasFocus();
			}
		});
		bCrearCuenta.setBounds(231, 209, 198, 23);
		panelConfig.add(bCrearCuenta);
		
		JLabel lblCanal = new JLabel(idioma.getProperty("lblcanal"));
		lblCanal.setBounds(10, 11, 95, 14);
		panelConfig.add(lblCanal);
		
		txtCanal = new JTextField();
		txtCanal.setToolTipText(idioma.getProperty("lblcanalhelp"));
		txtCanal.setBounds(121, 8, 124, 20);
		panelConfig.add(txtCanal);
		txtCanal.setColumns(10);
		
		JLabel lblIdioma = new JLabel(idioma.getProperty("lblidioma"));
		lblIdioma.setBounds(10, 36, 95, 14);
		panelConfig.add(lblIdioma);
		
		JLabel lblUsuario = new JLabel(idioma.getProperty("lblusuario"));
		lblUsuario.setBounds(10, 64, 95, 14);
		panelConfig.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText(idioma.getProperty("lblusuarioayuda"));
		txtUsuario.setBounds(121, 61, 124, 20);
		panelConfig.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContra = new JLabel(idioma.getProperty("lblcontra"));
		lblContra.setBounds(10, 92, 95, 14);
		panelConfig.add(lblContra);
		
		txtContra = new JTextField();
		txtContra.setToolTipText(idioma.getProperty("lblcontrahelp"));
		txtContra.setBounds(121, 89, 124, 20);
		panelConfig.add(txtContra);
		txtContra.setColumns(10);
		
		JButton bGuardar = new JButton(idioma.getProperty("bguardar"));
		bGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearConfig();
			}
		});
		bGuardar.setBounds(281, 7, 148, 23);
		panelConfig.add(bGuardar);
		
		JLabel lblAdmin = new JLabel(idioma.getProperty("lbladmin"));
		lblAdmin.setBounds(10, 120, 95, 20);
		panelConfig.add(lblAdmin);
		
		txtAdmin = new JTextField();
		txtAdmin.setToolTipText(idioma.getProperty("lbladminhelp"));
		txtAdmin.setColumns(10);
		txtAdmin.setBounds(121, 120, 124, 20);
		panelConfig.add(txtAdmin);
		
		cbIdioma = new JComboBox();
		cbIdioma.setToolTipText(idioma.getProperty("cbidioma"));
		cbIdioma.setBounds(121, 33, 124, 20);
		panelConfig.add(cbIdioma);
		
		cbIdioma.addItem("en");
		cbIdioma.addItem("es");
		
		JButton bCerrar = new JButton(idioma.getProperty("bcerrar"));
		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionInterfazPrincipal.pararPrograma();
			}
		});
		bCerrar.setBounds(281, 36, 148, 23);
		panelConfig.add(bCerrar);
		
		checkAutoSaludo = new JCheckBox(idioma.getProperty("checkautosaludo"));
		checkAutoSaludo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkAutoSaludo.isSelected()){
					Config.activarAutoSaludo();
				}else{
					Config.desactivarAutoSaludo();
				}
			}
		});
		checkAutoSaludo.setSelected(true);
		checkAutoSaludo.setBounds(281, 66, 148, 23);
		panelConfig.add(checkAutoSaludo);
		
		checkSiempreVisible = new JCheckBox(idioma.getProperty("checksiemprevisible"));
		checkSiempreVisible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkSiempreVisible.isSelected()){
					frmDmbot.setAlwaysOnTop(true);
				}else{
					frmDmbot.setAlwaysOnTop(false);
				}
			}
		});
		checkSiempreVisible.setBounds(281, 88, 148, 23);
		panelConfig.add(checkSiempreVisible);
		
		JLabel lblIdiomaDelBot = new JLabel(idioma.getProperty("idiomabot"));
		lblIdiomaDelBot.setBounds(10, 151, 95, 20);
		panelConfig.add(lblIdiomaDelBot);
		
		cbIdiomaBot = new JComboBox();
		cbIdiomaBot.setBounds(121, 151, 124, 20);
		panelConfig.add(cbIdiomaBot);
		
		cbIdiomaBot.addItem("Español");
		cbIdiomaBot.addItem("English");
		
		JButton btnCambiarIdioma = new JButton(idioma.getProperty("cambiaridioma"));
		btnCambiarIdioma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interfaz windows= new Interfaz(cbIdiomaBot.getSelectedItem().toString());
				windows.frmDmbot.setVisible(true);
				try {
					window.frmDmbot.dispose();
				} catch (Throwable e) {
				}
			}
		});
		btnCambiarIdioma.setBounds(10, 209, 124, 23);
		panelConfig.add(btnCambiarIdioma);
		
		JPanel panelSorteo = new JPanel();
		panelSorteo.setBorder(null);
		panelPrincipal.addTab(idioma.getProperty("sorteo"), null, panelSorteo, idioma.getProperty("sorteohelp"));
		panelSorteo.setLayout(null);
		
		JLabel lblPalabra = new JLabel(idioma.getProperty("lblpalabra"));
		lblPalabra.setBounds(10, 40, 202, 14);
		panelSorteo.add(lblPalabra);
		
		txtKeyWord = new JTextField();
		txtKeyWord.setText("@gzone");
		txtKeyWord.setBounds(10, 60, 172, 20);
		panelSorteo.add(txtKeyWord);
		txtKeyWord.setColumns(10);
		
		JButton bIniciarSorteo = new JButton(idioma.getProperty("biniciarsorteo"));
		bIniciarSorteo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isBot()){
					if(Config.isSorteo()){
						mostrarError(idioma.getProperty("errorsorteoenmarcha"));
					}else{
						iniciarSorteo();
					}
				}else{
					mostrarError(idioma.getProperty("errorbotencendido"));
				}
			}
		});
		bIniciarSorteo.setBounds(10, 117, 237, 23);
		panelSorteo.add(bIniciarSorteo);
		
		JButton bSacarGanador = new JButton(idioma.getProperty("bsacarganador"));
		bSacarGanador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isBot()){
					if(Config.isSorteo()){
						sacarGanador();
					}else{
						mostrarError(idioma.getProperty("errorbotnoenmarcha"));
					}
				}else{
					mostrarError(idioma.getProperty("errorbotencendido"));
				}
			}
		});
		bSacarGanador.setBounds(10, 151, 237, 23);
		panelSorteo.add(bSacarGanador);
		
		JLabel lblApuntados = new JLabel(idioma.getProperty("lblapuntados"));
		lblApuntados.setBounds(257, 11, 172, 14);
		panelSorteo.add(lblApuntados);
		
		checkAviso = new JCheckBox(idioma.getProperty("checkaviso"));
		checkAviso.setSelected(true);
		checkAviso.setBounds(10, 87, 225, 23);
		panelSorteo.add(checkAviso);
		
		lblSorteoGanador = new JLabel("");
		lblSorteoGanador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSorteoGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblSorteoGanador.setBounds(18, 187, 217, 45);
		panelSorteo.add(lblSorteoGanador);
		
		JLabel lblSorteo = new JLabel(idioma.getProperty("lblestadosorteo"));
		lblSorteo.setBounds(10, 11, 109, 14);
		panelSorteo.add(lblSorteo);
		
		estadoSorteo = new JLabel(idioma.getProperty("off"));
		estadoSorteo.setBounds(166, 11, 46, 14);
		panelSorteo.add(estadoSorteo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(256, 29, 173, 203);
		panelSorteo.add(scrollPane_1);
		
		listApuntados = new JList();
		scrollPane_1.setViewportView(listApuntados);
		listApuntados.setBackground(SystemColor.controlHighlight);
		
		JPanel panelVotacion = new JPanel();
		panelVotacion.setBorder(null);
		panelPrincipal.addTab(idioma.getProperty("votacion"), null, panelVotacion, idioma.getProperty("votacionhelp"));
		panelVotacion.setLayout(null);
		
		JLabel lblVotacion = new JLabel(idioma.getProperty("estadovotacion"));
		lblVotacion.setBounds(10, 11, 124, 14);
		panelVotacion.add(lblVotacion);
		
		estadoVotacion = new JLabel(idioma.getProperty("off"));
		estadoVotacion.setBounds(151, 11, 39, 14);
		panelVotacion.add(estadoVotacion);
		
		JLabel lblTxtVotacion = new JLabel(idioma.getProperty("textovotacion"));
		lblTxtVotacion.setBounds(10, 36, 161, 20);
		panelVotacion.add(lblTxtVotacion);
		
		txtFraseVotacion = new JTextField();
		txtFraseVotacion.setBounds(151, 36, 278, 20);
		panelVotacion.add(txtFraseVotacion);
		txtFraseVotacion.setColumns(10);
		
		JButton bIniciarVotacion = new JButton(idioma.getProperty("biniciarvotacion"));
		bIniciarVotacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isBot()){
					if(Config.isVotacion()){
						mostrarError(idioma.getProperty("errorvotacionencendida"));
					}else{
						iniciarVotacion();
					}
				}else{
					mostrarError(idioma.getProperty("errorbotencendido"));
				}
			}
		});
		bIniciarVotacion.setBounds(10, 84, 419, 23);
		panelVotacion.add(bIniciarVotacion);
		
		JButton bPararVotacion = new JButton(idioma.getProperty("bpararvotacion"));
		bPararVotacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isBot()){
					if(Config.isVotacion()){
						gestionInterfazPrincipal.pararVotacion();
					}else{
						mostrarError(idioma.getProperty("errorvotacionapagada"));
					}
				}else{
					mostrarError(idioma.getProperty("errorbotencendido"));
				}
			}
		});
		bPararVotacion.setBounds(10, 118, 419, 23);
		panelVotacion.add(bPararVotacion);
		
		JLabel lblVTotal = new JLabel(idioma.getProperty("lblvotostotal"));
		lblVTotal.setBounds(10, 152, 124, 20);
		panelVotacion.add(lblVTotal);
		
		JLabel lblVAFavor = new JLabel(idioma.getProperty("lblvotosfavor"));
		lblVAFavor.setBounds(10, 177, 124, 20);
		panelVotacion.add(lblVAFavor);
		
		JLabel lblNewLabel = new JLabel(idioma.getProperty("lblvotoscontra"));
		lblNewLabel.setBounds(10, 202, 124, 20);
		panelVotacion.add(lblNewLabel);
		
		txtVTotal = new JTextField();
		txtVTotal.setEditable(false);
		txtVTotal.setBackground(UIManager.getColor("Button.background"));
		txtVTotal.setBounds(151, 152, 86, 20);
		panelVotacion.add(txtVTotal);
		txtVTotal.setColumns(10);
		
		txtVAFavor = new JTextField();
		txtVAFavor.setEditable(false);
		txtVAFavor.setColumns(10);
		txtVAFavor.setBackground(SystemColor.menu);
		txtVAFavor.setBounds(151, 177, 86, 20);
		panelVotacion.add(txtVAFavor);
		
		txtVContra = new JTextField();
		txtVContra.setEditable(false);
		txtVContra.setColumns(10);
		txtVContra.setBackground(SystemColor.menu);
		txtVContra.setBounds(151, 202, 86, 20);
		panelVotacion.add(txtVContra);
		
		JButton btnAadirVotoA = new JButton(idioma.getProperty("aniadirvoto"));
		btnAadirVotoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isVotacion()){
					Votacion.aniadirVotoFavor();
				}
			}
		});
		btnAadirVotoA.setBounds(247, 176, 182, 23);
		panelVotacion.add(btnAadirVotoA);
		
		JButton btnNewButton = new JButton(idioma.getProperty("aniadirvotocontra"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isVotacion()){
					Votacion.aniadirVotoContra();
				}
			}
		});
		btnNewButton.setBounds(247, 201, 182, 23);
		panelVotacion.add(btnNewButton);
		
		JPanel panelChat = new JPanel();
		panelChat.setBorder(null);
		panelPrincipal.addTab(idioma.getProperty("chatbot"), null, panelChat, null);
		panelChat.setLayout(null);
		
		JButton bChatEnviar = new JButton(idioma.getProperty("benviar"));
		bChatEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Config.isBot()){
					if(txtMSGEnviar.getText().length()>0){
						mandarMensaje(TwitchBot.getCanal(), txtMSGEnviar.getText());
						txtMSGEnviar.setText("");
					}else{
						aniadirMensajeChat(idioma.getProperty("error"),idioma.getProperty("errornotexto"));
					}
				}else{
					aniadirMensajeChat(idioma.getProperty("error"),idioma.getProperty("errorbotencendido"));
				}
			}
			
		});
		bChatEnviar.setBounds(327, 209, 112, 34);
		panelChat.add(bChatEnviar);
		
		txtMSGEnviar = new JTextField();
		txtMSGEnviar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER){
					if(Config.isBot()){
						if(txtMSGEnviar.getText().length()>0){
							mandarMensaje(TwitchBot.getCanal(), txtMSGEnviar.getText());
							txtMSGEnviar.setText("");
						}else{
							aniadirMensajeChat(idioma.getProperty("error"),idioma.getProperty("errornotexto"));
						}
					}else{
						aniadirMensajeChat(idioma.getProperty("error"),idioma.getProperty("errorbotencendido"));
					}
				}
			}
		});
		txtMSGEnviar.setBounds(0, 209, 327, 34);
		panelChat.add(txtMSGEnviar);
		txtMSGEnviar.setColumns(10);
		
		sPChat = new JScrollPane();
		sPChat.setBounds(0, 0, 439, 209);
		panelChat.add(sPChat);
		
		listChat = new JList();
		listChat.setBackground(SystemColor.controlHighlight);
		sPChat.setViewportView(listChat);
		
		JPanel panelPuntos = new JPanel();
		panelPuntos.setBorder(null);
		panelPrincipal.addTab(idioma.getProperty("puntos"), null, panelPuntos, null);
		panelPrincipal.setEnabledAt(5, false);
		panelPuntos.setLayout(null);
		
		JButton btnConfiguracin = new JButton(idioma.getProperty("config"));
		btnConfiguracin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pantallaBD.setVisible(true);
				pantallaBD.hasFocus();
			}
		});
		btnConfiguracin.setBounds(295, 11, 134, 23);
		panelPuntos.add(btnConfiguracin);
		
		JPanel consola = new JPanel();
		if(debug){
			consola.setBorder(null);
			panelPrincipal.addTab(idioma.getProperty("consola"), null, consola, null);
			panelPrincipal.setEnabledAt(6, true);
			consola.setLayout(null);	
		}else{
			consola.setVisible(false);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 439, 243);
		consola.add(scrollPane);
		
		JTextArea txtConsola = new JTextArea();
		scrollPane.setViewportView(txtConsola);
		txtConsola.setEditable(false);
		txtConsola.setLineWrap(true);
		
		PrintStream con=new PrintStream(new TextAreaOutputStream(txtConsola,7));
		System.setOut(con);
		System.setErr(con);
		
		cargarDatos();
	}
	
	public static void setTxtEstadoCanal(String estado) {
		txtEstadoCanal.setText(estado);
	}

	public static void setTxtEstadoViews(String views) {
		txtEstadoViews.setText(views);
	}

	public static void setTxtEstadoSeguidores(String seguidores) {
		txtEstadoSeguidores.setText(seguidores);
	}

	public static void setTxtEstadoJuego(String juego) {
		txtEstadoJuego.setText(juego);
	}

	public static void setTxtEstadoViewsTotales(String viewsTotales) {
		txtEstadoViewsTotales.setText(viewsTotales);
	}

	private void cargarDatos(){
		f=new File(fConfig);
		if(f.exists()){
			leerConfig(fConfig);
		}else{
			crearConfig();
			leerConfig(fConfig);
		}
	}
	
	public static void crearBot(String canalConectarse,String idioma, String usuario,String contra,String admin) throws NickAlreadyInUseException, IOException, IrcException{
		
		bot= new TwitchBot(usuario,"azubu."+canalConectarse+"."+idioma,admin);
		bot.setVerbose(true);
		bot.connect("euroserv.fr.quakenet.org" ,6667);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bot.sendRawLine("auth "+usuario+" "+contra);
		bot.joinChannel("#azubu."+canalConectarse+"."+idioma);
		
		bot.sendRawLine("MODE "+usuario+" +x");
		bot.sendRawLine("nick "+usuario);
		
		Config.activarBot();
		actualizarEstados();
	}
	
	public static void mandarMensaje(String canalHoster,String mensaje){
		bot.sendMessage("#"+canalHoster,mensaje);
		aniadirMensajeChat(txtUsuario.getText(),mensaje);
	}
	
	public static void mandarComando(String mensaje){
		bot.sendRawLine(mensaje);
	}
	
	public static void mostrarError(String error){
		PantallaError.setError(error);
		pantallaError.setVisible(true);
		pantallaError.hasFocus();
	}
	
	public static void leerConfig(String fConfig){
		String cad = null;
		String canal = null;
		String usuario = null;
		String contra = null;
		String admin = null;
		String idiomas = "";
		int inicio=0;
		int fin=0;
		f=new File(fConfig);
		
		if(!(f.canRead())){
			try {
				f.createNewFile();
			} catch (IOException e) {
				mostrarError(idioma.getProperty("errorarchivoconfig"));
			}
			mostrarError(idioma.getProperty("errornoarchivoconfig"));
		}
		
		FileReader pr;
		try {
			pr = new FileReader(fConfig);
			BufferedReader br=new BufferedReader(pr);
			
			while((cad=br.readLine())!=null){
				if(cad.contains("canal")){
					inicio=cad.indexOf(":");
		            fin=cad.indexOf(";", inicio);
		            canal=cad.substring(inicio+1, fin);
		            txtCanal.setText(canal);
				}else if(cad.contains("idioma")){
					inicio=cad.indexOf(":");
		            fin=cad.indexOf(";", inicio);
		            idiomas=cad.substring(inicio+1, fin);
		            if(idiomas.contains("es")){
		            	cbIdioma.setSelectedIndex(1);
		            }else if(idiomas.contains("en")){
		            	cbIdioma.setSelectedIndex(0);
		            }else{
		            	cbIdioma.setSelectedIndex(0);
		            }
				}else if(cad.contains("usuario")){
					inicio=cad.indexOf(":");
		            fin=cad.indexOf(";", inicio);
		            usuario=cad.substring(inicio+1, fin);
		            txtUsuario.setText(usuario);
				}else if(cad.contains("pass")){
					inicio=cad.indexOf(":");
		            fin=cad.indexOf(";", inicio);
		            contra=cad.substring(inicio+1, fin);
		            txtContra.setText(contra);
				}else if(cad.contains("admin")){
					inicio=cad.indexOf(":");
		            fin=cad.indexOf(";", inicio);
		            admin=cad.substring(inicio+1, fin);
		            txtAdmin.setText(admin);
				}else if(cad.contains("genkey")){
					if(cad.contains("true")){
						Config.activarGenKey();
					}else{
						Config.desactivarGenKey();
					}
				}else if(cad.contains("modlinks")){
					if(cad.contains("true")){
						Config.activarModLinks();
					}else{
						Config.desactivarModLinks();
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			mostrarError(idioma.getProperty("errorarchivoconfig"));
		} catch (IOException e) {
			mostrarError(idioma.getProperty("errorleerconfig"));
		}
		
		
		if(admin==null){
			admin=canal;
		}
		
		if(canal!=null && usuario!=null && contra!=null){
			txtCanal.setText(canal);
			txtUsuario.setText(usuario);
			txtContra.setText(contra);
			txtAdmin.setText(admin);
			
			Canal.setAdmin(admin);
			Canal.setPassIRC(contra);
			Canal.setUsuarioIRC(usuario);
			Canal.setCanal(canal);
			Canal.setIdiomaIRC(idiomas);
			actualizarEstados();
		}else{
			mostrarError(idioma.getProperty("errordatosincorrectos"));
		}
		
	}
	
	private static void crearConfig(){
		File f=new File(fConfig);
		in=new BufferedReader(new InputStreamReader(System.in));
		String canal = txtCanal.getText().toLowerCase();
		String idiomas = (String) cbIdioma.getSelectedItem();
		String usuario = txtUsuario.getText().toLowerCase();
		String pass = txtContra.getText();
		String admin;
		if(txtAdmin.getText().length()>0){
			admin = txtAdmin.getText().toLowerCase();
		}else{
			admin = txtCanal.getText().toLowerCase();
		}
		
		
		if(!(canal.isEmpty() & idiomas.isEmpty() & usuario.isEmpty() & pass.isEmpty() & admin.isEmpty())){
			try {
				FileWriter fw=new FileWriter(f);
				BufferedWriter bw=new BufferedWriter(fw);
				
				bw.write("canal:"+canal+";");
				bw.newLine();
				bw.write("idioma:"+idiomas+";");
				bw.newLine();
				bw.write("usuario:"+usuario+";");
				bw.newLine();
				bw.write("pass:"+pass+";");
				bw.newLine();
				bw.write("admin:"+admin+";");
				bw.newLine();
				if(Config.isGenKey()){
					bw.write("genkey:true;");
					bw.newLine();
				}else{
					bw.write("genkey:false;");
					bw.newLine();
				}
				if(Config.isModLinks()){
					bw.write("modlinks:true;");
					bw.newLine();
				}else{
					bw.write("modlinks:false;");
					bw.newLine();
				}
				bw.close();
				fw.close();
			} catch (IOException e) {
				mostrarError(idioma.getProperty("errorguardararchivo"));
			}
		}else{
			mostrarError(idioma.getProperty("errorcamposvacios"));
		}
		
		leerConfig(fConfig);
	}
	
	public static void guardarConfig(){
		File f=new File(fConfig);
		try {
			FileWriter fw=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			
			bw.write("canal:"+Canal.getCanal()+";");
			bw.newLine();
			bw.write("idioma:"+Canal.getIdiomaIRC()+";");
			bw.newLine();
			bw.write("usuario:"+Canal.getUsuarioIRC()+";");
			bw.newLine();
			bw.write("pass:"+Canal.getPassIRC()+";");
			bw.newLine();
			bw.write("admin:"+Canal.getAdmin()+";");
			bw.newLine();
			if(Config.isGenKey()){
				bw.write("genkey:true;");
				bw.newLine();
			}else{
				bw.write("genkey:false;");
				bw.newLine();
			}
			if(Config.isModLinks()){
				bw.write("modlinks:true;");
				bw.newLine();
			}else{
				bw.write("modlinks:false;");
				bw.newLine();
			}
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			mostrarError(idioma.getProperty("errorguardararchivo"));
		}
	}
	
	public static void actualizarEstados(){
		if(Config.isBot()){
			estadoBot.setText(idioma.getProperty("on"));
		}else{
			estadoBot.setText(idioma.getProperty("off"));
		}
		
		if(Config.isGenKey()){
			estadoGenKey.setText(idioma.getProperty("on"));
		}else{
			estadoGenKey.setText(idioma.getProperty("off"));
		}
		
		if(Config.isModLinks()){
			estadoModLinks.setText(idioma.getProperty("on"));
		}else{
			estadoModLinks.setText(idioma.getProperty("off"));
		}
		
		if(Config.isSorteo()){
			estadoSorteo.setText(idioma.getProperty("on"));
		}else{
			estadoSorteo.setText(idioma.getProperty("off"));
		}
		
		if(Config.isVotacion()){
			estadoVotacion.setText(idioma.getProperty("on"));
		}else{
			estadoVotacion.setText(idioma.getProperty("off"));
		}
		
		if(Config.isAutoSaludo()){
			checkAutoSaludo.setSelected(true);
		}else{
			checkAutoSaludo.setSelected(false);
		}
	}
	
	public void pararBot(){
		bot.disconnect();
		Config.desactivarBot();
		actualizarEstados();
	}
	
	public void iniciarSorteo(){
		TwitchBot.setKeyWord(txtKeyWord.getText());
		mandarMensaje(TwitchBot.getCanal(),idioma.getProperty("sorteoenmarcha")+" "+txtKeyWord.getText());
		Sorteo.inciarSorteo();
		
		Config.activarSorteo();
		actualizarEstados();
		listadoDeApuntados.clear();
	}
	
	public static void aniadirApuntado(String apuntado){
		listadoDeApuntados.addElement(apuntado);
		
		listApuntados.setModel(listadoDeApuntados);
	}
	
	public void sacarGanador(){
		String ganador;
		
		Config.desactivarSorteo();
		ganador=Sorteo.sacarGanador();
		
		lblSorteoGanador.setText(idioma.getProperty("elganador")+" "+ganador);
		
		if(checkAviso.isSelected()){
			mandarMensaje(TwitchBot.getCanal(),idioma.getProperty("elganador")+" @"+ganador);
		}
		
		actualizarEstados();
	}
	
	public void iniciarVotacion(){
		Votacion.iniciarVotacion("@"+idioma.getProperty("votacion")+" "+txtFraseVotacion.getText());
		Interfaz.mandarMensaje(TwitchBot.getCanal(), idioma.getProperty("lavotacion")+" \""+Votacion.getMensaje()+"\" "+idioma.getProperty("haempezado"));
		Interfaz.mandarMensaje(TwitchBot.getCanal(), idioma.getProperty("ponedmasuno"));
		Interfaz.mandarMensaje(TwitchBot.getCanal(), idioma.getProperty("ponedmenosuno"));
		Config.activarVotacion();
		actualizarEstados();
	}
	
	public static void actualizarVotacion(){
		txtVTotal.setText(Integer.toString(Votacion.getApuntados()));
		txtVAFavor.setText(Integer.toString(Votacion.getaFavor()));
		txtVContra.setText(Integer.toString(Votacion.getEnContra()));
	}
	
	public static void aniadirMensajeChat(String usuario,String mensaje){
		
		if(mensaje.contains("8") && mensaje.length()>4){
			mensaje=mensaje.substring(0,mensaje.length()-3);
		}else if(mensaje.contains("6") && mensaje.length()>4){
			mensaje=mensaje.substring(0,mensaje.length()-3);
		}else if(mensaje.contains("1") && mensaje.length()>4){
			mensaje=mensaje.substring(0,mensaje.length()-3);
		}else if(mensaje.contains("10") && mensaje.length()>5){
			mensaje=mensaje.substring(0,mensaje.length()-4);
		}else if(mensaje.contains("0") && mensaje.length()>5){
			mensaje=mensaje.substring(0,mensaje.length()-4);
		}else if(mensaje.contains("") && mensaje.length()>5){
			mensaje=mensaje.substring(0,mensaje.length()-4);
		}
		
		listaMensajesChat.addElement(usuario+" : "+mensaje);
		listChat.setModel(listaMensajesChat);
		
		sPChat.getVerticalScrollBar().setValue(sPChat.getVerticalScrollBar().getMaximum());
	}
}
