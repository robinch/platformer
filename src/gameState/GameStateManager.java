package gameState;

import java.util.ArrayList;

/**
 * Created by robin on 2014-11-03.
 */
public class GameStateManager {

    private ArrayList<GameState> gameStates;
    private int currentState:
    public static final int MENUSTATE = 0;
    public static final int LEVEL1STATE = 1;

    public GameStateManager(){
        gameStates = new ArrayList<GameState>();
        currentState = MENUSTATE;
        gameStates.add(new MenuState(this));

    }
}
