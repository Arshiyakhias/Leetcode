class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer>p=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<gifts.length;i++){
            p.add(gifts[i]);
        }
        while(k!=0){
            int val=p.peek();
             p.poll();
            int fin=(int)Math.sqrt(val);
     
            System.out.println(fin);
           
            p.add(fin);
            k--;
        }
        long ans=0;
        while(!p.isEmpty()){
            ans=ans+p.peek();
            p.poll();
        }
        return ans;

        
    }
}