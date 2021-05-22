package TheConsumer;

import java.util.Scanner;

import POJOs.livre;
import TheBuyer.BuyerContainer;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class ConsumerContainer {
    public static void main(String[] args) {
        livre livre = new livre();

        try {
            Scanner clavier = new Scanner(System.in);

            System.out.print("Nom de consomatuer :");
            String name = clavier.next();

            Runtime runtime = Runtime.instance();
            ProfileImpl profileImpl = new ProfileImpl(false);
            profileImpl.setParameter(ProfileImpl.MAIN_HOST, "127.0.0.1");


            //récupérer les livres
            System.out.print("Nom du livre que voulez vous l'achetez:");
            String nom_livre = clavier.next();

            livre.setNom(nom_livre);

            AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);
            AgentController agentController = agentContainer.createNewAgent(name, "TheConsumer.ConsumerAgent", new Object[]{livre});

            agentController.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
