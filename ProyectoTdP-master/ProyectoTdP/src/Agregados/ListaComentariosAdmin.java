package Agregados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PaqueteJuego.AdminWindow;
import PaqueteJuego.UserWindow;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ListaComentariosAdmin extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	
	/**
	 * Create the frame.
	 */
	public ListaComentariosAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminWindow aw= new AdminWindow();
				aw.getFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(177, 187, 73, 53);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(12, 35, 408, 139);
		contentPane.add(textArea);
		
		cargar();
	}
	
	private void cargar() {
		String ruta = "comentarios.txt";
		File archivo = new File(ruta);
		BufferedReader bw=null;
		try {
			bw = new BufferedReader(new FileReader(archivo));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String cadena;
		 try {
			while((cadena = bw.readLine())!=null) {
			   textArea.setText(textArea.getText()+"Usuario: "+cadena+"\r\n"); 
			   cadena = bw.readLine();
			   textArea.setText(textArea.getText()+"Comentario: "+cadena+"\n"); 
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
