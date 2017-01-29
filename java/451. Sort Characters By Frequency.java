public class Solution {
    public String frequencySort(String s) {
        /*
            Example:
            input: tree
            return; eert OR eetr
         */
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            Character cur = s.charAt(i);
            if (frequencyMap.containsKey(cur)){
                frequencyMap.put(cur, frequencyMap.get(cur) + 1);
            }
            else{
                frequencyMap.put(cur, 1);
            }
        }
        List<Map.Entry<Character, Integer>> myList = new ArrayList<Map.Entry<Character, Integer>>(frequencyMap.entrySet());
        Collections.sort(myList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> stringIntegerEntry, Map.Entry<Character, Integer> t1) {
                return t1.getValue() - stringIntegerEntry.getValue() ;
            }
        });
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < myList.size(); i++){
            for (int j = 0; j < myList.get(i).getValue(); j++)
            {
                result.append(myList.get(i).getKey());
            }
        }
        return result.toString();
    }
}