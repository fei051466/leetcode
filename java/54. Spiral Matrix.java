public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return result;
        }
        int i = 0, j = 0;
        // mode: 0 - right  1 - down  2 - left  3 - up
        int mode = 0;

        int upMost = 1, rightMost = matrix[0].length - 1, downMost = matrix.length - 1, leftMost = 0;
        int totalCount = matrix.length * matrix[0].length;
        while (result.size() != totalCount) {
            // System.out.println(i + " " + j);
            result.add(matrix[i][j]);
            if (mode == 0) {
                if (j < rightMost)
                    j++;
                else {
                    rightMost--;
                    i++;
                    mode = 1;
                }
            }
            else if (mode == 1) {
                if (i < downMost)
                    i++;
                else {
                    downMost--;
                    j--;
                    mode = 2;
                }
            }
            else if (mode == 2) {
                if (j > leftMost)
                    j--;
                else {
                    leftMost++;
                    i--;
                    mode = 3;
                }
            }
            else if (mode == 3) {
                if (i > upMost)
                    i--;
                else {
                    upMost++;
                    j++;
                    mode = 0;
                }
            }
        }

        return result;
    }
}