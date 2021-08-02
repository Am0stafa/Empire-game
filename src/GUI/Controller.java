package GUI;

import GUI.BuiltWindow.*;
import buildings.*;
import engine.City;
import engine.Game;
import exceptions.FriendlyFireException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Unit;

import java.util.Random;

public class Controller {
    public static Game game;
    public static String playerName;
    public static String playerCity;

    public static String inWhatCity;
    public static int farmLevelCairo = 0;
    public static int marketLevelCairo = 0;
    public static int archeryRangeLevelCairo = 0;
    public static int barracksLevelCairo = 0;
    public static int stableLevelCairo = 0;

    public static int farmLevelRome = 0;
    public static int marketLevelRome = 0;
    public static int archeryRangeLevelRome = 0;
    public static int barracksLevelRome = 0;
    public static int stableLevelRome = 0;

    public static int farmLevelSparta = 0;
    public static int marketLevelSparta = 0;
    public static int archeryRangeLevelSparta = 0;
    public static int barracksLevelSparta = 0;
    public static int stableLevelSparta = 0;

    public static boolean conquoredCairo;
    public static boolean conquoredRome;
    public static boolean conquoredSparta;

    public static String cityToAttack;

    public static boolean playFirstTime = true;


    public static boolean button2Disabled = false;
    public static boolean button1Disabled = false;

    public static int roundsUntilArrived = -200;

    public static void updateInWhatCity(String city) {
        inWhatCity = city;
    }


    //    WelcomeWindow
    public static void welcomeWindowStartGameButtonAction() {
        WelcomeWindow.startGameButton.setOnAction(event -> {
            //        The enter your name window
            EnterNameWindow enterNameWindow = new EnterNameWindow();
            Main.window.setScene(enterNameWindow.getWelcomeScene());
            Constants.playEffect(Constants.clickButton);
        });
    }

    //    EnterNameWindow
    public static void enterNameWindowReadyButtonOnAction() {
        EnterNameWindow.readyButton.setOnAction(event -> {
            Constants.playEffect(Constants.clickButton);
            GameDescriptionWindow gameDescriptionWindow =
                    new GameDescriptionWindow();
            Main.window.setScene(gameDescriptionWindow.getGameDescriptionScene());
            if (EnterNameWindow.textField.getText().isEmpty()) {
                playerName = "Anonymous";
            } else {
                playerName = EnterNameWindow.textField.getText();
            }
        });
    }

    //    GameDescriptionWindow
    public static void gameDescriptionWindowProceedButtonOnAction() {
        GameDescriptionWindow.readyButton.setOnAction(event -> {
            Constants.playEffect(Constants.clickButton);
            ChooseCityWindow chooseCityWindow = new ChooseCityWindow();
            Main.window.setScene(chooseCityWindow.getChooseCityScene());
        });
    }

