class MinStack {
        Stack<List<Integer>>st=new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            List<Integer>lis=new ArrayList<>();
            lis.add(value);
            lis.add(value);
            st.push(lis);
        }
        else{
            List<Integer>find=st.peek();
            int min=Math.min(find.get(0),find.get(1));
            min=Math.min(min,value);
            List<Integer>fin=new ArrayList<>();
            fin.add(value);
            fin.add(min);
            st.push(fin);
        }
        
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        List<Integer>got=st.peek();
        return got.get(0);
        
    }
    
    public int getMin() {
        List<Integer>gots=st.peek();
        return gots.get(1);
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */