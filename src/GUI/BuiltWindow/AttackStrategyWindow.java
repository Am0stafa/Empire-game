package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Main;
import GUI.Scenes.MyScene;
import engine.City;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import units.Unit;

import java.io.File;
import java.util.Random;

public class AttackStrategyWindow {

    public static MyButton city2Button;
    public static MyButton city1Button;

    private final MyScene scene;

    public AttackStrategyWindow(boolean conquoredCairo, boolean conquoredRome,
                                boolean conquoredSparta, boolean button1Active,
                                boolean button2Active) {


        String[] cities = new String[2];
        cities[0] = "conquered";
        cities[1] = "conquered";
        for (int i = 0; i < cities.length; i++) {
            if (conquoredCairo == false) {
                cities[i] = "Cairo";
                conquoredCairo = true;
            } else if (conquoredRome == false) {
                cities[i] = "Rome";
                conquoredRome = true;
            } else if (conquoredSparta == false) {
                cities[i] = "Sparta";
                conquoredSparta = true;
            }
        }


        MyVbox vbox = new MyVbox();
        MyHbox hbox = new MyHbox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setPadding(new Insets(0, 0, 60, 0));
        hbox.setAlignment(Pos.CENTER);
        MyVbox vbox2 = new MyVbox();
        vbox2.setAlignment(Pos.CENTER);
        MyVbox vbox3 = new MyVbox();
        vbox3.setAlignment(Pos.CENTER);


        MyLabel chooseArmyLabel = new MyLabel("Attack: ");
        chooseArmyLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 80));
        chooseArmyLabel.setTextFill(Color.DARKGOLDENROD);

        city1Button = new MyButton(cities[0]);
        city1Button.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        city1Button.setTextFill(Color.DARKGOLDENROD);
        city1Button.setOnAction(event -> {
            Controller.cityToAttack = cities[0];


            if (!Controller.game.getPlayer().getControlledArmies().isEmpty()) {
                if (!Controller.game.getPlayer().getControlledArmies().get(0).getCurrentLocation().equalsIgnoreCase(cities[0])) {
                    Controller.game.targetCity(Controller.game.getPlayer().getControlledArmies().get(0), cities[0]);
                    Controller.roundsUntilArrived =
                            Controller.game.getPlayer().getControlledArmies().get(0).getDistancetoTarget();
                    Controller.button2Disabled = true;
                    Controller.button1Disabled = true;

                }


                City cityToAttack = null;
                for (City city : Controller.game.getAvailableCities()
                ) {
                    if (city.getName().equalsIgnoreCase(Controller.cityToAttack)) {
                        cityToAttack = city;
                    }
                }
                if (Controller.game.getPlayer().getControlledArmies().get(0).getDistancetoTarget() < 1) {
                    try {
                        Controller.game.getPlayer().laySiege(
                                Controller.game.getPlayer().getControlledArmies().get(0),
                                cityToAttack

                        );
                        Controller.cityToAttackButtonPressed();
                        Controller.roundsUntilArrived = -200;
                        city1Button.setDisable(true);


                    } catch (Exception e) {


                    }
                } else {
                    new PopUpWindow("Reached In " +
                            Controller.game.getPlayer().getControlledArmies().get(0).getDistancetoTarget()
                            + " Turns");
                }
            } else {
                new PopUpWindow("With What Army ?");
            }
        });

        city2Button = new MyButton(cities[1]);
        city2Button.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        city2Button.setTextFill(Color.DARKGOLDENROD);
        city2Button.setOnAction(event -> {
            Controller.cityToAttack = cities[1];


            if (!Controller.game.getPlayer().getControlledArmies().isEmpty()) {

                if (!Controller.game.getPlayer().getControlledArmies().get(0).getCurrentLocation().equalsIgnoreCase(cities[1])) {
                    Controller.game.targetCity(Controller.game.getPlayer().getControlledArmies().get(0), cities[1]);
                    Controller.roundsUntilArrived =
                            Controller.game.getPlayer().getControlledArmies().get(0).getDistancetoTarget();
                    Controller.button1Disabled = true;
                    Controller.button2Disabled = true;
                }

                City cityToAttack = null;
                for (City city : Controller.game.getAvailableCities()
                ) {
                    if (city.getName().equalsIgnoreCase(Controller.cityToAttack)) {
                        cityToAttack = city;
                    }
                }
                if (Controller.game.getPlayer().getControlledArmies().get(0).getDistancetoTarget() <= 0) {
                    try {
                        Controller.game.getPlayer().laySiege(
                                Controller.game.getPlayer().getControlledArmies().get(0),
                                cityToAttack);

                        Controller.cityToAttackButtonPressed();
                        Controller.roundsUntilArrived = -200;
                        city2Button.setDisable(true);

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                } else {
                    new PopUpWindow("Reached In " +
                            Controller.game.getPlayer().getControlledArmies().get(0).getDistancetoTarget()
                            + " Turns");

                }
            } else {
                new PopUpWindow("With What Army ?");
            }

        });

        MyButton autoResolveBtn1 = new MyButton("Auto-Resolve");
        autoResolveBtn1.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        autoResolveBtn1.setTextFill(Color.DARKGOLDENROD);
        autoResolveBtn1.setOnAction(event -> {

            Controller.cityToAttack = city1Button.getText();

            Random random = new Random();
            int chance = random.nextInt(10);

            if (chance > 5) {
                new PopUpWindow("You Lost This Battle");
                Main.window.setScene(new MapViewWindow().getMapViewScene());
                for (Unit units :
                        Controller.game.getPlayer().getControlledArmies().get(0).getUnits()
                ) {
                    Controller.game.getPlayer().getControlledArmies().get(0).getUnits().clear();
                }
            } else {
                new PopUpWindow("You Won This Battle");
                Main.window.setScene(new MapViewWindow().getMapViewScene());
                for (int i = 0; i < Controller.game.getPlayer().getControlledArmies().get(0).getUnits().size() / 2; i++) {
                    Controller.game.getPlayer().getControlledArmies().get(0).getUnits().remove(
                            Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(i)
                    );
                }

                City city1 = null;
                for (City cityTemp : Controller.game.getAvailableCities()
                ) {
                    if (cityTemp.getName().equalsIgnoreCase(Controller.cityToAttack)) {
                        city1 = cityTemp;
                    }
                }

                if (city1.getDefendingArmy().getUnits().isEmpty()) {
                    BattleFieldWindow.mapButton.setDisable(false);
                    new PopUpWindow("You Won This Battle");
                    if (MapViewWindow.cairoButton.getText().equalsIgnoreCase(city1.getName())) {
                        Controller.game.occupy(Controller.game.getPlayer().getControlledArmies().get(0), "cairo");
                        MapViewWindow.cairoButton.setDisable(false);
                    } else if (MapViewWindow.romeButton.getText().equalsIgnoreCase(city1.getName())) {
                        Controller.game.occupy(Controller.game.getPlayer().getControlledArmies().get(0), "rome");
                        MapViewWindow.romeButton.setDisable(false);
                    } else if (MapViewWindow.spartaButton.getText().equalsIgnoreCase(city1.getName())) {
                        Controller.game.occupy(Controller.game.getPlayer().getControlledArmies().get(0), "sparta");
                        MapViewWindow.spartaButton.setDisable(false);
                    }
                    Controller.game.getPlayer().getControlledCities().add(city1);

                }
            }

        });

        MyButton autoResolveBtn2 = new MyButton("Auto-Resolve");
        autoResolveBtn2.setFont(Font.loadFont(new

                File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").

                toURI().

                toString(), 30));
        autoResolveBtn2.setTextFill(Color.DARKGOLDENROD);
        autoResolveBtn2.setOnAction(event -> {


            Controller.cityToAttack = city2Button.getText();

            Random random = new Random();
            int chance = random.nextInt(10);

            if (chance > 5) {
                new PopUpWindow("You Lost This Battle");
                Main.window.setScene(new MapViewWindow().getMapViewScene());
                for (Unit units :
                        Controller.game.getPlayer().getControlledArmies().get(0).getUnits()
                ) {
                    Controller.game.getPlayer().getControlledArmies().get(0).getUnits().clear();
                }
            } else {
                new PopUpWindow("You Won This Battle");
                Main.window.setScene(new MapViewWindow().getMapViewScene());
                for (int i = 0; i < Controller.game.getPlayer().getControlledArmies().get(0).getUnits().size() / 2; i++) {
                    Controller.game.getPlayer().getControlledArmies().get(0).getUnits().remove(
                            Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(i)
                    );
                }

                City city1 = null;
                for (City cityTemp : Controller.game.getAvailableCities()
                ) {
                    if (cityTemp.getName().equalsIgnoreCase(Controller.cityToAttack)) {
                        city1 = cityTemp;
                    }
                }

                if (city1.getDefendingArmy().getUnits().isEmpty()) {
                    BattleFieldWindow.mapButton.setDisable(false);
                    new PopUpWindow("You Won This Battle");
                    if (MapViewWindow.cairoButton.getText().equalsIgnoreCase(city1.getName())) {
                        Controller.game.occupy(Controller.game.getPlayer().getControlledArmies().get(0), "cairo");
                        MapViewWindow.cairoButton.setDisable(false);
                    } else if (MapViewWindow.romeButton.getText().equalsIgnoreCase(city1.getName())) {
                        Controller.game.occupy(Controller.game.getPlayer().getControlledArmies().get(0), "rome");
                        MapViewWindow.romeButton.setDisable(false);
                    } else if (MapViewWindow.spartaButton.getText().equalsIgnoreCase(city1.getName())) {
                        Controller.game.occupy(Controller.game.getPlayer().getControlledArmies().get(0), "sparta");
                        MapViewWindow.spartaButton.setDisable(false);
                    }
                    Controller.game.getPlayer().getControlledCities().add(city1);

                }
            }

        });


        vbox2.getChildren().

                addAll(city1Button, Constants.spaceButton(),

                        autoResolveBtn1);
        vbox3.getChildren().

                addAll(city2Button, Constants.spaceButton(), autoResolveBtn2);
        vbox.getChildren().

                addAll(chooseArmyLabel, Constants.spaceButton2(), hbox);
        hbox.getChildren().

                addAll(vbox2, Constants.spaceButton(),

                        vbox3);

        city1Button.setDisable(Controller.button1Disabled);
        city2Button.setDisable(Controller.button2Disabled);

        this.scene = new

                MyScene(vbox);

    }

    public MyScene getScene() {
        return scene;
    }
}
