class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preFact = new int[n];
        int[] sufFact = new int[n];
        preFact[0] = 1;
        sufFact[n-1] = 1;
        for(int i=1; i<n; ++i) {
            preFact[i] = preFact[i-1] * nums[i-1];
        }
        for(int i=n-2; i>=0; --i) {
            sufFact[i] = sufFact[i+1] * nums[i+1];
        }
        for(int i=0; i<n; ++i) {
            nums[i] = preFact[i] * sufFact[i];
        }
        return nums;
    }
}  
