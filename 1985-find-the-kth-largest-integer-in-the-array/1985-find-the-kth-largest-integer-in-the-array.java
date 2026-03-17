import java.util.*;
import java.math.*;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq =new PriorityQueue<>((a,b)->
        new BigInteger(b).compareTo(new BigInteger(a)));
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        System.out.println(pq);
        for(int i=0;i<(k-1);i++){
            System.out.println(pq.peek());
            pq.poll();
        }
        return pq.poll();
    }
}