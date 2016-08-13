public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] str_array = str.split(" ");
        char[] pattern_array = pattern.toCharArray();
        if(str_array.length != pattern_array.length)
            return false;
        HashMap<String, String> pt_st_map = new HashMap<String, String>();
        HashSet<String> history = new HashSet<String>();
        for(int index=0; index<pattern_array.length; index++){
            if(pt_st_map.containsKey(String.valueOf(pattern_array[index]))) {
                if (!pt_st_map.get(String.valueOf(pattern_array[index])).equals(str_array[index])) {
                    return false;
                }
            }
            else{
                if(history.contains(str_array[index]))
                    return false;
                pt_st_map.put(String.valueOf(pattern_array[index]), str_array[index]);
                history.add(str_array[index]);
                }
            }
        return true;

    }
}