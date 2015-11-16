package interfaz;
import gestion.TwitchBot;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Toolkit;


public class PantallaCrearCuenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNick;
	private JTextField txtEmail;
	private JTextField txtInfo;
	private TwitchBot bot;
	private boolean botEncendido=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PantallaCrearCuenta dialog = new PantallaCrearCuenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PantallaCrearCuenta() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaCrearCuenta.class.getResource("/data/logo.png")));
		setTitle("Crear Cuenta IRC en Quakenet (En pruebas)");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNick = new JLabel("Introduce el Nick para el bot:");
			lblNick.setBounds(10, 11, 198, 22);
			contentPanel.add(lblNick);
		}
		{
			txtNick = new JTextField();
			txtNick.setBounds(218, 12, 206, 20);
			contentPanel.add(txtNick);
			txtNick.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Introduce tu email \r\n(No puede ser el mismo que el de Azubu):");
			lblEmail.setBounds(10, 44, 414, 20);
			contentPanel.add(lblEmail);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setBounds(10, 66, 414, 20);
			contentPanel.add(txtEmail);
			txtEmail.setColumns(10);
		}
		{
			JLabel lblInfo = new JLabel("Informaci\u00F3n");
			lblInfo.setBounds(10, 114, 93, 14);
			contentPanel.add(lblInfo);
		}
		{
			txtInfo = new JTextField();
			txtInfo.setHorizontalAlignment(SwingConstants.CENTER);
			txtInfo.setText("Esta funcion esta desactivada mira el tutorial");
			txtInfo.setEditable(false);
			txtInfo.setBounds(10, 139, 414, 78);
			contentPanel.add(txtInfo);
			txtInfo.setColumns(10);
		}
		
		JButton btnVerElTutoral = new JButton("Ver el tutoral");
		btnVerElTutoral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop enlace=Desktop.getDesktop();
		        try {
					enlace.browse(new URI("https://www.youtube.com/watch?v=7-1boh0PngI"));
				} catch (IOException e1) {
				} catch (URISyntaxException e1) {
				}
			}
		});
		btnVerElTutoral.setBounds(305, 110, 119, 23);
		contentPanel.add(btnVerElTutoral);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear Cuenta");
				okButton.setToolTipText("");
				okButton.setEnabled(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						crearCuenta();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton bSalir = new JButton("Salir");
				bSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(botEncendido){
							bot.disconnect();
						}
						dispose();
					}
				});
				buttonPane.add(bSalir);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(botEncendido){
							bot.disconnect();
						}
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	
	private void crearCuenta(){
		botEncendido=true;
		String usuario;
		String canalConectarse="dm94";
		String idioma="en";
		String admin="dm94dani";
		String correo;
		
		usuario=txtNick.getText();
		correo=txtEmail.getText();
		
		if(!(usuario.isEmpty() & correo.isEmpty())){
			bot= new TwitchBot(usuario,"azubu."+canalConectarse+"."+idioma,admin);
			bot.setVerbose(true);
			try {
				bot.connect("b0rk.uk.quakenet.org" ,6667);
			} catch (NickAlreadyInUseException e1) {
				txtInfo.setText("Ha habido en al conexión.");
			} catch (IOException e1) {
				txtInfo.setText("Ha habido en al conexión.");
			} catch (IrcException e1) {
				txtInfo.setText("Ha habido en al conexión.");
			}
			
			bot.sendRawLine("MODE "+usuario+" +x");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				txtInfo.setText("No se ha podido crear la cuenta");
			}
			
			
			bot.sendRawLine("/QUERY Q HELLO "+correo+" "+correo);
			txtInfo.setText("La contraseña sera enviada a tu correo.");
		}else{
			txtInfo.setText("Alguno de los campos esta vacio.");
		}
	}
}
