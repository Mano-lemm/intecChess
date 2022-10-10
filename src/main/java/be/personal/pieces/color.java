package be.personal.pieces;
 
public enum color{
    EMPTY(0),
    BLACK(-1),
    WHITE(1);

    public final int direction;

    private color(int dir) {
        direction = dir;
    }

    public color other() {
        switch (this) {
            case WHITE:
                return BLACK;
            case BLACK:
                return WHITE;
            default:
                return EMPTY;
        }
    }

    public String toString(){
        switch (this) {
            case WHITE:
                return "White ";
            case BLACK:
                return "Black ";
            default:
                return "";
        }
    }
};