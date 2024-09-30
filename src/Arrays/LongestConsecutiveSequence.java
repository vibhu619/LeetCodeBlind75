package Arrays;
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.
//
//
//
//Example 1:
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore, its length is 4.
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums={100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        //1.Find for each number from 0->n if its start of a sequence, how?
        //just check if number n has n-1 presented, if yes, it's not a start of any sequence else yes it is
        //after u get the start, just keep on find n+1 till u get.
        //store the max answer from each sequence
        if(nums.length==0){
            return 0;
        }
        return getSequence(nums);
    }

    private static int getSequence(int[] nums) {
        Set<Integer> s = new HashSet<>();  //used a set as its easy to search an element in set
        for (int num : nums) {
            s.add(num);  // Manually add elements to the set
        }
        int ans=Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++){
            if(!s.contains(nums[i]-1)){
                int count=1;
                int start= nums[i];
                while(s.contains(start+1)){
                    count++;
                    start=start+1;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}
