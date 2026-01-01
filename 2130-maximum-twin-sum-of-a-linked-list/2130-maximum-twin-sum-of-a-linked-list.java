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
    public int pairSum(ListNode head) {
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            ListNode nextnode=new ListNode(temp.val);
            tail.next=nextnode;
            tail=tail.next;
            count++;

            temp=temp.next;

        }
        
        ListNode prev=null;
        ListNode curr=dummy;
        while(curr!=null){
            ListNode nextn=curr.next;
            curr.next=prev;

            //update
            prev=curr;

            curr=nextn;

        }
        dummy=prev;
        ListNode dum=dummy;
       
  
        int max_sum=0;
        ListNode real=head;
        for(int i=0;i<count/2;i++){
            int sums=dum.val+real.val;
            System.out.println(dum.val);
            System.out.println(real.val);

            System.out.println(sums);
            max_sum=Math.max(max_sum,sums);
            dum=dum.next;
            real=real.next;
        }
     

      

        return max_sum;

    }
}