package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyImageView;
import GUI.CustomControllers.MyTextArea;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class BattleFieldWindow {
    private final MyScene scene;
    public static MyButton mapButton;
    public static MyTextArea battleLogTextArea;
    public static MyButton defendingArmyStatusButton;
    public static MyButton attackingArmyStatusButton;
    public static MyButton chooseNextAttackButton;
    public static MyButton letOpponentAttackButton;

    public static MyImageView currentAttacker;

    public BattleFieldWindow() {
        Controller.playFirstTime = true;
        Constants.playMusic(Constants.battleMusic);
        Controller.roundsUntilArrived = -200;

        MyBorderPane borderPane = new MyBorderPane();
        MyHbox hboxForMap = new MyHbox();
        MyBorderPane battleFieldPane = new MyBorderPane();
        MyVbox armyImgsLeft = new MyVbox();
        MyVbox armyImgsRight = new MyVbox();
        MyHbox bottomPane = new MyHbox();
        MyVbox battleLogPane = new MyVbox();
        MyHbox armyStatusPane = new MyHbox();
        MyHbox nextAttackPane = new MyHbox();
        MyVbox takeActionPane = new MyVbox();

        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/GUI/Resources/battleGroundjpg.jpg")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(Constants.GAME_WINDOW_SIZE_X,
                        Constants.GAME_WINDOW_SIZE_Y + 20, false,
                        false, false, false));
        borderPane.setBackground(new Background(backgroundImage));

        hboxForMap.setAlignment(Pos.TOP_RIGHT);
        hboxForMap.setPadding(new Insets(10, 50, 50, 50));
        battleLogPane.setAlignment(Pos.BOTTOM_LEFT);
        battleLogPane.setPadding(new Insets(10, 10, 10, 10));
        bottomPane.setAlignment(Pos.BOTTOM_CENTER);
        nextAttackPane.setPadding(new Insets(5, 5, 5, 5));
        armyStatusPane.setPadding(new Insets(0, 0, 70, 0));


        mapButton = new MyButton("Map");
        mapButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 25));
        mapButton.setTextFill(Color.DARKGOLDENROD);
        mapButton.setMinSize(30, 30);
        mapButton.setOpacity(0.8);
        mapButton.setOnAction(e -> {
            Controller.mapButtonPressedBattleField();
        });

        battleLogTextArea = new MyTextArea("");
        battleLogTextArea.setEditable(false);
        battleLogTextArea.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 15));
        battleLogTextArea.setStyle("-fx-text-inner-color: #6A1412");
        battleLogTextArea.setOpacity(0.8);

        defendingArmyStatusButton = new MyButton("Opposing Army\nStatus");
        defendingArmyStatusButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 19));
        defendingArmyStatusButton.setTextFill(Color.DARKGOLDENROD);
        defendingArmyStatusButton.setMinSize(18, 18);
        defendingArmyStatusButton.setOpacity(0.8);
        defendingArmyStatusButton.setOnAction(e -> {
            Controller.showDefendingArmyStatus();
        });

        attackingArmyStatusButton = new MyButton("Your Army\nStatus");
        attackingArmyStatusButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 19));
        attackingArmyStatusButton.setTextFill(Color.DARKGOLDENROD);
        attackingArmyStatusButton.setMinSize(18, 18);
        attackingArmyStatusButton.setOpacity(0.8);
        attackingArmyStatusButton.setOnAction(e -> {
            Controller.showAttackingArmyStatus();
        });

        chooseNextAttackButton = new MyButton("Choose Next\nAttack");
        chooseNextAttackButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 19));
        chooseNextAttackButton.setTextFill(Color.DARKGOLDENROD);
        chooseNextAttackButton.setMinSize(18, 18);
        chooseNextAttackButton.setOpacity(0.8);
        chooseNextAttackButton.setOnAction(e -> {
            chooseNextAttackButton.setDisable(true);
            chooseNextAttackButton.setOpacity(0.4);
            letOpponentAttackButton.setDisable(false);
            letOpponentAttackButton.setOpacity(0.8);
            Controller.chooseNextAttack();
            mapButton.setDisable(true);
            AttackStrategyWindow.city1Button.setDisable(false);
            AttackStrategyWindow.city2Button.setDisable(false);
            Controller.button1Disabled = false;
            Controller.button2Disabled = false;

        });

        letOpponentAttackButton = new MyButton("Let Opponent\nAttack");
        letOpponentAttackButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 19));
        letOpponentAttackButton.setTextFill(Color.DARKGOLDENROD);
        letOpponentAttackButton.setMinSize(18, 18);
        letOpponentAttackButton.setOpacity(0.8);
        letOpponentAttackButton.setOnAction(e -> {
            letOpponentAttackButton.setDisable(true);
            letOpponentAttackButton.setOpacity(0.4);
            chooseNextAttackButton.setDisable(false);
            chooseNextAttackButton.setOpacity(0.8);
            Controller.letOpponentAttack();
        });

        Image cavalryLeft = new Image(new File("src/GUI/Resources/" +
                "CavalryYemin.png").toURI().toString());
        MyImageView cavalryLeftImg = new MyImageView();
        cavalryLeftImg.setImage(cavalryLeft);
        cavalryLeftImg.setFitHeight(110);
        cavalryLeftImg.setFitWidth(110);

        Image cavalryRight = new Image(new File("src/GUI/Resources/" +
                "CavalryShemal.png").toURI().toString());
        MyImageView cavalryRightImg = new MyImageView();
        cavalryRightImg.setImage(cavalryRight);
        cavalryRightImg.setFitHeight(110);
        cavalryRightImg.setFitWidth(110);

        Image archeryLeft = new Image(new File("src/GUI/Resources/" +
                "ArcheryYemin.png").toURI().toString());
        MyImageView archeryLeftImg = new MyImageView();
        archeryLeftImg.setImage(archeryLeft);
        archeryLeftImg.setFitHeight(110);
        archeryLeftImg.setFitWidth(110);

        Image archeryRight = new Image(new File("src/GUI/Resources/" +
                "ArcheryShemal.png").toURI().toString());
        MyImageView archeryRightImg = new MyImageView();
        archeryRightImg.setImage(archeryRight);
        archeryRightImg.setFitHeight(110);
        archeryRightImg.setFitWidth(110);

        Image infantryLeft = new Image(new File("src/GUI/Resources/" +
                "InfantryYemin.png").toURI().toString());
        MyImageView infantryLeftImg = new MyImageView();
        infantryLeftImg.setImage(infantryLeft);
        infantryLeftImg.setFitHeight(110);
        infantryLeftImg.setFitWidth(110);

        Image infantryRight = new Image(new File("src/GUI/Resources/" +
                "InfantryShemal.png").toURI().toString());
        MyImageView infantryRightImg = new MyImageView();
        infantryRightImg.setImage(infantryRight);
        infantryRightImg.setFitHeight(110);
        infantryRightImg.setFitWidth(110);


        armyImgsLeft.getChildren().addAll(infantryLeftImg, cavalryLeftImg,
                archeryLeftImg);
        armyImgsRight.getChildren().addAll(infantryRightImg, cavalryRightImg,
                archeryRightImg);

        battleFieldPane.setLeft(armyImgsLeft);
        battleFieldPane.setRight(armyImgsRight);


        currentAttacker = new MyImageView();
        currentAttacker.setFitHeight(110);
        currentAttacker.setFitWidth(110);

//        battleFieldPane.setCenter(currentAttacker == null ?
//                Constants.spaceButton2() : currentAttacker);


        hboxForMap.getChildren().addAll(
                mapButton);
        battleLogPane.getChildren().add(battleLogTextArea);
        armyStatusPane.getChildren().addAll(defendingArmyStatusButton, Constants.spaceButton3(),
                attackingArmyStatusButton);
        nextAttackPane.getChildren().addAll(letOpponentAttackButton,
                Constants.spaceButton3(), chooseNextAttackButton);

        borderPane.setTop(hboxForMap);
        borderPane.setCenter(battleFieldPane);
        takeActionPane.getChildren().addAll(armyStatusPane, nextAttackPane);
        bottomPane.getChildren().addAll(battleLogPane, Constants.spaceButton2(),
                Constants.spaceButton2(),
                Constants.spaceButton2(), takeActionPane);
        borderPane.setBottom(bottomPane);

        this.scene = new MyScene(borderPane);
    }

    public MyScene getScene() {
        return scene;
    }
}
