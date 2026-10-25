class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i <= n; ++i) {
            while (!dq.isEmpty() && (i == n || heights[i] <= heights[dq.peekLast()])) {
                int last = dq.pollLast();
                int area = heights[last] * (dq.isEmpty() ? i : i - dq.peekLast() - 1);
                ans = Math.max(ans, area);
            }
            dq.addLast(i);
        }
        return ans;
    }
}
