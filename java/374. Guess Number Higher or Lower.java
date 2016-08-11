public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int high = n;
        int low = 1;
        int half = 0;
        int current_result = 0;
        while(low <= high){
            half = (high - low) / 2 + low;
            current_result =  guess(half);
            if (current_result == 0)
                break;
            else if(current_result == 1){
                low = half+1;
            }
            else
                high = half-1;
        }
        return half;
    }
}