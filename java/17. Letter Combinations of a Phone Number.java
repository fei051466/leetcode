import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return res;
        char[] digitsArray = digits.toCharArray();
        String[][] letters = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w","x","y","z"}};
        String  cur = "";
        genResult(res, cur, letters, digitsArray, 0);
        return res;

    }

    private void genResult(List<String> res, String cur, String[][] letters, char[] digitsArray, int index){
        if(index == digitsArray.length)
            res.add(cur);
        else{
            for(String candidateLetter: letters[digitsArray[index] - '0']){
                cur += candidateLetter;
                genResult(res, cur, letters, digitsArray, index+1);
                cur = cur.substring(0, cur.length()-1);
            }
        }
    }
}
