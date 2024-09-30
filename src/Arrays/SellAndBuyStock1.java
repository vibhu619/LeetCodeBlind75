package Arrays;
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//        Example 1:
//
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
public class SellAndBuyStock1 {
    public static void main(String[] args) {
        int[] arr={3,1,4,8,7,2,5};
        int n=arr.length;
        System.out.println("Approach 1: Using Two for loops ");
        maxProfitWithTwoLoops(arr,n);
        System.out.println("Approach 2: Using extra space ");
        maxProfitUsingExtraSpace(arr,n);
        System.out.println("Approach 3: Using No extra space and in linear time");
        maxProfit(arr,n);
    }

    private static void maxProfit(int[] arr, int n) {
        int min=arr[0];
        int mp=0;
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
            mp=Math.max(mp,arr[i]-min);
        }
        System.out.println(mp);
    }

    private static void maxProfitUsingExtraSpace(int[] arr, int n) {
        int[] aux=new int[n];
        int mp=0;
        int max=0;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,arr[i]);
            aux[i]=max;
        }

        for(int i=0;i<n;i++){
            mp=Math.max(mp,aux[i]-arr[i]);
        }
        System.out.println(mp);
    }

    private static void maxProfitWithTwoLoops(int[] arr, int n) {
        int mp=0;

        for(int i=0;i<n;i++){
            int max=0;
            for(int j=i;j<n;j++){
                max=Math.max(max,arr[j]);   //BRUTE FORCE- 2 FOR LOOPS//
            }
            mp=Math.max(mp,max-arr[i]);
        }

        System.out.println(mp);
    }
}
