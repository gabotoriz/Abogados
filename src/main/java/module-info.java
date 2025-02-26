module com.example.despacho {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;


    opens com.example.despacho to javafx.fxml;
    exports com.example.despacho;
    exports com.example.despacho.Controller;
    opens com.example.despacho.Controller to javafx.fxml;
}