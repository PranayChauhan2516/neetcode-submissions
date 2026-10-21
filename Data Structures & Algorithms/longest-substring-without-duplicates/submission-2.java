class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, ans = 0;
        HashSet<Character> window = new HashSet<>();
        while (r < s.length()) {
            if (!window.contains(s.charAt(r))) {
                window.add(s.charAt(r));
                ans = Math.max(ans, window.size());
                r++;
            } else {
                window.remove(s.charAt(l));
                l++;
            }
        }
        return ans;
    }
}
