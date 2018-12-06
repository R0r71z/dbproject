package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import logico.DB;
import logico.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.Icon;

public class Principal extends JFrame {
	private Dimension dim;
	private JTextField usernameField;
	private JTextField passwordField;
	private DB db = new DB();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Spotify");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 540);
		setLocationRelativeTo(null);
		
		
		URL url = Principal.class.getResource("/images/bg.gif");
		ImageIcon imageIcon = new ImageIcon(url);
		getContentPane().setLayout(null);
		
		JPanel homePanel = new JPanel();
		homePanel.setLayout(null);
		homePanel.setBounds(0, 0, 600, 480);
		getContentPane().add(homePanel);
		
		JLabel welcomeLbl = new JLabel("Bienvenido");
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLbl.setForeground(Color.WHITE);
		welcomeLbl.setFont(new Font("SimSun", Font.BOLD, 29));
		welcomeLbl.setBounds(0, 0, 238, 34);
		homePanel.add(welcomeLbl);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 600, 480);
		getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel userLbl = new JLabel("Nombre de usuario");
		userLbl.setBounds(52, 114, 192, 27);
		loginPanel.add(userLbl);
		userLbl.setHorizontalAlignment(SwingConstants.LEFT);
		userLbl.setForeground(Color.WHITE);
		userLbl.setFont(new Font("Open Sans", Font.BOLD, 19));
		
		JLabel lblLogin = new JLabel("Iniciar Sesi\u00F3n");
		lblLogin.setBounds(220, 5, 238, 34);
		loginPanel.add(lblLogin);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("SimSun", Font.BOLD, 29));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(52, 219, 114, 27);
		loginPanel.add(lblContrasea);
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Open Sans", Font.BOLD, 19));
		
		usernameField = new JTextField();
		usernameField.setBounds(340, 110, 199, 43);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(340, 215, 199, 43);
		loginPanel.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(200, 334, 199, 43);
		loginPanel.add(btnEntrar);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton btnNewButton = new JButton("Usuario Nuevo?");
		btnNewButton.setBounds(52, 417, 488, 41);
		loginPanel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		JLabel bg = new JLabel(imageIcon);
		bg.setBounds(0, 0, 600, 480);
		loginPanel.add(bg);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuario usuario = new RegistrarUsuario(db);
				usuario.setVisible(true);
			}
		});
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = String.valueOf(((JPasswordField) passwordField).getPassword());
				Usuario user = db.getDBUser(username);
				if (user != null && password != null) {
					if (user.getPassword().equalsIgnoreCase(password)) {
						loginPanel.setVisible(false);
					}	
				}
			}
		});
	}
}
