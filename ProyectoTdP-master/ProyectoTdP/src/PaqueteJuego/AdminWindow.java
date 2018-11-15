package PaqueteJuego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Agregados.ComentarioWindow;
import Agregados.ListaComentariosAdmin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class AdminWindow {

	private JFrame frame;
	private static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int frameWidth = 400;
	private static final int frameHeight = 400;
	private JPanel adminPanel;
	


	/**
	 * Create the application.
	 */
	public AdminWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Admin");
		
		frame.setBounds((int) (Xmax * 0.4), (int) (Ymax * 0.3), frameWidth, frameHeight);
		
		adminPanel = new JPanel();
		adminPanel.setBounds((int) (Xmax * 0.21), (int) (Ymax * 0.015), frameWidth, frameHeight);
		frame.getContentPane().add(adminPanel);
		adminPanel.setLayout(null);
		
		JButton playButton = new JButton("Jugar");
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		playButton.setBounds(92, 92, 185, 61);
		adminPanel.add(playButton);	
		
		JButton commentButton = new JButton("Ver Comentarios");
		commentButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		commentButton.setBounds(92, 178, 185, 61);
		adminPanel.add(commentButton);
		
		JButton closeButton = new JButton("Cerrar Sesion");
		closeButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		closeButton.setBounds(92, 264, 185, 35);
		adminPanel.add(closeButton);		

		
		JLabel lblAdmin = new JLabel("Administrador");
		lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdmin.setBounds(130, 35, 129, 27);
		adminPanel.add(lblAdmin);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		playButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					GUI guiWindow = new GUI();
					guiWindow.getFrame().setVisible(true);
					frame.dispose();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}				
			}
		});		
	
		commentButton.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent arg0) 
		    {
		        ListaComentariosAdmin  adm = new ListaComentariosAdmin();
		        adm.setVisible(true);
		        frame.dispose();
		    }
		});
		
		
		closeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					LoginWindow lw = new LoginWindow();
					lw.getFrame().setVisible(true);
					frame.dispose();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}				
			}
		});		
		
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
}
