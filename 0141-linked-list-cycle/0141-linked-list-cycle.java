/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode curr=head;
        HashSet<ListNode>set=new HashSet<>();
        while(curr!=null){
            if(set.contains(curr.next)){
                return true;
            }
            else{
                set.add(curr.next);
                curr=curr.next;
            }
        }
        return false;
    }
}