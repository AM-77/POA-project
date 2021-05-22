package TheConsumer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

import javax.swing.JTextField;

import POJOs.livre;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreerConso {

	public JFrame frame;
	private JTextField nom_l;
	private JTextField nom_a;
	public String nom;
	public String ach;
	public livre l=new livre();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CreerConso(String ach) {
		this.ach=ach;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if((nom_a.getText().equals(""))||(nom_l.getText().equals("")))
				{
					
				}
				else{
					
				
				try {
					
					nom=nom_a.getText();
					//récupérer les livres
					System.out.print("Nom du livre que voulez vous l'achetez:");
					String nom_livre=nom_l.getText();
					l.setNom(nom_livre);					
					frame.setVisible(false);
				} catch (Exception ex) { ex.printStackTrace(); }
				}
			
			}
		});
		
		btnValider.setForeground(Color.WHITE);
		btnValider.setFont(new Font("Roboto", Font.BOLD, 14));
		btnValider.setBackground(new Color(220, 20, 60));
		btnValider.setBounds(179, 300, 200, 50);
		frame.getContentPane().add(btnValider);
		
		nom_l = new JTextField();
		nom_l.setFont(new Font("Roboto", Font.BOLD, 14));
		nom_l.setBounds(179, 201, 200, 50);
		frame.getContentPane().add(nom_l);
		nom_l.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom du livre");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 201, 108, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNomDeLagent = new JLabel("Nom de l'Agent");
		lblNomDeLagent.setForeground(Color.WHITE);
		lblNomDeLagent.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNomDeLagent.setBounds(51, 110, 108, 50);
		frame.getContentPane().add(lblNomDeLagent);
		
		nom_a = new JTextField();
		nom_a.setFont(new Font("Roboto", Font.BOLD, 14));
		nom_a.setBounds(179, 111, 200, 50);
		frame.getContentPane().add(nom_a);
		nom_a.setColumns(10);
		
	
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setIcon(new ImageIcon("https://c1.wallpaperflare.com/preview/1005/855/635/campfire-fire-beach-bonfire.jpg"));
		lblNewLabel.setOpaque(false);
		lblNewLabel.setBounds(-10, 11, 574, 457);
		frame.getContentPane().add(lblNewLabel);
		

	}
}
