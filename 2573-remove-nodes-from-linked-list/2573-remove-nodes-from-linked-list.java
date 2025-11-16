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
    public ListNode removeNodes(ListNode head) {
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
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        ListNode check=head;
        int max=0;
        while(check!=null){
            if(max<=check.val){
                ListNode vals=new ListNode(check.val);
                tail.next=vals;
                tail=tail.next;
                
            }
            max=Math.max(max,check.val);


            check=check.next;

        }

        ListNode prev1=null;
        ListNode curr1=dummy;
        while(curr1!=null){
            ListNode nextnode1=curr1.next;
            curr1.next=prev1;

            //update
            prev1=curr1;
            curr1=nextnode1;
        }
        dummy=prev1;
        ListNode checks=dummy;
        while(checks.next.next!=null){
            checks=checks.next;
        }
        checks.next=null;
        return dummy;
    

        
    }
}