package TemplateMethod;

public abstract class QualityCheck {
    public void checkQuality() {
        checkAppearance();
        checkSpecificCharacteristics();
        finalReport();
    }

    private void checkAppearance() {
        System.out.println("Проверка внешнего вида.");
    }

    protected abstract void checkSpecificCharacteristics();

    private void finalReport() {
        System.out.println("Заключительный отчёт.");
    }
}