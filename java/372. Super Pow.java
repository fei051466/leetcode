public class Solution {
    private boolean moreThanZero(int[] num) {
        for (int i = num.length - 1; i >= 0; i--)
            if (num[i] > 0)
                return true;
        return false;
    }

    private void div(int[] num) {
        int last = 0;
        for (int i = 0; i < num.length; i++) {
            int cur = last * 10 + num[i];
            num[i] = cur / 2;
            last = cur % 2;
        }
    }

    public int superPow(int a, int[] b) {
        if (!moreThanZero(b))
            return 1;

        a = a % 1337;
        boolean isEven = b[b.length - 1] % 2 == 0;

        div(b);

        int result = superPow(a, b);
        result = result % 1337;
        
        result = result * result;
        result = result % 1337;
        
        if (!isEven) {
            result = result * a;
            result = result % 1337;
        }
        
        return result;
    }
}