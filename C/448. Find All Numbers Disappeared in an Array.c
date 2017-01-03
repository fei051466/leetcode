#include <stdio.h>
#include <stdlib.h>

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findDisappearedNumbers(int* nums, int numsSize, int* returnSize) {
    int i;
    int *count = malloc(sizeof(int) * numsSize);
    int currentSize = 0;
    int *result = NULL;
    for (i = 0; i < numsSize; i++)
    {
        count[i] = 0;
    }
    for (i = 0; i < numsSize; i++)
    {
        count[nums[i] - 1]++;
        if(count[nums[i] - 1] == 2) currentSize++;
    }
    result = malloc(sizeof(int) * currentSize);
    *returnSize = currentSize;
    for (i = numsSize - 1; i >= 0; i--)
    {
        if (count[i] != 0) continue;
        result[--currentSize] = i + 1;
    }
    return result;
}

int main(void)
{
    int testCase[] = {4, 5, 3, 2, 7, 7, 8, 8};
    int *result;
    int i;
    int resultSize;

    result = findDisappearedNumbers(testCase, sizeof(testCase) / sizeof(int), &resultSize);

    for (i = 0; i < resultSize; i++)
    {
        printf("result[%d]..%d\n", i, result[i]);
    }

    return 0;
    
}
