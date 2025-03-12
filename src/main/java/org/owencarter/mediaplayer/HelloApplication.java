package org.owencarter.mediaplayer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        File file = new File("C:\\\\Users\\\\owent\\\\Downloads\\\\unknown.mp3");
//        System.out.println(file.exists());
        MediaPlayer mp = new MediaPlayer(new Media(file.toURI().toString()));
        HBox hbox = new PlaybackControls(mp);
        hbox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(hbox, 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}