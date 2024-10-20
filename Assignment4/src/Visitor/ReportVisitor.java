package Visitor;

public class ReportVisitor implements Visitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Создание отчёта по текстовому файлу " + textFile.getFileName() + ".");
    }

    @Override
    public void visit(ExecutableFile executableFile) {
        System.out.println("Создание отчёта по исполняемому файлу " + executableFile.getFileName() + ".");
    }
}
