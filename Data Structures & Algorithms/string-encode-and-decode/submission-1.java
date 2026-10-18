class Solution {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            int l = s.length();
            encoded.append(l);
            encoded.append('#');
            encoded.append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<String>();
        int val = -1;
        for (int i = 0; i < str.length();) {
            if (val == -1) {
                val = str.charAt(i++) - '0';
                while (str.charAt(i) != '#') {
                    val = val * 10 + str.charAt(i) - '0';
                    i++;
                }
                i++;
                StringBuilder word = new StringBuilder();
                while (val != 0) {
                    word.append(str.charAt(i));
                    i++;
                    val--;
                }
                val--;
                ans.add(word.toString());
            }
        }
        return ans;
    }
}
