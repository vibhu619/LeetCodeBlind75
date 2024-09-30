package Arrays;

import java.util.HashMap;

//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//
//        Example 1:
//        Input: nums = [1,2,3,1]
//        Output: true
//        Explanation:
//        The element 1 occurs at the indices 0 and 3.
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        HashMap<Integer,Integer> m=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
                                                                            //HASHMAP///
        if(m.size()==nums.length){
            System.out.println("false");
        }
        else{
            System.out.println("true");
        }

    }
}
