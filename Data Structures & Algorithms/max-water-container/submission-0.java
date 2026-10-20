class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, ans = 0;
        while(l<r) {
            int area = r-l;
            if (heights[l] < heights[r]) {
                area *= heights[l];
                l++;
            } else {
                area *= heights[r];
                r--;
            }
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
