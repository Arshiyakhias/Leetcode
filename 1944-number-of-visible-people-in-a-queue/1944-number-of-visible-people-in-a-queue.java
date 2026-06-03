class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        List<Integer>lis=new ArrayList<>();
        
        for(int i=heights.length-1;i>=0;i--){
            lis.add(heights[i]);
        }
        System.out.println(lis);

        Stack<Integer>st=new Stack<>();

        List<Integer>fin=new ArrayList<>();
        for(int i=0;i<lis.size();i++){
            if(st.isEmpty()){
                fin.add(0);
                st.push(lis.get(i));
            }
            else{
                if(st.peek()>lis.get(i)){
                    fin.add(1);
                    st.push(lis.get(i));
                }
                else{
                    int count=0;
                    while(!st.isEmpty() && st.peek()<lis.get(i)){
                        count++;
                        st.pop();

                    }
                    if(st.isEmpty()){
                        fin.add(count);

                    }
                    else{
                        fin.add(count+1);
                    }
                    st.push(lis.get(i));
                }

            }
        }
        int[]ans;
        ans=new int[fin.size()];
        int count=0;
        for(int i=fin.size()-1;i>=0;i--){
            ans[count]=fin.get(i);
            count++;
        }

        System.out.println(fin);
        
        return ans;

    }
}