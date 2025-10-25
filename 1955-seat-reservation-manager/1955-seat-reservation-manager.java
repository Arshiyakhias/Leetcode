class SeatManager {
    PriorityQueue<Integer>p=new PriorityQueue<>();

    public SeatManager(int n) {
        
        for(int i=1;i<=n;i++){
            p.add(i);
        }
    }
    
    public int reserve() {
        int val=p.peek();
        p.poll();
        return val;
        
    }
    
    public void unreserve(int seatNumber) {
        p.add(seatNumber);

        
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */