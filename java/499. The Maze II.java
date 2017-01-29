public class Solution {
    private int min = Integer.MAX_VALUE;

    private String result = "";

    private void newWay(String path, int dis) {
        if (result.equals("")) {
            result = path;
            min = dis;
        }
        else if (dis < min) {
            result = path;
            min = dis;
        }
        else if (dis == min && result.compareTo(path) > 0) {
            result = path;
            min = dis;
        }
    }

    private boolean judgeOnHole(int[] hole, int[] newBall) {
        return hole[0] == newBall[0] && hole[1] == newBall[1];
    }

    private void dfs(int[][] maze, int[] ball, int[] hole, String path, int dis, int[][] beenTo) {
        if (beenTo[ball[0]][ball[1]] == 1)
            return;
        if (dis >= min)
            return;

        beenTo[ball[0]][ball[1]] = 1;
        int[] newBall = new int[2];
        int curDis;
        char lastDir;
        if (path.length() == 0)
            lastDir = 's';
        else
            lastDir = path.charAt(path.length() - 1);

        if (lastDir == 'd' || lastDir == 'u' || lastDir == 's') {
            // left
            newBall[0] = ball[0];
            newBall[1] = ball[1];
            curDis = 0;
            while (newBall[1] != 0 && maze[newBall[0]][newBall[1] - 1] != 1) {
                newBall[1]--;
                curDis++;
                if (judgeOnHole(hole, newBall)) {
                    newWay(path+"l", dis+curDis);
                }
            }
            dfs(maze, newBall, hole, path+"l", dis+curDis, beenTo);

            // right
            newBall[0] = ball[0];
            newBall[1] = ball[1];
            curDis = 0;
            while (newBall[1] != maze[0].length - 1 && maze[newBall[0]][newBall[1] + 1] != 1) {
                newBall[1]++;
                curDis++;
                if (judgeOnHole(hole, newBall)) {
                    newWay(path+"r", dis+curDis);
                }
            }
            dfs(maze, newBall, hole, path+"r", dis+curDis, beenTo);
        }

        if (lastDir == 'l' || lastDir == 'r' || lastDir == 's') {

            // up
            newBall[0] = ball[0];
            newBall[1] = ball[1];
            curDis = 0;
            while (newBall[0] != 0 && maze[newBall[0] - 1][newBall[1]] != 1) {
                newBall[0]--;
                curDis++;
                if (judgeOnHole(hole, newBall)) {
                    newWay(path+"u", dis+curDis);
                }
            }
            dfs(maze, newBall, hole, path+"u", dis+curDis, beenTo);

            // down
            newBall[0] = ball[0];
            newBall[1] = ball[1];
            curDis = 0;
            while (newBall[0] != maze.length - 1 && maze[newBall[0] + 1][newBall[1]] != 1) {
                newBall[0]++;
                curDis++;
                if (judgeOnHole(hole, newBall)) {
                    newWay(path+"d", dis+curDis);
                }
            }
            dfs(maze, newBall, hole, path+"d", dis+curDis, beenTo);
        }

        beenTo[ball[0]][ball[1]] = 0;
        return;
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] beenTo = new int[maze.length][maze[0].length];
        String path = "";
        dfs(maze, ball, hole, path, 0, beenTo);
        return result.equals("") ? "impossible": result;
    }
}