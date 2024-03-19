package src.Creature;

import src.Coordinates;

import static src.Entity.Grass.countGrass;
import static src.Simulation.map;

public class Herbivore extends Creature {

    public static int countHerbivore = 0;
    private int healthPoint = 10;
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        countHerbivore++;
    }

    public void takeHurt(int power) {
        healthPoint -= power;
        if (healthPoint == 0) {
            map.removeEntity(coordinates);
            countHerbivore--;
        }
    }
    @Override
    public void makeMove(Coordinates coordinates) {
        Coordinates belowCells = checkBelowCells(coordinates, true);
        if (belowCells != null) {
            map.removeEntity(belowCells);
            countGrass--;
            healthPoint += 5;
        }

    }


}
