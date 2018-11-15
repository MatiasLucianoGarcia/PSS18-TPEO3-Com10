package PaqueteJuego;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class LoginWindow {

	private JFrame frame;
	private static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int frameWidth = 400;
	private static final int frameHeight = 400;
	private JPanel loginPanel;
	private JButton loginButton, acceptButton;
	private JTextField idTextField;
	private JPasswordField passField;
	
	//Declaro los usuarios
	private static final String admin = "admin";
	private static final String passAdmin = "admin";
	
	private static final String user = "usuario";
	private static final String passUser = "usuario";

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0));
		frame.setResizable(false);
		frame.setTitle("Iniciar Sesión");
		
		frame.setBounds((int) (Xmax * 0.4), (int) (Ymax * 0.3), frameWidth, frameHeight);
		
		loginPanel = new JPanel();
		loginPanel.setBounds((int) (Xmax * 0.21), (int) (Ymax * 0.015), frameWidth, frameHeight);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		loginButton = new JButton("Iniciar Sesión");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		loginButton.setBounds(101, 140, 199, 70);
		
		loginPanel.add(loginButton);
	
		acceptButton = new JButton("Aceptar");
		acceptButton.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		acceptButton.setBounds(101, 206, 199, 42);
		acceptButton.setVisible(false);
		
		loginPanel.add(acceptButton);		
		
		idTextField = new JTextField();
		idTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idTextField.setBounds(101, 71, 199, 32);
		loginPanel.add(idTextField);
		idTextField.setColumns(10);
		idTextField.setVisible(false);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUser.setBounds(101, 36, 99, 26);
		loginPanel.add(lblUser);
		lblUser.setVisible(false);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPass.setBounds(101, 111, 99, 26);
		loginPanel.add(lblPass);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passField.setBounds(101, 150, 199, 31);
		loginPanel.add(passField);
		lblPass.setVisible(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{		
				loginButton.setVisible(false);
				acceptButton.setVisible(true);
				idTextField.setVisible(true);
				passField.setVisible(true);
				lblUser.setVisible(true);
				lblPass.setVisible(true);
				idTextField.requestFocus();
			}
		});
		
		acceptButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{		
				String id = idTextField.getText();
				String pass = passField.getText();
				checkUser(id, pass);
			}
		});
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	private void checkUser(String id, String pass)
	{
		if (id.equals(admin))
		{
			if (pass.equals(passAdmin))
			{
				//Inicia sesion como admin
				AdminWindow adminWindow = new AdminWindow();
				adminWindow.getFrame().setVisible(true);
				frame.dispose();
			}
		}
		else
		{
			if (id.equals(user))
			{
				if (pass.equals(passUser))
				{
					//Inicia sesion como user
					UserWindow userWindow = new UserWindow();
					userWindow.getFrame().setVisible(true);
					frame.dispose();
				}
			}
			else
			{
				//No inicia sesion
				JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				idTextField.setText("");
				passField.setText("");
			}
		}
	}
}
