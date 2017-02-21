public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> available = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            available.add(i);
        }
        String result = "";

        int all = 1;

        for (int i = 2; i <= n; i++) {
            all *= i;
        }

        int level = n;
        while (all != 1) {
            all /= level;
            level--;
            int index = (k - 1) / all;
            result += String.valueOf(available.get(index));
            available.remove(index);
            k -= all * index;
        }
        result += String.valueOf(available.get(0));
        return result;
    }
}