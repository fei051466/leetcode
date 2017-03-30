public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int row = matrix.size();
        int col = row == 0 ? 0 : matrix.get(0).size();
        int count = 0;
        int[][] resultArray = new int[row + 2][col + 2];
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[0].length; j++) {
                if (i == 0 || i == resultArray.length - 1 || j == 0 || j == resultArray[0].length - 1) {
                    resultArray[i][j] = resultArray.length + resultArray[0].length;
                }
                else {
                    if (matrix.get(i - 1).get(j - 1) == 0) {
                        resultArray[i][j] = 0;
                        count++;
                    }
                    else
                        resultArray[i][j] = -1;
                }
            }
        }
        int dis = 1;
        while (count < row * col) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (resultArray[i + 1][j + 1] != -1)
                        continue;
                    int left = resultArray[i + 1][j];
                    int right = resultArray[i + 1][j + 2];
                    int up = resultArray[i][j + 1];
                    int down = resultArray[i + 2][j + 1];
                    if (right == dis - 1 || down == dis - 1 || left == dis - 1 || up == dis - 1) {
                        resultArray[i + 1][j + 1] = dis;
                        count++;
                    }
                }
            }
            dis++;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i < resultArray.length - 1; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 1; j < resultArray[0].length - 1; j++) {
                list.add(resultArray[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}