public class Solution {
    public int lengthOfLastWord(String s) {
        String[] str_array = s.split(" ");
        int length = str_array.length;
        if(length == 0)
            return 0;
        return str_array[length-1].length();
    }
}