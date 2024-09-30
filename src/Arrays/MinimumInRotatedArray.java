package Arrays;

//Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//
//        [4,5,6,7,0,1,2] if it was rotated 4 times.
//        [0,1,2,4,5,6,7] if it was rotated 7 times.
//        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
//        Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//
//        You must write an algorithm that runs in O(log n) time.
public class MinimumInRotatedArray {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int s=0;
        int e=nums.length-1;
        while(s<e){
            int mid=(s+e)/2;
            //our mission is to find the point in array where its rotated, that will be the answer hence min element
            if(nums[mid]<=nums[e]){   //IF element at mid is smaller than  element at end, which everything is fine bw mid and end as it's a sorted array
                e=mid; //hence move end behind
            }
            //else there is an issue( inflection point is bw mid and end)
            else{
                s=mid+1;  //hence move start ahead
            }
        }
        System.out.println(nums[s]);
    }
}
