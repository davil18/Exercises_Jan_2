package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = IEntityProcessingService.class)
public class AsteroidControlSystem  implements IEntityProcessingService {

    private boolean[] nam = randomMovement();

    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);

            this.nam = randomMovement();
            movingPart.setLeft(nam[0]);
            movingPart.setRight(nam[1]);
            movingPart.setUp(nam[2]);

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);

            updateShape(enemy);
        }
    }
    private boolean[] randomMovement(){
        boolean[] nam = new boolean[3];
        double a = Math.random();
        if(a < 0.2){
            nam[0] = true;
            nam[1] = false;
            nam[2] = true;
        }else if (a > 0.2 && a < 0.4){
            nam[0] = false;
            nam[1] = true;
            nam[2] = true;
        }else{
            nam[0] = false;
            nam[1] = false;
            nam[2] = true;
        }
        return nam;
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);

        entity.setPosX(positionPart.getX());
        entity.setPosY(positionPart.getY());

        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x - 5);
        shapey[0] = (float) (y + 5);

        shapex[1] = (float) (x + 5);
        shapey[1] = (float) (y + 5);

        shapex[2] = (float) (x + 5);
        shapey[2] = (float) (y - 5);

        shapex[3] = (float) (x - 5);
        shapey[3] = (float) (y - 5);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}