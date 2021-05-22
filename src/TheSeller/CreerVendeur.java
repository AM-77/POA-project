package TheSeller;

import POJOs.livre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class CreerVendeur {


    public JFrame frame;
    private JTextField nom_a;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreerVendeur window = new CreerVendeur();
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
    public CreerVendeur() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        LinkedList<livre> livres = new LinkedList<livre>();
        frame = new JFrame();
        frame.setBounds(100, 100, 590, 495);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnValider = new JButton("Ajouter livres");
        btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (nom_a.getText().equals("")) {

                } else {
                    String nom = nom_a.getText();
                    AjouterLivres al = new AjouterLivres(nom);
                    al.frame.setVisible(true);
                }
            }
        });
        btnValider.setForeground(Color.WHITE);
        btnValider.setFont(new Font("Roboto", Font.BOLD, 14));
        btnValider.setBackground(new Color(220, 20, 60));
        btnValider.setBounds(179, 288, 200, 50);
        frame.getContentPane().add(btnValider);

        JLabel lblNomDeLagent = new JLabel("Nom de l'Agent");
        lblNomDeLagent.setForeground(Color.WHITE);
        lblNomDeLagent.setFont(new Font("Roboto", Font.BOLD, 14));
        lblNomDeLagent.setBounds(53, 166, 108, 50);
        frame.getContentPane().add(lblNomDeLagent);

        nom_a = new JTextField();
        nom_a.setFont(new Font("Roboto", Font.BOLD, 14));
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
