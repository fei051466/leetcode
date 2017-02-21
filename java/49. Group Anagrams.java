public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<String, List<String>>();
        for (String str: strs) {
            String key = format(str);
            if (resMap.containsKey(key)) {
                resMap.get(key).add(str);
            }
            else {
                List<String> tmp = new ArrayList<String>();
                tmp.add(str);
                resMap.put(key, tmp);
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> list: resMap.values()) {
            res.add(list);
        }
        return res;
    }
    
    private String format(String str) {
        char[] strArray = str.toCharArray();
        int[] counts = new int[26];
        for (char c: strArray) {
            counts[c - 'a']++; 
        }
        StringBuffer sb = new StringBuffer();
        for (int count: counts) {
            sb.append(count);
        }
        return sb.toString();
    }
}