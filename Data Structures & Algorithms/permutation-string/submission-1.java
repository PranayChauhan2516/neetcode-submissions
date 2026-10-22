class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] ref = new int[26];
        for (char c : s1.toCharArray()) {
            ref[c - 'a']++;
        }
        int l = 0, count = s1.length();
        for (int r = 0; r < s2.length(); ++r) {
            char c = s2.charAt(r);
            if (ref[c - 'a'] > 0) {
                count--;
            }
            ref[c - 'a']--;
            if (r >= s1.length()) {
                ref[s2.charAt(l) - 'a']++;
                if (ref[s2.charAt(l) - 'a'] > 0) {
                    count++;
                }
                l++;
            }
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}
