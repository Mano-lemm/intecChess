package be.personal.pieces;

import be.personal.board.chess;

public class horse extends piece{
    private byte[][] moves;
    public horse(int x,int y, color c){
        super(x, y, c);   
        moves = new byte[8][2];
        moves[0][0] = 2;
        moves[0][1] = -1;
        moves[1][0] = 2;
        moves[1][1] = 1;
        moves[2][0] = -2;
        moves[2][1] = -1;
        moves[3][0] = -2;
        moves[3][1] = 1;
        moves[4][0] = 1;
        moves[4][1] = -2;
        moves[5][0] = 1;
        moves[5][1] = 2;
        moves[6][0] = -1;
        moves[6][1] = -2;
        moves[7][0] = -1;
        moves[7][1] = 2;
    }

    @Override
    public void move(int x, int y, piece[][] board) {
        for (byte[] move : moves) {
            if(pos[0] + move[0] == x && pos[1] + move[1] == y){
                if(board[pos[0] + move[0]][pos[1] + move[1]].co == color.EMPTY
                || board[pos[0] + move[0]][pos[1] + move[1]].co == co.other()){
                    chess.place(this, x, y);
                }
                break;
            }
        }
    }

    @Override
    public String toString() {
        return co.toString() + "Horse";
    }
}
