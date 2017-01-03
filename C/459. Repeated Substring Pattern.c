bool repeatedSubstringPattern(char *str)
{
    /*kmp next array*/
    int len = strlen(str);
    int next[10001] = {0};

    int i = 1;
    next[0] = 0;
    int j = 0;
    while(i < len)
    {
        if(*(str + j) == *(str + i))
        {
            next[i] = j + 1;
            i++;
            j++;
        }
        else if(j != 0)
        {
            j = next[j - 1];
        }
        else
        {
            i++;
        }
    }

    return next[len-1] && len % (len - next[len-1]) == 0;
}
