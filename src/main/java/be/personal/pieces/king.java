package be.personal.pieces;

import be.personal.board.chess;
import utils.gUtils;

public class king extends piece{
    public king(int x, int y, color c){
        super(x, y, c);
        moved = false;
    }

    @Override
    public void move(int x, int y, piece[][] board) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(pos[0] + i == x && pos[1] + j == y){
                    if(board[pos[0] + i][pos[1] + j].co == color.EMPTY
                    ||board[pos[0] + i][pos[1] + j].co == co.other()){
                        chess.place(this, x, y);
                    }
                }
            }
        } 

        // rokade
        int row = gUtils.boolToInt(co == color.BLACK) * 7;
        if(board[x][y].getClass() == rook.class 
        && pos[0] == row
        && pos[1] == 4){
            if(y == 7){
                if(!board[row][7].moved 
                    && board[row][6].co == color.EMPTY 
                    && board[row][5].co == color.EMPTY){
                    chess.place(board[row][7], row, 5);
                    chess.turn = co;
                    chess.place(this, row, 6);
                }
            else if(!board[row][0].moved
                  && board[row][1].co == color.EMPTY
                  && board[row][2].co == color.EMPTY
                  && board[row][3].co == color.EMPTY){
                    chess.place(board[row][0], row, 3);
                    chess.turn = co;
                    chess.place(this, row, 2);
                }
            }
        }
    }

    @Override
    public String toString() {
        return co.toString() + "King";
    }
}