    //    ChooseCityWindow
    public static void chooseCityWindowButtonOnAction(String cityName) {
        if (cityName.equals("Cairo")) {
            Main.window.setScene(new MapViewWindow().getMapViewScene());
            Constants.playEffect(Constants.clickButton);
            playerCity = "Cairo";
        } else if (cityName.equals("Rome")) {
            Main.window.setScene(new MapViewWindow().getMapViewScene());
            Constants.playEffect(Constants.clickButton);
            playerCity = "Rome";
        } else if (cityName.equals("Sparta")) {
            Main.window.setScene(new MapViewWindow().getMapViewScene());
            Constants.playEffect(Constants.clickButton);
            playerCity = "Sparta";
        }
        try {
            game = new Game(playerName, playerCity);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void enterCityMapButtonOnAction(String cityName) {
        if (cityName.equals("Cairo")) {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityOrArmyWindow("Cairo").getCityOrArmyWindow());
        } else if (cityName.equals("Rome")) {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityOrArmyWindow("Rome").getCityOrArmyWindow());
        } else if (cityName.equals("Sparta")) {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityOrArmyWindow("Sparta").getCityOrArmyWindow());
        }
    }


    public static Stage showSettingsStage;

    public static void settingsButtonPressed() {
        long endTime = System.nanoTime();
        long totalTime = endTime - Main.startTime;

        showSettingsStage = new Stage();
        showSettingsStage.initModality(Modality.APPLICATION_MODAL);
        showSettingsStage.setScene(new SettingsWindow(game.getPlayer().getName(),
                Long.toString(totalTime / 1000000000)
        ).getSettingsScene());
        showSettingsStage.showAndWait();
    }


    //  SettingsWindow
    public static void settingsButtonOnAction(String choice) {
        if (choice.equals("Back")) {
            Constants.playEffect(Constants.clickButton);
            showSettingsStage.close();
        } else {
            Constants.playEffect(Constants.clickButton);
            System.exit(0);
        }
    }


    //    CityOrArmyWindow
    public static Stage showArmyWindowStage;

    public static void chooseCityOrArmy(String choice, String cityToEnter) {
        City currentCity = null;


        if (choice.equals("City")) {
            Constants.playEffect(Constants.clickButton);
            if (inWhatCity.equalsIgnoreCase("cairo")) {

                for (City city : game.getPlayer().getControlledCities()
                ) {
                    if (city.getName().equalsIgnoreCase("cairo")) {
                        currentCity = city;
                    }
                }

                for (Building building : currentCity.getEconomicalBuildings()
                ) {
                    if (building instanceof Market) {
                        marketLevelCairo = building.getLevel();
                    } else {
                        farmLevelCairo = building.getLevel();
                    }
                }

                for (Building building : currentCity.getMilitaryBuildings()
                ) {
                    if (building instanceof ArcheryRange) {
                        archeryRangeLevelCairo = building.getLevel();
                    } else if (building instanceof Barracks) {
                        barracksLevelCairo = building.getLevel();
                    } else {
                        stableLevelCairo = building.getLevel();
                    }
                }

                Main.window.setScene(new CityViewWindowCairo(
                        inWhatCity
                        ,
                        Double.toString(game.getPlayer().getTreasury()),
                        Double.toString(game.getPlayer().getFood()),
                        Integer.toString(game.getCurrentTurnCount()),
                        Integer.toString(marketLevelCairo),
                        Integer.toString(farmLevelCairo),
                        Integer.toString(archeryRangeLevelCairo),
                        Integer.toString(stableLevelCairo),
                        Integer.toString(barracksLevelCairo)
                ).getCityViewScene());


            } else if (inWhatCity.equalsIgnoreCase("rome")) {

                for (City city : game.getPlayer().getControlledCities()
                ) {
                    if (city.getName().equalsIgnoreCase("rome")) {
                        currentCity = city;
                    }
                }

                for (Building building : currentCity.getEconomicalBuildings()
                ) {
                    if (building instanceof Market) {
                        marketLevelRome = building.getLevel();
                    } else {
                        farmLevelRome = building.getLevel();
                    }
                }

                for (Building building : currentCity.getMilitaryBuildings()
                ) {
                    if (building instanceof ArcheryRange) {
                        archeryRangeLevelRome = building.getLevel();
                    } else if (building instanceof Barracks) {
                        barracksLevelRome = building.getLevel();
                    } else {
                        stableLevelRome = building.getLevel();
                    }
                }

                Main.window.setScene(new CityViewWindowRome(
                        inWhatCity
                        ,
                        Double.toString(game.getPlayer().getTreasury()),
                        Double.toString(game.getPlayer().getFood()),
                        Integer.toString(game.getCurrentTurnCount()),
                        Integer.toString(marketLevelRome),
                        Integer.toString(farmLevelRome),
                        Integer.toString(archeryRangeLevelRome),
                        Integer.toString(stableLevelRome),
                        Integer.toString(barracksLevelRome)
                ).getCityViewScene());

            } else if (inWhatCity.equalsIgnoreCase("sparta")) {

                for (City city : game.getPlayer().getControlledCities()
                ) {
                    if (city.getName().equalsIgnoreCase("sparta")) {
                        currentCity = city;
                    }
                }


                for (Building building : currentCity.getEconomicalBuildings()
                ) {
                    if (building instanceof Market) {
                        marketLevelSparta = building.getLevel();
                    } else {
                        farmLevelSparta = building.getLevel();
                    }
                }

                for (Building building : currentCity.getMilitaryBuildings()
                ) {
                    if (building instanceof ArcheryRange) {
                        archeryRangeLevelSparta = building.getLevel();
                    } else if (building instanceof Barracks) {
                        barracksLevelSparta = building.getLevel();
                    } else {
                        stableLevelSparta = building.getLevel();
                    }
                }

                Main.window.setScene(new CityViewWindowSparta(
                        inWhatCity
                        ,
                        Double.toString(game.getPlayer().getTreasury()),
                        Double.toString(game.getPlayer().getFood()),
                        Integer.toString(game.getCurrentTurnCount()),
                        Integer.toString(marketLevelSparta),
                        Integer.toString(farmLevelSparta),
                        Integer.toString(archeryRangeLevelSparta),
                        Integer.toString(stableLevelSparta),
                        Integer.toString(barracksLevelSparta)
                ).getCityViewScene());
            }

        } else {
            Constants.playEffect(Constants.clickButton);

            Army army = getArmyOfCity();
            showArmyWindowStage = new Stage();
            showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);
            if (army != null) {
                showArmyWindowStage.setScene(new ShowArmyWindow(cityToAttack,
                        game.getPlayer().getControlledArmies().get(0).getCurrentStatus().toString(),
                        roundsUntilArrived != -1 ? "" : Integer.toString(roundsUntilArrived),
                        game.getPlayer().getControlledArmies().get(0).getCurrentLocation(),
                        cityToAttack).getShowArmyScene());
            } else {
                showArmyWindowStage.setScene(new ShowArmyWindow("",
                        "", "", "", "").getShowArmyScene());
            }
            showArmyWindowStage.showAndWait();
        }
    }


    //    ShowArmyWindow
    public static void updateShowArmyWindowTitleLabel() {

    }

    public static void updateShowArmyWindowStatusTextField() {

    }

    public static void updateShowArmyWindowMarchingToCityTextField() {

    }

    public static void updateShowArmyWindowBesiegingCityTextField() {

    }

    public static void showArmyWindowRelocateButtonOnAction() {
        Constants.playEffect(Constants.clickButton);
    }


    public static void showArmyWindowBackButtonOnAction() {
        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage.close();
    }

    public static ObservableList<Unit> unitsObservableList;

    public static ObservableList<Unit> putShowArmyWindowUnits() {

        unitsObservableList =
                FXCollections.observableArrayList();

        for (Army army : game.getPlayer().getControlledArmies()
        ) {
            for (Unit unit : army.getUnits()) {
                unitsObservableList.add(unit);

            }
        }
        return unitsObservableList;
    }


