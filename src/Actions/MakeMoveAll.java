package src.Actions;

import src.Coordinates;
import src.Creature.Herbivore;
import src.Creature.Predator;


import static src.Simulation.*;

public class MakeMoveAll extends Action {

    private int move;

    @Override
    public void doInThisMove() {
        Coordinates[] readyPredators = Predator.predatorsOnMap.toArray(new Coordinates[0]);
        for (Coordinates coordinates : readyPredators) {
            if (map.getEntity(coordinates) instanceof Predator predator)
                predator.makeMove(coordinates);
        }
        Coordinates[] readyHerbivores = Herbivore.herbivoresOnMap.toArray(new Coordinates[0]);
        for (Coordinates coordinates : readyHerbivores) {
            if (map.getEntity(coordinates) instanceof Herbivore herbivore)
                herbivore.makeMove(coordinates);
        }


        System.out.println(++move);
    }
}
