public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int i, j;
        int result = 0;

        for (i = 0; i < points.length; i++){
            HashMap<Integer, Integer> disMap = new HashMap<Integer, Integer>();
            for (j = 0; j < points.length; j++){
                if (i == j) continue;
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int dis = x * x + y * y;
                if (disMap.containsKey(dis))
                    disMap.put(dis, disMap.get(dis) + 1);
                else
                    disMap.put(dis, 1);
            }
            for (Integer dis: disMap.values())
                result += dis * (dis - 1);
        }

        return result;
    }
}