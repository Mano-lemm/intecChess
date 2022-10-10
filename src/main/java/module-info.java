module be.personal {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens be.personal.GUI to javafx.fxml;
    exports be.personal.GUI;
    exports be.personal.pieces;
}
