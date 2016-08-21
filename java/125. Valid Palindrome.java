public class Solution {
    public boolean isPalindrome(String s) {
        char[] str_array = s.toCharArray();
        if(str_array.length == 0)
            return true;
        int head = 0;
        int tail = str_array.length - 1;
        while(head < tail){
            if(!Character.isLetterOrDigit(str_array[head])){
                head++;
                continue;
            }
            if(!Character.isLetterOrDigit(str_array[tail])){
                tail--;
                continue;
            }
            if(('0'<=str_array[head] && str_array[head]<='9') ^ ('0'<=str_array[tail] && str_array[tail]<='9'))
                return false;
            int temp = Math.abs(str_array[head]-str_array[tail]);
            if(temp == 0 || temp == 'a' - 'A'){
                head++;
                tail--;
                continue;
            }
            return false;
        }
        return true;

    }
}