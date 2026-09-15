/*

Given a string s, find if it is a palindrome. A string is considered a palindrome if it reads the same forwards and backwards.

Examples :

Input: s = "abba"
Output: true
Explanation: "abba" reads the same forwards and backwards, so it is a palindrome.
Input: s = "abc" 
Output: false
Explanation: "abc" does not read the same forwards and backwards, so it is not a palindrome.
Constraints:

1 ≤ s.size() ≤ 106
s contains: [a-z].

*/

class Palindrome_String {
    boolean isPalindrome(String s) {
        return check(s,0 , s.length()-1);
    }
    boolean check (String s , int first , int last){
        if(first>=last){
            return true;
        }
        if(s.charAt(first)!= s.charAt(last)){
            return false;
        }
        return  check(s,first+1, last-1);
    }
    
}