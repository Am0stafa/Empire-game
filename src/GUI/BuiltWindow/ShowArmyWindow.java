package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.CustomControllers.MyTableView;
import GUI.CustomControllers.MyTextField;
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

public class ShowArmyWindow {
    private final MyScene showArmyScene;
    public static MyTableView tableView;
    public static MyLabel title;
    public static MyTextField statusTextField;
    public static MyTextField marchingToCityTextField;
    public static MyTextField besiegingCityTextField;
    //    public static MyButton relocateButton;
    public static MyButton backButton;

    public ShowArmyWindow(String cityToAttack, String status,
                          String reachedIn, String besiegingCity,
                          String turnsBesieging) {

        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hbox = new MyHbox();
        hbox.setAlignment(Pos.CENTER);
        MyGridPane gridPane = new MyGridPane();
        MyVbox vbox = new MyVbox();
        vbox.setAlignment(Pos.CENTER);

        title = new MyLabel("Controlled Armies");
        title.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 70));
        title.setTextFill(Color.DARKGOLDENROD);

        statusTextField = new MyTextField();
        statusTextField.setText("Status: " + status);
        statusTextField.setEditable(false);
        statusTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        statusTextField.setMinWidth(36);
        statusTextField.setStyle("-fx-text-inner-color: #6A1412");


        marchingToCityTextField = new MyTextField();
        marchingToCityTextField.setText("Marching to: " + cityToAttack + "   And " +
                "Reached In " +
                reachedIn +
                " Turns");
        marchingToCityTextField.setEditable(false);
        marchingToCityTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        marchingToCityTextField.setStyle("-fx-text-inner-color: #6A1412");
        marchingToCityTextField.setPrefWidth(600);

        besiegingCityTextField = new MyTextField();
        besiegingCityTextField.setText("Location: " + besiegingCity);
        besiegingCityTextField.setEditable(false);
        besiegingCityTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        besiegingCityTextField.setStyle("-fx-text-inner-color: #6A1412");
        besiegingCityTextField.setPrefWidth(550);

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


        typeColumn.setCellValueFactory(new PropertyValueFactory<>(
                "type"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>(
                "level"));
        maxSoldierColumn.setCellValueFactory(new PropertyValueFactory<>(
                "maxSoldierCount"));
        currentSoldiersColumn.setCellValueFactory(new PropertyValueFactory<>(
                "currentSoldierCount"));

        tableView = new MyTableView();
        tableView.setEditable(false);
        tableView.setItems(Controller.putShowArmyWindowUnits());
        tableView.getColumns().addAll(typeColumn, levelColumn, maxSoldierColumn,
                currentSoldiersColumn);


        MyHbox buttonsHbox = new MyHbox();
        buttonsHbox.setAlignment(Pos.CENTER);
        buttonsHbox.setPadding(new Insets(0, 0, 80, 0));


        MyButton spaceButton = new MyButton("SP");
        spaceButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        spaceButton.setTextFill(Color.DARKGOLDENROD);
        spaceButton.setOpacity(0);

        backButton = new MyButton("Back");
        backButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        backButton.setTextFill(Color.DARKGOLDENROD);
        backButton.setOnAction(event -> {
            Controller.showArmyWindowBackButtonOnAction();
        });

        buttonsHbox.getChildren().addAll(
                backButton);


        hbox.getChildren().add(title);
        gridPane.add(Constants.spaceButton2(), 0, 0);
        gridPane.add(statusTextField, 1, 0);
        gridPane.add(Constants.spaceButton2(), 2, 0);
        gridPane.add(marchingToCityTextField, 3, 0);
        gridPane.add(Constants.spaceButton2(), 4, 0);
        gridPane.add(besiegingCityTextField, 5, 0);
        gridPane.add(Constants.spaceButton2(), 6, 0);
        vbox.getChildren().addAll(hbox, gridPane,
                tableView, Constants.spaceButton3(), buttonsHbox);
        borderPane.setTop(vbox);


        this.showArmyScene = new MyScene(borderPane);
    }


    public MyScene getShowArmyScene() {
        return showArmyScene;
    }
}
