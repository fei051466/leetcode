#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void *b)
{
    return *(int *)a - *(int *)b;
}

int findContentChildren(int* g, int gSize, int* s, int sSize) {
    qsort(g, gSize, sizeof(int), cmp);
    qsort(s, sSize, sizeof(int), cmp);
    int gIndex = 0, sIndex = 0;
    int result = 0;
    while (gIndex < gSize && sIndex < sSize)
    {
        if (g[gIndex] <= s[sIndex]) 
        {
            gIndex++;
            sIndex++;
            result++;
        }
        else
            sIndex++;
    }
    return result; 
}

int main(void)
{
    int testg[] = {1, 2};
    int tests[] = {1, 2, 3};

    printf("%d\n", findContentChildren(testg, 2, tests, 3));

    return 0;
}
