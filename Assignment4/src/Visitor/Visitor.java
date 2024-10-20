package Visitor;

public interface Visitor {
    void visit(TextFile textFile);
    void visit(ExecutableFile executableFile);
}
