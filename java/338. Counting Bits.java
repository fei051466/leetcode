public class Solution {
    public int[] countBits(int num) {
        if(num == 0){
            int res[] = {0};
            return res;
        }
        if(num == 1){
            int res[] = {0, 1};
            return res;
        }
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        int index = 2;
        int last = 2;
        while(index < res.length){
            for(int i = 0; i < last; i++) {
                res[index++] = 1 + res[i];
                if(index == res.length)
                    break;
            }
            last = index;
        }
        return res;
    }
}