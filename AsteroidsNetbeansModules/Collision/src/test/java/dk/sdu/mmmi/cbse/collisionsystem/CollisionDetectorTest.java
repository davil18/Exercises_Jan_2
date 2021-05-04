/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author A
 */
public class CollisionDetectorTest {

    public CollisionDetectorTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testCollides() {
        Entity entity = new Entity();
        entity.add(new PositionPart(100, 100, 1));
        
        Entity entity2 = new Entity();
        entity2.add(new PositionPart(101, 101, 1));

        CollisionDetector instance = new CollisionDetector();
        Boolean expectedResult = true;
        Boolean result = instance.Collides(entity, entity2);
        
        assertEquals(expectedResult, result);
    }
    
    @org.junit.Test
    public void testCollidesNot() {
        Entity entity = new Entity();
        entity.add(new PositionPart(100, 100, 1));
        
        Entity entity2 = new Entity();
        entity2.add(new PositionPart(151, 151, 1));

        CollisionDetector instance = new CollisionDetector();
        Boolean expectedResult = false;
        Boolean result = instance.Collides(entity, entity2);
        
        assertEquals(expectedResult, result);
    }
    
}
