class Solution {
    public String reverseVowels(String s) {
        int head = 0;
        int tail = s.length()-1;
        char[] ch = s.toCharArray();
        char temp;
        while (head < tail)
        {
            if (isVowel(ch[head]) && isVowel(ch[tail]))
            {
                temp = ch[head];
                ch[head] = ch[tail];
                ch[tail] = temp;
                head++;
                tail--;
            }
            else if (!isVowel(ch[head]) && isVowel(ch[tail]))
                head++;
            else if (isVowel(ch[head]) && !isVowel(ch[tail]))
                tail--;
            else
            {
                head++;
                tail--;
            }
        }
        return String.valueOf(ch);
    }

    private boolean isVowel(char c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U');
    }
}