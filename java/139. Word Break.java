public class Solution {
    private Map<Character, List<String>> wordMap;
    private int[] note;

    public boolean wordBreak(String s, List<String> wordDict) {
        wordMap = new HashMap<Character, List<String>>();
        note = new int[s.length()];
        for (String word: wordDict) {
            char start = word.charAt(0);
            if (!wordMap.containsKey(start)) {
                List<String> wordList = new ArrayList<String>();
                wordList.add(word);
                wordMap.put(start, wordList);
            }
            else {
                wordMap.get(start).add(word);
            }
        }
        return dfs(s, 0) == 1;

        // return note[0] == 1;
    }

    private int dfs(String s, int index) {
        if (index == s.length())
            return 1;
        if (note[index] != 0) {
            return note[index];
        }
        char start = s.charAt(index);
        if (!wordMap.containsKey(start)) {
            note[index] = -1;
            return -1;
        }
        List<String> wordList = wordMap.get(start);
        for (String word: wordList) {
            int wordLength = word.length();
            if (index + wordLength > s.length())
                continue;
            if (!word.equals(s.substring(index, index + wordLength)))
                continue;
            note[index] = dfs(s, index + wordLength);
            if (note[index] == 1)
                return 1;
        }
        return -1;
    }
}