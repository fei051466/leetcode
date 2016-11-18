public class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while(left <= right){
            long mid = (right - left) / 2 + left;
            long cur = mid * mid;
            if(cur == num){
                return true;
            }
            else if(cur < num){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
}