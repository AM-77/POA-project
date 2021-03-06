/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import POJOs.livre;
import TheConsumer.FixerTemps;
import TheSeller.AjouterLivres;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

/**
 * @author Mohamed Amine Griche
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        initializer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_vendeur = new javax.swing.JTextField();
        btn_add_seller = new javax.swing.JButton();
        tf_buyer = new javax.swing.JTextField();
        btn_add_buyer = new javax.swing.JButton();
        tf_nom_consomateur = new javax.swing.JTextField();
        tf_nom_livre_consommer = new javax.swing.JTextField();
        btn_add_consumer = new javax.swing.JButton();
        tf_temps = new javax.swing.JTextField();
        btn_set_delay = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_console = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        btn_demarrer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tf_vendeur.setToolTipText("Nom du vendeur");
        tf_vendeur.setName("vendeur_name"); // NOI18N
        tf_vendeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_vendeurActionPerformed(evt);
            }
        });

        btn_add_seller.setText("Ajouter un vendeur");
        btn_add_seller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_sellerMouseClicked(evt);
            }
        });
        btn_add_seller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_sellerActionPerformed(evt);
            }
        });

        tf_buyer.setToolTipText("nom de l'acheteur");

        btn_add_buyer.setText("Ajouter acheteur");
        btn_add_buyer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_buyerMouseClicked(evt);
            }
        });

        tf_nom_consomateur.setToolTipText("nom de l'agent");

        btn_add_consumer.setText("Ajouter un consomateur");
        btn_add_consumer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_consumerMouseClicked(evt);
            }
        });

        tf_temps.setToolTipText("temps d'attente");

        btn_set_delay.setText("Fixer le temps d'attente");
        btn_set_delay.setToolTipText("temps d'attente");
        btn_set_delay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_set_delayMouseClicked(evt);
            }
        });

        tf_console.setBackground(new java.awt.Color(0, 0, 0));
        tf_console.setColumns(20);
        tf_console.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        tf_console.setRows(5);
        tf_console.setDisabledTextColor(new java.awt.Color(51, 255, 51));
        tf_console.setEnabled(false);
        jScrollPane1.setViewportView(tf_console);

        btn_demarrer.setBackground(new java.awt.Color(102, 153, 255));
        btn_demarrer.setText("Demarrer");
        btn_demarrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_demarrerMouseClicked(evt);
            }
        });

        jLabel1.setText("nom de l'agent");

        jLabel2.setText("nom du livre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator4)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tf_nom_livre_consommer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(tf_vendeur, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(tf_buyer, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(tf_temps, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                                        .addComponent(tf_nom_consomateur))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btn_add_seller, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn_add_buyer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn_set_delay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(181, 181, 181)
                                                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                                                        .addComponent(btn_add_consumer, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                                        .addComponent(jSeparator3))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(btn_demarrer, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tf_vendeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_add_seller))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tf_buyer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_add_buyer))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(tf_nom_consomateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(tf_nom_livre_consommer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btn_add_consumer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)))
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_set_delay)
                                        .addComponent(tf_temps, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_demarrer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_vendeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_vendeurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_vendeurActionPerformed

    private void btn_add_sellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_sellerActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btn_add_sellerActionPerformed

    private void btn_add_sellerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_sellerMouseClicked
        // TODO add your handling code here:

        ajouterUnVendeur();
    }//GEN-LAST:event_btn_add_sellerMouseClicked

    private void btn_add_buyerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_buyerMouseClicked
        // TODO add your handling code here:
        ajouterUnAcheteur();
    }//GEN-LAST:event_btn_add_buyerMouseClicked

    private void btn_add_consumerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_consumerMouseClicked
        // TODO add your handling code here:
        ajouterUnConsomateur();
    }//GEN-LAST:event_btn_add_consumerMouseClicked

    private void btn_set_delayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_set_delayMouseClicked
        // TODO add your handling code here:
        reglerTempsDattente();
    }//GEN-LAST:event_btn_set_delayMouseClicked

    private void btn_demarrerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_demarrerMouseClicked
        // TODO add your handling code here:

        demarrer();
    }//GEN-LAST:event_btn_demarrerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_buyer;
    private javax.swing.JButton btn_add_consumer;
    private javax.swing.JButton btn_add_seller;
    private javax.swing.JButton btn_demarrer;
    private javax.swing.JButton btn_set_delay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField tf_buyer;
    private javax.swing.JTextArea tf_console;
    private javax.swing.JTextField tf_nom_consomateur;
    private javax.swing.JTextField tf_nom_livre_consommer;
    private javax.swing.JTextField tf_temps;
    private javax.swing.JTextField tf_vendeur;
    // End of variables declaration//GEN-END:variables

    private void ajouterUnVendeur() {
        if (tf_vendeur.getText().length() > 2) {
            tf_console.append("ajout du vendeur : " + tf_vendeur.getText() + "\n");
            AjouterLivres al = new AjouterLivres(tf_vendeur.getText(),agentContainer);
            al.frame.setVisible(true);
        } else {
            tf_console.append("Veuillez inserer le nom du vendeur !!!!!!\n");
        }
    }

    private void ajouterUnAcheteur() {
        if (tf_buyer.getText().length() > 2) {
            tf_console.append("ajout d'un Acheteur: " + tf_buyer.getText() + "\n");
            try {
                AgentController agentController = agentContainer.createNewAgent(tf_buyer.getText(), "TheBuyer.BuyerAgent", new Object[]{});
                agentController.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            tf_console.append("Veuillez inserer le nom de l'Acheteur !!!!!!\n");
        }
    }

    private void ajouterUnConsomateur() {
        if (tf_nom_consomateur.getText().length() > 2 && tf_nom_livre_consommer.getText().length() > 2) {
            tf_console.append("ajout de Consomateur : consomateur :" + tf_nom_consomateur.getText() + " livre :" + tf_nom_consomateur.getText() + "\n");
            try {
                //creation de l'agent consommateur et demmarage de l'execution
                livre livre = new livre();
                livre.setNom(tf_nom_livre_consommer.getText());
                AgentController agentController = agentContainer.createNewAgent(tf_nom_consomateur.getText(),
                        "TheConsumer.ConsumerAgent", new Object[]{livre, tf_buyer.getText()});
                agentController.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            tf_console.append("Veuillez inserer le nom du Consomateur !!!!!!\n");
        }
    }

    private void reglerTempsDattente() {
        if (tf_temps.getText().length() > 2) {
            tf_console.append("parametrage du Temps D'attente : " + tf_temps.getText() + "\n");
            FixerTemps f = new FixerTemps(tf_temps.getText());
            f.frame.setVisible(true);
        } else {
            tf_console.append("Veuillez inserer le nom du TempsDattente !!!!!!\n");
        }
    }

    AgentContainer mainContainer;
    AgentContainer agentContainer;

    private void initializer() {
        try { //cr???ation Main Container
            Runtime runtime = Runtime.instance();

            Properties properties = new ExtendedProperties();
            properties.setProperty(Profile.GUI, "true");

            ProfileImpl profilImpl = new ProfileImpl(properties);
            mainContainer = runtime.createMainContainer(profilImpl);

            ProfileImpl profileImpl = new ProfileImpl(false);
            profileImpl.setParameter(ProfileImpl.MAIN_HOST, "127.0.0.1");
            agentContainer = runtime.createAgentContainer(profileImpl);
            mainContainer.start();

            tf_console.append("Conteneur principale cr????!\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void demarrer() {

        AgentController agentController;
        try {
            agentController = agentContainer.createNewAgent(tf_nom_consomateur.getText(), "TheConsumer.ConsumerAgent",
                    new Object[]{tf_nom_livre_consommer.getText(), tf_buyer.getText()});

            agentController.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}
