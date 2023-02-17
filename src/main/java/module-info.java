module be.personal {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens be.personal.GUIRedesign to javafx.fxml;
    exports be.personal.GUIRedesign;
    exports be.personal.pieces;
}
