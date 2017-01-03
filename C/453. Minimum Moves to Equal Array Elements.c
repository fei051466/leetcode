#include <stdio.h>

int minMoves(int* nums, int numsSize) {
    int min = nums[0];
    int i;
    int result = 0;

    for (i = 0; i < numsSize; i++)
    {
        if (nums[i] < min) min = nums[i];
    }

    for (i = 0; i < numsSize; i++)
    {
        result += nums[i] - min;
    }
    
    return result;
}

int main(void)
{
    int testCase[] = {1, 2, 4, 5};

    printf("%d\n", minMoves(testCase, 4));
    return 0;
}
