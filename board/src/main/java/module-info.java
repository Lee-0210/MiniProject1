module com.team1 {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    requires javafx.graphics;
    opens com.team1 to javafx.base, javafx.graphics, javafx.fxml;
    opens com.team1.DTO to javafx.base;
    opens com.team1.Controller to javafx.fxml;
    exports com.team1;
}
