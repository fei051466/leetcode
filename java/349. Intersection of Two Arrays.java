 public class Solution {
     public int[] intersection(int[] nums1, int[] nums2) {
         HashSet<Integer> num = new HashSet<Integer>();
         for (int i=0; i<nums1.length; i++) {
             num.add(nums1[i]);
         }
         List<Integer> resultlist = new ArrayList<Integer>();
         for (int i=0; i<nums2.length; i++) {
             if (num.contains(nums2[i])) {
                 resultlist.add(nums2[i]);
                 num.remove(nums2[i]);
             }
         }
         int[] result = new int[resultlist.size()];
         for (int i = 0; i < resultlist.size(); i++) {
             result[i] = resultlist.get(i);
         }
         return result;
     }
 }