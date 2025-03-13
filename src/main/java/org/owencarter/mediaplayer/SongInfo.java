package org.owencarter.mediaplayer;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

import java.util.Arrays;

public class SongInfo extends VBox {
    MediaPlayer mediaPlayer;
    public SongInfo(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.statusProperty().addListener((_, _, _) -> updateMetadata());
    }

    private void updateMetadata() {
        this.getChildren().clear();
        String[] metadata = {
                (String) mediaPlayer.getMedia().getMetadata().get("title"),
                (String) mediaPlayer.getMedia().getMetadata().get("artist"),
                (String) mediaPlayer.getMedia().getMetadata().get("album"),
//                (String) mediaPlayer.getMedia().getMetadata().get("year"),
        };
        Label[] labels = Arrays.stream(metadata).map(s -> new Label(s)).toArray(Label[]::new);


        this.getChildren().addAll(labels);
    }
}
