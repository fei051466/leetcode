public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        int all = (C-A)*(D-B) + (G-E)*(H-F);
        if (C<=E || G<=A || B>=H || F>=D)
            return all;
        else{
            left = Math.max(A, E);
            right = Math.min(C, G);
            top = Math.min(D, H);
            bottom = Math.max(B, F);
            return all - (right-left) * (top-bottom);
        }
    }
}