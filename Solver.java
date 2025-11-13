// Name: Anand Raj
// Date: 11/7/25
// General Description: Checks if a string of parentheses is valid or not.
// Uses a stack to make sure all opening brackets have matching closing ones.

import java.util.Stack;

public class Solver {

    // Pre-condition: s contains only the characters '(', ')', '{', '}', '[' and ']'
    // Post-condition: returns true if the parentheses are valid, false otherwise
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // if opening bracket, push onto stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // if closing bracket, check if stack has a matching opening one
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // valid if nothing left unmatched
        return stack.isEmpty();
    }

    // just some tests
    public static void main(String[] args) {
        System.out.println(isValid("(){}[]"));     // true
        System.out.println(isValid("([)]"));       // false
        System.out.println(isValid("{[()]}"));     // true
        System.out.println(isValid("(({}))"));     // true
        System.out.println(isValid("{[}]"));       // false
        System.out.println(isValid("({)}"));       // false
        System.out.println(isValid("(){}["));      // false
    }
}
