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
    public String gameResult(ListNode head) {
        ListNode curr=head;
        int odd=0;
        int even=0;
        if(curr==null){
            return " ";
        }
        int count=0;
        while(curr.next!=null ){
            count++;
            if(count%2!=0){
                int first=curr.val;
                int second=curr.next.val;
                if(first<second){
                    odd++;
                }
                else{
                    even++;
                }

            }

            
            curr=curr.next;
           

            
           
        }
        if(odd>even){
            return "Odd";
        }
        if(odd==even){
            return "Tie";
        }
        return "Even";
    }
}