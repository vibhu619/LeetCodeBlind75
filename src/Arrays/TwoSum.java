package Arrays;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        HashMap<Integer,Integer> m=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i])){
                ans[0]=m.get(target-nums[i]);   ///HASHMAP///
                ans[1]=i;
                break;
            }
            else{
                m.put(nums[i],i);
            }
        }

        for(int x: ans){
            System.out.println(x+" ");
        }
    }
}
