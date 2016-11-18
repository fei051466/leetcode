public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String>  res = new ArrayList<String>();
        for (int i=0; i<=num && i<=4; i++) {
            List<String> hourList = new ArrayList<String>();
            for (int counter=0; counter<=11; counter++) {
                if(countBit(counter) == i) {
                    hourList.add(String.valueOf(counter) + ":");
                }
            }
            List<String> tempResList = new ArrayList<String>();
            for (int counter=0; counter<=59; counter++) {
                if(countBit(counter) == num-i) {
                    for (String hour: hourList) {
                        String min = String.valueOf(counter);
                        if (min.length() < 2) min = "0" + min;
                        tempResList.add(hour + min);
                    }
                }
            }
            for (String tempRes: tempResList) {
                res.add(tempRes);
            }
        }
        return res;
    }

    private int countBit(int counter) {
        int res = 0;
        while(counter != 0) {
            counter = counter & (counter - 1);
            res++;
        }
        return res;
    }
}