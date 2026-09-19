/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

*/

import java.util.*;
class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        f(0, 0, n, temp, res);

        return res;
    }

    void f(int open, int close, int n,
           StringBuilder temp, List<String> res) {

        if (open == n && close == n) {
            res.add(temp.toString());
            return;
        }

        if (open < n) {
            temp.append('(');

            f(open + 1, close, n, temp, res);

            temp.deleteCharAt(temp.length() - 1);
        }

        if (close < open) {
            temp.append(')');

            f(open, close + 1, n, temp, res);

            temp.deleteCharAt(temp.length() - 1);
        }
    }
}