class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (!isAlphanum(s.charAt(start))) {
                start++;
                continue;
            }
            if (!isAlphanum(s.charAt(end))) {
                end--;
                continue;
            }
            if (!isEqual(s.charAt(start), s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    boolean isAlphanum(char c) {
        return isAlpha(c) || isNum(c);
    }

    boolean isAlpha(char c) {
        return isLower(c) || isUpper(c);
    }

    boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    boolean isEqual(char a, char b) {
        if (isAlpha(a) && isAlpha(b)) {
            if ((isUpper(a) && isUpper(b)) || (isLower(a) && isLower(b))) {
                return a == b;
            } else if (isUpper(a) && isLower(b)) {
                return a - 'A' == b - 'a';
            } else {
                return a - 'a' == b - 'A';
            }
        } else if (isNum(a) && isNum(b)) {
            return a == b;
        }
        return false;
    }
}
