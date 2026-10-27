class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1, ans = 1000;
        while(l<=r) {
            int mid = (l+r) / 2;
            if (nums[mid]<=nums[r]) {
                r = mid - 1;
                ans = Math.min(ans, nums[mid]);
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
