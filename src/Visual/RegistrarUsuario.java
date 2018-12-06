package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;

import logico.DB;
import logico.Pais;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsername;
	private JTextField txtCorreo;
	private JPasswordField passwordField;

	public RegistrarUsuario(DB db) {
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
		
		ArrayList<Pais> paises = db.getPaises();
		JComboBox cbxPais = new JComboBox(paises.toArray());
		cbxPais.setBounds(66, 120, 102, 23);
		panel.add(cbxPais);
		
		JLabel lblNewLabel_2 = new JLabel("Sexo:");
		lblNewLabel_2.setBounds(197, 120, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNacimiento = new JLabel("Fecha N:");
		lblNacimiento.setBounds(10, 165, 64, 14);
		panel.add(lblNacimiento);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1543982400000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(66, 162, 102, 23);
		panel.add(spinner);
		
		JLabel lblUsername = new JLabel("Usuario:");
		lblUsername.setBounds(197, 165, 72, 14);
		panel.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(271, 161, 170, 23);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setBounds(197, 210, 83, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo:");
		lblNewLabel_4.setBounds(10, 255, 46, 14);
		panel.add(lblNewLabel_4);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(66, 252, 375, 23);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(271, 210, 170, 20);
		panel.add(passwordField);
		
		JComboBox cbxSex = new JComboBox();
		cbxSex.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cbxSex.setBounds(271, 120, 53, 20);
		panel.add(cbxSex);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Integer cedula = null;
						try {
							cedula = Integer.valueOf(txtCedula.getText());
						} catch(NumberFormatException er) {
							txtCedula.setText("");
						}
						
						
						String pnombre = txtNombre.getText();
						String papellido = txtApellido.getText();
						int idPais = paises.get(cbxPais.getSelectedIndex()).getCodigo_pais();
						String username = txtUsername.getText();
						String password = String.valueOf(passwordField.getPassword());
						String correo = txtCorreo.getText();
						Date fecha_nacim = (Date) spinner.getValue();
						Integer codigoPersona = db.generateNextCode("persona");
						Integer codigoUsuario = db.generateNextCode("usuario");
						String sexo = cbxSex.getSelectedItem().toString();
						
						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
						String fecha_nac = formatter.format(fecha_nacim);
						
						if (codigoPersona != null && pnombre.length() > 0 && papellido.length() > 0 && fecha_nacim != null
							&& codigoUsuario != null && username.length() > 0 && password.length() > 0) {
							db.registerUser(codigoPersona, codigoUsuario, username, password, pnombre, papellido, idPais, fecha_nac, correo, cedula, sexo);
							dispose();
						}

					}
				});
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