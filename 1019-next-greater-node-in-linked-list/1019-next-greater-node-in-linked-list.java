/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {

        ListNode prev=null;
        ListNode curr=head;
        
        while(curr!=null){
            ListNode nextnode=curr.next;
            curr.next=prev;

            //update
            prev=curr;
            curr=nextnode;
 
        }
  

        head=prev;
        int len=0;
        

        ListNode find=head;
        Stack<Integer>st=new Stack<>();
        List<Integer>ans=new ArrayList<>();

        while(find!=null){
            if(st.isEmpty()){
                st.push(find.val);
                ans.add(0);
            }
            else{
                if(st.peek()>find.val){
                    ans.add(st.peek());
                    st.push(find.val);
                    

                }
                else{
                    
                    while(!st.isEmpty() && st.peek()<=find.val ){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        ans.add(0);
                        st.push(find.val);
                    }
                    
                    else{
                        ans.add(st.peek());
                        st.push(find.val);
                    }
                }
                
            }
            System.out.println(st);
            find=find.next;
        }
        int[]fin;
        fin=new int[ans.size()];
        int count=0;
        for(int i=ans.size()-1;i>=0;i--){
            fin[count]=ans.get(i);
            count++;
        }
        System.out.println();
        System.out.println(ans);
        return fin;


    
        
    }
}