package be.personal.pieces;
 
public class empty extends piece{
    public empty(){
        super(-1, -1, color.EMPTY);
    };

    public empty(int x, int y, color c){
        super(x, y, c);
    }

    @Override
    public void move(int x, int y, piece[][] board) {
       assert false; 
    }

    @Override
    public String toString() {
        return "";
    }
}