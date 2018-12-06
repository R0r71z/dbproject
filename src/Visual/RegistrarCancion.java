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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class RegistrarCancion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCancion dialog = new RegistrarCancion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarCancion() {
		setTitle("Registrar Canci\u00F3n");
		setType(Type.UTILITY);
		setResizable(false);
		setBounds(100, 100, 400, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("ID:");
			lblId.setBounds(10, 11, 26, 14);
			contentPanel.add(lblId);
		}
		{
			textField = new JTextField();
			textField.setBounds(66, 8, 66, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblTitulo = new JLabel("Titulo:");
			lblTitulo.setBounds(10, 50, 46, 14);
			contentPanel.add(lblTitulo);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(66, 47, 308, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblDuracin = new JLabel("Duraci\u00F3n:");
			lblDuracin.setBounds(10, 89, 46, 14);
			contentPanel.add(lblDuracin);
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setBounds(66, 86, 66, 20);
			contentPanel.add(spinner);
		}
		{
			JLabel lblMins = new JLabel("Mins");
			lblMins.setBounds(136, 89, 46, 14);
			contentPanel.add(lblMins);
		}
		{
			JLabel lblGenero = new JLabel("Genero:");
			lblGenero.setBounds(192, 89, 46, 14);
			contentPanel.add(lblGenero);
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(240, 86, 134, 20);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Autor:");
		lblNewLabel.setBounds(10, 128, 46, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
