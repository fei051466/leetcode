public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n > 0){
            int temp = (n - 1)% 26;
            res = String.valueOf((char) (temp + 'A')) + res;
            n = (n - 1) / 26;
        }
        return res;
    }
}