public class Solution {
    public int firstUniqChar(String s) {
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        char[] charArray = s.toCharArray();
        for (char c: charArray) {
            if (counter.containsKey(String.valueOf(c))) {
                counter.put(String.valueOf(c), counter.get(String.valueOf(c)) + 1);
            }
            else {
                counter.put(String.valueOf(c), 1);
            }
        }
        for (int i=0; i<charArray.length; i++) {
            if (counter.get(String.valueOf(charArray[i])) == 1)
                return i;
        }
        return -1;
    }
}