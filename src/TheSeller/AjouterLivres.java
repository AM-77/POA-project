package TheSeller;

import java.awt.EventQueue;

import jade.core.ProfileImpl;


import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POJOs.livre;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

import javax.swing.JFrame;

public class AjouterLivres {


    private AgentContainer agentContainer;
    public JFrame frame;
    private JTextField nom_l;
    private String nom_a;
    public LinkedList<livre> livres = new LinkedList<livre>();
    private JTextField prix;
    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public AjouterLivres(String n) {
        nom_a = n;
        initialize();
    }

    public AjouterLivres(String text, AgentContainer agentContainer) {
        nom_a = text;
        initialize();
        this.agentContainer = agentContainer;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 590, 495);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnValider = new JButton("Ajouter un livre");
        btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((nom_l.getText().equals("")) || (nom_l.getText().equals(""))) {

                } else {
                    livre livre = new livre();
                    livre.setNom(nom_l.getText());
                    livre.setPrix(Double.parseDouble(prix.getText()));
                    livres.add(livre);
                    nom_l.setText("");
                    prix.setText("");
                }

            }
        });
        btnValider.setForeground(Color.WHITE);
        btnValider.setFont(new Font("Roboto14));
        btnValider.setBackground(new Color(220, 20, 60));
        btnValider.setBounds(313, 295, 200, 50);
        frame.getContentPane().add(btnValider);

        JLabel lblNomDeLagent = new JLabel("Titre du livre");
        lblNomDeLagent.setForeground(Color.WHITE);
        lblNomDeLagent.setFont(new Font("Roboto14));
        lblNomDeLagent.setBounds(53, 98, 108, 50);
        frame.getContentPane().add(lblNomDeLagent);

        nom_l = new JTextField();
        nom_l.setFont(new Font("Roboto14));
        nom_l.setBounds(179, 98, 200, 50);
        frame.getContentPane().add(nom_l);
        nom_l.setColumns(10);

        JButton btnValider_1 = new JButton("Valider");
        btnValider_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((!nom_l.getText().equals("")) && (!prix.getText().equals(""))) {
                    livre livre = new livre();
                    livre.setNom(nom_l.getText());
                    livre.setPrix(Double.parseDouble(prix.getText()));
                    livres.add(livre);
                    try {
                        AgentController agentController = agentContainer.createNewAgent(nom_a, "TheSeller.SellerAgent", new Object[]{livres});
                        agentController.start();

                        frame.setVisible(false);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        AgentController agentController = agentContainer.createNewAgent(nom_a, "TheSeller.SellerAgent", new Object[]{livres});
                        agentController.start();
                        frame.setVisible(false);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnValider_1.setForeground(Color.WHITE);
        btnValider_1.setFont(new Font("Roboto14));
        btnValider_1.setBackground(new Color(220, 20, 60));
        btnValider_1.setBounds(53, 295, 200, 50);
        frame.getContentPane().add(btnValider_1);

        JLabel lblPrixDuLivre = new JLabel("Prix du livre");
        lblPrixDuLivre.setForeground(Color.WHITE);
        lblPrixDuLivre.setFont(new Font("Roboto14));
        lblPrixDuLivre.setBounds(53, 189, 108, 50);
        frame.getContentPane().add(lblPrixDuLivre);

        prix = new JTextField();
        prix.setFont(new Font("Roboto14));
        prix.setColumns(10);
        prix.setBounds(179, 189, 200, 50);
        frame.getContentPane().add(prix);


        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setForeground(SystemColor.windowBorder);
        lblNewLabel.setIcon(new ImageIcon("https://c1.wallpaperflare.com/preview/1005/855/635/campfire-fire-beach-bonfire.jpg"));
        lblNewLabel.setOpaque(false);
        lblNewLabel.setBounds(-10, 11, 574, 457);
        frame.getContentPane().add(lblNewLabel);

    }
}
