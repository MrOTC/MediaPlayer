package org.owencarter.mediaplayer;

import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;

import static org.owencarter.mediaplayer.Util.makePathFromSvg;

public class PlaybackControls extends HBox {
    public PlaybackControls(MediaPlayer mediaPlayer) {

        Button playPause = new Button();
        playPause.setGraphic(makePathFromSvg("playbutton.svg"));
        playPause.setPrefWidth(100);
        playPause.setDisable(false);
        playPause.setOnAction(_ -> {
            if (mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
                mediaPlayer.play();
            } else {
                mediaPlayer.pause();
            }
        });
        mediaPlayer.statusProperty().addListener((_, _, newValue) -> {
            if (newValue != MediaPlayer.Status.PLAYING) {
                playPause.setGraphic(makePathFromSvg("playbutton.svg"));
            } else {
                playPause.setGraphic(makePathFromSvg("pause.svg"));
            }
        });

        Button skipNext = new Button();
        skipNext.setGraphic(makePathFromSvg("skipnext.svg"));
        skipNext.setPrefWidth(100);
        skipNext.setDisable(true);
        skipNext.setOnAction(_ -> mediaPlayer.play());

        Button skipPrevious = new Button();
        skipPrevious.setGraphic(makePathFromSvg("skipprevious.svg"));
        skipPrevious.setPrefWidth(100);
        skipPrevious.setDisable(true);
        skipPrevious.setOnAction(_ -> mediaPlayer.play());

        ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefWidth(250);
        mediaPlayer.currentTimeProperty().addListener((_, _, newValue) -> {
            progressBar.setProgress(newValue.toMillis() / mediaPlayer.getTotalDuration().toMillis());
        });

        mediaPlayer.setVolume(.2);

        super.getChildren().addAll(skipPrevious, playPause, skipNext, progressBar);
    }
}

