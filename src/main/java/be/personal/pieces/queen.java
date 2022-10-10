package be.personal.pieces;

import be.personal.board.chess;
import utils.gUtils;

public class queen extends piece{
    public queen(int x, int y, color c){
        super(x, y, c);
    }

    @Override
    public void move(int x, int y, piece[][] board) {
        for (Integer[] pos : gUtils.diagonals(pos[1], pos[0], co, board)) {
            if(pos[0] == x
            && pos[1] == y){
                chess.place(this, x, y);
                return;
            }
        }
        for(Integer[] pos : gUtils.rowsAndColumns(pos[0], pos[1], co, board)){
            if(pos[0] == x
            && pos[1] == y){
                chess.place(this, x, y);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return co.toString() + "Queen";
    }
}
