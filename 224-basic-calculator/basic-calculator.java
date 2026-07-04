class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {

                number = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }

                result += sign * number;
                i--;

            } else if (c == '+') {

                sign = 1;

            } else if (c == '-') {

                sign = -1;

            } else if (c == '(') {

                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;

            } else if (c == ')') {

                result *= stack.pop();      // sign before '('
                result += stack.pop();      // result before '('
            }
        }

        return result;
    }
}