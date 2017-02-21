/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class MyClass implements Comparable<MyClass> {
    int val;
    int isEnd;
    int index;

    public MyClass(int val, int isEnd, int index) {
        this.val = val;
        this.isEnd = isEnd;
        this.index = index;
    }

    @Override
    public int compareTo(MyClass mc) {
        if (this.val != mc.val) {
            return this.val - mc.val;
        }
        if (this.isEnd != mc.isEnd) {
            return mc.isEnd - this.isEnd;
        }
        return this.index - mc.index;
    }
}

public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        List<MyClass> mcList = new ArrayList<MyClass>();
        for (int i = 0; i < intervals.length; i++) {
            MyClass mc1 = new MyClass(intervals[i].start , 0, i);
            MyClass mc2 = new MyClass(intervals[i].end, 1, i);
            mcList.add(mc1);
            mcList.add(mc2);
        }
        Collections.sort(mcList);
        int preIndex = -1;
        for (int i = mcList.size() - 1; i >= 0; i--) {
            MyClass curMc = mcList.get(i);
            if (curMc.isEnd == 1) {
                result[curMc.index] = preIndex;
            }
            else {
                preIndex = curMc.index;
            }
        }


        return result;

    }
}