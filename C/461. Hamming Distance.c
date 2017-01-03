#include <stdio.h>

int hammingDistance(int x, int y) {
    int z = x ^ y;
    int result = 0;
    while (z != 0)
    {
        result += z % 2;
        z /= 2;
    }
    return result;    
}

int main(void)
{
    printf("%d", hammingDistance(1, 4));

    return 0;
}
