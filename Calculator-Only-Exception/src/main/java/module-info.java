module com.example.calculatoronlyexception {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatoronlyexception to javafx.fxml;
    exports com.example.calculatoronlyexception;
}