//    BattleFieldWindow

    public static void mapButtonPressedBattleField() {
//        if battle is going on this button is greyed out
        Constants.playEffect(Constants.clickButton);
        Main.window.setScene(new MapViewWindow().getMapViewScene());
    }

    public static void updateBattleLog() {
//        BattleFieldWindow.battleLogTextArea.appendText("Battle between " + inWhatCity + " and " + cityToAttack
//                + " may commence!\nMay the most worthy win.");
    }

    //    public static Stage defendingArmyStatusFromBattleField;
    public static void showDefendingArmyStatus() {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow = new Stage();
        showDefendingArmiesWindow.initModality(Modality.APPLICATION_MODAL);
        showDefendingArmiesWindow.setScene(new ShowDefendingArmyOfCityWindow(cityToAttack, true, false).getScene());
        showDefendingArmiesWindow.showAndWait();
    }

    public static int numOfLostSoldiers;

    public static void letOpponentAttack() {
        BattleFieldWindow.battleLogTextArea.appendText("\n\nYour Opponent Will" +
                " " +
                "Strike Now....\n\n");


        Random rand = new Random();
        int upperBound =
                rand.nextInt(Controller.game.getPlayer().getControlledArmies().get(0).getUnits().size());
        int lowerBound = rand.nextInt(17);

        if (Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(upperBound) instanceof Archer) {
            BattleFieldWindow.battleLogTextArea.appendText("You lost " + lowerBound +
                    " soldiers of an Archer Unit");
        } else if (Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(upperBound) instanceof Cavalry) {
            BattleFieldWindow.battleLogTextArea.appendText("You lost " + lowerBound +
                    " soldiers of a Cavalry Unit");
        } else {
            BattleFieldWindow.battleLogTextArea.appendText("You lost " + lowerBound +
                    " soldiers of an Infantry Unit");
        }

        Controller.game.getPlayer().getControlledArmies().get(0).getUnits().remove(
                Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(upperBound)
        );


//        game.endTurn();


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
            Main.window.setScene(new MapViewWindow().getMapViewScene());

            if (Controller.game.isGameOver()) {
                Main.window.setScene(new GameOverWindow("Won").getGameOverScene());
            }
        }

        if (Controller.game.getPlayer().getControlledArmies().get(0).getUnits().isEmpty()) {
            BattleFieldWindow.mapButton.setDisable(false);
            new PopUpWindow("You Lost This Battle");
            Main.window.setScene(new MapViewWindow().getMapViewScene());

        }
    }

    public static void chooseUnitToAttack() {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow = new Stage();
        showDefendingArmiesWindow.initModality(Modality.APPLICATION_MODAL);
        showDefendingArmiesWindow.setScene(new ShowDefendingArmyOfCityWindow(cityToAttack, true, true).getScene());
        showDefendingArmiesWindow.showAndWait();
    }


    public static void showAttackingArmyStatus() {
        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage = new Stage();
        showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);

        showArmyWindowStage.setScene(new ShowArmyWindow(cityToAttack,
                game.getPlayer().getControlledArmies().get(0).getCurrentStatus().toString(),
                roundsUntilArrived != -1 ? "" : Integer.toString(roundsUntilArrived),
                game.getPlayer().getControlledArmies().get(0).getCurrentLocation(),
                cityToAttack).getShowArmyScene());

        showArmyWindowStage.showAndWait();
    }

    public static Stage attackWithWindow;

    public static void chooseNextAttack() {
        Constants.playEffect(Constants.clickButton);
        attackWithWindow = new Stage();
        attackWithWindow.initModality(Modality.APPLICATION_MODAL);
        attackWithWindow.setScene(new AttackWithWindow().getAttackWithScene());
        attackWithWindow.showAndWait();
    }


    //    AttackWith Window
    public static void goBackFromAttackWithWindow() {
        Constants.playEffect(Constants.clickButton);
        attackWithWindow.close();
    }


    //    CityViewWindow
    public static void endTurnInCairo() {
        game.endTurn();
        Main.window.setScene(new CityViewWindowCairo(
                inWhatCity
                ,
                Double.toString(game.getPlayer().getTreasury()),
                Double.toString(game.getPlayer().getFood()),
                Integer.toString(game.getCurrentTurnCount()),
                Integer.toString(marketLevelCairo),
                Integer.toString(farmLevelCairo),
                Integer.toString(archeryRangeLevelCairo),
                Integer.toString(stableLevelCairo),
                Integer.toString(barracksLevelCairo)
        ).getCityViewScene());
    }

    public static void endTurnInRome() {
        game.endTurn();
        Main.window.setScene(new CityViewWindowRome(
                inWhatCity
                ,
                Double.toString(game.getPlayer().getTreasury()),
                Double.toString(game.getPlayer().getFood()),
                Integer.toString(game.getCurrentTurnCount()),
                Integer.toString(marketLevelRome),
                Integer.toString(farmLevelRome),
                Integer.toString(archeryRangeLevelRome),
                Integer.toString(stableLevelRome),
                Integer.toString(barracksLevelRome)
        ).getCityViewScene());

    }

    public static void endTurnInSparta() {
        game.endTurn();
        Main.window.setScene(new CityViewWindowSparta(
                inWhatCity
                ,
                Double.toString(game.getPlayer().getTreasury()),
                Double.toString(game.getPlayer().getFood()),
                Integer.toString(game.getCurrentTurnCount()),
                Integer.toString(marketLevelSparta),
                Integer.toString(farmLevelSparta),
                Integer.toString(archeryRangeLevelSparta),
                Integer.toString(stableLevelSparta),
                Integer.toString(barracksLevelSparta)
        ).getCityViewScene());
    }

    public static void openMapFromCityView() {
        Constants.playEffect(Constants.clickButton);
        Main.window.setScene(new MapViewWindow().getMapViewScene());
    }


    public static void addBuildingToCity() {

    }

    public static void updateBuildingLevel() {

    }

    public static Stage editBuildingwindow;

    public static void buildButtonPressedCairo() {
        Constants.playEffect(Constants.clickButton);

        editBuildingwindow = new Stage();
        editBuildingwindow.initModality(Modality.APPLICATION_MODAL);
        editBuildingwindow.setScene(new EditBuildingWindow(Integer.toString(marketLevelCairo),
                Integer.toString(farmLevelCairo),
                Integer.toString(archeryRangeLevelCairo),
                Integer.toString(stableLevelCairo),
                Integer.toString(barracksLevelCairo)).getEditBuildingScene());
        editBuildingwindow.showAndWait();
    }

    public static void buildButtonPressedRome() {
        Constants.playEffect(Constants.clickButton);

        editBuildingwindow = new Stage();
        editBuildingwindow.initModality(Modality.APPLICATION_MODAL);
        editBuildingwindow.setScene(new EditBuildingWindow(Integer.toString(marketLevelRome),
                Integer.toString(farmLevelRome),
                Integer.toString(archeryRangeLevelRome),
                Integer.toString(stableLevelRome),
                Integer.toString(barracksLevelRome)).getEditBuildingScene());
        editBuildingwindow.showAndWait();
    }

    public static void buildButtonPressedSparta() {
        Constants.playEffect(Constants.clickButton);

        editBuildingwindow = new Stage();
        editBuildingwindow.initModality(Modality.APPLICATION_MODAL);
        editBuildingwindow.setScene(new EditBuildingWindow(Integer.toString(marketLevelSparta),
                Integer.toString(farmLevelSparta),
                Integer.toString(archeryRangeLevelSparta),
                Integer.toString(stableLevelSparta),
                Integer.toString(barracksLevelSparta)).getEditBuildingScene());
        editBuildingwindow.showAndWait();
    }


    public static void armiesButtonPressed() {
        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage = new Stage();
        showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);
        Army army = getArmyOfCity();
        if (army != null) {
            showArmyWindowStage.setScene(new ShowArmyWindow(cityToAttack,
                    game.getPlayer().getControlledArmies().get(0).getCurrentStatus().toString(),
                    roundsUntilArrived != -1 ? "" : Integer.toString(roundsUntilArrived),
                    game.getPlayer().getControlledArmies().get(0).getCurrentLocation(),
                    cityToAttack).getShowArmyScene());
        } else {
            showArmyWindowStage.setScene(new ShowArmyWindow("",
                    "", "", "", "").getShowArmyScene());
        }
        showArmyWindowStage.showAndWait();
    }

    public static Stage showDefendingArmiesWindow;

    public static void defendingArmyButtonPressed(String city) {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow = new Stage();
        showDefendingArmiesWindow.initModality(Modality.APPLICATION_MODAL);
        showDefendingArmiesWindow.setScene(new ShowDefendingArmyOfCityWindow(inWhatCity,
                false, false).getScene());
        showDefendingArmiesWindow.showAndWait();
    }

    public static Stage showAttackStrategyWindow;

    public static void attackButtonPressed() {

        for (City city : game.getPlayer().getControlledCities()
        ) {
            if (city.getName().equalsIgnoreCase("Cairo")) {
                conquoredCairo = true;
            }
            if (city.getName().equalsIgnoreCase("Rome")) {
                conquoredRome = true;
            }
            if (city.getName().equalsIgnoreCase("Sparta")) {
                conquoredSparta = true;
            }
        }

        Constants.playEffect(Constants.clickButton);
        showAttackStrategyWindow = new Stage();
        showAttackStrategyWindow.initModality(Modality.APPLICATION_MODAL);
        showAttackStrategyWindow.setScene(new AttackStrategyWindow(conquoredCairo,
                conquoredRome, conquoredSparta, button1Disabled, button2Disabled).getScene());
        showAttackStrategyWindow.showAndWait();
    }

