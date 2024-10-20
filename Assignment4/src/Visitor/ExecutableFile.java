package Visitor;

public class ExecutableFile implements File {
    private String fileName;

    public ExecutableFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getFileName() {
        return fileName;
    }
}