package Visitor;

public class TextFile implements File {
    private String fileName;

    public TextFile(String fileName) {
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
