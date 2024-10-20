package TemplateMethod;

public class ElectronicsQualityCheck extends QualityCheck {
    @Override
    protected void checkSpecificCharacteristics() {
        System.out.println("Проверка(электроники) работоспособности и гарантии.");
    }
}
