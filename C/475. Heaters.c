#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void *b)
{
    return *(int *)a - *(int *)b;
}

int findRadius(int* houses, int housesSize, int* heaters, int heatersSize) {
    int i = 0, j = 0;
    int max = 0;
    int cur;
    int leftR, rightR;
    qsort(houses, housesSize, sizeof(int), cmp);
    qsort(heaters, heatersSize, sizeof(int), cmp);
    while (i < housesSize)
    {
        cur = 0;
        if (houses[i] < heaters[j])
        {
            if (j == 0)
            {
                cur = heaters[j] - houses[i];
            }
            else
            {
                leftR = houses[i] - heaters[j - 1];
                rightR = heaters[j] - houses[i];
                cur = leftR > rightR? rightR: leftR;
            }
            i++;
        }
        else if (houses[i] == heaters[j])
        {
            i++;
            if (j != heatersSize -1 ) j++;
        }
        else
        {
            if (j == heatersSize - 1)
            {
                cur = houses[i] - heaters[j];
                i++;
            }
            else
            {
                j++;
            }
        }
        max = cur > max ? cur : max;
    }
     
    return max;
}

int main(void)
{
    int hourses[] = {1, 2, 3, 4};
    int heaters[] = {1, 4};
    
    printf("%d\n", findRadius(hourses, sizeof(hourses) / sizeof(int), heaters, sizeof(heaters) / sizeof(int)));
    return 0;
}
