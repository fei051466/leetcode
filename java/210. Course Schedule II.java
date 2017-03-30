public class Solution {
    private int usedCount;
    private boolean notValid;
    private int[] result;
    private Set<Integer> used;

    private void study(int i, Map<Integer, List<Integer>> prMap, Set<Integer> after) {
        if (notValid)
            return;
        if (used.contains(i))
            return;
        used.add(i);
        after.add(i);
        if (prMap.containsKey(i)) {
            List<Integer> preList = prMap.get(i);
            for (Integer pre: preList) {
                if (after.contains(pre)) {
                    notValid = true;
                    break;
                }
                study(pre, prMap, after);
            }
        }
        after.remove(i);
        result[usedCount++] = i;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prMap = new HashMap<Integer, List<Integer>>();
        used = new HashSet<Integer>();
        usedCount = 0;
        result = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
             int course = prerequisites[i][0];
             int pre = prerequisites[i][1];
             if (prMap.containsKey(course)) {
                 prMap.get(course).add(pre);
             }
             else {
                 List<Integer> preList = new ArrayList<Integer>();
                 preList.add(pre);
                 prMap.put(course, preList);
             }
        }

        for (int i = 0; i < numCourses; i++) {
            if (used.contains(i))
                continue;
            Set<Integer> after = new HashSet<Integer>();
            study(i, prMap, after);
        }

        if (notValid)
            result = new int[0];

        return result;
    }
}