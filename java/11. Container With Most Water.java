public class Solution {
    public int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int maxArea = 0;
        while(head < tail){
            int curArea;
            if(height[tail] <= height[head]){
                curArea = height[tail] * (tail - head);
                tail--;
            }
            else{
                curArea = height[head] * (tail - head);
                head++;
            }
            if(curArea > maxArea){
                maxArea = curArea;
            }
        }
        return maxArea;
    }
}