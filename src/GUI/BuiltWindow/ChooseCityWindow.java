package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class ChooseCityWindow {

    private final MyScene chooseCityScene;
    public static MyButton cairoButton;
    public static MyButton romeButton;
    public static MyButton spartaButton;

    public ChooseCityWindow() {


//        Setting up the layouts and properties
        MyHbox allCitiesHbox = new MyHbox();
        BackgroundSize vboxBackgroundSize = new BackgroundSize(50,
                50, false,
                false, false, true);


        MyVbox cairoVbox = new MyVbox();
        BackgroundImage backgroundImageCairo = new BackgroundImage(new Image(new File(
                "src/GUI/Resources/cairo_pyramids.jpg")
                .toURI().toString()), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, vboxBackgroundSize);
        cairoVbox.setBackground(new Background(backgroundImageCairo));
        cairoButton = new MyButton("Cairo");
        cairoButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));

        cairoButton.setTextFill(Color.WHITE);
        cairoButton.setOnMouseEntered(e -> {
            cairoButton.setTextFill(Color.RED);
            cairoButton.setEffect(new InnerShadow());
        });
        cairoButton.setOnMouseExited(e -> {
            cairoButton.setTextFill(Color.WHITE);
            cairoButton.setEffect(new InnerShadow(0, Color.WHITE));
        });
        cairoButton.setOnAction(e -> {
            Controller.chooseCityWindowButtonOnAction("Cairo");
        });

        cairoButton.setFont(Font.loadFont(new File("src/GUI/Resources" +
                "/BerkshireSwash-Regular.ttf").toURI().toString(), 20));
        cairoVbox.getChildren().addAll(cairoButton, Constants.spaceButton4());
        cairoVbox.setAlignment(Pos.CENTER);


        MyVbox romeVbox = new MyVbox();
        BackgroundImage backgroundImageRome = new BackgroundImage(new Image(new File(
                "src/GUI/Resources/roman_empire.jpg")
                .toURI().toString()), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, vboxBackgroundSize);
        romeVbox.setBackground(new Background(backgroundImageRome));
        romeButton = new MyButton("Rome");
        romeButton.setTextFill(Color.WHITE);
        romeButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));

        romeButton.setFont(Font.loadFont(new File("src/GUI/Resources" +
                "/BerkshireSwash-Regular.ttf").toURI().toString(), 20));
        romeButton.setOnMouseEntered(e -> {
            romeButton.setTextFill(Color.RED);
            romeButton.setEffect(new InnerShadow());
        });
        romeButton.setOnMouseExited(e -> {
            romeButton.setTextFill(Color.WHITE);
            romeButton.setEffect(new InnerShadow(0, Color.WHITE));
        });
        romeButton.setOnAction(e -> {
            Controller.chooseCityWindowButtonOnAction("Rome");
        });
        romeVbox.getChildren().addAll(romeButton, Constants.spaceButton4());
        romeVbox.setAlignment(Pos.CENTER);


        MyVbox spartaVbox = new MyVbox();
        BackgroundImage backgroundImageSparta =
                new BackgroundImage(new Image(new File(
                        "src/GUI/Resources/sparta.jpg")
                        .toURI().toString()), BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER, vboxBackgroundSize);
        spartaVbox.setBackground(new Background(backgroundImageSparta));
        spartaButton = new MyButton("Sparta");
        spartaButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        spartaButton.setTextFill(Color.WHITE);

        spartaButton.setFont(Font.loadFont(new File("src/GUI/Resources" +
                "/BerkshireSwash-Regular.ttf").toURI().toString(), 20));
        spartaButton.setOnMouseEntered(e -> {
            spartaButton.setTextFill(Color.RED);
            spartaButton.setEffect(new InnerShadow());
        });
        spartaButton.setOnMouseExited(e -> {
            spartaButton.setTextFill(Color.WHITE);
            spartaButton.setEffect(new InnerShadow(0, Color.WHITE));
        });
        spartaButton.setOnAction(e -> {
            Controller.chooseCityWindowButtonOnAction("Sparta");
        });
        spartaVbox.getChildren().addAll(spartaButton, Constants.spaceButton4());
        spartaVbox.setAlignment(Pos.CENTER);

        allCitiesHbox.getChildren().addAll(cairoVbox, romeVbox, spartaVbox);


        this.chooseCityScene = new MyScene(allCitiesHbox);
    }

    public MyScene getChooseCityScene() {
        return chooseCityScene;
    }
}
