public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] aPart = a.split("\\+");
        String[] bPart = b.split("\\+");
        int aFirst = Integer.valueOf(aPart[0]);
        int aSecond = Integer.valueOf(aPart[1].substring(0, aPart[1].length() - 1));
        int bFirst = Integer.valueOf(bPart[0]);
        int bSecond = Integer.valueOf(bPart[1].substring(0, bPart[1].length() - 1));
        int resultFirst = aFirst * bFirst - aSecond * bSecond;
        int resultSecond = aFirst * bSecond + aSecond * bFirst;
        StringBuffer sb = new StringBuffer();
        sb.append(resultFirst);
        sb.append('+');
        sb.append(resultSecond);
        sb.append('i');
        return sb.toString();
        
    }
}