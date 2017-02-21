class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p){
        return this.y == p.y? this.x - p.x: this.y - p.y;
    }
}

public class Solution {
    public int findMinArrowShots(int[][] points) {
        int index;
        int result = 0;

        List<Point> pointList = new ArrayList<Point>();
        for (index = 0; index < points.length; index++){
            pointList.add(new Point(points[index][0], points[index][1]));
        }
        Collections.sort(pointList);

        index = 0;
        while (index < pointList.size()){
            Point p = pointList.get(index);
            System.out.println(p.y);
            index++;
            while (index < pointList.size() && pointList.get(index).x <= p.y) index++;
            System.out.println(index);
            result++;
        }

        return result;
    }
}