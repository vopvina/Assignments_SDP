package State;

public class PausedState implements PlayerState {
    private final Player player;

    public PausedState(Player player) {
        this.player = player;
    }

    @Override
    public void play() {
        System.out.println("Плеер возобновляет воспроизведение.");
        player.setState(player.getPlayingState());
    }

    @Override
    public void pause() {
        System.out.println("Плеер уже на паузе.");
    }

    @Override
    public void stop() {
        System.out.println("Плеер остановлен.");
        player.setState(player.getStoppedState());
    }
}
