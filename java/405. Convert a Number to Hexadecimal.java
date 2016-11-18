public class Solution {
    public String toHex(int num) {
        String[] map = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        String res = "";
        boolean isNagetive = num < 0;
        if (num == 0)
            res = "0";
        else {
            long temp;
            if (isNagetive)
                temp = (long)0 - num;
            else
                temp = num;
            while (temp != 0) {
                int mapIndex = (int)temp % 16;
                if (isNagetive)  mapIndex ^= 15;
                res = map[mapIndex] + res;
                temp = temp / 16;
            }
        }
        if (isNagetive) {
            char[] resCharArray = res.toCharArray();
            int index = resCharArray.length - 1;
            if (resCharArray[index] == '9')
                resCharArray[index] = 'a';
            else
                resCharArray[index] += 1;
            while (resCharArray[index] == 'g') {
                resCharArray[index] = '0';
                resCharArray[index-1] += 1;
                index--;
            }
            res = String.valueOf(resCharArray);
            while (res.length() != 8) res = "f" + res;
        }
        return res;
    }
}