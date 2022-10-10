package be.personal.pieces;

import be.personal.board.chess;
import utils.gUtils;

public class bishop extends piece{
    public bishop(int x, int y, color c){
        super(x, y, c);
    }

    @Override
    public void move(int x, int y, piece[][] board) {
        for(Integer[] pos : gUtils.diagonals(pos[1], pos[0], co, board)){
            if(pos[0] == x 
            && pos[1] == y){
                chess.place(this, x, y);
                break;
            }
        }
        return;
    }

    @Override
    public String toString() {
        return co.toString() + "Bishop";
    }
}
