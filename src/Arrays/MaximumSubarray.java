package Arrays;
//Given an integer array nums, find the
//        subarray
//        with the largest sum, and return its sum.
//        Example 1:
//
//        input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6
//        Explanation: The subarray [4,-1,2,1] has the largest sum 6.
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarray(nums));
    }

    private static int maxSubarray(int[] nums){

        //KADANE ALGORITHM USAGE//

        //Just kadane don't deal with all negative integers
        //hence writing separate code when all integers are negative
        int negativeMax=Integer.MIN_VALUE;
        boolean flag=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                flag=true;
                break;
            }
            negativeMax=Math.max(negativeMax,nums[i]);
        }
        if(flag==false){
            return negativeMax;
        }
        else{
            //KADANE STARTS FROM HERE//
            int ms=Integer.MIN_VALUE;
            int cs=0;
            for(int i=0;i<nums.length;i++){
                cs=cs+nums[i];
                if(cs<0){
                    cs=0;
                }
                ms=Math.max(ms,cs);
            }
            return ms;
        }
    }
}
