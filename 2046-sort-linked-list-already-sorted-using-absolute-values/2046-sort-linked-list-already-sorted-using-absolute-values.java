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
    public ListNode sortLinkedList(ListNode head) {
        List<Integer>lis=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            lis.add(curr.val);
            curr=curr.next;
        }
        Collections.sort(lis);
        ListNode curr1=head;
        int count=0;
        while(curr1!=null){
            curr1.val=lis.get(count);
            count++;
            curr1=curr1.next;

        }
        return head;
    }
}