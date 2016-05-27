public class Solution {
    public String reverseString(String s) {
        int len = s.length();
        char[] ch = new char[len];
        int index = 0;
        for (int i=len-1; i>=0; i--)
        {
            ch[index++] = s.charAt(i);
        }
        return new String(ch);
    }
}
