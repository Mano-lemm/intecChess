package utils;

import java.util.ArrayList;

import be.personal.pieces.color;
import be.personal.pieces.piece;

public class gUtils {
    public static int boolToInt(boolean b){
        return b ? 1 : 0;
    }

    public static ArrayList<Integer[]> diagonals(byte c, byte b, color co, piece[][] board) {
        boolean[] dirs = new boolean[]{true, true, true, true};
        int n = 1;
        ArrayList<Integer[]> list = new ArrayList<Integer[]>(1);
        while(dirs[0] || dirs[1] || dirs[2] || dirs[3]) {
            if(dirs[0]){
                if(b + n < 8
                && c + n < 8){
                    if(board[b + n][c + n].co == color.EMPTY
                    || board[b + n][c + n].co == co.other()){
                        list.add(new Integer[]{b + n, c + n});
                    }
                    if(board[b + n][c + n].co == co
                    || board[b + n][c + n].co == co.other()){
                        dirs[0] = false;
                    }
                }else{
                    dirs[0] = false;
                }
            }
            if(dirs[1]){
                if(b - n >= 0
                && c + n < 8){
                    if(board[b - n][c + n].co == color.EMPTY
                    || board[b - n][c + n].co == co.other()){
                        list.add(new Integer[]{b - n, c + n});
                    }
                    if(board[b - n][c + n].co == co
                    || board[b - n][c + n].co == co.other()){
                        dirs[1] = false;
                    }
                }else{
                    dirs[1] = false;
                }
            }
            if(dirs[2]){
                if(b + n < 8
                && c - n >= 0){
                    if(board[b + n][c - n].co == color.EMPTY
                    || board[b + n][c - n].co == co.other()){
                        list.add(new Integer[]{b + n, c - n});
                    }
                    if(board[b + n][c - n].co == co
                    || board[b + n][c - n].co == co.other()){
                        dirs[2] = false;
                    }
                }else{
                    dirs[2] = false;
                }
            }
            if(dirs[3]){
                if(b - n >= 0
                && c - n >= 0){
                    if(board[b - n][c - n].co == color.EMPTY
                    || board[b - n][c - n].co == co.other()){
                        list.add(new Integer[]{b - n, c - n});
                    }
                    if(board[b - n][c - n].co == co
                    || board[b - n][c - n].co == co.other()){
                        dirs[3] = false;
                    }
                }else{
                    dirs[3] = false;
                }
            }
            n++;
        }
        return list;
    }

    public static ArrayList<Integer[]> rowsAndColumns(byte b, byte c, color co, piece[][] board){
        ArrayList<Integer[]>  arr = new ArrayList<Integer[]>();
        boolean[] dirs = new boolean[]{true, true, true, true};
        int n = 1;
        while(dirs[0] || dirs[1] || dirs[2] || dirs[2]){
            if(dirs[3]){
                if(c - n >= 0){
                    if(board[b][c - n].co == color.EMPTY
                    || board[b][c - n].co == co.other()){
                        arr.add(new Integer[]{(int) b, c - n});
                    }
                if(board[b][c - n].co == co.other()
                || board[b][c - n].co == co){
                    dirs[3] = false;
                }
                }else{  
                    dirs[3] = false;
                }
            }
            if(dirs[2]){
                if(c + n < 8){
                    if(board[b][c + n].co == color.EMPTY
                    || board[b][c + n].co == co.other()){
                        arr.add(new Integer[]{(int) b, c + n});
                    }
                if(board[b][c + n].co == co.other()
                || board[b][c + n].co == co){
                    dirs[2] = false;
                }
                }else{  
                    dirs[2] = false;
                }
            }
            if(dirs[1]){
                if(b - n >= 0){
                    if(board[b - n][c].co == color.EMPTY
                    || board[b - n][c].co == co.other()){
                        arr.add(new Integer[]{b - n, (int) c});
                    }
                if(board[b - n][c].co == co.other()
                || board[b - n][c].co == co){
                    dirs[1] = false;
                }
                }else{  
                    dirs[1] = false;
                }
            }
            if(dirs[0]){
                if(b + n < 8){
                    if(board[b + n][c].co == color.EMPTY
                    || board[b + n][c].co == co.other()){
                        arr.add(new Integer[]{b + n, (int) c});
                    }
                if(board[b + n][c].co == co.other()
                || board[b + n][c].co == co){
                    dirs[0] = false;
                }
                }else{  
                    dirs[0] = false;
                }
            }
            n++;
        }
        return arr;
    }
}
