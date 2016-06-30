public class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int carry = 0;
        int current = 0;
        for (int i=digits.length-1; i>=0; i--){
            current = digits[i] + carry;
            if (i == digits.length-1)
                current += 1;
            if (current == 10){
                temp.add(0);
                carry = 1;
            }
            else{
                temp.add(current);
                carry = 0;
            }
        }
        int size = temp.size();
        if (carry == 1)
            size = temp.size() + 1;
        int[] result = new int[size];
        if (carry == 1){
            result[0] = 1;
        }
        else{
            int j = 0;
            for (int index=size-1; index>=0; index--)
                result[j++] = temp.get(index);
        }
        return result;
    }
}