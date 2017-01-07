#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */

int countCur(int count[])
{
    int i;
    for (i = 0; i < 26; i++)
        printf("%d ", count[i]);
    printf("\n");
    for (i = 0; i < 26; i++)
    {
        if (count[i] != 0)
            return 0;
    }
    return 1;
}

int* findAnagrams(char* s, char* p, int* returnSize) {
    int *result = malloc(sizeof(int));        
    int slen = strlen(s);
    int plen = strlen(p);
    int sample[26] = {0};
    int count[26] = {0};
    int i;

    *returnSize = 0;
    for(i = 0; p[i] != '\0'; i++)
    {
        sample[p[i] - 'a']++;
        count[p[i] - 'a']++;
    }
    for(i = 0; s[i] != '\0'; i++)
    {
        if(i-plen >= 0 && sample[s[i-plen] - 'a'] != 0)
        {
            count[s[i-plen] - 'a']++;
        }
        if (sample[s[i] - 'a'] != 0)
        {
            count[s[i] - 'a']--;
            if (countCur(count))
            {
                *returnSize = *returnSize + 1;
                result = realloc(result, (*returnSize) * sizeof(int));
                result[*returnSize-1] = i - plen + 1;
            }
        }
    }
    return result;
}

int main(void)
{
    int returnSize;
    int *result;
    char *s = "baa";
    char *p = "aa";
    int i;

    result = findAnagrams(s, p, &returnSize);
    for (i = 0; i < returnSize; i++)
        printf("%d\n", result[i]);

    return 0;
}
