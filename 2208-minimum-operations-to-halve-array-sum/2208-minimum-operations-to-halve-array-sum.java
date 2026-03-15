class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double>pq=new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        for(int i=0;i<nums.length;i++){
            pq.add((double)nums[i]);
            sum=sum+nums[i];

        }
        int count=0;
     double half=sum/2;
        while(!pq.isEmpty()){
            double vals=pq.poll();
            double halved=vals/2;
            sum=sum-vals;
            sum=sum+halved;
            
            count++;
   
            pq.add(halved);
            if(sum<=half){
                break;
            }
        }
        return count;
    }
}