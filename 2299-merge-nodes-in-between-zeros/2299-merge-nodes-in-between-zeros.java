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
    public ListNode mergeNodes(ListNode head) {
        int sum=0;
        ListNode curr=head;
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(curr!=null){
            if(curr.val==0){
                if(sum!=0){
                    System.out.println(sum);
                    ListNode addon=new ListNode(sum);
                    tail.next=addon;
                    tail=tail.next;
                    
                
                   

                }
                
                sum=0;
                curr=curr.next;
            }
            else{
                sum=sum+curr.val;
                curr=curr.next;
            
            }
            
        }
        return dummy.next;
    }
}