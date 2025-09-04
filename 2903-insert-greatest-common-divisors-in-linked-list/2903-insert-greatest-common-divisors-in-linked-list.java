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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        int len=0;
        ListNode curr=head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        if(len<1){
            return head;
        }
       
        ListNode curr1=head;
        while(curr1.next!=null){
            int min=Math.min(curr1.val,curr1.next.val);
            int max=0;
            for(int i=min;i>=1;i--){
                if(curr1.val%i==0 && curr1.next.val%i==0){
                    max=Math.max(max,i);
                    break;
                }
            }
            ListNode newNode=new ListNode(max);
            newNode.next=curr1.next;
            curr1.next=newNode;
            curr1=newNode.next;
            
        }
        return head;
    }
}