module com.example._11_teledominospizza {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.desktop;
    requires java.sql;


    opens com.example._11_teledominospizza to javafx.fxml;
    opens Pizzeria to javafx.base;
    exports com.example._11_teledominospizza;
}