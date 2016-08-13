public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(index1<m && index2<n){
            if(nums1[index1] < nums2[index2]){
                res.add(nums1[index1]);
                index1++;
            }
            else{
                res.add(nums2[index2]);
                index2++;
            }
        }
        if(index1 == m){
            while(index2 < n){
                res.add(nums2[index2]);
                index2++;
            }
        }
        else{
            while(index1 < m){
                res.add(nums1[index1]);
                index1++;
            }
        }
        for(int index=0; index<res.size(); index++){
            nums1[index] = res.get(index);
        }

    }
}