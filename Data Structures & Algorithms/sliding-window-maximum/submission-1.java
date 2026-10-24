class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        for (int r = 0; r < nums.length; ++r) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[r])
                dq.pollLast();
            dq.addLast(r);
            if (dq.peekFirst() <= r - k)
                dq.pollFirst();
            if (r >= k - 1)
                ans[r - k + 1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
