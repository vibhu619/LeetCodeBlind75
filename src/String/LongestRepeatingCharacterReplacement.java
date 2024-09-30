package String;
//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
// You can perform this operation at most k times.
//
//        Return the length of the longest substring containing the same letter you can get after performing the above operations.
//
//        Input: s = "AABABBA", k = 1
//        Output: 4
//        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//        The substring "BBBB" has the longest repeating letters, which is 4.
//        There may exist other ways to achieve this answer too.


public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s="AABABBA";
        int k=2;

        System.out.println(findSubstring(s,k,s.length()));
    }
    //Intuition - We will make substrings and in each substring starting from i=0->n, e store frequency of each character in array[26]
    //for each substring we will find character in that substring which has maximum frequency (maxf).
    //To make it a substring with the same characters, its more reasonable to flip characters other than maxf character.
    //Hence, number of flips to make that substring valid flipsNeeded= len of substring - maxf.
    //Now we can do max K flips, hence if flipsNeeded> k then this substring is useless to update the length of the substring in answer
    private static int findSubstring(String s, int k, int n) {
        if(n==1){
            return 1;
        }
        int maxf=Integer.MIN_VALUE;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            //create substring from i=0->n
            int[]  freq=new int[26];  //to store frequency of each character in substring(i->j)
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                freq[ch-'A']++;
                maxf=Math.max(maxf,freq[ch-'A']);  //find character in substring with max frequency

                int flips=(j-i+1)- maxf;  //no of flips needed
                if(flips<=k){ //if satisfied, then update answer with length of substring
                    ans=Math.max(ans,j-i+1);
                }
                else {
                    break;
                }
            }
        }
        return ans;
    }
}
