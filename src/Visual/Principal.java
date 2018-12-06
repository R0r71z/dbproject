package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
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

public class Principal extends JFrame {
	private Dimension dim;
	private JTextField username;
	private JTextField password;

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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		menuBar.add(mnRegistrar);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnRegistrar.add(mntmUsuario);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Artista");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarAutor autor = new RegistrarAutor();
				autor.setVisible(true);
			}
		});
		mnRegistrar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Canci\u00F3n");
		mnRegistrar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Album");
		mnRegistrar.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("Listar");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Canci\u00F3n");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmAlbum = new JMenuItem("Album");
		mnNewMenu.add(mntmAlbum);
		
		JMenuItem mntmArtista = new JMenuItem("Artista");
		mnNewMenu.add(mntmArtista);
		
		JMenu mnReproducir = new JMenu("Reproducir");
		menuBar.add(mnReproducir);
		
		
		URL url = Principal.class.getResource("/images/bg.gif");
		ImageIcon imageIcon = new ImageIcon(url);
		getContentPane().setLayout(null);
		
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
		
		username = new JTextField();
		username.setBounds(341, 226, 199, 43);
		loginPanel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(341, 121, 199, 43);
		loginPanel.add(password);
		password.setColumns(10);
		
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
				RegistrarUsuario usuario = new RegistrarUsuario();
				usuario.setVisible(true);
			}
		});
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if login is correct
				loginPanel.setVisible(false);
			}
		});
	}
}
