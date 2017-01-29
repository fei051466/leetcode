#include <stdio.h>

int numberOfArithmeticSlices(int* A, int ASize) {
    if (ASize < 3) return 0;
    int pre = A[1] - A[0];
    int i = 2;
    int curLen = 2;
    int result = 0;

    while (i < ASize)
    {
        if (A[i] - A[i - 1] == pre)
        {
            curLen++;
        }
        else
        {
            if (curLen > 2)
                result += (curLen - 1) * (curLen - 2) / 2;
            pre = A[i] - A[i - 1];
            curLen = 2;
        }            
        i++;
    }
    result += (curLen - 1) * (curLen - 2) / 2;

    return result;
}

int main(void)
{
    int A[] = {1, 2, 3, 4};
    printf("%d\n", numberOfArithmeticSlices(A, sizeof(A) / sizeof(int)));
    return 0;
}
