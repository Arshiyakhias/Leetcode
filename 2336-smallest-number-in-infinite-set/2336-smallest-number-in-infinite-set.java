class SmallestInfiniteSet {
    public PriorityQueue<Integer>pq;
    

    public SmallestInfiniteSet() {
        pq=new PriorityQueue<Integer>();
        for(int i=1;i<=1000;i++){
            pq.add(i);
        }
        
    }
    
    public int popSmallest() {
        int val=pq.poll();
        return val;
        
    }
    
    public void addBack(int num) {
        if(!pq.contains(num)){
            pq.add(num);

        }
        
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */