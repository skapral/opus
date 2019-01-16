package com.github.skapral.opus;

import com.pragmaticobjects.oo.atom.anno.NotAtom;
import io.vavr.collection.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


@NotAtom
public class Main extends Application {
    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*String s = Main.class.getClassLoader().getResource("index.html").toExternalForm();
        System.out.println(s);*/

        List.of("a", "b", "c").forEach(System.out::println);

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.setJavaScriptEnabled(true);
        engine.setOnAlert(System.out::println);
        engine.load("https://mail.ru");
        GridPane pane = new GridPane();
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(100);
        pane.getRowConstraints().addAll(row);
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(100);
        pane.getColumnConstraints().addAll(column);
        pane.add(webView, 0, 0);
        primaryStage.setScene(
            new Scene(
                pane
            )
        );
        primaryStage.show();
    }
}
