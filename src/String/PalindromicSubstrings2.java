package String;
//Given a string s, return the number of palindromic substrings in it.
//
//A string is a palindrome when it reads the same backward as forward.
//
//A substring is a contiguous sequence of characters within the string.
//
//
//
//Example 1:
//
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
//Example 2:
//
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"

public class PalindromicSubstrings2 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));

    }

    //Logic-here we just iterate through each character and for char[i], e go to i-1 and i+1 till the character match
    //we have to keep point of even length and odd length palindrome
    //If it is odd, expand left = (i-1) and right = (i+1)
    //If it is even, expand left = (i) and right = (i+1)
    public static int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++) {
            int even = palindromeCount(s, i, i+1);
            int odd = palindromeCount(s, i-1, i+1);
            ans += even + odd + 1;  //odd +even plus 1 because each character is itself palindrome
        }
        return ans;
    }

    public static int palindromeCount(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        return count;
    }
}
