class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        TreeMap<Integer, Set<Integer>> valueSet = new TreeMap<>();
        for (int e : nums) {
            count.put(e, count.getOrDefault(e, 0) + 1);
            int value = count.get(e);
            valueSet.putIfAbsent(value, new HashSet<>());
            valueSet.get(value).add(e);
            if (value > 1) {
                valueSet.get(value - 1).remove(e);
            }
        }
        int[] ans = new int[k--];
        for (int value : valueSet.descendingKeySet()) {
            for (int key : valueSet.get(value)) {
                if (k == -1)
                    return ans;
                ans[k--] = key;
            }
        }
        return ans;
    }
}
