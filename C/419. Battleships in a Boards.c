#include <stdio.h>
#include <stdlib.h>

int countBattleships(char** board, int boardRowSize, int boardColSize) {
    int i, j;
    int result = 0;
    for (i = 0; i < boardRowSize; i++)
    {
        for (j = 0; j < boardColSize; j++)
        {
            if (board[i][j] == '.')
                continue;
            if (j != boardColSize - 1 && board[i][j + 1] == 'X')
                continue;
            if (i != boardRowSize - 1 && board[i + 1][j] == 'X')
                continue;
            result++;
            continue;
        }
    }
                
    return result;    
}

int main(void)
{
    char **board;
    char *board1 = "X..X";
    char *board2 = "...X";
    char *board3 = "...X";
    board = malloc(3 * sizeof(char *));
    board[0] = board1;
    board[1] = board2;
    board[2] = board3;
    printf("%d\n", countBattleships(board, 3, 4));
    return 0;
}
