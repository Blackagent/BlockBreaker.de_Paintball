package de.blockbreaker.paintball.data;

/**
 * Created by Janne on 09.06.2015.
 */
public enum GameState {

    IN_LOBBY,
    IN_GAME,
    POST_GAME;

    private static GameState currentState;

    public static void setState(GameState state) {
        GameState.currentState = state;
    }

    public static GameState getState() {
        return currentState;
    }

    public static boolean isState(GameState state) {
        return GameState.currentState == state;
    }

}
