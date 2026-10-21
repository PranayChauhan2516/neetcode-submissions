class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, ans = 0;
        HashMap<Character, Integer> window = new HashMap<>(); // Changed to HashMap
        while(r < s.length()) {
            char c = s.charAt(r);
            if (!window.containsKey(c) || window.get(c) < l) {
                window.put(c, r);
                ans = Math.max(ans, r - l + 1);
                r++;
            } else {
                l = window.get(c) + 1;
            }
        }
        return ans;
    }
}
