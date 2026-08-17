class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<List<Integer>>st=new Stack<>();
        for(int i=0;i<heights.length;i++){
            if(st.isEmpty()){
                List<Integer>lis=new ArrayList<>();
                lis.add(heights[i]);
                lis.add(i);
                st.push(lis);
            }
            else{
                List<Integer>liss=st.peek();
                while(!st.isEmpty() && heights[i]>=liss.get(0) ){
                    st.pop();
                    if(!st.isEmpty()){
                        liss=st.peek();

                    }
                    
                }
                List<Integer>lis1=new ArrayList<>();
                lis1.add(heights[i]);
                lis1.add(i);
                st.push(lis1);
               
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!st.isEmpty()){
            List<Integer>addon=st.pop();
            ans.add(addon.get(1));

        }
        Collections.sort(ans);
        int[]fin;
        fin=new int[ans.size()];
        for(int i=0;i<fin.length;i++){
            fin[i]=ans.get(i);
        }
        //System.out.println(fin);
        return fin;
    }
}