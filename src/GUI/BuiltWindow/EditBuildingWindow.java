package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyChoiceBox;
import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyHbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class EditBuildingWindow {
    private final MyScene editBuildingScene;

    public static ChoiceBox<String> buildingChoiceBox;
    public static MyLabel buildingLevelLabel;
    public static MyButton harvestOrRecruitButton;


    public EditBuildingWindow(String marketLevel, String farmLevel,
                              String archeryRangeLevel, String stablesLevel,
                              String barracksLevel) {

        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hboxTop = new MyHbox();
        hboxTop.setAlignment(Pos.CENTER);
        hboxTop.setPadding(new Insets(50, 0, 0, 0));
        MyHbox hboxCenter = new MyHbox();
        hboxCenter.setAlignment(Pos.CENTER);

        MyButton buildButton = new MyButton("Build");
        buildButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 35));
        buildButton.setTextFill(Color.DARKGOLDENROD);
        buildButton.setOnAction(event -> {
            try {
                Controller.buildButtonPressedCairo(buildingChoiceBox.getValue());
            } catch (Exception e) {
                new PopUpWindow(e.toString());
            }

            if (Controller.inWhatCity.equalsIgnoreCase("cairo")) {
                CityViewWindowCairo.turnsLabel.setText("Turns: " + Controller.game.getCurrentTurnCount() +
                        "/50" +
                        " " +
                        "|" +
                        " Turns until" +
                        " " +
                        "arrived: " +
                        (Controller.roundsUntilArrived > -1 ?
                                Integer.toString(Controller.roundsUntilArrived - 1)
                                : "0"
                        ));
            } else if (Controller.inWhatCity.equalsIgnoreCase("sparta")) {

                CityViewWindowSparta.turnsLabel.setText("Turns: " + Controller.game.getCurrentTurnCount() +
                        "/50" +
                        " " +
                        "|" +
                        " Turns until" +
                        " " +
                        "arrived: " +
                        (Controller.roundsUntilArrived > -1 ?
                                Integer.toString(Controller.roundsUntilArrived - 1)
                                : "0"
                        ));
            } else {

                CityViewWindowRome.turnsLabel.setText("Turns: " + Controller.game.getCurrentTurnCount() +
                        "/50" +
                        " " +
                        "|" +
                        " Turns until" +
                        " " +
                        "arrived: " +
                        (Controller.roundsUntilArrived > -1 ?
                                Integer.toString(Controller.roundsUntilArrived - 1)
                                : "0"
                        ));
            }

        });

        MyButton upgradeButton = new MyButton("Upgrade");
        upgradeButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 35));
        upgradeButton.setTextFill(Color.DARKGOLDENROD);
        upgradeButton.setOnAction(event -> {
            try {
                Controller.upgradeButtonPressed(buildingChoiceBox.getValue());
            } catch (Exception e) {
                new PopUpWindow(e.toString());
            }


            if (Controller.inWhatCity.equalsIgnoreCase("cairo")) {
                CityViewWindowCairo.turnsLabel.setText("Turns: " + Controller.game.getCurrentTurnCount() +
                        "/50" +
                        " " +
                        "|" +
                        " Turns until" +
                        " " +
                        "arrived: " +
                        (Controller.roundsUntilArrived > -1 ?
                                Integer.toString(Controller.roundsUntilArrived - 1)
                                : "0"
                        ));
            } else if (Controller.inWhatCity.equalsIgnoreCase("sparta")) {

                CityViewWindowSparta.turnsLabel.setText("Turns: " + Controller.game.getCurrentTurnCount() +
                        "/50" +
                        " " +
                        "|" +
                        " Turns until" +
                        " " +
                        "arrived: " +
                        (Controller.roundsUntilArrived > -1 ?
                                Integer.toString(Controller.roundsUntilArrived - 1)
                                : "0"
                        ));
            } else {

                CityViewWindowRome.turnsLabel.setText("Turns: " + Controller.game.getCurrentTurnCount() +
                        "/50" +
                        " " +
                        "|" +
                        " Turns until" +
                        " " +
                        "arrived: " +
                        (Controller.roundsUntilArrived > -1 ?
                                Integer.toString(Controller.roundsUntilArrived - 1)
                                : "0"
                        ));
            }
        });


        buildingChoiceBox = new MyChoiceBox();
        buildingChoiceBox.getItems().addAll("Stable", "Barracks", "ArcheryRange"
                , "Market", "Farm");
        buildingChoiceBox.setPrefSize(300, 100);
        buildingChoiceBox.setStyle("-fx-font-size : 20pt;");
        buildingChoiceBox.setOnAction(e -> {


            if (buildingChoiceBox.getValue().equals("Stable")) {
                buildingLevelLabel.setText("Level: " + stablesLevel);
                harvestOrRecruitButton.setText("Recruit: " + getRecruitmentCost(
                        "Stable", Integer.parseInt(stablesLevel)));
                if (Integer.parseInt(stablesLevel) <= 0) {
                    upgradeButton.setText("Upgrade: 0");
                    buildButton.setText("Build: " + getCost("Stable",
                            Integer.parseInt(stablesLevel)));
                } else if (Integer.parseInt(stablesLevel) > 0) {
                    buildButton.setText("Build: 0");
                    upgradeButton.setText("Upgrade: " + getCost("Stable",
                            Integer.parseInt(stablesLevel)));
                }


            } else if (buildingChoiceBox.getValue().equals("Barracks")) {
                buildingLevelLabel.setText("Level: " + barracksLevel);
                harvestOrRecruitButton.setText("Recruit: " + getRecruitmentCost(
                        "Barracks", Integer.parseInt(barracksLevel)));
                if (Integer.parseInt(barracksLevel) == 0) {
                    upgradeButton.setText("Upgrade: 0");
                    buildButton.setText("Build: " + getCost("Barracks",
                            Integer.parseInt(barracksLevel)));
                } else if (Integer.parseInt(barracksLevel) > 0) {
                    buildButton.setText("Build: 0");
                    upgradeButton.setText("Upgrade: " + getCost("Barracks",
                            Integer.parseInt(barracksLevel)));
                }

            } else if (buildingChoiceBox.getValue().equals("ArcheryRange")) {
                buildingLevelLabel.setText("Level: " + archeryRangeLevel);
                harvestOrRecruitButton.setText("Recruit: " + getRecruitmentCost(
                        "ArcheryRange", Integer.parseInt(archeryRangeLevel)));
                if (Integer.parseInt(archeryRangeLevel) == 0) {
                    upgradeButton.setText("Upgrade: 0");
                    buildButton.setText("Build: " + getCost("ArcheryRange",
                            Integer.parseInt(archeryRangeLevel)));
                } else if (Integer.parseInt(archeryRangeLevel) > 0) {
                    buildButton.setText("Build: 0");
                    upgradeButton.setText("Upgrade: " + getCost("ArcheryRange",
                            Integer.parseInt(archeryRangeLevel)));
                }

            } else if (buildingChoiceBox.getValue().equals("Market")) {
                buildingLevelLabel.setText("Level: " + marketLevel);
                if (Integer.parseInt(marketLevel) == 0) {
                    upgradeButton.setText("Upgrade: 0");
                    buildButton.setText("Build: " + getCost("Market",
                            Integer.parseInt(marketLevel)));
                } else if (Integer.parseInt(marketLevel) > 0) {
                    buildButton.setText("Build: 0");
                    upgradeButton.setText("Upgrade: " + getCost("Market",
                            Integer.parseInt(marketLevel)));
                }

            } else if (buildingChoiceBox.getValue().equals("Farm")) {
                buildingLevelLabel.setText("Level: " + farmLevel);
                if (Integer.parseInt(farmLevel) == 0) {
                    upgradeButton.setText("Upgrade: 0");
                    buildButton.setText("Build: " + getCost("Farm",
                            Integer.parseInt(farmLevel)));
                } else if (Integer.parseInt(farmLevel) > 0) {
                    buildButton.setText("Build: 0");
                    upgradeButton.setText("Upgrade: " + getCost("Farm",
                            Integer.parseInt(farmLevel)));
                }
            }

            if (buildingChoiceBox.getValue().equalsIgnoreCase("Market") ||
                    buildingChoiceBox.getValue().equalsIgnoreCase("Farm")) {
                harvestOrRecruitButton.setOpacity(0);
                harvestOrRecruitButton.setDisable(true);
            } else {
                harvestOrRecruitButton.setOpacity(1);
                harvestOrRecruitButton.setDisable(false);
            }
        });


        buildingLevelLabel = new MyLabel("Level: 0");
        buildingLevelLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 90));
        buildingLevelLabel.setTextFill(Color.DARKGOLDENROD);


        harvestOrRecruitButton = new MyButton("Action");
        harvestOrRecruitButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 35));
        harvestOrRecruitButton.setTextFill(Color.DARKGOLDENROD);
        harvestOrRecruitButton.setOnAction(event -> {

            try {
                Controller.recruitButtonPressed(buildingChoiceBox.getValue());
            } catch (Exception e) {
                new PopUpWindow("Not Enough\nGold");
            }

            if (Controller.inWhatCity.equalsIgnoreCase("cairo")) {
                CityViewWindowCairo.turnsLabel.setText("Turns: " + Controller.game.getCurrentTurnCount() +
                        "/50" +
                        " " +
                        "|" +
                        " Turns until" +
                        " " +
                        "arrived: " +
                        (Controller.roundsUntilArrived > -1 ?
                                Integer.toString(Controller.roundsUntilArrived - 1)
                                : "0"
                        ));
            } else if (Controller.inWhatCity.equalsIgnoreCase("sparta")) {

                CityViewWindowSparta.turnsLabel.setText("Turns: " + Controller.game.getCurrentTurnCount() +
                        "/50" +
                        " " +
                        "|" +
                        " Turns until" +
                        " " +
                        "arrived: " +
                        (Controller.roundsUntilArrived > -1 ?
                                Integer.toString(Controller.roundsUntilArrived - 1)
                                : "0"
                        ));
            } else {

                CityViewWindowRome.turnsLabel.setText("Turns: " + Controller.game.getCurrentTurnCount() +
                        "/50" +
                        " " +
                        "|" +
                        " Turns until" +
                        " " +
                        "arrived: " +
                        (Controller.roundsUntilArrived > -1 ?
                                Integer.toString(Controller.roundsUntilArrived - 1)
                                : "0"
                        ));
            }

        });


        hboxTop.getChildren().addAll(buildingChoiceBox,
                Constants.spaceButton2(), buildingLevelLabel);

        hboxCenter.getChildren().addAll(harvestOrRecruitButton,
                Constants.spaceButton2(), buildButton, Constants.spaceButton2(),
                upgradeButton);

        borderPane.setTop(hboxTop);
        borderPane.setCenter(hboxCenter);

        this.editBuildingScene = new MyScene(borderPane);


    }


    private double getRecruitmentCost(String type, int level) {
        switch (type) {
            case "Stable":
                switch (level) {
                    case 0:
                        return 0;
                    case 1:
                        return 600;
                    case 2:
                        return 650;
                    case 3:
                        return 700;
                }
                break;
            case "ArcheryRange":
                switch (level) {
                    case 0:
                        return 0;
                    case 1:
                        return 400;
                    case 2:
                        return 450;
                    case 3:
                        return 500;
                }
                break;
            case "Barracks":
                switch (level) {
                    case 0:
                        return 0;
                    case 1:
                        return 500;
                    case 2:
                        return 550;
                    case 3:
                        return 600;
                }
                break;
        }
        return 0;
    }

    private double getCost(String type, int level) {
        switch (type) {
            case "Stable":
                switch (level) {
                    case 0:
                        return 2500;
                    case 1:
                        return 1500;
                    case 2:
                    case 3:
                        return 2000;
                }
                break;
            case "ArcheryRange":
                switch (level) {
                    case 0:
                        return 1500;
                    case 1:
                        return 800;
                    case 2:
                    case 3:
                        return 700;
                }
                break;
            case "Barracks":
                switch (level) {
                    case 0:
                        return 2000;
                    case 1:
                        return 1000;
                    case 2:
                    case 3:
                        return 1500;
                }
                break;
            case "Farm":
                switch (level) {
                    case 0:
                        return 1000;
                    case 1:
                        return 500;
                    case 2:
                    case 3:
                        return 700;

                }
                break;
            case "Market":
                switch (level) {
                    case 0:
                        return 1500;
                    case 1:
                        return 700;
                    case 2:
                    case 3:
                        return 1000;

                }
                break;
        }
        return 0;
    }

    public MyScene getEditBuildingScene() {
        return editBuildingScene;
    }
}
