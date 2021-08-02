package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.CustomControllers.MyTableView;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyGridPane;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import units.Unit;

import java.io.File;

public class AttackWithWindow {
    public static MyLabel title;

    private final MyScene attackWithScene;
    public static Unit currentAttackingUnit;

    public AttackWithWindow() {
        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hbox = new MyHbox();
        hbox.setAlignment(Pos.CENTER);
        MyGridPane gridPane = new MyGridPane();
        MyVbox vbox = new MyVbox();
        vbox.setAlignment(Pos.CENTER);

        title = new MyLabel("Choose Attacking Unit");
        title.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        title.setTextFill(Color.DARKGOLDENROD);


        TableColumn<Unit, String> typeColumn = new TableColumn<>(
                "Type");
        TableColumn<Unit, String> levelColumn = new TableColumn<>(
                "Level");
        TableColumn<Unit, String> maxSoldierColumn = new TableColumn<>(
                "Max Soldiers");
        TableColumn<Unit, String> currentSoldiersColumn = new TableColumn<>(
                "Current Soldiers");


        typeColumn.setMinWidth(360);
        typeColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        levelColumn.setMinWidth(360);
        levelColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        maxSoldierColumn.setMinWidth(360);
        maxSoldierColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        currentSoldiersColumn.setMinWidth(360);
        currentSoldiersColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
//        radioButtonColumn.setMinWidth(390);


        typeColumn.setCellValueFactory(new PropertyValueFactory<>(
                "type"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>(
                "level"));
        maxSoldierColumn.setCellValueFactory(new PropertyValueFactory<>(
                "maxSoldierCount"));
        currentSoldiersColumn.setCellValueFactory(new PropertyValueFactory<>(
                "currentSoldierCount"));

        ShowArmyWindow.tableView = new MyTableView();
        ShowArmyWindow.tableView.setEditable(false);
        ShowArmyWindow.tableView.setItems(Controller.putShowArmyWindowUnits());
        ShowArmyWindow.tableView.getColumns().addAll(typeColumn, levelColumn, maxSoldierColumn,
                currentSoldiersColumn
//                ,radioButtonColumn
        );


        MyButton backButton = new MyButton("Back");
        backButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        backButton.setPadding(new Insets(30, 30, 30, 30));
        backButton.setTextFill(Color.DARKGOLDENROD);
        backButton.setOnAction(event -> {
            Controller.goBackFromAttackWithWindow();
        });

        MyButton chooseAttckButton = new MyButton("Attack");
        chooseAttckButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        chooseAttckButton.setPadding(new Insets(30, 30, 30, 30));
        chooseAttckButton.setTextFill(Color.DARKGOLDENROD);
        chooseAttckButton.setOnAction(event -> {


            currentAttackingUnit = null;
            for (Unit unit : Controller.game.getPlayer().getControlledArmies().get(0).getUnits()
            ) {
                if (unit == ((Unit) ShowArmyWindow.tableView.getSelectionModel().getSelectedItem())) {
                    currentAttackingUnit = unit;
                }
            }

            Controller.chooseUnitToAttack();
            Controller.updateBattleLog();
        });


        MyHbox buttonsHbox = new MyHbox();
        buttonsHbox.setAlignment(Pos.CENTER);
        buttonsHbox.setPadding(new Insets(0, 0, 110, 0));
        buttonsHbox.getChildren().addAll(backButton, Constants.spaceButton2(),
                chooseAttckButton);


        hbox.getChildren().add(title);
        gridPane.add(Constants.spaceButton2(), 0, 0);
        gridPane.add(Constants.spaceButton2(), 2, 0);
        gridPane.add(Constants.spaceButton2(), 4, 0);
        gridPane.add(Constants.spaceButton2(), 6, 0);
        vbox.getChildren().addAll(hbox, gridPane, Constants.spaceButton3(),
                ShowArmyWindow.tableView, Constants.spaceButton3(), buttonsHbox);
        borderPane.setTop(vbox);


        this.attackWithScene = new MyScene(borderPane);
    }

    public MyScene getAttackWithScene() {
        return attackWithScene;
    }
}
