class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, maxFreq = 0, ans = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        for (int r = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            h.put(c, h.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, h.get(c));
            if (r - l - maxFreq + 1 > k) {
                h.put(s.charAt(l), h.get(s.charAt(l)) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
