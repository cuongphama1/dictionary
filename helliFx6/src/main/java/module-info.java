module com.example.hellifx6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires freetts;


    opens com.example.hellifx6 to javafx.fxml;
    exports com.example.hellifx6;
}