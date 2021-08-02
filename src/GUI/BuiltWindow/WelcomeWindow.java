package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyHbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Pos;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.io.File;

public class WelcomeWindow {

    private final MyScene welcomeScene;
    public static MyButton startGameButton;

    public WelcomeWindow() {
        //        Music player for this window
        Constants.playMusic(Constants.openingMusic);

//        Setting the background image for the welcome page
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/GUI/Resources/background_welcome.png")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);

        MyBorderPane welcomeSceneLayout = new MyBorderPane();
        welcomeSceneLayout.setBackground(new Background(backgroundImage));

//        setting the label properties
        MyLabel welcomeLabel = new MyLabel("Welcome To Empire Building");
        welcomeLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 60));
        welcomeLabel.setTextFill(Color.DARKGOLDENROD);
        InnerShadow shadow = new InnerShadow();
        shadow.setOffsetX(4.0f);
        shadow.setOffsetY(4.0f);
        welcomeLabel.setEffect(shadow);


//        Creating hbox for title
        MyHbox welcomeTitleHbox = new MyHbox();
        welcomeTitleHbox.getChildren().add(welcomeLabel);
        welcomeTitleHbox.setAlignment(Pos.CENTER);

//        Setting button properties
        startGameButton = new MyButton("Start Game");
        startGameButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        startGameButton.setTextFill(Color.DARKGOLDENROD);
        startGameButton.setShape(new Circle(1.5));
        startGameButton.setMinSize(200, 200);
        startGameButton.setOpacity(0.9);
        Controller.welcomeWindowStartGameButtonAction();


        welcomeSceneLayout.setTop(welcomeTitleHbox);
        welcomeSceneLayout.setCenter(startGameButton);
        this.welcomeScene = new MyScene(welcomeSceneLayout);

    }


    public MyScene getWelcomeScene() {
        return welcomeScene;
    }

}
