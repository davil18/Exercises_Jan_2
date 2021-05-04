package dk.sdu.mmmi.osgiplayer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author A
 */

public class Activator implements BundleActivator {
    
    public void start(BundleContext context) throws Exception {
        System.out.println("Player Started"); 
        PlayerPlugin player = new PlayerPlugin();
        //player.start(gameData, world);
    }
    
    public void stop(BundleContext context) throws Exception {
        //TODO add deactivation code here
    }
    
}
