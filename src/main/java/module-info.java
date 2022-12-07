module com.example.c195 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.c195 to javafx.fxml;
    exports com.example.c195;
    exports Helper;
    opens Helper to javafx.fxml;
    exports com.example.c195.DBaccess;
    opens com.example.c195.DBaccess to javafx.fxml;
    exports com.example.c195.Controller;
    opens com.example.c195.Controller to javafx.fxml;
    exports com.example.c195.Model;
    opens com.example.c195.Model to javafx.fxml;
}