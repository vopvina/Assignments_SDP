package State;

public class Player {
    private final PlayerState playingState;
    private final PlayerState pausedState;
    private final PlayerState stoppedState;
    private PlayerState currentState;

    public Player() {
        this.playingState = new PlayingState(this);
        this.pausedState = new PausedState(this);
        this.stoppedState = new StoppedState(this);
        this.currentState = stoppedState;
    }

    public void setState(PlayerState state) {
        this.currentState = state;
    }

    public PlayerState getPlayingState() {
        return playingState;
    }

    public PlayerState getPausedState() {
        return pausedState;
    }

    public PlayerState getStoppedState() {
        return stoppedState;
    }

    public void play() {
        currentState.play();
    }

    public void pause() {
        currentState.pause();
    }

    public void stop() {
        currentState.stop();
    }
}
