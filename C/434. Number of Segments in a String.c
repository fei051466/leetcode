int countSegments(char* s) {
    int count = 0;
    int prechar = 0;
    while(*s != '\0')
    {
        if(*s != ' ')
        {
            if(!prechar)
            {
                count++;
                prechar = 1;
            }
        }
        else
        {
            prechar = 0;
        }
        s++;
    }
    return count;
}