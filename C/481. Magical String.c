#include <stdio.h>
#include <stdlib.h>

int magicalString(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    int *original = malloc(n * sizeof(int));         
    int *counting = malloc(n * sizeof(int));
    int i = 1, j = 1, k = 1;
    int cur_count = 0, result = 1;
    int pending;

    original[0] = 1;
    counting[0] = 1;
    counting[1] = 2;
    while (i < n)
    {
        while (j < i)
        {
            counting[j] = original[j];
            j++;
        }
        if (cur_count < counting[k])
        {
            if (cur_count == 0)
                pending = 3 - original[i - 1];
            else 
                pending = original[i - 1];
            original[i] = pending;
            if (pending == 1) result++;
            cur_count++;
            i++;
        }
        else
        {
            cur_count = 0;
            k++;
        }
    }
    return result; 
}

int main(void)
{
    printf("%d\n", magicalString(6));
    return 0;
}
