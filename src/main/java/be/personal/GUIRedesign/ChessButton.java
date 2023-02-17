package be.personal.GUIRedesign;

import be.personal.pieces.empty;
import be.personal.pieces.piece;
import javafx.scene.control.Button;

public class ChessButton extends Button{
    private static final String stylePrefix = "-fx-text-fill: #00FFFF;";
    private final SelectionColours defaultColour;
    public final int x, y;
    private boolean selected;
    private piece piece;

    public ChessButton(piece piece, int x, int y){
        this.defaultColour = (x + y) % 2 == 0 ? SelectionColours.BLACK : SelectionColours.WHITE;
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.setText(piece.toString());
        this.setMaxSize(400, 400);
        this.setStyle(stylePrefix + this.defaultColour.colour);
    }

    public void update(piece piece){
        this.setText(piece.toString());
        this.piece = piece;
    }

    public void select(){
        if(piece instanceof empty){
            return;
        }
        this.setStyle(stylePrefix + SelectionColours.SELECTED.colour);
        selected = true;
    }

    public void deSelect(){
        if(piece instanceof empty){
            return;
        }
        this.setStyle(stylePrefix + " " + this.defaultColour.colour);
        selected = false;
    }

    public piece getPiece(){
        return this.piece;
    }

    public boolean isSelected(){
        return this.selected;
    }
}
