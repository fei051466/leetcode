public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int temp = 0;
        int lasttemp = 0;
        for (int i=0; i<s.length(); i++)
        {
            temp = standard(s.charAt(i));
            res = res + temp;
            if (i != 0)
            {
                lasttemp = standard(s.charAt(i-1));
                if (temp > lasttemp)
                {
                    res = res - 2*lasttemp;
                }
            }
        }
        return res;

    }
    int standard(char c)
    {
        switch (c)
        {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}