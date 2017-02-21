public class Solution {
    public class myComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer s1, Integer s2) {
            /*
            char[] s1Array = String.valueOf(s1).toCharArray();
            char[] s2Array = String.valueOf(s2).toCharArray();
            int i = 0;
            int j = 0;
            boolean isS1Finish = false;
            boolean isS2Finish = false;
            while (!(isS1Finish && isS2Finish)) {
                if (s1Array[i] != s2Array[j]) {
                    return s2Array[j] - s1Array[i];
                }
                i++;
                if (i == s1Array.length) {
                    i = 0;
                    isS1Finish = true;
                }
                j++;
                if (j == s2Array.length) {
                    j = 0;
                    isS2Finish = true;
                }
            }
            return 0;
            */
            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            sb1.append(s1);
            sb1.append(s2);
            sb2.append(s2);
            sb2.append(s1);
            return sb2.toString().compareTo(sb1.toString());
        }
    }

    public String largestNumber(int[] nums) {
        StringBuffer sb = new StringBuffer();
        List<Integer> numsArray = new ArrayList<Integer>();
        for (int val: nums) {
            numsArray.add(val);
        }
        Collections.sort(numsArray, new myComparator());
        for (int val: numsArray) {
            sb.append(val);
        }
        if (sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}