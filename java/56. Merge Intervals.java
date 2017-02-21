/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public class myComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            return result;
        }


        Collections.sort(intervals, new myComparator());

        int start = intervals.get(0).start;
        int pre = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > pre) {
                Interval tmp = new Interval(start, pre);
                result.add(tmp);
                start = intervals.get(i).start;
                pre = intervals.get(i).end;
            }
            else {
                if (intervals.get(i).end > pre) {
                    pre = intervals.get(i).end;
                }
            }
        }
        Interval last = new Interval(start, pre);
        result.add(last);


        return result;
    }
}