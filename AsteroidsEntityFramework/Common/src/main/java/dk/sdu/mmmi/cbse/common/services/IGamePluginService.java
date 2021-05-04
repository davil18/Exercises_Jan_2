package dk.sdu.mmmi.cbse.common.services;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

//Interface that has a given contract specified for Game
//methods this contract contain is start and stop which likely is used to start and stop the Game runtime at will.
//pre-condition to this is to import; GameData and World, post-condition is to implement this interface in a given class

public interface IGamePluginService {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
