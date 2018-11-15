package Agregados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PaqueteJuego.UserWindow;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class ComentarioWindow extends JFrame {

	private String user;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblDejarComentario;

	
	private static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	/**
	 * Create the frame.
	 */
	public ComentarioWindow(String u) {
		user=u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnComentar = new JButton("Comentar");
		btnComentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ruta = "comentarios.txt";
				File archivo = new File(ruta);
				BufferedWriter bw = null;
				try {
					FileWriter fw= new FileWriter(archivo, true);
					if(archivo.exists()) {
						bw = new BufferedWriter(fw);
						bw.write(user);
						bw.newLine();
						bw.write(textField.getText());   
						bw.newLine();
					}
					bw.close();
				}catch (IOException f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Comentario enviado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				textField.setText("");
			}
		});
		btnComentar.setBounds(89, 182, 97, 37);
		contentPane.add(btnComentar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserWindow uw= new UserWindow();
				uw.getFrame().setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(231, 182, 97, 37);
		contentPane.add(btnCancelar);
		
		textField = new JTextField();
		textField.setBounds(89, 73, 239, 82);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblDejarComentario = new JLabel("Dejar Comentario");
		lblDejarComentario.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDejarComentario.setBounds(138, 44, 145, 16);
		contentPane.add(lblDejarComentario);
	}
	
	
	
}
