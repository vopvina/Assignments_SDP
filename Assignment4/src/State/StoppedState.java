package State;

public class StoppedState implements PlayerState {
    private final Player player;

    public StoppedState(Player player) {
        this.player = player;
    }

    @Override
    public void play() {
        System.out.println("Плеер начинает воспроизведение.");
        player.setState(player.getPlayingState());
    }

    @Override
    public void pause() {
        System.out.println("Плеер не может быть приостановлен, он остановлен.");
    }

    @Override
    public void stop() {
        System.out.println("Плеер уже остановлен.");
    }
}
