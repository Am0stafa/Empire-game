package GUI;

import GUI.CustomControllers.MyButton;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;

import java.io.File;

public class Constants {


    public static final double GAME_WINDOW_SIZE_X =
            Screen.getPrimary().getBounds().getMaxX() - 5;
    public static final double GAME_WINDOW_SIZE_Y =
            Screen.getPrimary().getBounds().getMaxY() - 35;

    public static Media openingMusic = new Media(new File("src/GUI/Resources" +
            "/openingWindowsSound.mp3").toURI().toString());
    public static Media clickButton = new Media(new File("src/GUI/Resources/" +
            "sword_button_click.mp3").toURI().toString());
    public static Media cityMusic = new Media(new File("src/GUI/Resources/peace_music.mp3").
            toURI().toString());
    public static Media battleMusic = new Media(new File("src/GUI/Resources/battle_music.mp3")
            .toURI().toString());
    public static Media horseSound = new Media(new File("src/GUI/Resources/horse_sound.mp3")
            .toURI().toString());
    public static Media archerSound = new Media(new File("src/GUI/Resources/bow_arrow_sound.mp3")
            .toURI().toString());
    public static Media infantrySound = new Media(new File("src/GUI/Resources/sword_battle_sound.mp3")
            .toURI().toString());
    public static Media harvestFoodSound = new Media(new File("src/GUI/Resources/harvest_sound.mp3")
            .toURI().toString());
    public static Media harvestGoldSound = new Media(new File("src/GUI/Resources/harvest_sound.mp3")
            .toURI().toString());

    public static MediaPlayer mediaPlayer = new MediaPlayer(openingMusic);


    public static String gameDescription = "A player\n" +
            "initially chooses one historical city to start his empire with. " +
            "The goal is to conquer the whole\n" +
            "world by taking control over every other city under a certain amount " +
            "of turns. In order to\n" +
            "achieve this goal, the player have the option of building various types " +
            "of building in any city he\n" +
            "has control over and also build armies in order to conquer other \n" +
            "cities.\n" + "The player will win if he managed to conquer all \n" +
            "cities available in the game under the \n" +
            "\ndetermined amounts of turns. If these turns passed and the \n" +
            "player did not achieve this goal, this is\n" +
            "considered a loss.\n\n\n" + "Each city has an army that defends \n" +
            "it from conquerors. The player needs to build a powerful\n" +
            "army and defeat the defending army in order to take control over \n" +
            "the city. Once the attacking\n" +
            "army reaches the city, it can either lay siege on the target city \n" +
            "trying to starve them out or\n" +
            "directly attack the defending army. If the player chooses to besiege \n" +
            "the city, the defending\n" +
            "army will gradually lose soldiers each turn the city is under siege. \n" +
            "However, the player can\n" +
            "only besiege a city for a max of three turns. During these three turns,\n" +
            " the player can choose\n" +
            "to break the siege and leave the city or directly fight the defending army. \n" +
            "If these three turns\n" +
            "passed, the player has to fight the defending army in a decisive battle.\n" +
            "When the player engages\n" +
            "the defending army in a battle, he can choose to either automatically\n" +
            "resolves the battle or\n" +
            "he manually commands his units during it. In auto resolve mode, a random\n" +
            "unit from the\n" +
            "attacking army will attack another random unit from the defending army\n" +
            "then, same action\n" +
            "happens but this time the defending army will be the attacker and so on\n" +
            "till one of the two\n" +
            "armies is completely destroyed. In all cases, only the attacked unit\n" +
            "receives damage and have\n" +
            "some of its soldiers lost during the attack. The attacking unit does not\n" +
            "receive any damage\n" +
            "in the process. In the manual mode, the battle starts by the player " +
            "choosing \n" +
            " one of his units\n" +
            "to attack another unit in \nthe defending army followed by a random\n" +
            " unit from the defending" + " army attack another random unit from the player’s \n" +
            "army and so on till one of the two armies is\n" +
            "destroyed. Once the city’s defending army is defeated, the player takes control\n" +
            " over it and can\n" +
            "build any building or recruit any unit inside it.";

    public static void playMusic(Media media) {
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public static void playEffect(Media media) {
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public static MyButton spaceButton() {
        MyButton spaceButton = new MyButton("SP");
        spaceButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 150));
        spaceButton.setTextFill(Color.DARKGOLDENROD);
        spaceButton.setOpacity(0);
        return spaceButton;
    }

    public static MyButton spaceButton2() {
        MyButton spaceButton = new MyButton("SP");
        spaceButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        spaceButton.setTextFill(Color.DARKGOLDENROD);
        spaceButton.setOpacity(0);
        return spaceButton;
    }

    public static MyButton spaceButton3() {
        MyButton spaceButton = new MyButton("SP");
        spaceButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 3));
        spaceButton.setTextFill(Color.DARKGOLDENROD);
        spaceButton.setOpacity(0);
        return spaceButton;
    }

    public static MyButton spaceButton4() {
        MyButton spaceButton = new MyButton("SP");
        spaceButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 200));
        spaceButton.setTextFill(Color.DARKGOLDENROD);
        spaceButton.setOpacity(0);
        return spaceButton;
    }


    public static Image egyptBack = new Image(new File("src/GUI/Resources/egypt_back.jpg").toURI().toString());

}
