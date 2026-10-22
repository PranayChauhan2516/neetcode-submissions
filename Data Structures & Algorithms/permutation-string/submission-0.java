class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] ref = new int[26];
        for (char c : s1.toCharArray()) {
            ref[c - 'a']++;
        }
        int l = 0;
        for (int r = 0; r < s2.length(); ++r) {
            char c = s2.charAt(r);
            if (r < s1.length()) {
                ref[c - 'a']--;
            } else {
                if (isZero(ref)) {
                    return true;
                }
                ref[c - 'a']--;
                ref[s2.charAt(l) - 'a']++;
                l++;
            }
        }
        return isZero(ref);
    }

    boolean isZero(int[] ref) {
        for (int i = 0; i < ref.length; ++i) {
            if (ref[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