//    EditBuildingWindow

    public static void goBackToCityFromEditBuilding() {
        Constants.playEffect(Constants.clickButton);
        Main.window.setScene(new CityOrArmyWindow(inWhatCity).getCityOrArmyWindow());
        editBuildingwindow.close();
    }


    public static void buildButtonPressedCairo(String building) {
        City currentCity = null;
        for (City city : game.getPlayer().getControlledCities()
        ) {
            if (city.getName().equalsIgnoreCase(inWhatCity)) {
                currentCity = city;
            }
        }
        try {
            game.getPlayer().build(building, currentCity.getName());
//            Controller.game.endTurn();
        } catch (Exception e) {
            new PopUpWindow("Not Enough Gold");
        }
        Constants.playEffect(Constants.clickButton);
        goBackToCityFromEditBuilding();
    }

    public static void upgradeButtonPressed(String building) {
        City currentCity = null;
        for (City city : game.getPlayer().getControlledCities()
        ) {
            if (city.getName().equalsIgnoreCase(inWhatCity)) {
                currentCity = city;
            }
        }


        Building buildingToUpgrade = null;
        for (Building buildingTemp : currentCity.getMilitaryBuildings()
        ) {
            if (buildingTemp instanceof ArcheryRange && building.equals("ArcheryRange")) {
                buildingToUpgrade = buildingTemp;
            } else if (buildingTemp instanceof Stable && building.equals("Stable")) {
                buildingToUpgrade = buildingTemp;

            } else if (buildingTemp instanceof Barracks && building.equals(
                    "Barracks")) {
                buildingToUpgrade = buildingTemp;

            }
        }


        for (Building buildingTemp : currentCity.getEconomicalBuildings()
        ) {
            if (buildingTemp instanceof Market && building.equals("Market")) {
                buildingToUpgrade = buildingTemp;

            } else if (buildingTemp instanceof Farm && building.equals("Farm")) {
                buildingToUpgrade = buildingTemp;

            }
        }

        try {
            game.getPlayer().upgradeBuilding(buildingToUpgrade);
//            Controller.game.endTurn();
        } catch (Exception e) {
            new PopUpWindow("Not Enough Gold\nOr Not Built\nOr Building " +
                    "Cool Down\n Or Max Level");
        }
        Constants.playEffect(Constants.clickButton);
        goBackToCityFromEditBuilding();
    }

    public static void recruitButtonPressed(String building) {
        City currentCity = null;
        for (City city : game.getPlayer().getControlledCities()
        ) {
            if (city.getName().equalsIgnoreCase(inWhatCity)) {
                currentCity = city;
            }
        }


        String typeToRecruitFrom = "";
        for (Building buildingTemp : currentCity.getMilitaryBuildings()
        ) {
            if (buildingTemp instanceof ArcheryRange && building.equals("ArcheryRange")) {
                typeToRecruitFrom = "archer";
            } else if (buildingTemp instanceof Stable && building.equals("Stable")) {
                typeToRecruitFrom = "cavalry";
            } else if (buildingTemp instanceof Barracks && building.equals(
                    "Barracks")) {
                typeToRecruitFrom = "infantry";
            }
        }

        try {
            game.getPlayer().recruitUnit(typeToRecruitFrom, inWhatCity);
            if (Controller.inWhatCity.equalsIgnoreCase("cairo")) {
                Main.window.setScene(new CityViewWindowCairo(
                        inWhatCity
                        ,
                        Double.toString(game.getPlayer().getTreasury()),
                        Double.toString(game.getPlayer().getFood()),
                        Integer.toString(game.getCurrentTurnCount()),
                        Integer.toString(marketLevelCairo),
                        Integer.toString(farmLevelCairo),
                        Integer.toString(archeryRangeLevelCairo),
                        Integer.toString(stableLevelCairo),
                        Integer.toString(barracksLevelCairo)
                ).getCityViewScene());
            } else if (Controller.inWhatCity.equalsIgnoreCase("sparta")) {
                Main.window.setScene(new CityViewWindowSparta(
                        inWhatCity
                        ,
                        Double.toString(game.getPlayer().getTreasury()),
                        Double.toString(game.getPlayer().getFood()),
                        Integer.toString(game.getCurrentTurnCount()),
                        Integer.toString(marketLevelSparta),
                        Integer.toString(farmLevelSparta),
                        Integer.toString(archeryRangeLevelSparta),
                        Integer.toString(stableLevelSparta),
                        Integer.toString(barracksLevelSparta)
                ).getCityViewScene());
            } else {
                Main.window.setScene(new CityViewWindowRome(
                        inWhatCity
                        ,
                        Double.toString(game.getPlayer().getTreasury()),
                        Double.toString(game.getPlayer().getFood()),
                        Integer.toString(game.getCurrentTurnCount()),
                        Integer.toString(marketLevelRome),
                        Integer.toString(farmLevelRome),
                        Integer.toString(archeryRangeLevelRome),
                        Integer.toString(stableLevelRome),
                        Integer.toString(barracksLevelRome)
                ).getCityViewScene());
            }
//            game.endTurn();
        } catch (Exception ignored) {

        }
        Constants.playEffect(Constants.clickButton);
        editBuildingwindow.close();


    }

    public static void recruitButtonPressed() {
        Constants.playEffect(Constants.clickButton);
    }

    public static void updateBuildingLevelLabel() {

    }


    //    GameOverWindow
    public static void upDateGameEndResult() {

    }


    //    ShowControlledArmiesWindow
    public static void controlledArmyOfCityChosen(String cityBeingAttacked) {

        Army army = getArmyOfCity();

        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage = new Stage();
        showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);
        if (army != null) {
            showArmyWindowStage.setScene(new ShowArmyWindow(cityToAttack,
                    game.getPlayer().getControlledArmies().get(0).getCurrentStatus().toString(),
                    roundsUntilArrived != -1 ? "" : Integer.toString(roundsUntilArrived),
                    game.getPlayer().getControlledArmies().get(0).getCurrentLocation(),
                    cityBeingAttacked).getShowArmyScene());
        } else {
            showArmyWindowStage.setScene(new ShowArmyWindow("", "",
                    "", "", "").getShowArmyScene());
        }
        showArmyWindowStage.showAndWait();
    }


    private static City getCityBeingAttacked(String cityBeingAttacked) {
        for (City city : game.getAvailableCities()
        ) {
            if (city.getName().equals(cityBeingAttacked)) {
                return city;
            }
        }
        return null;
    }


    private static Army getArmyOfCity() {
        try {
            return game.getPlayer().getControlledArmies().get(0);
        } catch (Exception e) {
            return null;
        }
    }

