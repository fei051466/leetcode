public class Solution {
    public String addBinary(String a, String b) {
        char[] array_a = a.toCharArray();
        char[] array_b = b.toCharArray();
        int index_a = array_a.length - 1;
        int index_b = array_b.length - 1;
        int plus = 0;
        int temp;
        char[] exchange;
        int index_exchange;
        if(index_a < index_b){
            exchange = array_a;
            array_a = array_b;
            array_b = exchange;
            index_exchange = index_a;
            index_a = index_b;
            index_b = index_exchange;
        }
        while(index_b >= 0){
            temp = array_a[index_a] - '0' + array_b[index_b] - '0' + plus;
            if(temp > 1){
                temp = temp % 2;
                plus = 1;
            }
            else{
                plus = 0;
            }
            array_a[index_a] = (char)(temp + '0');
            index_a--;
            index_b--;
        }
        while(index_a >= 0){
            temp = array_a[index_a] - '0' + plus;
            if(temp > 1){
                temp = temp % 2;
                plus = 1;
            }
            else{
                plus = 0;
            }
            array_a[index_a] = (char)(temp + '0');
            index_a--;
            index_b--;
        }
        if(plus == 1){
            return "1" + String.valueOf(array_a);
        }
        else{
            return String.valueOf(array_a);
        }
    }
}