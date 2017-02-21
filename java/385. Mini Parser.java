/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    private NestedInteger parse(char[] chars, int left, int right) {
        NestedInteger result;
        if (chars[left] == '[' && chars[right] == ']') {
            result = new NestedInteger();
            int pre = left;
            left = left + 1;
            right = right - 1;
            int bracketCount = 0;
            NestedInteger cur;
            while (left <= right) {
                if (chars[left] == ',' && bracketCount == 0) {
                    cur = parse(chars, pre + 1, left - 1);
                    result.add(cur);
                    pre = left;
                }
                else if (chars[left] == '[') 
                    bracketCount++;
                else if (chars[left] == ']')
                    bracketCount--;
                left++; 
            }
            if (pre + 1 <= left - 1) {
                cur = parse(chars, pre + 1, left - 1);
                result.add(cur);
            }
        }
        else {
            int num = 0;
            boolean negative = false;
            if (chars[left] == '-') {
                left++;
                negative = true;
            }
            for (int i = left; i <= right; i++) {
                num = num * 10 + chars[i] - '0';
            }
            if (negative)
                num = -num;
            result = new NestedInteger(num);
        }
        return result;
    }
    public NestedInteger deserialize(String s) {
        char[] sArray = s.toCharArray();
        return parse(sArray, 0, sArray.length - 1);
    }
}