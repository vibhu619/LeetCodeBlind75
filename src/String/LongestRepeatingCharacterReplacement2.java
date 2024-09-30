package String;


//Here we will use a sliding window + 2-pointer technique
public class LongestRepeatingCharacterReplacement2 {
    public static void main(String[] args) {
    String s = "AABABBA";
    int k = 2;
    System.out.println(findSubstring(s, k, s.length()));
}

    private static int findSubstring(String s, int k, int n) {
        if (n == 1) {
            return 1;
        }

        int r=0;  //right pointer
        int l=0;  //left pointer
        int maxf=0;  //to store max frequency at every point
        int ans=0;
        int[] freq=new int[26];  //frequency array

        while(r<n){
            //1. start making the window from element at 'r' index
            char chR =s.charAt(r);
            freq[chR -'A']++;  //update the frequency of each element
            maxf=Math.max(maxf,freq[chR -'A']);  //update maxf with max frequency

            //As we know, neededFlips= length of current window - maxf which should be <=k
            //hence, if > k then remove an element from 'l' index till neededFlips<=k (shrink the window)
            while((r-l+1)-maxf>k){
                char chL=s.charAt(l);
                freq[chL-'A']--;  //just decrease frequency
                l++;  //increment l index
                //also update maxf
                maxf=0;
                for(int i=0;i<26;i++){
                    maxf=Math.max(maxf,freq[i]);
                }
            }


            //now, as it is valid, we can update the answer
            if ((r-l+1)-maxf<=k) {
                ans=Math.max(ans,r-l+1);
            }

            r++;
        }
        return ans;
    }
}
