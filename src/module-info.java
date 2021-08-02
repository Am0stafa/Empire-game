module EmpireBuilding {
    requires javafx.media;
    requires java.xml;
    requires javafx.controls;
    exports units;
    opens units;
    opens GUI;
}