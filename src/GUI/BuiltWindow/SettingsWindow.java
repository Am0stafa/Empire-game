package GUI.BuiltWindow;

import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.CustomControllers.MyTextField;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class SettingsWindow {
    private final MyScene settingsScene;

    public SettingsWindow(String playerName, String timePlayed) {
//        Setting the background for page

        MyBorderPane settingsLayout = new MyBorderPane();
        settingsLayout.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));

//        setting the label properties
        MyLabel settingsTitleLabel = new MyLabel("Settings");
        settingsTitleLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 130));
        settingsTitleLabel.setTextFill(Color.DARKGOLDENROD);


//        Creating hbox for title
        MyHbox settingsTitleHbox = new MyHbox();
        settingsTitleHbox.getChildren().add(settingsTitleLabel);
        settingsTitleHbox.setAlignment(Pos.CENTER);
//        settingsTitleHbox.setPadding(new Insets(0, 0, 100, 120));


//        Setting hbox for buttons
        MyHbox buttonsHbox = new MyHbox();
        buttonsHbox.setAlignment(Pos.CENTER);
        buttonsHbox.setPadding(new Insets(0, 0, 160, 0));

//        Setting button properties
        MyButton continueGameButton = new MyButton("Continue");
        continueGameButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        continueGameButton.setTextFill(Color.DARKGOLDENROD);
        continueGameButton.setOnAction(event -> {
            Controller.settingsButtonOnAction("Back");
        });

        MyButton spaceButton = new MyButton("SP");
        spaceButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        spaceButton.setTextFill(Color.DARKGOLDENROD);
        spaceButton.setOpacity(0);

        MyButton exitGameButton = new MyButton("Quit Game");
        exitGameButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        exitGameButton.setTextFill(Color.DARKGOLDENROD);
//        continueGameButton.setMinSize(200, 200);
        exitGameButton.setOnAction(event -> {
            Controller.settingsButtonOnAction("Exit");
        });

        buttonsHbox.getChildren().addAll(continueGameButton, spaceButton,
                exitGameButton);


        //        Setting hbox for TextFields
        MyVbox textFieldsVbox = new MyVbox();
        textFieldsVbox.setAlignment(Pos.CENTER);
        MyHbox textFieldsHbox1 = new MyHbox();
        textFieldsHbox1.setPadding(new Insets(20, 20, 20, 20));
        textFieldsHbox1.setAlignment(Pos.CENTER);
        MyHbox textFieldsHbox2 = new MyHbox();
        textFieldsHbox2.setPadding(new Insets(20, 20, 20, 20));
        textFieldsHbox2.setAlignment(Pos.CENTER);

        MyLabel playerNameLabel = new MyLabel("Player Name:");
        playerNameLabel.setPadding(new Insets(0, 20, 0, 0));
        playerNameLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        playerNameLabel.setTextFill(Color.DARKGOLDENROD);

        MyTextField playerNameTextField = new MyTextField();
        playerNameTextField.setText(playerName);
        playerNameTextField.setEditable(false);
        playerNameTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        playerNameTextField.setStyle("-fx-text-inner-color: #6A1412");


        MyLabel timePlayedLabel = new MyLabel("Time played:");
        timePlayedLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        timePlayedLabel.setPadding(new Insets(0, 20, 0, 0));
        timePlayedLabel.setTextFill(Color.DARKGOLDENROD);

        MyTextField timePlayedTextField = new MyTextField();
        timePlayedTextField.setText(timePlayed + " seconds");
        timePlayedTextField.setEditable(false);
        timePlayedTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        timePlayedTextField.setStyle("-fx-text-inner-color: #6A1412");

        textFieldsHbox1.getChildren().addAll(playerNameLabel, playerNameTextField);
        textFieldsHbox2.getChildren().addAll(timePlayedLabel, timePlayedTextField);
        textFieldsVbox.getChildren().addAll(textFieldsHbox1, textFieldsHbox2);


        settingsLayout.setTop(settingsTitleHbox);
        settingsLayout.setCenter(textFieldsVbox);
        settingsLayout.setBottom(buttonsHbox);

        this.settingsScene = new MyScene(settingsLayout);

    }

    public MyScene getSettingsScene() {
        return settingsScene;
    }
}
