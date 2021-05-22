package TheConsumer;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


import javax.swing.JLabel;

import javax.swing.JTextField;

import POJOs.livre;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FixerTemps {

    public JFrame frame;
    private JTextField tmp;

    public livre l = new livre();
    /**
     * Launch the application.
     */


    /**
     * Create the application.
     *
     * @param text
     */
    public FixerTemps(String text) {
        initialize();
        this.tmp.setText(text);
    }

    public FixerTemps() {

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

                if (tmp.getText().equals("")) {

                } else {


                }

            }
        });

        btnValider.setForeground(Color.WHITE);
        btnValider.setFont(new Font("Roboto", Font.BOLD, 14));
        btnValider.setBackground(new Color(220, 20, 60));
        btnValider.setBounds(179, 300, 200, 50);
        frame.getContentPane().add(btnValider);

        tmp = new JTextField();
        tmp.setFont(new Font("Roboto", Font.BOLD, 14));
        tmp.setBounds(322, 180, 200, 50);
        frame.getContentPane().add(tmp);
        tmp.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Temps d'attente du consommateur");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
        lblNewLabel_1.setBounds(41, 180, 248, 50);
        frame.getContentPane().add(lblNewLabel_1);


        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setForeground(SystemColor.windowBorder);
        lblNewLabel.setIcon(new ImageIcon("https://c1.wallpaperflare.com/preview/1005/855/635/campfire-fire-beach-bonfire.jpg"));
        lblNewLabel.setOpaque(false);
        lblNewLabel.setBounds(-10, 11, 574, 457);
        frame.getContentPane().add(lblNewLabel);


    }
}

