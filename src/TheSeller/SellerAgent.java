package TheSeller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import POJOs.livre;
import TheBuyer.ResVente;
import jade.core.*;
import jade.core.behaviours.*;
import jade.domain.*;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.*;

public class SellerAgent extends Agent {

    private Map<String, Double> data = new HashMap<String, Double>();
    private ParallelBehaviour parallelBehaviour;
    LinkedList<livre> livres = new LinkedList<livre>();

    @Override
    protected void setup() {


        //récupérer les arguments de l'agent (array de type livre)
        Object[] args = getArguments();
        if (args.length == 1) {
            livres = (LinkedList<livre>) args[0];
        }

        //poser les livres dans le hashmap  : livre ... prix
        for (livre livre : livres) {
            data.put(livre.getNom(), livre.getPrix());

            System.out.println(" ==== le livres: " + livre.getNom() + "=== le prix: " + livre.getPrix());
        }


        System.out.println("....... Vendeur " + this.getAID().getName());
        System.out.println("--------------");
        System.out.println("Publication du service dans Directory Facilitator...");

        //service description
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setType("book-selling");
        serviceDescription.setName("book-trading");

        //agent description
        DFAgentDescription agentDescription = new DFAgentDescription();
        agentDescription.setName(this.getAID());
        agentDescription.addServices(serviceDescription);

        //Publication du service
        try {
            DFService.register(this, agentDescription);
        } catch (FIPAException e1) {
            e1.printStackTrace();
        }


        parallelBehaviour = new ParallelBehaviour();
        addBehaviour(parallelBehaviour);

        //le 1 er behaviour
        parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                try {
                    // attente de message de type CFP (create for proposal)
                    MessageTemplate messageTemplate = MessageTemplate.MatchPerformative(ACLMessage.CFP);
                    ACLMessage aclMessage = receive(messageTemplate);

                    //reception de CFP
                    if (aclMessage != null) {
                        //récupérer le Conversation ID et le nom du livre
                        System.out.println("Conversation ID:" + aclMessage.getConversationId());
                        String livre = aclMessage.getContent();

                        if (data.get(livre) != null) {
                            //récupérer le prix de ce livre du collection hashmap
                            Double prix = data.get(livre);

                            //créer message proposer prix
                            ACLMessage reply = aclMessage.createReply();
                            reply.setPerformative(ACLMessage.PROPOSE);
                            reply.setContent(prix.toString());

                            System.out.println("...... En cours");
                            Thread.sleep(5000);
                            send(reply);

                            //le 2 eme behaviour
                            parallelBehaviour.addSubBehaviour(new SellerBehaviour(myAgent, aclMessage.getConversationId()));

                        } else {

                            System.out.println(".........................");
                            System.out.println("Livre n'existe pas");
                            System.out.println("Conversation ID:" + aclMessage.getConversationId());

                            //création de message inform
                            ACLMessage msg3 = new ACLMessage(ACLMessage.INFORM);
                            msg3.addReceiver(aclMessage.getSender());
                            msg3.setConversationId(aclMessage.getConversationId());
                            msg3.setContent("<transaction>"
                                    + "<livre>" + livre + "</livre>"
                                    + "<resulatat> faux </resulatat>"
                                    + "<fournisseur>" + aclMessage.getSender().getName() + "</fournisseur>"
                                    + "</transaction");

                            //envoyer le message inform
                            myAgent.send(msg3);
                        }


                    } else {
                        block();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //avant de mourir supprimer service
    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException e) {
            e.printStackTrace();
        }
    }
}
