class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks.length<=1){
            return 0;
        }
        
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<sticks.length;i++){
            pq.add(sticks[i]);
        }
        int ans=0;
        while(pq.size()>1){
            int val1=pq.poll();
            int val2=pq.poll();
            val1=val1+val2;
             ans=ans+val1;
            if(!pq.isEmpty()){
                pq.add(val1);

            }
           
            System.out.println(val1);
            
        }
        if(!pq.isEmpty()){
            ans=ans+pq.poll();

        }
        
        
        return ans;
    }
}