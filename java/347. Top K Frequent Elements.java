public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> my_map = new HashMap<Integer, Integer>(nums.length);
        List<Integer> res = new ArrayList<Integer>();
        List<Integer>[] bucket = new List[nums.length+1];


        for(int i=0; i<nums.length; i++){
            if(my_map.containsKey(nums[i])){
                my_map.put(nums[i], my_map.get(nums[i])+1);
            }
            else{
                my_map.put(nums[i], 1);
            }
        }
        for(int key:my_map.keySet()){
            int count = my_map.get(key);
            if(bucket[count] == null){
                bucket[count] = new ArrayList<Integer>();
            }
            bucket[count].add(key);
        }
        for(int i=bucket.length-1; i>=0; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
            if(res.size() == k){
                break;
            }
        }
        return res;

    }
}