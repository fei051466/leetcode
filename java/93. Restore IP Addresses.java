public class Solution {
    private void dfs(List<String> result, StringBuffer cur, char[] sArray, int startIndex, int place) {
        if (place == 5) {
            if (startIndex == sArray.length) {
                String tmp = cur.toString();
                tmp = tmp.substring(0, tmp.length() - 1);
                result.add(tmp);
            }
            return;
        }
        if (startIndex == sArray.length)
            return;
        int remainCount = sArray.length - startIndex;
        if (4 - place > remainCount || remainCount > 3 * remainCount)
            return;
        int curSize = cur.length();
        int val = 0;
        for (int i = startIndex; i < startIndex + 3 && i < sArray.length; i++) {
            if (val == 0 && i != startIndex)
                break;
            val = val * 10 + sArray[i] - '0';
            if (val > 255)
                break;
            cur.append(sArray[i]);
            cur.append('.');
            dfs(result, cur, sArray, i + 1, place + 1);
            cur.delete(cur.length() - 1, cur.length());
        }
        cur.delete(curSize, cur.length());


    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        char[] sArray = s.toCharArray();

        dfs(result, sb, sArray, 0, 1);

        return result;
    }
}