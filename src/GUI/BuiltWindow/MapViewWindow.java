package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.Layouts.MyGridPane;
import GUI.Scenes.MyScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.File;

public class MapViewWindow {
    public static MyButton cairoButton;
    public static MyButton romeButton;
    public static MyButton spartaButton;
    public static MyButton settingsButton;
    private final MyScene mapViewScene;


    public MapViewWindow() {


//        Constants.playMusic(Constants.openingMusic);
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/GUI/Resources/mapGame.jpg")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(Constants.GAME_WINDOW_SIZE_X,
                        Constants.GAME_WINDOW_SIZE_Y + 20, false,
                        false, false, false));

        MyGridPane mapViewSceneLayout = new MyGridPane();
        mapViewSceneLayout.setBackground(new Background(backgroundImage));


        cairoButton = new MyButton("cairo");
        cairoButton.setPrefWidth(400);
        cairoButton.setPrefHeight(180);
        cairoButton.setOpacity(0);

        cairoButton.setOnAction(e -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {

                if (Controller.game.getPlayer().getControlledCities().get(i).getName().
                        equalsIgnoreCase("cairo")) {
                    Controller.updateInWhatCity("Cairo");
                    Controller.enterCityMapButtonOnAction("Cairo");
                    break;
                } else {
                    if (spartaButton.isDisabled()) {
                        new PopUpWindow("Cairo not conquered yet.");
                    }
                }
            }
        });
        MyButton cairoButton2 = new MyButton("cairo");
        cairoButton2.setPrefWidth(400);
        cairoButton2.setPrefHeight(250);
        cairoButton2.setOpacity(0);
        cairoButton2.setOnAction(e -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {

                if (Controller.game.getPlayer().getControlledCities().get(i).getName().
                        equalsIgnoreCase("cairo")) {
                    Controller.updateInWhatCity("Cairo");
                    Controller.enterCityMapButtonOnAction("Cairo");
                    break;
                } else {
                    if (spartaButton.isDisabled()) {
                        new PopUpWindow("Cairo not conquered yet.");
                    }
                }
            }
        });

        romeButton = new MyButton("rome");
        romeButton.setPrefWidth(400);
        romeButton.setPrefHeight(150);
        romeButton.setOpacity(0);
        romeButton.setOnAction(e -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {
                if (Controller.game.getPlayer().getControlledCities().get(i).getName().
                        equalsIgnoreCase("rome")) {
                    Controller.updateInWhatCity("Rome");
                    Controller.enterCityMapButtonOnAction("Rome");
                    break;
                } else {
                    if (spartaButton.isDisabled()) {
                        new PopUpWindow("Rome not conquered yet.");
                        break;
                    }
                }
            }
        });


        MyButton romeButton2 = new MyButton("rome");
        romeButton2.setPrefWidth(400);
        romeButton2.setPrefHeight(150);
        romeButton2.setOpacity(0);
        romeButton2.setOnAction(e -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {

                if (Controller.game.getPlayer().getControlledCities().get(i).getName().
                        equalsIgnoreCase("rome")) {
                    Controller.updateInWhatCity("Rome");
                    Controller.enterCityMapButtonOnAction("Rome");
                    break;
                } else {
                    if (spartaButton.isDisabled()) {
                        new PopUpWindow("Rome not conquered yet.");
                        break;
                    }
                }
            }
        });

        MyButton spartaButton3 = new MyButton("sparta");
        spartaButton3.setPrefWidth(330);
        spartaButton3.setPrefHeight(220);
        spartaButton3.setOpacity(0);

        spartaButton3.setOnAction(e -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {

                if (Controller.game.getPlayer().getControlledCities().get(i).getName().
                        equalsIgnoreCase("sparta")) {
                    Controller.updateInWhatCity("Sparta");
                    Controller.enterCityMapButtonOnAction("Sparta");
                    break;
                } else {
                    if (spartaButton.isDisabled()) {
                        new PopUpWindow("Sparta not conquered yet.");
                    }
                }
            }
        });


        spartaButton = new MyButton("sparta");
        spartaButton.setPrefWidth(330);
        spartaButton.setPrefHeight(220);
        spartaButton.setOpacity(0);

        spartaButton.setOnAction(e -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {

                if (Controller.game.getPlayer().getControlledCities().get(i).getName().
                        equalsIgnoreCase("sparta")) {
                    Controller.updateInWhatCity("Sparta");
                    Controller.enterCityMapButtonOnAction("Sparta");
                    break;
                } else {
                    if (spartaButton.isDisabled()) {
                        new PopUpWindow("Sparta not conquered yet.");
                    }
                }
            }
        });


        MyButton spartaButton2 = new MyButton("sparta");
        spartaButton2.setPrefWidth(330);
        spartaButton2.setPrefHeight(220);
        spartaButton2.setOpacity(0);

        spartaButton2.setOnAction(e -> {
            for (int i = 0; i < Controller.game.getPlayer().getControlledCities().size(); i++) {

                if (Controller.game.getPlayer().getControlledCities().get(i).getName().
                        equalsIgnoreCase("sparta")) {
                    Controller.updateInWhatCity("Sparta");
                    Controller.enterCityMapButtonOnAction("Sparta");
                    break;
                } else {
                    if (spartaButton.isDisabled()) {
                        new PopUpWindow("Sparta not conquered yet.");
                    }
                }
            }
        });

        settingsButton = new MyButton("settings");
        settingsButton.setPrefWidth(400);
        settingsButton.setPrefHeight(400);
        settingsButton.setOpacity(0);

        settingsButton.setOnAction(e -> {
            Constants.playEffect(Constants.clickButton);
            Controller.settingsButtonPressed();
        });


        mapViewSceneLayout.add(cairoButton2, 0, 0);
        mapViewSceneLayout.add(Constants.spaceButton(), 0, 1);
        mapViewSceneLayout.add(settingsButton, 0, 2);
        mapViewSceneLayout.add(Constants.spaceButton(), 0, 3);
        mapViewSceneLayout.add(Constants.spaceButton(), 1, 0);
        mapViewSceneLayout.add(cairoButton, 1, 1);
        mapViewSceneLayout.add(Constants.spaceButton(), 1, 2);
        mapViewSceneLayout.add(Constants.spaceButton(), 1, 3);
        mapViewSceneLayout.add(romeButton2, 2, 0);
        mapViewSceneLayout.add(spartaButton2, 2, 1);
        mapViewSceneLayout.add(Constants.spaceButton(), 2, 2);
        mapViewSceneLayout.add(romeButton, 3, 0);
        mapViewSceneLayout.add(spartaButton3, 3, 1);
        mapViewSceneLayout.add(spartaButton, 3, 2);
        mapViewSceneLayout.add(Constants.spaceButton(), 3, 3);
        mapViewSceneLayout.add(Constants.spaceButton(), 4, 0);
        mapViewSceneLayout.add(Constants.spaceButton(), 4, 1);
        mapViewSceneLayout.add(Constants.spaceButton(), 4, 2);


        this.mapViewScene = new MyScene(mapViewSceneLayout);
    }

    public MyScene getMapViewScene() {
        return mapViewScene;
    }
}
