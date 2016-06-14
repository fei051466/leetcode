public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList temp = new ArrayList();
        for (int index1=0, index2=0; index1<nums1.length && index2<nums2.length;)
        {
            if (nums1[index1]==nums2[index2])
            {
                temp.add(nums1[index1]);
                index1++;
                index2++;
            }
            else if(nums1[index1]<nums2[index2])
                index1++;
            else
                index2++;
                
        }
        int[] res = new int[temp.size()];
        for (int i=0; i<temp.size(); i++)
            res[i] = (int)temp.get(i);
        return res;
    }
}