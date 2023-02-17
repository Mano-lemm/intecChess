package utils;

import java.util.ArrayList;

import be.personal.pieces.color;
import be.personal.pieces.piece;

public class gUtils {
    public static int boolToInt(boolean b){
        return b ? 1 : 0;
    }

    public static ArrayList<Integer[]> diagonals(int pos, int pos2, color co, piece[][] board) {
        boolean[] dirs = new boolean[]{true, true, true, true};
        int n = 1;
        ArrayList<Integer[]> list = new ArrayList<Integer[]>(1);
        while(dirs[0] || dirs[1] || dirs[2] || dirs[3]) {
            if(dirs[0]){
                if(pos2 + n < 8
                && pos + n < 8){
                    if(board[pos2 + n][pos + n].co == color.EMPTY
                    || board[pos2 + n][pos + n].co == co.other()){
                        list.add(new Integer[]{pos2 + n, pos + n});
                    }
                    if(board[pos2 + n][pos + n].co == co
                    || board[pos2 + n][pos + n].co == co.other()){
                        dirs[0] = false;
                    }
                }else{
                    dirs[0] = false;
                }
            }
            if(dirs[1]){
                if(pos2 - n >= 0
                && pos + n < 8){
                    if(board[pos2 - n][pos + n].co == color.EMPTY
                    || board[pos2 - n][pos + n].co == co.other()){
                        list.add(new Integer[]{pos2 - n, pos + n});
                    }
                    if(board[pos2 - n][pos + n].co == co
                    || board[pos2 - n][pos + n].co == co.other()){
                        dirs[1] = false;
                    }
                }else{
                    dirs[1] = false;
                }
            }
            if(dirs[2]){
                if(pos2 + n < 8
                && pos - n >= 0){
                    if(board[pos2 + n][pos - n].co == color.EMPTY
                    || board[pos2 + n][pos - n].co == co.other()){
                        list.add(new Integer[]{pos2 + n, pos - n});
                    }
                    if(board[pos2 + n][pos - n].co == co
                    || board[pos2 + n][pos - n].co == co.other()){
                        dirs[2] = false;
                    }
                }else{
                    dirs[2] = false;
                }
            }
            if(dirs[3]){
                if(pos2 - n >= 0
                && pos - n >= 0){
                    if(board[pos2 - n][pos - n].co == color.EMPTY
                    || board[pos2 - n][pos - n].co == co.other()){
                        list.add(new Integer[]{pos2 - n, pos - n});
                    }
                    if(board[pos2 - n][pos - n].co == co
                    || board[pos2 - n][pos - n].co == co.other()){
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

    public static ArrayList<Integer[]> rowsAndColumns(int pos, int pos2, color co, piece[][] board){
        ArrayList<Integer[]>  arr = new ArrayList<Integer[]>();
        boolean[] dirs = new boolean[]{true, true, true, true};
        int n = 1;
        while(dirs[0] || dirs[1] || dirs[2] || dirs[2]){
            if(dirs[3]){
                if(pos2 - n >= 0){
                    if(board[pos][pos2 - n].co == color.EMPTY
                    || board[pos][pos2 - n].co == co.other()){
                        arr.add(new Integer[]{(int) pos, pos2 - n});
                    }
                if(board[pos][pos2 - n].co == co.other()
                || board[pos][pos2 - n].co == co){
                    dirs[3] = false;
                }
                }else{  
                    dirs[3] = false;
                }
            }
            if(dirs[2]){
                if(pos2 + n < 8){
                    if(board[pos][pos2 + n].co == color.EMPTY
                    || board[pos][pos2 + n].co == co.other()){
                        arr.add(new Integer[]{(int) pos, pos2 + n});
                    }
                if(board[pos][pos2 + n].co == co.other()
                || board[pos][pos2 + n].co == co){
                    dirs[2] = false;
                }
                }else{  
                    dirs[2] = false;
                }
            }
            if(dirs[1]){
                if(pos - n >= 0){
                    if(board[pos - n][pos2].co == color.EMPTY
                    || board[pos - n][pos2].co == co.other()){
                        arr.add(new Integer[]{pos - n, (int) pos2});
                    }
                if(board[pos - n][pos2].co == co.other()
                || board[pos - n][pos2].co == co){
                    dirs[1] = false;
                }
                }else{  
                    dirs[1] = false;
                }
            }
            if(dirs[0]){
                if(pos + n < 8){
                    if(board[pos + n][pos2].co == color.EMPTY
                    || board[pos + n][pos2].co == co.other()){
                        arr.add(new Integer[]{pos + n, (int) pos2});
                    }
                if(board[pos + n][pos2].co == co.other()
                || board[pos + n][pos2].co == co){
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
