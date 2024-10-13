package Command;

public class VolumeUpCommand implements Command {
    private Television tv;

    public VolumeUpCommand(Television tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.volumeUp();
    }
}
