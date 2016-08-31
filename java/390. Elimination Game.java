public class Solution {
    public int lastRemaining(int n) {
        if(n == 1){
            return 1;
        }
        boolean fromLeft = true;
        int interval = 1;
        int index = 1;
        while(n != 1){
            if(fromLeft){
                n /= 2;
                index += interval;
                interval *= 2;
                fromLeft = false;
            }
            else{
                if(n % 2 != 0){
                    index += interval;
                }
                n /= 2;
                interval *= 2;
                fromLeft = true;
            }
        }
        return index;
    }
}