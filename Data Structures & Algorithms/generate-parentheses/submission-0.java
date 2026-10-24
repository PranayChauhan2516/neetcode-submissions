class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0, n, new StringBuilder(), ans);
        return ans;
    }

    void generate(int open, int closed, int n, StringBuilder s, List<String> ans) {
        if (open == n && closed == open) {
            ans.add(s.toString());
            return;
        }
        if (open < n) {
            s.append('(');
            generate(open + 1, closed, n, s, ans);
            s.deleteCharAt(s.length() - 1);
        }
        if (closed < open) {
            s.append(')');
            generate(open, closed + 1, n, s, ans);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
