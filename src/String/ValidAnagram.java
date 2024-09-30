package String;
//Given two strings s and t, return true if t is an
//        anagram
//        of s, and false otherwise.
//
//
//
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//
//        Output: true
//
//        Example 2:
//
//        Input: s = "rat", t = "car"
//
//        Output: false
public class ValidAnagram {
    public static void main(String[] args) {
        String s="anagram";
        String t="Nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static  boolean isAnagram(String s, String t) {
        int[] arr=new int[26];
        s=s.toLowerCase();
        t=t.toLowerCase();
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t.length();i++){
            if(arr[t.charAt(i)-'a']==0){
                return false;
            }

            else{
                arr[t.charAt(i)-'a']--;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                return false;
            }
        }

        return true;
    }
}
