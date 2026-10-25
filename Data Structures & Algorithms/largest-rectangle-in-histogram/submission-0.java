class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevSmall = new int[n];
        Arrays.fill(prevSmall, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n; ++i) {
            while(!dq.isEmpty() && heights[i]<=heights[dq.peekLast()]) {
                dq.pollLast();
            }
            if (!dq.isEmpty()) prevSmall[i] = dq.peekLast();
            dq.addLast(i);
        }
        int[] nextSmall = new int[n];
        Arrays.fill(nextSmall, -1);
        dq.clear();
        for(int i=n-1; i>=0; --i) {
            while(!dq.isEmpty() && heights[i]<=heights[dq.peekLast()]) {
                dq.pollLast();
            }
            if (!dq.isEmpty()) nextSmall[i] = dq.peekLast();
            dq.addLast(i);
        }
        int ans = 0;
        for(int i=0; i<n; ++i) {
            int area = heights[i];
            int prevLen = prevSmall[i]==-1 ? i+1 : i - prevSmall[i];
            int nextLen = nextSmall[i]==-1 ? n - i : nextSmall[i] - i;
            area *= (prevLen + nextLen-1);
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
