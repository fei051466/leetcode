class Solution {
    public String getHint(String secret, String guess) {
        int[] bullsArr = new int[10];
        int[] cowsArrS = new int[10];
        int[] cowsArrG = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int indexS=0; indexS<secret.length(); indexS++){
            if (secret.charAt(indexS) == guess.charAt(indexS)){
                bullsArr[secret.charAt(indexS)-'0']++;
            }
            else{
                cowsArrS[secret.charAt(indexS)-'0']++;
                cowsArrG[guess.charAt(indexS)-'0']++;
            }
        }
        for (int index = 0; index<10; index++){
            bulls += bullsArr[index];
            cows += Math.min(cowsArrS[index], cowsArrG[index]);
        }

        return bulls + "A" + cows + "B";
    }
}