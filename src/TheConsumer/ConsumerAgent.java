package TheConsumer

import java.util.Arrays;
import java.util.LinkedList;

import POJOs.livre;
import TheBuyer.BuyerContainer;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ConsumerAgent extends Agent {
    ParallelBehaviour parallelBehaviour;
    livre livre;

    String achteur;

    @Override
    protected void setup() {
        System.out.println("Salut je suis l'agentc consomateur mon nom est:" + this.getAID().getName());

        parallelBehaviour = new ParallelBehaviour();
        addBehaviour(parallelBehaviour);

        //récupérer les arguments de l'agent (livre)
        Object[] args = getArguments();

        System.out.println(Arrays.toString(args));
        if (args.length == 2) {
            livre = (livre) args[0];
        }
        //création de message request
        ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
        aclMessage.setContent(livre.getNom());
        aclMessage.addReceiver(new AID((String) args[1], AID.ISLOCALNAME));

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //envoyer le message request
        this.send(aclMessage);

        //le 1 er behaviour
        parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {

            @Override
            public void action() {

                //attente de iform (resultat de request)
                MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
                ACLMessage aclMessage = receive(template);

                //if il reçoie un ifnfotm
                if (aclMessage != null) {

                    //récupérer les infos de message
                    String livre = aclMessage.getContent();
                    AID requester = aclMessage.getSender();

                    System.out.println("vous avez trouvez ....");
                    System.out.println(livre);
                    System.out.println("Le sender");
                    System.out.println(requester.getName());
                } else
                    block();

            }
        });
    }

    @Override
    protected void beforeMove() {
        System.out.println("Avant de migrer vers une nouvelle location.....");
    }

    @Override
    protected void afterMove() {
        System.out.println("Je viens d'arriver à une nouvelle location.....");
    }

    @Override
    protected void takeDown() {
        System.out.println("avant de mourir .....");
    }
}