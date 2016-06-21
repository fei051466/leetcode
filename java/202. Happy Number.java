class Solution {
    public boolean isHappy(int n) {
        int sum;
        while (true)
        {
            sum = 0;
            while (n != 0)
            {
                sum = sum + (n % 10) * (n % 10);
                n /= 10;
            }
            System.out.println(sum);
            if (sum >= 10)
            {
                n = sum;
            }
            else
                return sum == 1 || sum == 7;
        }
    }
}