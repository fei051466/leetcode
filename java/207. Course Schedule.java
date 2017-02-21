public class Solution {
    private int[] note;
    private Map<Integer, List<Integer>> prMap;

    private int dfs(int courseNum, Set selectCourses) {
        if (note[courseNum] == 1)
            return 1;
        if (!prMap.containsKey(courseNum))
            return 1;
        selectCourses.add(courseNum);
        for (int pr: prMap.get(courseNum)) {
            if (selectCourses.contains(pr))
                return -1;
            if (dfs(pr, selectCourses) == -1)
                return -1;
        }
        selectCourses.remove(courseNum);
        note[courseNum] = 1;
        return 1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        prMap = new HashMap<Integer, List<Integer>>();
        note = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            int key = prerequisite[0];
            int val = prerequisite[1];
            if (!prMap.containsKey(key)) {
                List<Integer> prList = new ArrayList<Integer>();
                prList.add(val);
                prMap.put(key, prList);
            }
            else {
                prMap.get(key).add(val);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (note[i] == 0) {
                Set<Integer> selectCourses = new HashSet<Integer>();
                note[i] = dfs(i, selectCourses);
            }
            if (note[i] == -1) {
                return false;
            }
        }
        return true;
    }
}