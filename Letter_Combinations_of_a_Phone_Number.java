
/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

*/

import java.util.*;

class Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        int n = digits.length();
        int idx = 0;

        StringBuilder diary = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }

        backtrack(idx, digits, n, diary, res, map);

        return res;
    }

    void backtrack(int idx, String digits, int n,
                   StringBuilder diary, ArrayList<String> res,
                   HashMap<Character, String> map) {

        if (idx == n) {
            res.add(diary.toString());
            return;
        }

        String letters = map.get(digits.charAt(idx));

        for (int j = 0; j < letters.length(); j++) {
            char ch = letters.charAt(j);

            diary.append(ch);

            backtrack(idx + 1, digits, n, diary, res, map);

            diary.deleteCharAt(diary.length() - 1);
        }
    }
}