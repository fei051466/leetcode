public class Solution {
    // Map<String, Boolean> stateMap;
    Map<Integer, Boolean> stateMap;
    boolean[] used;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
            return false;
        if (desiredTotal <= 0)
            return true;
        //stateMap = new HashMap<String, Boolean>();
        stateMap = new HashMap<Integer, Boolean>();
        used = new boolean[maxChoosableInteger + 1];

        return subCanIWin(desiredTotal);
    }

    private boolean subCanIWin(int desiredTotal) {
        if (desiredTotal <= 0)
            return false;
        //String key = Arrays.toString(used);
        Integer key = formatKey(used);
        if (!stateMap.containsKey(key)) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!subCanIWin(desiredTotal- i)) {
                        stateMap.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            stateMap.put(key, false);
        }
        return stateMap.get(key);
    }
    
    private int formatKey(boolean[] used) {
        int key = 0;
        for (boolean b: used) {
            key <<= 1;
            if (b)
                key |= 1;
        }
        return key;
    }
}