class Solution {
    public String minWindow(String s, String t) {
        int[] ref = new int[126];
        for (char c : t.toCharArray()) {
            ref[c]++;
        }
        int l = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;
        for (int r = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            if (ref[c] > 0) {
                count--;
            }
            ref[c]--;
            while (count == 0) {
                if (minLen > r - l) {
                    minLen = r - l;
                    start = l;
                }
                ref[s.charAt(l)]++;
                if (ref[s.charAt(l)] > 0) {
                    count++;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen + 1);
    }
}
