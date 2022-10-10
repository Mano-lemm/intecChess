package be.personal.pieces;

import utils.gUtils;
import be.personal.board.chess;

public class pawn extends piece{
    public pawn(int x, int y, color c){
        super(x, y, c);
        moved = false;
    }

    @Override
    public void move(int x, int y, piece[][] board) {
        //no - take moves
        if(y == pos[1]){
            if(x == pos[0] + (1 * co.direction) 
            && board[x][y].getClass() == empty.class){
                chess.place(this, x, y);
            }
            // first move 2 away
            else if(!moved
                    && x == pos[0] + (2 * co.direction)
                    && board[x][y].getClass() == empty.class
                    && board[pos[0] + (1 * co.direction)][y].getClass() == empty.class){
                chess.place(this, x, y);
            }
        }
        //taking moves
        else if(y == pos[1] + 1 || y == pos[1] - 1){
            if(x == pos[0] + (1 * co.direction) && board[x][y].co == co.other()){
                chess.place(this, x, y);
            }
        }
        // TODO: pawn choice in promotion
        // kan via scanner
        // ik kies ervoor dit niet te doen 
        // ivm dit mogelijk uitwerken met een GUI
        // waardoor ik oftewel een pop up moet aanmaken vanuit deze functie
        // of een andere functie moet maken die slechts aangeeft welke pionnen
        // gepromoveerd moeten
        if(pos[0] == (gUtils.boolToInt(co == color.WHITE) * 7)){
            board[pos[0]][pos[1]] = new queen(pos[0], pos[1], co);
        }
        return;
    }

    @Override
    public String toString() {
        return co.toString() + "Pawn";
    }
}
