#include <stdio.h>

int arrangeCoins(int n) {
    int num = 1;
    while(n >= num) 
    {
        n -= num;
        num++;
    }
    return num - 1;        
}
