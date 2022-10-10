package be.personal.board;

import be.personal.pieces.color;
import be.personal.pieces.*;

public class chess {
    private static piece[][] board;
    public static color turn;

    private boolean contains(piece p){
        for (piece[] pieces : board) {
            for (piece piece : pieces) {
                if(piece.co == p.co 
                && p.getClass() == piece.getClass()){
                    return true;
                } 
            } 
        }
        return false;
    }

    public static void place(piece ori, int x, int y){
        board[x][y] = ori;
        board[ori.pos[0]][ori.pos[1]] = new empty(ori.pos[0], ori.pos[1], color.EMPTY);
        ori.pos[0] = (byte) x;
        ori.pos[1] = (byte) y;
        ori.moved = true;
        turn = turn.other();
    }
    
    public void newGame(){
        turn = color.WHITE;
        board[0][0] = new rook(0, 0, color.WHITE);
        board[0][1] = new horse(1, 0, color.WHITE);
        board[0][2] = new bishop(2, 0, color.WHITE);
        board[0][3] = new queen(3, 0, color.WHITE);
        board[0][4] = new king(4, 0, color.WHITE);
        board[0][5] = new bishop(5, 0, color.WHITE);
        board[0][6] = new horse(6, 0, color.WHITE);
        board[0][7] = new rook(7, 0, color.WHITE);
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new pawn(i, 1, color.WHITE); 
        }
        for (int i = 2; i < 6; i++){
            for (int j = 0; j < 8; j++){
                board[i][j] = new empty(i, j, color.EMPTY);
            }
        }
        for (int i = 0; i < board.length; i++) {
            board[6][i] = new pawn(i, 6, color.BLACK); 
        }
        board[7][0] = new rook(0, 7, color.BLACK);
        board[7][1] = new horse(1, 7, color.BLACK);
        board[7][2] = new bishop(2, 7, color.BLACK);
        board[7][3] = new queen(3, 7, color.BLACK);
        board[7][4] = new king(4, 7, color.BLACK);
        board[7][5] = new bishop(5, 7, color.BLACK);
        board[7][6] = new horse(6, 7, color.BLACK);
        board[7][7] = new rook(7, 7, color.BLACK);
    }

    public chess(){
        board = new piece[8][8];
        newGame();
    }

    public void testMove(int[] pos1, int[] pos2){
        board[pos1[0]][pos1[1]].move(pos2[0], pos2[1], board);
    }

    private String colorToStr(color c){
        switch(c.direction){
            case -1:
                return "B";
            case 1:
                return "W";
            default:
                return "E";
        }
    }

    public boolean isGameOver(){
        if(!(contains(new king(0, 0, color.WHITE)) && contains(new king(0, 0, color.BLACK)))){
            turn = color.EMPTY;
            return true;
        }
        return false;
    }

    // gebruikt voor testen en text-based display
    @SuppressWarnings("unused")
    private void displayBoard(){
        for (piece[] pieces : board) {
            System.out.printf(" ");
            for (piece piece : pieces) {
                if(piece.getClass() == horse.class){
                    System.out.printf(colorToStr(piece.co) + "H ");
                }
                if(piece.getClass() == pawn.class){
                    System.out.printf(colorToStr(piece.co) + "P ");
                }
                if(piece.getClass() == king.class){
                    System.out.printf(colorToStr(piece.co) + "K ");
                }
                if(piece.getClass() == queen.class){
                    System.out.printf(colorToStr(piece.co) + "Q ");
                }
                if(piece.getClass() == bishop.class){
                    System.out.printf(colorToStr(piece.co) + "B ");
                }
                if(piece.getClass() == rook.class){
                    System.out.printf(colorToStr(piece.co) + "R ");
                }
                if(piece.getClass() == empty.class){
                    System.out.printf(colorToStr(piece.co) + "  ");
                }
            }
            System.out.printf("\n"); 
        }
        System.out.printf("\n\n\n");
    }

    public final piece[][] getBoard(){
        return board;
    }

    public final String getTurn(){
        switch(turn){
            case WHITE:
                return "White's turn";
            case BLACK:
                return "Black's turn";
            default:
                return "Nobody's turn";
        }
    }

    public boolean move(int[] x, int[] y){
        if(turn == board[x[0]][x[1]].co){
            testMove(x, y);
            return true;
        }
        return false;
    }
}