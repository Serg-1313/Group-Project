package am.aua.ui;

import am.aua.core.Player;
import am.aua.core.board.Area;
import am.aua.core.board.Board;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;

public class UiApp extends Application {
    Player[] players;
    Area[] areas;
    Board board;
    Circle[] circles;
    Polygon[] hexes;

    @Override
    public void start(Stage stage) throws IOException {

        StackPane stackPane = new StackPane();
        StackPane stackPane2 = new StackPane();
        StackPane stackPane3 = new StackPane();
        Button button = new Button("2 Players");
        Button button2 = new Button("3 Players");
        Button button3 = new Button("4 Players");
        stackPane.getChildren().add(button);
        stackPane2.getChildren().add(button2);
        stackPane3.getChildren().add(button3);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setCenter(stackPane2);
        borderPane.setBottom(stackPane3);
        Scene scene = new Scene(borderPane,600,400);
        stage.setTitle("Catan Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}