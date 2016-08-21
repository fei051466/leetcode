public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        HashSet<Integer> mySet = new HashSet<Integer>();
        for(int index=0; index<nums.length; index++){
            if(!mySet.contains(nums[index])){
                mySet.add(nums[index]);
            }
            else{
                mySet.remove(nums[index]);
            }
        }
        Iterator<Integer> i = mySet.iterator();
        int index = 0;
        while(i.hasNext()){
            res[index++] = i.next();
        }
        return res;

    }
}