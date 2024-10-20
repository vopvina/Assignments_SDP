package State;

public class PlayingState implements PlayerState {
    private final Player player;

    public PlayingState(Player player) {
        this.player = player;
    }

    @Override
    public void play() {
        System.out.println("Плеер уже воспроизводит.");
    }

    @Override
    public void pause() {
        System.out.println("Плеер приостановлен.");
        player.setState(player.getPausedState());
    }

    @Override
    public void stop() {
        System.out.println("Плеер остановлен.");
        player.setState(player.getStoppedState());
    }
}
