package TemplateMethod;

public class FoodQualityCheck extends QualityCheck {
    @Override
    protected void checkSpecificCharacteristics() {
        System.out.println("Проверка(продуктов) срока годности и состава.");
    }
}
