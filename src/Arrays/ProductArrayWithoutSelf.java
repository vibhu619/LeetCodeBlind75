package Arrays;
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//        You must write an algorithm that runs in O(n) time and without using the division operation.
//
//        Example 1:
//
//        Input: nums = [1,2,3,4]
//        Output: [24,12,8,6]
//        Example 2:
//
//        Input: nums = [-1,1,0,-3,3]
//        Output: [0,0,9,0,0]
public class ProductArrayWithoutSelf {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7, 1};
        int n = nums.length;
        int[] ans = new int[n];   //Initialize an empty array answer where answer[i] will eventually store the product of all elements except nums[i].

        ans[0] = 1;
        for (int i = 1; i < n; i++) {  //First, traverse the array from left to right, calculating the product of elements to the left of each index and store them in answer.
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {  //Then traverse the array from right to left, calculating the product of elements to the right of each index and multiply that with the value already present in answer.
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }
        for (int x : ans) {
            System.out.println(x + " ");
        }
    }
}
