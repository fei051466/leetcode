#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* licenseKeyFormatting(char* S, int K) {
    int i = 0, j;
    int len = 0;
    int alen = 0;
    for (i = 0; S[i] != '\0'; i++)
    {
        if (S[i] != '-')
            len++;
        alen++;
    }
    if (len == 0) return "";
    int resultLen = len + len / K;
    if (len % K != 0) resultLen++; 
    printf("alen--%d\n", alen);
    printf("len--%d\n", len);
    printf("resultLen--%d\n", resultLen);
    char *result = malloc(sizeof(char) * resultLen);
    i = alen - 1;
    j = resultLen - 2;
    int count = 0;
    while (i >= 0 && j >= 0)
    {
        if (count == K)
        {
            result[j] = '-';
            j--;
            count = 0;
            continue;
        }
        if (S[i] == '-')
        {
            i--;
            continue;
        }
        if (S[i] >= 'a' && S[i] <= 'z')
            result[j] = S[i] - 'a' + 'A';
        else
            result[j] = S[i];
        i--;
        j--;
        count++;
    }
    result[resultLen - 1] = '\0';
    return result;            
}  

int main(void)
{
    printf("%s\n", licenseKeyFormatting("---", 3));
    return 0;
}
