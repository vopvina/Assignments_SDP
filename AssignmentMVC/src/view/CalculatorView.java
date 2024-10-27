package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField firstNumber = new JTextField(10);
    private JTextField secondNumber = new JTextField(10);
    private JButton addButton = new JButton("+");
    private JButton subtractButton = new JButton("-");
    private JButton powerButton = new JButton("^");
    private JButton multiplyButton = new JButton("*");
    private JButton divideButton = new JButton("/");
    private JButton sqrtButton = new JButton("√");
    private JLabel resultLabel = new JLabel("Результат:");

    public CalculatorView() {
        // Настройка окна
        setTitle("Калькулятор");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Первая строка: поля для ввода чисел
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Первое число:"), gbc);
        gbc.gridx = 1;
        add(firstNumber, gbc);
        gbc.gridx = 2;
        add(new JLabel("Второе число:"), gbc);
        gbc.gridx = 3;
        add(secondNumber, gbc);

        // Вторая строка: кнопки "+", "-", "^"
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(addButton, gbc);
        gbc.gridx = 1;
        add(subtractButton, gbc);
        gbc.gridx = 2;
        add(powerButton, gbc);

        // Третья строка: кнопки "*", "/", "√"
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(multiplyButton, gbc);
        gbc.gridx = 1;
        add(divideButton, gbc);
        gbc.gridx = 2;
        add(sqrtButton, gbc);

        // Четвёртая строка: результат
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        add(resultLabel, gbc);
    }

    // Методы для получения введённых значений
    public double getFirstNumber() {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber() {
        return Double.parseDouble(secondNumber.getText());
    }

    // Метод для установки результата
    public void setResult(String result) {
        resultLabel.setText("Результат: " + result);
    }

    // Регистрация слушателя для кнопок
    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        powerButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
        sqrtButton.addActionListener(listener);
    }

    // Методы для доступа к кнопкам
    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getPowerButton() {
        return powerButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getSqrtButton() {
        return sqrtButton;
    }

    // Метод для очистки второго числа (для операций, где оно не требуется)
    public void clearSecondNumber() {
        secondNumber.setText("");
    }
}