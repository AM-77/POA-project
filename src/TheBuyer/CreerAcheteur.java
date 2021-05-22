package TheBuyer;

import jade.core.ProfileImpl;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POJOs.livre;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
public class CreerAcheteur {

	public JFrame frame;
	private JTextField nom_a;
	public String ach;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreerAcheteur window = new CreerAcheteur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreerAcheteur() {
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
				livre livre = new livre();

				if(nom_a.getText().equals(""))
				{
					
				}
				else{
					
				try{
					Runtime runtime=Runtime.instance();
					ProfileImpl profileImpl=new ProfileImpl(false);
					profileImpl.setParameter(ProfileImpl.MAIN_HOST,"127.0.0.1");
				
					ach=nom_a.getText();			
					AgentContainer agentContainer=runtime.createAgentContainer(profileImpl);
					AgentController agentController=agentContainer.createNewAgent(nom_a.getText(),"TheBuyer.BuyerAgent", new Object[]{});
				
					agentController.start();
					frame.setVisible(false);
					}
					catch (Exception ex)
						{ ex.printStackTrace(); }
				}
			} 
		});
		btnValider.setForeground(Color.WHITE);
		btnValider.setFont(new Font("Roboto14));
		btnValider.setBackground(new Color(220, 20, 60));
		btnValider.setBounds(179, 288, 200, 50);
		frame.getContentPane().add(btnValider);
		
		JLabel lblNomDeLagent = new JLabel("Nom de l'Agent");
		lblNomDeLagent.setForeground(Color.WHITE);
		lblNomDeLagent.setFont(new Font("Roboto14));
		lblNomDeLagent.setBounds(53, 166, 108, 50);
		frame.getContentPane().add(lblNomDeLagent);
		
		nom_a = new JTextField();
		nom_a.setFont(new Font("Roboto14));
		nom_a.setBounds(179, 166, 200, 50);
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
