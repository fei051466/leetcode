public class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        if(needleArray.length == 0){
            return 0;
        }
        int next[] = process(needleArray);
        int pos = 0;
        int index = 0;
        while(index<haystackArray.length){
            if(haystackArray[index] == needleArray[pos]){
                index++;
                pos++;
                if(pos == needleArray.length){
                    return index - pos;
                }
            }
            else if(pos > 0){
                pos = next[pos];
            }
            else{
                index++;
            }
        }
        return -1;
    }

    private int[] process(char[] needle){
        if(needle.length == 1){
            return new int[] {-1};
        }
        int[] next = new int[needle.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while(pos < needle.length){
            if(needle[pos-1] == needle[cn]){
                next[pos++] = ++cn;
            }
            else if(cn > 0){
                cn = next[cn];
            }
            else{
                pos++;
            }
        }
        return next;
    }
}