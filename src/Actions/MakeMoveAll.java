package src.Actions;

import src.Coordinates;
import src.Creature.Herbivore;
import src.Creature.Predator;

import static src.Simulation.*;

public class MakeMoveAll extends Action {

    private int move;
    public void nextTurn() {

        for (Coordinates coordinates : Predator.predatorsOnMap) {
            Predator entity = (Predator) map.getEntity(coordinates);
            entity.makeMove(coordinates);
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
