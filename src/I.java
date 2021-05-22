

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import TheBuyer.CreerAcheteur;
import TheConsumer.CreerConso;
import TheConsumer.FixerTemps;
import TheSeller.CreerVendeur;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I {

    public JFrame frame;
    public String ach;
    public static CreerAcheteur p;
    public static CreerConso c;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    I window = new I();
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
    public I() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 590, 546);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnCrerConsommateur = new JButton("Fixer Temps d'attente");
        btnCrerConsommateur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FixerTemps f = new FixerTemps();
                f.frame.setVisible(true);
            }
        });
        btnCrerConsommateur.setForeground(SystemColor.textHighlightText);
        btnCrerConsommateur.setBackground(new Color(0, 0, 0));
        btnCrerConsommateur.setFont(new Font("JavaScript The Hard Way", Font.BOLD, 14));
        btnCrerConsommateur.setBounds(196, 325, 200, 50);
        frame.getContentPane().add(btnCrerConsommateur);

        JButton btnCrerAcheteur = new JButton("Cr\u00E9er Acheteur");
        btnCrerAcheteur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p = new CreerAcheteur();
                p.frame.setVisible(true);
            }
        });
        btnCrerAcheteur.setForeground(Color.WHITE);
        btnCrerAcheteur.setFont(new Font("JavaScript The Hard Way", Font.BOLD, 14));
        btnCrerAcheteur.setBackground(new Color(0, 0, 0));
        btnCrerAcheteur.setBounds(196, 178, 200, 50);
        frame.getContentPane().add(btnCrerAcheteur);

        JButton btnCrerVendeurs = new JButton("Cr\u00E9er Vendeurs");
        btnCrerVendeurs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreerVendeur p = new CreerVendeur();
                p.frame.setVisible(true);
            }
        });
        btnCrerVendeurs.setForeground(Color.WHITE);
        btnCrerVendeurs.setFont(new Font("JavaScript The Hard Way", Font.BOLD, 14));
        btnCrerVendeurs.setBackground(new Color(0, 0, 0));
        btnCrerVendeurs.setBounds(196, 106, 200, 50);
        frame.getContentPane().add(btnCrerVendeurs);

        JButton btnValider = new JButton("Valider");
        btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //cr�ation de l'agent consommateur et demmarage de l'execution
                    Runtime runtime = Runtime.instance();
                    ProfileImpl profileImpl = new ProfileImpl(false);
                    profileImpl.setParameter(ProfileImpl.MAIN_HOST, "127.0.0.1");
                    AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);
                    AgentController agentController = agentContainer.createNewAgent(c.nom, "TheConsumer.ConsumerAgent", new Object[]{c.l, c.ach});
                    agentController.start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnValider.setForeground(Color.WHITE);
        btnValider.setFont(new Font("JavaScript The Hard Way", Font.BOLD, 14));
        btnValider.setBackground(new Color(220, 20, 60));
        btnValider.setBounds(196, 398, 200, 50);
        frame.getContentPane().add(btnValider);

        JButton button_1 = new JButton("Cr\u00E9er Consommateur");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c = new CreerConso(p.ach);
                c.frame.setVisible(true);
            }
        });
        button_1.setForeground(Color.WHITE);
        button_1.setFont(new Font("JavaScript The Hard Way", Font.BOLD, 14));
        button_1.setBackground(new Color(0, 0, 0));
        button_1.setBounds(196, 251, 200, 50);
        frame.getContentPane().add(button_1);

        JLabel lblVeuillre = new JLabel("VEUILLEZ CREER VOTRE SMA");
        lblVeuillre.setForeground(SystemColor.menu);
        lblVeuillre.setFont(new Font("JavaScript The Hard Way", Font.BOLD, 26));
        lblVeuillre.setBounds(120, 42, 358, 41);
        frame.getContentPane().add(lblVeuillre);


        JLabel lblNewLabel = new JLabel("Montain lake");
        lblNewLabel.setForeground(SystemColor.windowBorder);
        lblNewLabel.setIcon(new ImageIcon("https://wallpaperaccess.com/fire-hd-desktop/full/174275.jpg"));
        lblNewLabel.setOpaque(false);
        lblNewLabel.setBounds(0, 0, 574, 508);
        frame.getContentPane().add(lblNewLabel);
        try { //cr�ation Main Container
            Runtime runtime = Runtime.instance();

            Properties properties = new ExtendedProperties();
            properties.setProperty(Profile.GUI, "true");

            ProfileImpl profilImpl = new ProfileImpl(properties);
            AgentContainer mainContainer = runtime.createMainContainer(profilImpl);

            mainContainer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
