package src.Actions;

import src.Coordinates;
import src.Creature.Herbivore;
import src.Creature.Predator;


import static src.Simulation.*;

public class MakeMoveAll extends Action {

    private int move;

    @Override
    public void doInThisMove() {

        Coordinates[] readyHerbivores = Herbivore.herbivoresOnMap.toArray(new Coordinates[0]);
        for (Coordinates coordinates : readyHerbivores) {
            Herbivore herbivore = (Herbivore) map.getEntity(coordinates);
            herbivore.makeMove(coordinates);
        }
        Coordinates[] readyPredators = Predator.predatorsOnMap.toArray(new Coordinates[0]);
        for (Coordinates coordinates : readyPredators) {
            Predator predator = (Predator) map.getEntity(coordinates);
            predator.makeMove(coordinates);
        }


        System.out.println(++move);
    }
}
