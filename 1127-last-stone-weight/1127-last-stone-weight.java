class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>p=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++){
            p.add(stones[i]);
        }


        while(p.size()>1){
            int val1=p.peek();
            p.poll();
            int val2=p.peek();
            p.poll();
            if(val1!=val2){
                int adds=val1-val2;
                p.add(adds);

            }

        }
        if(p.size()==1){
            int ans=p.peek();
            return ans;
        }
        return 0;
        
    }
}