package PaqueteJuego;

import java.awt.EventQueue;
import Agregados.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserWindow {

	private JFrame frame;
	private static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int frameWidth = 400;
	private static final int frameHeight = 400;
	private JPanel userPanel;

	/**
	 * Create the application.
	 */
	public UserWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Usuario");
		
		frame.setBounds((int) (Xmax * 0.4), (int) (Ymax * 0.3), frameWidth, frameHeight);
		
		userPanel = new JPanel();
		userPanel.setBounds((int) (Xmax * 0.21), (int) (Ymax * 0.015), frameWidth, frameHeight);
		frame.getContentPane().add(userPanel);
		userPanel.setLayout(null);
		
		JButton playButton = new JButton("Jugar");
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 18));		
		playButton.setBounds(92, 92, 185, 61);
		userPanel.add(playButton);	
		
		JButton commentButton = new JButton("Dejar Comentario");
		commentButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		commentButton.setBounds(92, 178, 185, 61);
		userPanel.add(commentButton);
		
		
		JButton closeButton = new JButton("Cerrar Sesion");
		closeButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		closeButton.setBounds(92, 264, 185, 35);
		userPanel.add(closeButton);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUser.setBounds(155, 35, 66, 27);
		userPanel.add(lblUser);
		
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
		        ComentarioWindow comentarioWindow = new ComentarioWindow("Usuario");
		        comentarioWindow.setVisible(true);
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
