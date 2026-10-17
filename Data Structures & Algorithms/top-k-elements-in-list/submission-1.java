class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int e : nums) {
            count.put(e, count.getOrDefault(e, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> e: count.entrySet()) {
            int value = e.getValue();
            if(buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(e.getKey());
        }

        int[] ans = new int[k];
        int index = 0;
        for(int i=buckets.length-1; i>0 && index<k; --i) {
            if(buckets[i]==null) continue;
            for(int e: buckets[i]) {
                ans[index++] = e;
                if(index == k) break;
            }
        }

        return ans;
    }
}
