public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] square = new boolean[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.')
                {
                    if(rows[i][board[i][j]-'1'])
                        return false;
                    rows[i][board[i][j]-'1'] = true;
                    if(columns[j][board[i][j]-'1'])
                        return false;
                    columns[j][board[i][j]-'1'] = true;
                    int current_square = i/3 + 3*(j/3);
                    if(square[current_square][board[i][j]-'1'])
                        return false;
                    square[current_square][board[i][j]-'1'] = true;
                }
            }
        }
        return true;
    }
}