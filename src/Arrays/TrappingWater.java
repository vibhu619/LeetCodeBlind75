package Arrays;
//Given an array arr[] of N non-negative integers representing the height of blocks.
// If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.
//
//
//        Example 1:
//
//        Input:
//        N = 6
//        arr[] = {3,0,0,2,0,4}
//        Output:
//        10


public class TrappingWater {
    public static void main(String[] args) {
        int[] arr = {3,0,0,2,0,4};
        int n=6;
        System.out.println(trappingWater(arr,n));

    }

    static long trappingWater(int arr[], int n) {
        // Your code here
        //Logic-create two array right and left to keep index of the greatest value on the left of ith element and right of ith element
        long[] right=new long[n];
        long[] left=new long[n];
        long mr=arr[n-1];
        long ml=0;
        for(int i=0;i<n;i++){
            ml=Math.max(arr[i],ml);  //getting index of largest value on left side of arr[i]
            left[i]=ml;

            mr=Math.max(arr[n-i-1],mr);  //getting index of largest value on right side of arr[i]
            right[n-i-1]=mr;
        }
        long ans=0;
        //for each element at i, water will be trapped only if it has larger building on its right and left side
        for(int i=0;i<n;i++){
            if(arr[i]<left[i] && right[i]>arr[i]){
                ans=ans+Math.min(left[i],right[i])-arr[i];
            }
        }
        return ans;
    }
}
