package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyImageView;
import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyGridPane;
import GUI.Layouts.MyHbox;
import GUI.Main;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class CityViewWindowRome {

    public static MyLabel cityNameLabelRome;
    public static MyLabel playerGoldAmountLabel;
    public static MyLabel playerFoodAmountLabel;
    public static MyLabel turnsLabel;

    private final MyScene cityViewScene;
    public static MyGridPane cityViewGridPaneRome;

    public CityViewWindowRome(
            String city,
            String playerGold, String playerFood,
            String turns, String marketLevel, String farmLevel,
            String archeryRangeLevel, String stablesLevel,
            String barracksLevel
    ) {


        MyBorderPane borderPane = new MyBorderPane();
        MyHbox hboxForTopControllers = new MyHbox();
        cityViewGridPaneRome = new MyGridPane();
        MyHbox bottomHbox = new MyHbox();
        bottomHbox.setPadding(new Insets(0, 0, 10, 0));

        hboxForTopControllers.setAlignment(Pos.CENTER);
        bottomHbox.setAlignment(Pos.CENTER);
        cityViewGridPaneRome.setAlignment(Pos.CENTER);
        cityViewGridPaneRome.setPadding(new Insets(0, 0, 0, 0));

        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/GUI/Resources/city_background.jpg")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(2000,
                        1080, false,
                        false, false, false));
        borderPane.setBackground(new Background(backgroundImage));

        MyButton mapButton = new MyButton("Map");
        mapButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        mapButton.setTextFill(Color.DARKGOLDENROD);
        mapButton.setMinSize(20, 20);
        mapButton.setOpacity(0.8);
        mapButton.setOnAction(e -> {
            Controller.openMapFromCityView();
        });


        cityNameLabelRome = new MyLabel(city);
        cityNameLabelRome.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        cityNameLabelRome.setTextFill(Color.MAROON);

        playerGoldAmountLabel = new MyLabel("Gold: " + playerGold);
        playerGoldAmountLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        playerGoldAmountLabel.setTextFill(Color.MAROON);

        playerFoodAmountLabel = new MyLabel("Food: " + playerFood);
        playerFoodAmountLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        playerFoodAmountLabel.setTextFill(Color.MAROON);

        turnsLabel = new MyLabel("Turns: " + turns + "/50 | Turns until arrived: " +
                (Controller.roundsUntilArrived > -1 ?
                        Integer.toString(Controller.roundsUntilArrived - 1)
                        : "0"
                ));
        turnsLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        turnsLabel.setTextFill(Color.MAROON);


        MyButton buildButton = new MyButton("Buildings");
        buildButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        buildButton.setTextFill(Color.DARKGOLDENROD);
        buildButton.setMinSize(20, 20);
        buildButton.setOpacity(0.8);
        buildButton.setOnAction(e -> {
            Controller.buildButtonPressedRome();
        });

        MyButton endTurnButton = new MyButton("End Turn");
        endTurnButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        endTurnButton.setTextFill(Color.DARKGOLDENROD);
        endTurnButton.setMinSize(20, 20);
        endTurnButton.setOpacity(0.8);
        endTurnButton.setOnAction(e -> {
            Controller.endTurnInRome();
            if (Integer.parseInt(turns) >= 49) {
                Main.window.setScene(new GameOverWindow("Lost").getGameOverScene());
            }
        });


        MyButton armiesButton = new MyButton("Armies");
        armiesButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        armiesButton.setTextFill(Color.DARKGOLDENROD);
        armiesButton.setMinSize(20, 20);
        armiesButton.setOpacity(0.8);
        armiesButton.setOnAction(e -> {
            Controller.armiesButtonPressed();
        });

        MyButton defendingArmyButton = new MyButton("Defending Army");
        defendingArmyButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        defendingArmyButton.setTextFill(Color.DARKGOLDENROD);
        defendingArmyButton.setMinSize(20, 20);
        defendingArmyButton.setOpacity(0.8);
        defendingArmyButton.setOnAction(e -> {
            Controller.defendingArmyButtonPressed(Controller.inWhatCity);
        });

        MyButton attackButton = new MyButton("Attack");
        attackButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        attackButton.setTextFill(Color.DARKGOLDENROD);
        attackButton.setMinSize(20, 20);
        attackButton.setOpacity(0.8);
        attackButton.setOnAction(e -> {
            if (Controller.roundsUntilArrived <= 1 && Controller.roundsUntilArrived > -100) {
                Controller.cityToAttackButtonPressed();
            } else {
                Controller.attackButtonPressed();
            }
        });


        Image stables = new Image(new File("src/GUI/Resources/stables.png").toURI().toString());
        MyImageView stablesImg = new MyImageView();
        stablesImg.setImage(stables);
        stablesImg.setFitHeight(250);
        stablesImg.setFitWidth(250);

        Image barracks = new Image(new File("src/GUI/Resources/barracks.png").toURI().toString());
        MyImageView barracksImg = new MyImageView();
        barracksImg.setImage(barracks);
        barracksImg.setFitHeight(250);
        barracksImg.setFitWidth(250);

        Image archeryRange = new Image(new File("src/GUI/Resources/archery_range.png").toURI().toString());
        MyImageView archeryRangeImg = new MyImageView();
        archeryRangeImg.setImage(archeryRange);
        archeryRangeImg.setFitHeight(250);
        archeryRangeImg.setFitWidth(250);

        Image market = new Image(new File("src/GUI/Resources/market.png").toURI().toString());
        MyImageView marketImg = new MyImageView();
        marketImg.setImage(market);
        marketImg.setFitHeight(250);
        marketImg.setFitWidth(250);

        Image farm = new Image(new File("src/GUI/Resources/farm.png").toURI().toString());
        MyImageView farmImg = new MyImageView();
        farmImg.setImage(farm);
        farmImg.setFitHeight(250);
        farmImg.setFitWidth(250);

        Image tree0 =
                new Image(new File("src/GUI/Resources/tree.png").toURI().toString());

        MyImageView tree0Img = new MyImageView();
        tree0Img.setImage(tree0);
        tree0Img.setFitHeight(150);
        tree0Img.setFitWidth(150);


        MyImageView tree1Img = new MyImageView();
        tree1Img.setImage(tree0);
        tree1Img.setFitHeight(150);
        tree1Img.setFitWidth(150);


        MyImageView tree2Img = new MyImageView();
        tree2Img.setImage(tree0);
        tree2Img.setFitHeight(150);
        tree2Img.setFitWidth(150);


        MyImageView tree3Img = new MyImageView();
        tree3Img.setImage(tree0);
        tree3Img.setFitHeight(150);
        tree3Img.setFitWidth(150);

        MyImageView tree4Img = new MyImageView();
        tree4Img.setImage(tree0);
        tree4Img.setFitHeight(150);
        tree4Img.setFitWidth(150);


        hboxForTopControllers.getChildren().addAll(
                turnsLabel,
                Constants.spaceButton2(),
                cityNameLabelRome,
                Constants.spaceButton2(),
                playerGoldAmountLabel,
                Constants.spaceButton2(),
                playerFoodAmountLabel,
                Constants.spaceButton2(),
                mapButton, endTurnButton);


        cityViewGridPaneRome.add(Integer.parseInt(stablesLevel) > 0 ? stablesImg :
                Constants.spaceButton2(), 0, 0);
        cityViewGridPaneRome.add(tree0Img, 0, 1);

        cityViewGridPaneRome.add(tree1Img, 1, 0);
        cityViewGridPaneRome.add(Integer.parseInt(archeryRangeLevel) > 0 ? archeryRangeImg :
                Constants.spaceButton2(), 1, 1);

        cityViewGridPaneRome.add(Integer.parseInt(farmLevel) > 0 ? farmImg :
                Constants.spaceButton2(), 2, 0);
        cityViewGridPaneRome.add(Integer.parseInt(marketLevel) > 0 ? marketImg :
                Constants.spaceButton2(), 2, 1);

        cityViewGridPaneRome.add(tree3Img, 3, 0);
        cityViewGridPaneRome.add(tree2Img, 3, 1);

        cityViewGridPaneRome.add(Integer.parseInt(barracksLevel) > 0 ? barracksImg :
                Constants.spaceButton2(), 4, 0);
        cityViewGridPaneRome.add(tree4Img, 4, 1);

        bottomHbox.getChildren().addAll(buildButton, Constants.spaceButton3(),
                armiesButton, Constants.spaceButton3(),
                defendingArmyButton, Constants.spaceButton3(), attackButton);

        borderPane.setTop(hboxForTopControllers);
        borderPane.setCenter(cityViewGridPaneRome);
        borderPane.setBottom(bottomHbox);

        this.cityViewScene = new MyScene(borderPane);
    }

    public MyScene getCityViewScene() {
        return cityViewScene;
    }
}
