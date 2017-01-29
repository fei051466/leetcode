#include <stdio.h>

int findComplement(int num) {
    int mask = 0;
    int n = num;
    while(n != 0)
    {
        n /= 2;
        mask = 2 * mask + 1;
    }
    return num ^ mask;
}

int main(void)
{
    printf("%d\n", findComplement(5));
    return 0;
}
