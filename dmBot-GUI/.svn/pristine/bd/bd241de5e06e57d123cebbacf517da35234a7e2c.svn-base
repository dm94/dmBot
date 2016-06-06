package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaError extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PantallaError dialog = new PantallaError();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	public PantallaError() {
		setTitle("Error");
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaError.class.getResource("/data/logo.png")));
		setBounds(100, 100, 383, 112);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblError = new JLabel("");
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setBounds(10, 11, 358, 30);
			contentPanel.add(lblError);
		}
		{
			JButton btnNewButton = new JButton("OK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(147, 52, 89, 23);
			contentPanel.add(btnNewButton);
		}
	}
	
	public static void setError(String mensaje){
		lblError.setText(mensaje);
	}

}
