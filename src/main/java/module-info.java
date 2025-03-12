module org.owencarter.mediaplayer {
    requires javafx.controls;
    requires java.desktop;
    requires javafx.media;


    opens org.owencarter.mediaplayer to javafx.fxml;
    exports org.owencarter.mediaplayer;
}