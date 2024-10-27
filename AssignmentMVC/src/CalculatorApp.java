import model.CalculatorModel;
import view.CalculatorView;
import controller.CalculatorController;

// Основной класс приложения
public class CalculatorApp {
    public static void main(String[] args) {
        // Создание модели, представления и контроллера
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        // Запуск приложения
        view.setVisible(true);
    }
}