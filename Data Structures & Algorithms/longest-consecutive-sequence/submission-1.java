class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for (int e : nums) {
            h.add(e);
        }
        int ans = 0;
        for (int e : h) {
            if (!h.contains(e - 1)) {
                int start = e;
                while (h.contains(start)) {
                    start++;
                }
                ans = Math.max(ans, start - e);
            }
        }
        return ans;
    }
}
