/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

*/
import java.util.*;
class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack <>();
        boolean flag = true;
        for(char c : s.toCharArray()){
            
            if(c == '{' || c == '[' || c== '('){
                stack.push(c);
            }
            
            else if (c == '}' || c == ']' || c== ')'){
                if (stack.isEmpty()){
                    flag = false;
                }
                else if(c == '}' && stack.peek()== '{' || c == ']' && stack.peek()== '['|| c== ')' && stack.peek()== '('){
                    stack.pop();
                }
                else{
                    flag = false;
                }
            }
        }
        if(!stack.isEmpty()){
                flag = false;
        }
        return flag ;
    }
}