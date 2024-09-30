package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//        Notice that the solution set must not contain duplicate triplets.
//
//        Example 1:
//
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//        Explanation:
//        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//        The distinct triplets are [-1,0,1] and [-1,-1,2].
//        Notice that the order of the output and the order of the triplets does not matter.
//        Example 2:
//
//        Input: nums = [0,1,1]
//        Output: []
//        Explanation: The only possible triplet does not sum up to 0.
//        Example 3:
//
//        Input: nums = [0,0,0]
//        Output: [[0,0,0]]
//        Explanation: The only possible triplet sums up to 0.
public class TripletSum {

    //CONCEPT-- Here we fix one number at index 'i' and call for twoSum approach to find two numbers from i+1 to n which sum to target=-nums[i]
    //For two sum technique we use hashmap

    public static void main(String[] args) {
        int[] nums= {-1,0,1,2,-1,-4};
        List<List<Integer>> ans=threeSum(nums);
        for(List<Integer> l: ans){
            for(int x: l){
                System.out.print(x+" ");
            }
            System.out.println("\n");
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
    int n=nums.length;
        for(int i=0;i<n-2;i++){
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        twoSum(nums,ans,i,n);
    }
        return ans;
}

    private static void twoSum(int[] nums, List<List<Integer>> ans, int i, int n){
        HashMap<Integer,Integer> m=new HashMap<>();
        int target=-nums[i];
        ArrayList<Integer> a=new ArrayList<>();
        for(int j=i+1;j<n;j++){
            if(m.containsKey(target-nums[j])){
                a.add(nums[i]);
                a.add(nums[j]);
                a.add(target-nums[j]);
                ans.add(new ArrayList<>(a));  //remember we cant do ans.add(a) because after a.clear() it will be cleared from ans also as ans will have reference of a,hence use new array
                a.clear();
                while(j+1<n && nums[j]==nums[j+1]){  //we have sorted array , and if duplicate element comes, it will come consecutively ,hence if element at j and j+1 are same we will skip
                    j++;
                }
            }
            else{
                m.put(nums[j],j);
            }
        }
    }
}
