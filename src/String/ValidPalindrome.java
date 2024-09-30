package String;
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//        Given a string s, return true if it is a palindrome, or false otherwise.
//
//        Example 1:
//
//        Input: s = "A man, a plan, a canal: Panama"
//        Output: true
//        Explanation: "amanaplanacanalpanama" is a palindrome.
import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s=s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        List<Character> l=new ArrayList<>();
        int i=0;
        int j=s.length()-1;
        s=s.toLowerCase();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            l.add(ch);
        }

        // Add digits (0-9) to the list
        for (char ch = '0'; ch <= '9'; ch++) {
            l.add(ch);
        }
        while(i<=j){

            while(i<s.length() && !l.contains(s.charAt(i))){
                i++;
            }
            while(j>=0 && !l.contains(s.charAt(j)) ){
                j--;
            }
            if(i==s.length() || j==0){
                return true;
            }

            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}
