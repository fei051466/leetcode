public class Solution {
    public String originalDigits(String s) {
        int[] count = new int[26];
        char[] sArray = s.toCharArray();
        List<Integer> resultList = new ArrayList<Integer>();
        String result = "";
        int minCount;
        int index;

        for (int i = 0; i < sArray.length; i++){
            count[sArray[i] - 'a']++;
        }

        // zero
        minCount = count['z' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(0);
        }
        count['z' - 'a'] -= minCount;
        count['e' - 'a'] -= minCount;
        count['r' - 'a'] -= minCount;
        count['o' - 'a'] -= minCount;

        // two
        minCount = count['w' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(2);
        }
        count['t' - 'a'] -= minCount;
        count['w' - 'a'] -= minCount;
        count['o' - 'a'] -= minCount;

        // four
        minCount = count['u' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(4);
        }
        count['f' - 'a'] -= minCount;
        count['o' - 'a'] -= minCount;
        count['u' - 'a'] -= minCount;
        count['r' - 'a'] -= minCount;

        // five
        minCount = count['f' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(5);
        }
        count['f' - 'a'] -= minCount;
        count['i' - 'a'] -= minCount;
        count['v' - 'a'] -= minCount;
        count['e' - 'a'] -= minCount;

        // six
        minCount = count['x' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(6);
        }
        count['s' - 'a'] -= minCount;
        count['i' - 'a'] -= minCount;
        count['x' - 'a'] -= minCount;

        // seven
        minCount = count['v' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(7);
        }
        count['s' - 'a'] -= minCount;
        count['e' - 'a'] -= minCount;
        count['v' - 'a'] -= minCount;
        count['e' - 'a'] -= minCount;
        count['n' - 'a'] -= minCount;

        // eight
        minCount = count['g' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(8);
        }
        count['e' - 'a'] -= minCount;
        count['i' - 'a'] -= minCount;
        count['g' - 'a'] -= minCount;
        count['h' - 'a'] -= minCount;
        count['t' - 'a'] -= minCount;

        // one
        minCount = count['o' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(1);
        }
        count['o' - 'a'] -= minCount;
        count['n' - 'a'] -= minCount;
        count['e' - 'a'] -= minCount;

        // three
        minCount = count['h' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(3);
        }
        count['t' - 'a'] -= minCount;
        count['h' - 'a'] -= minCount;
        count['r' - 'a'] -= minCount;
        count['e' - 'a'] -= minCount;
        count['e' - 'a'] -= minCount;

        // nine
        minCount = count['i' - 'a'];
        for (index = 0; index < minCount; index++){
            resultList.add(9);
        }
        count['n' - 'a'] -= minCount;
        count['i' - 'a'] -= minCount;
        count['n' - 'a'] -= minCount;
        count['e' - 'a'] -= minCount;

        Collections.sort(resultList);

        for (index = 0; index < resultList.size(); index++){
            result += resultList.get(index).toString();
        }

        return result;
    }
}