package TheBuyer;
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
public class ResVente {

	public JFrame frame;
	public String nom;
	public double prix;
	
	public livre l=new livre();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ResVente(String l,double p) {
		nom=l;
		prix=p;
		
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
		
		JLabel lblNewLabel_1 = new JLabel(nom);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(375, 106, 161, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNomDeLagent = new JLabel("VOUS AVEZ ACHETE LE LIVRE:");
		lblNomDeLagent.setForeground(Color.WHITE);
		lblNomDeLagent.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNomDeLagent.setBounds(93, 106, 272, 50);
		frame.getContentPane().add(lblNomDeLagent);
		
		JLabel label = new JLabel(Double.toString(prix));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.BOLD, 14));
		label.setBounds(286, 203, 154, 50);
		frame.getContentPane().add(label);
		
		JLabel lblPourLePrix = new JLabel("POUR LE PRIX DE :");
		lblPourLePrix.setForeground(Color.WHITE);
		lblPourLePrix.setFont(new Font("Roboto", Font.BOLD, 18));
		lblPourLePrix.setBounds(93, 203, 212, 50);
		frame.getContentPane().add(lblPourLePrix);
		
	
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setIcon(new ImageIcon("https://c1.wallpaperflare.com/preview/1005/855/635/campfire-fire-beach-bonfire.jpg"));
		lblNewLabel.setOpaque(false);
		lblNewLabel.setBounds(0, 11, 574, 457);
		frame.getContentPane().add(lblNewLabel);
		

	}
}
