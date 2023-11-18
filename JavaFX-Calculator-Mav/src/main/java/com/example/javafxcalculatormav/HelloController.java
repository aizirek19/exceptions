package com.example.javafxcalculatormav;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public void handleButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        if (startNewInput) {
            display.clear();
            startNewInput = false;
        }

        // Check if the input is a valid number
        try {
            Double.parseDouble(display.getText() + buttonText);
            display.appendText(buttonText);
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    public void handleOperation(ActionEvent event) {
        Button button = (Button) event.getSource();
        String currentOperator = button.getText();

        if (!operator.isEmpty()) {
            return;
        }

        // Check if the input is a valid number
        try {
            num1 = Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            display.setText("Error");
            return;
        }

        operator = currentOperator;
        startNewInput = true;
    }

    public void handleEquals() {
        if (operator.isEmpty()) {
            return;
        }

        // Check if the input is a valid number
        double num2;
        try {
            num2 = Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            display.setText("Error");
            return;
        }

        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error: Division by zero");
                    return;
                }
                break;
        }

        display.setText(String.valueOf(result));
        operator = "";
        startNewInput = true;
    }

    public void handleClear() {
        display.clear();
        operator = "";
        startNewInput = true;
    }
}

