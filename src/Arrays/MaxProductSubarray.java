package Arrays;
//Given an integer array nums, find a
//        subarray
//        that has the largest product, and return the product.
//
//        The test cases are generated so that the answer will fit in a 32-bit integer.
//
//
//
//        Example 1:
//
//        Input: nums = [2,3,-2,4]
//        Output: 6
//        Explanation: [2,3] has the largest product 6.
public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] nums={2,3,-2,4};
        System.out.println(maxSproduct(nums));
    }

    //check notes
    private static int maxSproduct(int[] nums){
        int max=Integer.MIN_VALUE;
        int prefix=1;
        int suffix=1;
        int n=nums.length;
        for(int i=0;i<n;i++){

            //if prefix becomes 0 , reset prefix to 1
            if(prefix==0){
                prefix=1;
            }

            //if suffix becomes 0 , reset suffix to 1
            if(suffix==0){
                suffix=1;
            }

            prefix=prefix*nums[i];
            suffix=suffix*nums[n-i-1];

            max=Math.max(max,Math.max(prefix,suffix));
        }

        return max;
    }
}
