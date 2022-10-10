package be.personal.pieces;

public abstract class piece{
    public byte[] pos;
    public boolean moved;
    public color co;

    protected piece(int x, int y, color c){
        assert x > 0 && x < 9;
        assert y > 0 && y < 9;
        pos = new byte[2];
        pos[1] = (byte) x;
        pos[0] = (byte) y;
        co = c;
        moved = true;
    }

    public abstract void move(int x, int y, piece[][] board);

    public abstract String toString();
}
