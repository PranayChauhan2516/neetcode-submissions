class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int e : piles) {
            r = Math.max(r, e);
        }
        int ans = r;
        while (l <= r) {
            int k = l + (r - l) / 2;
            long hours = 0;
            for (int e : piles) {
                hours += (e + k - 1L) / k;
            }
            if (hours <= h) {
                ans = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return ans;
    }
}
