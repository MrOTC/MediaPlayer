package org.owencarter.mediaplayer;

import javafx.scene.layout.Region;
import javafx.scene.shape.SVGPath;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    private static final double REQUIRED_WIDTH = 50.0;
    private static final double REQUIRED_HEIGHT = 50.0;

    public static Region makePathFromSvg(String filename) {
        SVGPath svgpath = new SVGPath();
        svgpath.setContent(pathFromSvg(Util.class.getResource(filename)));
        final Region svgShape = new Region();
        svgShape.setShape(svgpath);
        svgShape.setMinSize(REQUIRED_WIDTH, REQUIRED_HEIGHT);
        svgShape.setPrefSize(REQUIRED_WIDTH, REQUIRED_HEIGHT);
        svgShape.setMaxSize(REQUIRED_WIDTH, REQUIRED_HEIGHT);
        svgShape.setStyle("-fx-background-color: black;");
        return svgShape;
    }

    private static String pathFromSvg(URL url) {
        try {
            String fileContent = Files.readString(Paths.get(url.toURI()));
            String startKey = "<path d=\"";
            String endKey = "\"";
            int startIndex = fileContent.indexOf(startKey) + startKey.length();
            int endIndex = fileContent.substring(startIndex).indexOf(endKey) + startIndex;
            return fileContent.substring(startIndex, endIndex);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