//    public static void goBackControlledArmiesWindow() {
//        Constants.playEffect(Constants.clickButton);
//        showControlledArmiesWindow.close();
//    }


//    ShowDefendingArmyOfCityWindow

    public static void showDefendingArmyWindowBackButtonOnAction() {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow.close();
    }


    public static ObservableList<Unit> unitsObservableListDefendingArmy;

    public static ObservableList<Unit> putDefendingputdArmyUnits(String city) {
        unitsObservableListDefendingArmy = FXCollections.observableArrayList();

        Army army = null;

        for (City cityTemp : game.getAvailableCities()
        ) {
            if (cityTemp.getName().equalsIgnoreCase(city)) {
                army = cityTemp.getDefendingArmy();
            }
        }

        for (Unit unit : army.getUnits()) {
            unitsObservableListDefendingArmy.add(unit);
        }

        return unitsObservableListDefendingArmy;
    }


    //    RelocateWindow
    public static void updateButtonTextRelocate() {

    }
//
//    public static void relocateUnitButtonPressed() {
//        Constants.playEffect(Constants.clickButton);
//        UnitsHelperClass.relocateStage.close();
//    }


    //    AttackStrategyWindow
    public static void cityToAttackButtonPressed() {
        Constants.playEffect(Constants.clickButton);
        showAttackStrategyWindow.close();
        Main.window.setScene(new BattleFieldWindow().getScene());
    }

    public static void autoresolveButtonPressed(Army attacker, Army defender) {
        Constants.playEffect(Constants.clickButton);
        try {
            game.autoResolve(attacker, defender);
        } catch (FriendlyFireException e) {
            new PopUpWindow(e.toString());
        }
    }


}
