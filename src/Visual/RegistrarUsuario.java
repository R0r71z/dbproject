package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarUsuario dialog = new RegistrarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarUsuario() {
		setTitle("Registrar Usuario");
		setType(Type.UTILITY);
		setResizable(false);
		setBounds(100, 100, 481, 381);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registrar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 455, 297);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setBounds(10, 30, 46, 14);
		panel.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(66, 30, 375, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 75, 91, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 75, 102, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Apellido:");
		lblNewLabel.setBounds(197, 75, 64, 14);
		panel.add(lblNewLabel);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(271, 75, 170, 23);
		panel.add(txtApellido);
		
		JLabel lblNewLabel_1 = new JLabel("Pa\u00EDs:");
		lblNewLabel_1.setBounds(10, 120, 46, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox cbxPais = new JComboBox();
		cbxPais.setBounds(66, 120, 102, 23);
		panel.add(cbxPais);
		
		JLabel lblNewLabel_2 = new JLabel("Sexo:");
		lblNewLabel_2.setBounds(197, 120, 46, 14);
		panel.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setBounds(271, 120, 97, 23);
		panel.add(rdbtnNewRadioButton);
		
		JLabel lblNacimiento = new JLabel("Fecha N:");
		lblNacimiento.setBounds(10, 165, 64, 14);
		panel.add(lblNacimiento);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1543982400000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(66, 162, 102, 23);
		panel.add(spinner);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(197, 165, 46, 14);
		panel.add(lblIdioma);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(271, 162, 170, 23);
		panel.add(comboBox);
		
		JLabel lblUsername = new JLabel("ID:");
		lblUsername.setBounds(10, 210, 46, 14);
		panel.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(66, 210, 102, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setBounds(197, 210, 83, 14);
		panel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(271, 207, 170, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Correo:");
		lblNewLabel_4.setBounds(10, 255, 46, 14);
		panel.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 252, 375, 23);
		panel.add(textField_2);
		textField_2.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
}
