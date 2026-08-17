class CustomStack {
    int i=0;
    public int[]arr;

    public CustomStack(int maxSize) {
        
        arr=new int[maxSize];
    }
    
    public void push(int x) {
        if(i!=arr.length){
            arr[i]=x;
            i++;

        }


        
    }
    
    public int pop() {
        
        if(i==0){
            return -1;
        }
        i=i-1;
        return arr[i];
        
    }
    
    public void increment(int k, int val) {
        if(i<k){
            for(int j=0;j<i;j++){
            arr[j]=arr[j]+val;
        }

        }
        else{
        for(int j=0;j<k;j++){
            arr[j]=arr[j]+val;
        }}
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */