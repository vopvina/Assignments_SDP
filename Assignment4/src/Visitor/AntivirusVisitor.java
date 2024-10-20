package Visitor;

public class AntivirusVisitor implements Visitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Проверка текстового файла " + textFile.getFileName() + " на запрещённые слова.");
    }

    @Override
    public void visit(ExecutableFile executableFile) {
        System.out.println("Проверка исполняемого файла " + executableFile.getFileName() + " на вредоносный код.");
    }
}
