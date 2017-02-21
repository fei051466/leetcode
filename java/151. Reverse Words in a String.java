public class Solution {
    public String reverseWords(String s) {
        List<String> words = Arrays.asList(s.split(" "));
        StringBuffer sb = new StringBuffer();
        for (int i = words.size() - 1; i >= 0; i--) {
            if (words.get(i).equals(""))
                continue;
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(words.get(i));
        }
        return sb.toString();
    }
}