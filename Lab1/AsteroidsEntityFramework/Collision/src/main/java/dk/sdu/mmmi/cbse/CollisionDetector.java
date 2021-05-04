package dk.sdu.mmmi.cbse;
import dk.sdu.mmmi.cbse.asteroidsystem.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.enemysystem.Enemy;
import dk.sdu.mmmi.cbse.playersystem.Player;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = IPostEntityProcessingService.class)
public class CollisionDetector implements IPostEntityProcessingService {


    public CollisionDetector(){

    }

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities()) {
            //Collision
            for (Entity ent : world.getEntities()) {
                if (collide(ent, entity)) {
                    world.removeEntity(ent);
                    System.out.println("crash");
                }
            }
        }
    }

    public boolean collide(Entity a, Entity b){
        if(Math.abs(a.getPosX()-b.getPosX()) < 5 && Math.abs(a.getPosY()-b.getPosY()) < 5 && a != b){
            if(a instanceof Player && b instanceof Enemy){
                return true;
            }else if (a instanceof Asteroid && b instanceof Enemy){
                return true;
            }else if (a instanceof Asteroid && b instanceof Asteroid){
                return true;
            }else if (a instanceof Player && b instanceof Asteroid){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

}
