public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        int loop = 0;
        char[] last_array;
        int index;
        char last_character;
        int count;
        while(loop++ < n-1){
            last_array = res.toCharArray();
            last_character = last_array[0];
            index = 1;
            count = 1;
            res = "";
            while(index < last_array.length){
                if(last_array[index] != last_character){
                    res = res + String.valueOf(count) + String.valueOf(last_character);
                    count = 1;
                    last_character = last_array[index];
                }
                else{
                    count += 1;
                }
                index++;
            }
            res = res + String.valueOf(count) + String.valueOf(last_character);
        }

        return res;

    }
}