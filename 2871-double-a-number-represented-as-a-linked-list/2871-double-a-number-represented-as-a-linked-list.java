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
    public ListNode doubleIt(ListNode head) {
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

       ListNode check=head;
       int carry=0;

       while(check!=null){
        int vals=check.val*2;
        if(vals>=10){
            int units=vals%10;
            if(carry==0){
                check.val=units;

            }
            else{
                check.val=units+carry;
                carry=0;
            }
            carry=vals/10;
        }
        else{
            if(carry==0){
                check.val=vals;

            }
            else{
                check.val=vals+carry;
                carry=0;
            }
            
        }
        check=check.next;
        
       }
       if(carry!=0){
        ListNode addon=new ListNode(carry);
        ListNode again=head;
        while(again.next!=null){
            again=again.next;
        }
        again.next=addon;
       
       }
       ListNode prev1=null;
       ListNode curr1=head;

       while(curr1!=null){
        ListNode nextnode1=curr1.next;
        curr1.next=prev1;

        //update
        prev1=curr1;
        curr1=nextnode1;

       }
       head=prev1;
       return head;
    }
}