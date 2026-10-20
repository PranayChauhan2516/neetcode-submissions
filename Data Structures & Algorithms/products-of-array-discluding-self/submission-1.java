class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] sufFact = new int[n];
        int preFact = nums[0];
        sufFact[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            sufFact[i] = sufFact[i + 1] * nums[i + 1];
        }
        nums[0] = sufFact[0];
        for (int i = 1; i < n; ++i) {
            int result = preFact * sufFact[i];
            preFact = preFact * nums[i];
            nums[i] = result;
        }
        return nums;
    }
}
