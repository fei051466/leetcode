public class Solution {
    public int lengthLongestPath(String input) {
        List<String> names = Arrays.asList(input.split("\n"));
        List<Integer> count = new ArrayList<Integer>();
        count.add(0);
        int maxLength = 0;
        int preLevel = 0;
        for (String name: names) {
            char[] nameArray = name.toCharArray();
            int level = 0;
            boolean isFile = name.indexOf('.') != -1;
            for (int i = 0; i < nameArray.length; i++) {
                if (nameArray[i] == '\t') {
                    level++;
                }
                else
                    break;
            }
            int length = nameArray.length - level;
            if (level <= preLevel) {
                if (level == 0) {
                    count.set(0, length);
                }
                else {
                    count.set(level, count.get(level - 1) + length);
                }
            }
            else {
                if (level == count.size()) {
                    count.add(count.get(level - 1) + length);
                }
                else {
                    count.set(level, count.get(level - 1) + length);
                }
            }
            if (isFile)
                maxLength = Math.max(maxLength, count.get(level) + level);
            preLevel = level;
        }
        return maxLength;
    }
}