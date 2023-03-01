module be.personal {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires annotations;

    opens be.personal.GUIRedesign to javafx.fxml;
    exports be.personal.GUIRedesign;
    exports be.personal.pieces;
}
