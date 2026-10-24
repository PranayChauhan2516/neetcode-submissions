class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens) {
            if (isOperator(token)) {
                int right = st.pop();
                int left = st.pop();
                int ans = 0;
                switch(token) {
                    case "+":
                        ans = left + right;
                        break;
                    case "-":
                        ans = left - right;
                        break;
                    case "*":
                        ans = left * right;
                        break;
                    case "/":
                        ans = left / right;
                        break;
                }
                st.add(ans);
            } else {
                st.add(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    boolean isOperator(String val) {
        return val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/");
    }
}
