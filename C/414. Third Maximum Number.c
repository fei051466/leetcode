int thirdMax(int *nums, int numSize)
{
    int i;
    int pool[3] = {INT_MIN};
    int cmpIndex;
    int moveIndex;
    int count = 0;
    int flag = 0;
    for(int i=0; i<numSize; i++)
    {
        cmpIndex = 0; 
        while(pool[cmpIndex] > nums[i] && cmpIndex < 3) cmpIndex++;
        if(cmpIndex == 3)
            continue;
        else if (pool[cmpIndex] == nums[i]) 
        {
            if(nums[i] == INT_MIN) flag = 1;
            continue;
        }
        moveIndex = 2;
        while(moveIndex > cmpIndex)
        {
            pool[moveIndex] = pool[moveIndex-1];
            moveIndex--;
        }
        pool[cmpIndex] = nums[i];
        count++;
    }

    if(count + flag >= 3)
        return pool[2];
    else
        return pool[0];
}
