package be.personal.GUIRedesign;

public enum SelectionColours {
    SELECTED("-fx-background-color: Green;"),
    AVAILABLE("-fx-background-color: Blue;"),
    ATTACKABLE("-fx-background-color: Red;"),
    WHITE("-fx-background-color: White;"),
    BLACK("-fx-background-color: Black;");

    public String colour;
    private SelectionColours(String colour){
        this.colour = colour;
    }
}