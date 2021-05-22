package TheBuyer;

import java.util.Scanner;


import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class BuyerContainer {
	public static void main(String[] args) {
		try {
			Scanner clavier=new Scanner(System.in);

			System.out.print("l'acheteur:");

			
			Runtime runtime=Runtime.instance();
			ProfileImpl profileImpl=new ProfileImpl(false);
			profileImpl.setParameter(ProfileImpl.MAIN_HOST,"127.0.0.1");
			
						
			AgentContainer agentContainer=runtime.createAgentContainer(profileImpl);
			AgentController agentController=agentContainer.createNewAgent("achteur","TheBuyer.BuyerAgent", new Object[]{});
			
			agentController.start();
		} 
		catch (Exception e)
		{ e.printStackTrace(); }
	} 
}