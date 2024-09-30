package String;

//Given a string S, find the length of the longest substring with all distinct characters.
//
//        Example 1:
//
//        Input:
//        S = "geeksforgeeks"
//        Output: 7
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "geeksforseeks";
        System.out.println(longestSubstr(s));
    }

    private static int longestSubstr(String s) {
        int n = s.length();
        //if zero element is there
        if (n == 0) {
            return 0;
        }
        //if one element is there
        if (n == 1) {
            return 1;
        }
        //for more than 1
        //1) create a boolean array to keep track of visited elements
        boolean[] arr = new boolean[256];

        //keep two pointers for current window      ////////////////TRICK - SLIDING WINDOW //////////////////////
        int left = 0;
        int right = 0;
        int maxLength = 0;

        //traverse the string
        while (right < n) {
            //if character is visited--> repeated character occurred
            if (arr[s.charAt(right)]) {
                //move left pointer to right and make those elements mark false till repeated character is marked false
                while (arr[s.charAt(right)]) {
                    arr[s.charAt(left)] = false;
                    left++;
                }

            }
            // move right ++ and mark elements at right as visited
            arr[s.charAt(right)] = true;  //note- marked the repeated element as true as new window will start from here
            maxLength = Math.max(maxLength, right - left + 1); //keep max length of window updated

            right++;
        }
        return maxLength;
    }
}
