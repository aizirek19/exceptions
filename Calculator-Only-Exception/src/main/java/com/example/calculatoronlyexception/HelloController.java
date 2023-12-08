package com.example.calculatoronlyexception;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField display;

    private String currentInput = "";
    private double currentResult = 0;
    private String currentOperator = "";

    private Calculator calculator = new Calculator();

    @FXML
    public void handleDigit(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (!button.getText().equals("0") || !currentInput.equals("0"))
            currentInput += button.getText();

        display.setText(currentInput);
    }

    @FXML
    public void handleOperator(ActionEvent event) {
        Button button = (Button) event.getSource();
        currentOperator = button.getText();
        currentResult = Double.parseDouble(currentInput);
        currentInput = "";
    }

    @FXML
    public void calculate() {
        if (!currentInput.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            try {
                switch (currentOperator) {
                    case "+":
                        currentResult = calculator.add(currentResult, secondOperand);
                        break;
                    case "-":
                        currentResult = calculator.subtract(currentResult, secondOperand);
                        break;
                    case "*":
                        currentResult = calculator.multiply(currentResult, secondOperand);
                        break;
                    case "/":
                        currentResult = calculator.divide(currentResult, secondOperand);
                        break;
                    case "sqrt":
                        currentResult = calculator.squareRoot(secondOperand);
                        break;
                    case "^":
                        currentResult = calculator.power(currentResult, secondOperand);
                        break;
                    // Add other cases for additional operators

                    default:
                        // Handle invalid operator
                        display.setText("Error: Invalid Operator");
                        return;
                }
                display.setText(String.valueOf(currentResult));
            } catch (DivisionByZeroException | IllegalArgumentException e) {
                display.setText("Error: " + e.getMessage());
            }

            currentInput = "";
            currentOperator = "";
        }
    }

    @FXML
    public void clear() {
        currentInput = "";
        currentResult = 0;
        currentOperator = "";
        display.clear();
    }
}