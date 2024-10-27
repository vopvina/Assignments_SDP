package controller;

import model.CalculatorModel;
import view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        this.view.addOperationListener(new OperationListener());
    }

    class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double firstNumber = view.getFirstNumber();
                double secondNumber = 0;
                String result = "";

                // Проверка на операцию квадратного корня
                if (e.getSource() == view.getSqrtButton()) {
                    if (firstNumber < 0) {
                        result = "Ошибка: корень из отрицательного числа";
                    } else {
                        result = String.valueOf(Math.sqrt(firstNumber));
                        view.clearSecondNumber(); // Очистка второго числа
                    }
                } else {
                    secondNumber = view.getSecondNumber();
                    if (e.getSource() == view.getAddButton()) {
                        result = String.valueOf(model.add(firstNumber, secondNumber));
                    } else if (e.getSource() == view.getSubtractButton()) {
                        result = String.valueOf(model.subtract(firstNumber, secondNumber));
                    } else if (e.getSource() == view.getMultiplyButton()) {
                        result = String.valueOf(model.multiply(firstNumber, secondNumber));
                    } else if (e.getSource() == view.getDivideButton()) {
                        try {
                            result = String.valueOf(model.divide(firstNumber, secondNumber));
                        } catch (ArithmeticException ex) {
                            result = "Ошибка: деление на ноль";
                        }
                    } else if (e.getSource() == view.getPowerButton()) {
                        result = String.valueOf(Math.pow(firstNumber, secondNumber));
                    }
                }

                view.setResult(result);
            } catch (NumberFormatException ex) {
                view.setResult("Ошибка: введите корректные числа");
            }
        }
    }
}