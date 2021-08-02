package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
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

public class ShowControlledArmiesWindow {
    private final MyScene scene;

    public ShowControlledArmiesWindow() {

        MyVbox vbox = new MyVbox();
        MyHbox hbox = new MyHbox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setPadding(new Insets(0, 0, 100, 0));
        hbox.setAlignment(Pos.CENTER);


        MyLabel chooseArmyLabel = new MyLabel("Choose Army");
        chooseArmyLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 130));
        chooseArmyLabel.setTextFill(Color.DARKGOLDENROD);

        MyButton cairoButton = new MyButton("Cairo");
        cairoButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        cairoButton.setPadding(new Insets(50, 50, 50, 50));
        cairoButton.setTextFill(Color.DARKGOLDENROD);
        cairoButton.setOnAction(event -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {
                if (!Controller.game.getPlayer().getControlledCities().get(i).
                        getName().equalsIgnoreCase("cairo")) {
                    new PopUpWindow("Cairo not conquered yet.");
                } else {
                    Controller.controlledArmyOfCityChosen("Cairo");
                }
            }
        });

        MyButton romeButton = new MyButton("Rome");
        romeButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        romeButton.setPadding(new Insets(50, 50, 50, 50));
        romeButton.setTextFill(Color.DARKGOLDENROD);
        romeButton.setOnAction(event -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {
                if (!Controller.game.getPlayer().getControlledCities().get(i).
                        getName().equalsIgnoreCase("rome")) {
                    new PopUpWindow("Rome not conquered yet.");
                } else {
                    Controller.controlledArmyOfCityChosen("Rome");
                }
            }
        });

        MyButton spartaButton = new MyButton("Sparta");
        spartaButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        spartaButton.setPadding(new Insets(50, 50, 50, 50));
        spartaButton.setTextFill(Color.DARKGOLDENROD);
        spartaButton.setOnAction(event -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {
                if (!Controller.game.getPlayer().getControlledCities().get(i).
                        getName().equalsIgnoreCase("sparta")) {
                    new PopUpWindow("Sparta not conquered yet.");
                } else {
                    Controller.controlledArmyOfCityChosen("Sparta");
                }
            }
        });

        MyButton backButton = new MyButton("Back");
        backButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        backButton.setPadding(new Insets(40, 40, 40, 40));
        backButton.setTextFill(Color.DARKGOLDENROD);
        backButton.setOnAction(event -> {
//            Controller.goBackControlledArmiesWindow();
        });

        vbox.getChildren().addAll(chooseArmyLabel, Constants.spaceButton2(), hbox,
                backButton);
        hbox.getChildren().addAll(cairoButton, Constants.spaceButton(),
                romeButton, Constants.spaceButton(), spartaButton);

        scene = new MyScene(vbox);
    }

    public MyScene getScene() {
        return scene;
    }
}
