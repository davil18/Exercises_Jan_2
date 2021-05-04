package dk.sdu.mmmi.cbse.common.services;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

//Interface that has a given contract specified for Entities, that can be implemented by said entities
//methods this contract contain is process;
//pre-condition to this is to import; GameData and World, post-condition is to implement this interface in a given class


public interface IEntityProcessingService {

    void process(GameData gameData, World world);
}
