module com.example.ecsedimilan_javafxrestclientdolgozat {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.ecsedimilan_javafxrestclientdolgozat to javafx.fxml,com.google.gson;
    exports com.example.ecsedimilan_javafxrestclientdolgozat;

}