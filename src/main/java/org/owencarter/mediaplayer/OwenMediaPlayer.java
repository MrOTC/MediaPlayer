package org.owencarter.mediaplayer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class OwenMediaPlayer extends Application {
    @Override
    public void start(Stage stage) {
        File file = new File("C:\\\\Users\\\\owent\\\\Downloads\\\\I Want It All.mp3");
//        System.out.println(file.exists());
        Media media = new Media(file.toURI().toString());
        javafx.scene.media.MediaPlayer mp = new javafx.scene.media.MediaPlayer(media);
        PlaybackControls playbackControls = new PlaybackControls(mp);
        SongInfo songInfo = new SongInfo(mp);
        SongQueue songQueue = new SongQueue();
        Button addSongButton = new Button("Add Song");
        addSongButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File newSong = fileChooser.showOpenDialog(stage);
            if(newSong != null) {
                songQueue.addSong(new Media(newSong.toURI().toString()));
            }
        });
        playbackControls.getChildren().addAll(songInfo, songQueue, addSongButton);
        playbackControls.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(playbackControls, 800, 600);
        stage.setTitle("Media Player");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}