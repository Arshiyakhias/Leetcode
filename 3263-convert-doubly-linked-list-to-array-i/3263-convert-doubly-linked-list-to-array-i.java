/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node head) {
         Node curr=head;
       
        int count=0;
        while(curr.prev!=null){
            curr=curr.prev;
         
       
           

        }
        System.out.println(curr.val);




      
        List<Integer>lis=new ArrayList<>();
  
        while(curr!=null){
            lis.add(curr.val);
            curr=curr.next;
          
        }
        int[]ans;
        ans=new int[lis.size()];
        for(int i=0;i<lis.size();i++){
            ans[i]=lis.get(i);
        }
        return ans;
    }
}