package GUI;

import GUI.BuiltWindow.WelcomeWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage window;
    public static long startTime = System.nanoTime();


    @Override
    public void start(Stage primaryStage) throws Exception {
//        setting the primary stage to the variable window to be able to change
//        scenes
        window = primaryStage;


        window.setHeight(763);
        window.setMaxWidth(1355);

        window.setResizable(false);


//        Setting the first scene to the welcome scene and setting the title
        window.setScene(new WelcomeWindow().getWelcomeScene());
        window.setTitle("Empire Building");


        window.show();

    }


    public static void main(String[] args) {
        launch(args);

    }
}
