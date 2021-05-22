package TheBuyer;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;
import java.util.List;

class RequestBehaviour extends CyclicBehaviour {
    private String conversationID;
    private AID requester;

    private String livre;
    private double prix;
    private int compteur;

    private List<AID> vendeurs = new ArrayList<AID>();
    private AID meilleureOffre;
    private double meilleurPrix;

    private int index;
    private boolean existe;

    //le constructeur
    public RequestBehaviour(Agent agent, String livre, AID requester, String conversationID) {
        super(agent);
        this.livre = livre;
        this.requester = requester;
        this.conversationID = conversationID;

        System.out.println("Recherche des services...");
        vendeurs = chercherServices(myAgent, "book-selling");

        System.out.println("Liste des vendeurs trouvés :");
        try {
            for (AID aid : vendeurs) {
                System.out.println("==== le vendeur : " + aid.getName());
            }

            ++compteur;

            System.out.println("#########################################");
            System.out.println("Requête d'achat de livre:");
            System.out.println("From :" + requester.getName()); //l'AID de l'agent consomateur
            System.out.println("Livre : " + livre);
            System.out.println("............................");

            System.out.println("Envoi de la requête....");

            //créer message CFP
            ACLMessage msg = new ACLMessage(ACLMessage.CFP);
            msg.setContent(livre);
            msg.setConversationId(conversationID);
            msg.addUserDefinedParameter("compteur", String.valueOf(compteur));

            //ajouter les receivers de messages (les vendeurs)
            for (AID aid : vendeurs) {
                msg.addReceiver(aid);
            }

            System.out.println("....... En cours");
            Thread.sleep(5000);
            index = 0;

            //envoyer le message CFP
            myAgent.send(msg);

            existe = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void action() {
        try {
            MessageTemplate template = MessageTemplate.and(
                    MessageTemplate.MatchConversationId(conversationID),
                    MessageTemplate.or(
                            MessageTemplate.MatchPerformative(ACLMessage.PROPOSE),
                            MessageTemplate.or(
                                    MessageTemplate.MatchPerformative(ACLMessage.CONFIRM),
                                    MessageTemplate.MatchPerformative(ACLMessage.INFORM))));

            //reception de message propose ou confirme avec la conversationID Montré
            ACLMessage aclMessage = myAgent.receive(template);

            if (aclMessage != null) {
                switch (aclMessage.getPerformative()) {

                    case ACLMessage.PROPOSE:
                        System.out.println("***********************************");
                        System.out.println("Conversation ID:" + aclMessage.getConversationId());
                        System.out.println("Réception de l'offre :");

                        //le vendeur
                        System.out.println("From :" + aclMessage.getSender().getName());

                        //récupérer le prix de livre proposer
                        prix = Double.parseDouble(aclMessage.getContent());
                        System.out.println("Prix=" + prix);

                        //pour choisir le meilleur prix et le meilleur offre
                        if (existe == false) { //c-à-d le premier vendeur
                            meilleurPrix = prix;
                            meilleureOffre = aclMessage.getSender();
                        } else {
                            if (prix < meilleurPrix) {
                                meilleurPrix = prix;
                                meilleureOffre = aclMessage.getSender();
                            }
                        }
                        ++index;
                        existe = true;


                        //s'il traite toutes les proposition de prix il peut accepter une proposition
                        if (index == vendeurs.size()) {
                            index = 0;
                            System.out.println("-----------------------------------");
                            System.out.println("Conclusion de la transaction.......");

                            //créer le messag accepter proposition
                            ACLMessage aclMessage2 = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                            aclMessage2.addReceiver(meilleureOffre);
                            aclMessage2.setConversationId(conversationID);

                            Thread.sleep(5000);


                            myAgent.send(aclMessage2);
                            System.out.println("...... envoyer le message accepter propostion");

                        }
                        break;

                    case ACLMessage.CONFIRM:
                        System.out.println(".........................");
                        System.out.println("Reçu de la confirmation ...");
                        System.out.println("Conversation ID:" + aclMessage.getConversationId());

                        //création de message inform
                        ACLMessage msg3 = new ACLMessage(ACLMessage.INFORM);
                        msg3.addReceiver(requester);
                        msg3.setConversationId(conversationID);
                        msg3.setContent("<transaction>"
                                + "<livre>" + livre + "</livre>"
                                + "<prix>" + meilleurPrix + "</prix>"
                                + "<fournisseur>" + aclMessage.getSender().getName() + "</fournisseur>"
                                + "</transaction");

                        //envoyer le message inform
                        myAgent.send(msg3);
                        ResVente r = new ResVente(livre, meilleurPrix);
                        r.frame.setVisible(true);
                        break;
                    case ACLMessage.INFORM:

                        System.out.println("***********************************");
                        System.out.println("Reception de message inform car l'agent n'a pas le livre");
                        System.out.println("Conversation ID:" + aclMessage.getConversationId());

                        //le vendeur
                        System.out.println("From :" + aclMessage.getSender().getName());
                        System.out.println("content :" + aclMessage.getContent());

                        ++index;

                        //s'il traite toutes les proposition
                        if (index == vendeurs.size()) {
                            index = 0;

                            if (existe == false) {//pas d'agent qui peut vendre ce livre
                                System.out.println(".........................ce livre n'existe pas");

                                //création de message inform
                                ACLMessage msg4 = new ACLMessage(ACLMessage.INFORM);
                                msg4.addReceiver(requester);
                                msg4.setConversationId(conversationID);
                                msg4.setContent("<transaction>"
                                        + "<livre>" + livre + "</livre>"
                                        + "<resulat>" + existe + "</resulat>"
                                        + "</transaction");

                                //envoyer le message inform
                                myAgent.send(msg4);
                                r = new ResVente(livre, meilleurPrix);
                                r.frame.setVisible(true);
                            } else {
                                System.out.println("-----------------------------------");
                                System.out.println("Conclusion de la transaction.......");

                                //créer le messag accepter proposition
                                ACLMessage aclMessage2 = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                                aclMessage2.addReceiver(meilleureOffre);
                                aclMessage2.setConversationId(conversationID);

                                Thread.sleep(5000);


                                myAgent.send(aclMessage2);
                                System.out.println("...... envoyer le message accepter propostion");

                            }


                            break;

                        }
                }
            } else
                block();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<AID> chercherServices(Agent agent, String type) {
        List<AID> vendeurs = new ArrayList<AID>();
        System.out.println("recherche des vendeurs");

        //service de descritption
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setType(type);

        //agent de description
        DFAgentDescription agentDescription = new DFAgentDescription();
        agentDescription.addServices(serviceDescription);

        try {
            DFAgentDescription[] descriptions = DFService.search(agent, agentDescription);

            for (DFAgentDescription dfad : descriptions) {
                vendeurs.add(dfad.getName());
                System.out.println("seller found : " + dfad);
            }
        } catch (FIPAException e) {
            e.printStackTrace();
        }
        System.out.println("nbr de vendeurs trouvés : " + vendeurs.size());

        return vendeurs;
    }
}