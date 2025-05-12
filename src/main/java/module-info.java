module am.aua.ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens am.aua.ui to javafx.fxml;
    exports am.aua.ui;
}