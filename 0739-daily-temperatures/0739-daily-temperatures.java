class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<temperatures.length;i++){
            map.put(i,temperatures[i]);
        }
        Stack<Integer>st=new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){
            if(st.isEmpty()){
                st.push(i);
                temperatures[i]=0;
            }
            else if(map.get(st.peek())>temperatures[i]){
                temperatures[i]=st.peek()-i;
                st.push(i);

            }
            else if(map.get(st.peek())<=temperatures[i]){
                while(!st.isEmpty() && map.get(st.peek())<=temperatures[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    temperatures[i]=0;
                    st.push(i);
                    
                }
                else{
                   

                    temperatures[i]=st.peek()-i;
                    st.push(i);
                }

            }
        }
        return temperatures;
    }
}