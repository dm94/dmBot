package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class IConfigBD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IConfigBD dialog = new IConfigBD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IConfigBD() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(IConfigBD.class.getResource("/data/logo.png")));
		setTitle("Configuraci\u00F3n de la base de datos");
		setBounds(100, 100, 271, 245);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTipoDeLa = new JLabel("MySQL:");
		lblTipoDeLa.setBounds(10, 11, 46, 14);
		contentPanel.add(lblTipoDeLa);
		
		JLabel label_1 = new JLabel("IP del servidor:");
		label_1.setBounds(10, 36, 87, 20);
		contentPanel.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(107, 36, 138, 20);
		contentPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(107, 67, 138, 20);
		contentPanel.add(textField_1);
		
		JLabel label_2 = new JLabel("Usuario:");
		label_2.setBounds(10, 67, 87, 20);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("Contrase\u00F1a:");
		label_3.setBounds(10, 98, 87, 20);
		contentPanel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(107, 98, 138, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(107, 129, 138, 20);
		contentPanel.add(textField_3);
		
		JLabel label_4 = new JLabel("Nombre de la BD:");
		label_4.setBounds(10, 129, 87, 20);
		contentPanel.add(label_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
