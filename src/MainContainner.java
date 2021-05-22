import jade.util.leap.Properties;
import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.util.ExtendedProperties;
import jade.wrapper.AgentContainer;

public class MainContainner {
	public static void main (String[] args)
	{
		try 
		{
			Runtime runtime = Runtime.instance();
			
			Properties properties = new ExtendedProperties();
			properties.setProperty(Profile.GUI, "true");
			
			ProfileImpl profilImpl = new ProfileImpl(properties);
			AgentContainer mainContainer = runtime.createMainContainer(profilImpl);
			
			mainContainer.start();
		}
		catch (Exception e) {e.printStackTrace();}	
	}
}

