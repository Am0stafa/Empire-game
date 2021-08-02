package GUI.BuiltWindow;

import GUI.Constants;
import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyBorderPane;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class PopUpWindow {
    public PopUpWindow(String msg) {
        MyBorderPane borderPane = new MyBorderPane();

        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));

        MyLabel msgLabel = new MyLabel(msg);
        msgLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        msgLabel.setTextFill(Color.DARKGOLDENROD);


        borderPane.setCenter(msgLabel);
        Scene scene = new Scene(borderPane);
        Stage window = new Stage();
        window.setMinWidth(350);
        window.setMinHeight(350);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }
}
