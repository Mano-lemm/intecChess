package be.personal.pieces;

public abstract class piece{
    public int[] pos;
    public boolean moved;
    public color co;

    protected piece(int x, int y, color c){
        assert x > 0 && x < 9;
        assert y > 0 && y < 9;
        pos = new int[2];
        pos[1] = x;
        pos[0] = y;
        co = c;
        moved = true;
    }

    public abstract void move(int x, int y, piece[][] board);

    public abstract String toString();
}
