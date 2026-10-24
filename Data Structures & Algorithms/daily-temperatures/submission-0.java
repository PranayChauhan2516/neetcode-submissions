class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n; ++i) {
            while(!dq.isEmpty() && temperatures[dq.peekLast()]<temperatures[i]) {
                int oldLowIndex = dq.pollLast();
                res[oldLowIndex] = i - oldLowIndex; 
            }
            dq.addLast(i);
        }
        return res;
    }
}
