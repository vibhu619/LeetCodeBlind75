package Arrays;
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

//Example 1:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
public class FindElementInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2,3};
        int target=0;
        System.out.println(findElement(nums, target,nums.length));
    }

    private static int findElement(int[] nums,int target, int n) {
         int s=0;
         int e=n-1;
         while(s<=e){
             int mid=(s+e)/2;

             if(nums[mid]==target){  //If target is matched return ans
                 return mid;
             }                                                                      /////BINARY SEARCH///

             else if(nums[s]<=nums[mid]){    //if start is smaller than mid-element
                 //if target is b/w start and mid, then bring end to mid
                  if(target>=nums[s] && target<=nums[mid]){
                     e=mid-1;
                 }
                  //else bring start to mid+1
                 else{
                     s=mid+1;
                 }
             }
             else{
                 //if target b/w mid and end , then bring start to mid+1
                 if(target>=nums[mid] && target<=nums[e]){
                     s=mid+1;
                 }
                 //else bring end to mid-1
                 else{
                     e=mid-1;
                 }
             }

        }
        return -1;
    }
}
