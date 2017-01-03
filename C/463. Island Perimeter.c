#include <stdio.h>
#include <stdlib.h>

int islandPerimeter(int** grid, int gridRowSize, int gridColSize) {
    int row;
    int col;
    int total = 0;

    for (row = 0; row < gridRowSize; row++)
    {
        for (col = 0; col < gridColSize; col++)
        {
            if (grid[row][col] == 1)
            {
                total += 4;
                if (row != 0 && grid[row-1][col] == 1) total -= 2;
                if (col != 0 && grid[row][col-1] == 1) total -= 2;
            }
        }
    }

    return total;        
}

int main(void)
{
    int testCase[4][4] = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};

    int **test = malloc(sizeof(int*) * 4);
    int i;
    for (i = 0; i < 4; i++)
    {
        int *line = malloc(sizeof(int) * 4);
        *(test + i) = line;
    }
    test[0][1] = 1;
    test[1][0] = 1;
    test[1][1] = 1;
    test[1][2] = 1;
    test[2][1] = 1;
    test[3][0] = 1;
    test[2][1] = 1;


    printf("%d\n", islandPerimeter(test, 4, 4));

    return 0;
}
