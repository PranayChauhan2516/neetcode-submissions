class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for(int e : nums) {
            if(h.contains(e)) {
                return true;
            }
            h.add(e);
        }
        return false;
    }
}