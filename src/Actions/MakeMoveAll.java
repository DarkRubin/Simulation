package src.Actions;

import src.Coordinates;
import src.Creature.Herbivore;
import src.Creature.Predator;

import static src.Simulation.*;

public class MakeMoveAll extends Action {

    private int move;
    public void nextTurn() {

        for (Coordinates coordinates : Predator.predatorsOnMap) {
            Predator predator = (Predator) map.getEntity(coordinates);
            predator.makeMove(coordinates);
        }
        for (Coordinates coordinates : Herbivore.herbivoreOnMap) {
            Herbivore herbivore = (Herbivore) map.getEntity(coordinates);
            herbivore.makeMove(coordinates);
        }

        move++;
        System.out.println(move);
    }

    @Override
    public void doInThisMove() {
        nextTurn();
    }
}
