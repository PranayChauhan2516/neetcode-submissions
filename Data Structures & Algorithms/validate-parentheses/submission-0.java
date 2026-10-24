class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char e : s.toCharArray()) {
            if (e == '(' || e == '{' || e == '[') {
                st.add(e);
            } else {
                if (!st.isEmpty() && matches(st.peek(), e)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    boolean matches(char a, char b) {
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }
}
