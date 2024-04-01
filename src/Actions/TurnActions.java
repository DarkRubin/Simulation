package src.Actions;

public class TurnActions {

    private final SpawnMoreObjects spawnMoreObjects = new SpawnMoreObjects();
    private final MakeMoveAll makeMoveAll = new MakeMoveAll();
    private final MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();

    public void nextTurn() {
        spawnMoreObjects.doInThisMove();
        makeMoveAll.doInThisMove();
        mapConsoleRenderer.doInThisMove();
    }
}
