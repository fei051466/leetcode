public class Solution {
    public String intToRoman(int num) {
        String res = new String();
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decades = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II",  "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        int thousand = num / 1000;
        int hundred = (num % 1000) / 100;
        int decade = (num % 100) / 10;
        int unit = num % 10;
        return thousands[thousand] + hundreds[hundred] + decades[decade] + units[unit];

    }
}