class Solution {
    public int minOperations(int[] nums, int k) {
        if(nums.length<2){
            return -1;
        }
        PriorityQueue<Long>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add((long)nums[i]);
        }
        int count=0;
        if(pq.peek()>=k){
            return 0;
        }
        while(pq.size()>=2){
            long x=pq.poll();
            long y=pq.poll();
            Long ins=(long)x*2+y;
            pq.add(ins);
         
            count++;
            if(pq.peek()>=k){
                break;
            }
        }
        return count;
    }
}