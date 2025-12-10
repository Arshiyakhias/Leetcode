class Solution {
    public String reverseParentheses(String s) {
      Stack<Character>st=new Stack<>();
      StringBuilder ans=new StringBuilder();

      for(int i=0;i<s.length();i++){
        if(st.isEmpty()){
            st.push(s.charAt(i));
            continue;
            
        }
        if(s.charAt(i)==')'){
            StringBuilder addon=new StringBuilder();
            while(!st.peek().equals('(')){
             
                addon.append(st.peek());
                st.pop();

            }
            //addon.reverse();
            st.pop();
            System.out.println(addon);
            
        
            
            for(int k=0;k<addon.length();k++){
                st.push(addon.charAt(k));
            }
           
        }
        else{
            st.push(s.charAt(i));
        }
      }
      while(!st.isEmpty()){
        ans.append(st.peek());
        st.pop();
      }
      ans.reverse();
      return ans.toString();


       
    }
}