package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.CustomControllers.MyTextArea;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyHbox;
import GUI.Main;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.io.File;

public class GameDescriptionWindow {
    private final MyScene gameDescriptionScene;
    public static MyButton readyButton;

    public GameDescriptionWindow() {


        //        Setting the background image for the welcome page
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/GUI/Resources/background_welcome.png")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        MyBorderPane gameDescriptionSceneLayout = new MyBorderPane();
        gameDescriptionSceneLayout.setBackground(new Background(backgroundImage));


//        Creating and setting hbox for title
        //        setting the label properties
        MyLabel gamDescriptionLabel = new MyLabel("Game Description");
        gamDescriptionLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        gamDescriptionLabel.setTextFill(Color.DARKGOLDENROD);
        MyHbox gameDescriptionTextTitleHbox = new MyHbox();
        gameDescriptionTextTitleHbox.setAlignment(Pos.CENTER);
        gameDescriptionTextTitleHbox.getChildren().add(gamDescriptionLabel);


//        Creating Hbox for textfield and textfield
        MyHbox gameDescriptionTextHbox = new MyHbox();
        gameDescriptionTextHbox.setAlignment(Pos.BOTTOM_CENTER);
        MyTextArea gameDescriptionText = new MyTextArea(Constants.gameDescription);
        gameDescriptionText.setEditable(false);
        gameDescriptionText.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        gameDescriptionText.setStyle("-fx-text-inner-color: #6A1412");
        gameDescriptionText.setOpacity(0.8);
        gameDescriptionTextHbox.setPadding(new Insets(50, 50, 50, 50));
        gameDescriptionTextHbox.getChildren().add(gameDescriptionText);


//        Setting button properties and hbox for button
        MyHbox readyButtonHbox = new MyHbox();
        readyButtonHbox.setPadding(new Insets(10, 600 , 10, 580));
        readyButton = new MyButton("Proceed");
        readyButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        readyButton.setTextFill(Color.DARKGOLDENROD);
        readyButton.setShape(new Circle(1.5));
        readyButton.setMinSize(200, 200);
        readyButton.setOpacity(0.9);
        Controller.gameDescriptionWindowProceedButtonOnAction();

        readyButtonHbox.getChildren().add(readyButton);

        gameDescriptionSceneLayout.setTop(gameDescriptionTextTitleHbox);
        gameDescriptionSceneLayout.setCenter(gameDescriptionTextHbox);
        gameDescriptionSceneLayout.setBottom(readyButtonHbox);

        this.gameDescriptionScene = new MyScene(gameDescriptionSceneLayout);

    }

    public MyScene getGameDescriptionScene() {
        return gameDescriptionScene;
    }
}
