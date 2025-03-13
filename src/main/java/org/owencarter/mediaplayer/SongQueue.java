package org.owencarter.mediaplayer;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SongQueue extends TableView<Media> {
    ObservableList<Media> mediaList = FXCollections.observableArrayList();
    public SongQueue() {
        this.setItems(mediaList);
        TableColumn<Media, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper((String) data.getValue().getMetadata().get("title")));
        TableColumn<Media, String> artistColumn = new TableColumn<>("Artist");
        artistColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper((String) data.getValue().getMetadata().get("artist")));
        TableColumn<Media, String> albumColumn = new TableColumn<>("Album");
        albumColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper((String) data.getValue().getMetadata().get("album")));
        this.getColumns().addAll(titleColumn, artistColumn, albumColumn);
    }

    public void addSong(Media media) {
        mediaList.add(media);
        MediaPlayer checkMetadata = new MediaPlayer(media);
        checkMetadata.statusProperty().addListener((_, _, _) -> {
            this.refresh();
        });
    }
}
