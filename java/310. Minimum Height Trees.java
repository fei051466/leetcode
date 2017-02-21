public class Solution {
    private Map<Integer, List<Integer>> edgeMap;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        edgeMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            List<Integer> adjacentList = new ArrayList<Integer>();
            edgeMap.put(i, adjacentList);
        }

        for (int[] edge: edges) {
            int first = edge[0];
            int second = edge[1];
            edgeMap.get(first).add(second);
            edgeMap.get(second).add(first);
        }

        Set<Integer> treeNodeSet = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (edgeMap.get(i).size() <= 1) {
                treeNodeSet.add(i);
            }
        }
        while (treeNodeSet.size() >= 2) {
            if (treeNodeSet.size() == 2) {
                boolean isOK = true;
                for (int treeNode: treeNodeSet) {
                    if (!treeNodeSet.contains(edgeMap.get(treeNode).get(0)))
                        isOK = false;
                }
                if (isOK)
                    break;
            }
            Set<Integer> newTreeNodeSet = new HashSet<Integer>();
            for (int treeNode: treeNodeSet) {
                List<Integer> adjancentNodeList = edgeMap.get(treeNode);
                int adjacentNode = adjancentNodeList.get(0);
                edgeMap.get(adjacentNode).remove(Integer.valueOf(treeNode));
                if (edgeMap.get(adjacentNode).size() == 1)
                    newTreeNodeSet.add(adjacentNode);
            }
            treeNodeSet = newTreeNodeSet;
        }

        List<Integer> res = new ArrayList<Integer>(treeNodeSet);

        return res;
    }
}
