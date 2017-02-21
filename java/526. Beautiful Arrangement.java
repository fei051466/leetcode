public class Solution {
    private int result;

    private void dfs(int N, Set used, int index) {
        if (index == N + 1) {
            result++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (used.contains(i))
                continue;
            if (i % index == 0 || index % i == 0) {
                used.add(i);
                dfs(N, used, index + 1);
                used.remove(i);
            }
        }
    }

    public int countArrangement(int N) {
        result = 0;
        Set<Integer> used = new HashSet<Integer>();
        dfs(N, used, 1);
        return result;
    }
}