package be.personal.pieces;

import be.personal.board.chess;
import utils.gUtils;

public class rook extends piece{
    public rook(int x, int y, color c){
        super(x, y, c);
        moved = false;
    }

    @Override
    public void move(int x, int y, piece[][] board) {
        for (Integer[] pos : gUtils.rowsAndColumns(pos[0], pos[1], co, board)) {
            if(pos[0] == x
            && pos[1] == y){
                chess.place(this, x, y);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return co.toString() + "Rook";
    }
}
