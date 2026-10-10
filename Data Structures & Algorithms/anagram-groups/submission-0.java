class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> h = new HashMap<>();
        for (String s : strs) {
            int[] cnt = new int[26];
            for (char e : s.toCharArray()) {
                cnt[e - 'a']++;
            }
            String key = Arrays.toString(cnt);
            h.putIfAbsent(key, new ArrayList<String>());
            h.get(key).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(h.values());
        return ans;
    }
}
