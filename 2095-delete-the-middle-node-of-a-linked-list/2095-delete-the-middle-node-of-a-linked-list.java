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
    public ListNode deleteMiddle(ListNode head) {
       ListNode curr=head;
       int length=0;
       while(curr!=null){
        length++;
        curr=curr.next;
        
       }
      
       if(length<2){
        return null;
       }
       ListNode prev=head;
       while(prev!=null){
        if(prev.next.next==null){
            break;
        }
        else{
            prev=prev.next;
        }
       }
       int mid=length/2;
       int checking=mid+1;
       ListNode curr1=head;
       int check=0;
       while(curr1!=null){
        check++;
        if(check==checking && curr1.next!=null){
            curr1.val=curr1.next.val;
            curr1.next=curr1.next.next;
        }
        else if(check==checking && curr1.next==null){
            prev.next=null;
        
           
         
        }
        else{
            curr1=curr1.next;
        }
        
       }
       return head;

    }
}