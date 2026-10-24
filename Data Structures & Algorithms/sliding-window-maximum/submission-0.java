class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int l = 0, n = nums.length;
        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, Integer.MIN_VALUE);
        for (int r = 0; r < n; ++r) {
            pq.add(nums[r]);
            if (r >= k) {
                pq.remove(nums[l]);
                l++;
            }
            ans[l] = Math.max(ans[l], pq.peek());
        }
        return ans;
    }
}
