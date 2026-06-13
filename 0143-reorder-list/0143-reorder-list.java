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
    public void reorderList(ListNode head) {
        List<Integer>lis=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            lis.add(curr.val);
            curr=curr.next;
        }
        int left=0;
        int right=lis.size()-1;
        ListNode currs=head;
        while(left<=right){
            if(left==right){
                currs.val=lis.get(left);
                break;

            }
         
                            
            currs.val=lis.get(left);
            currs.next.val=lis.get(right);
            
            currs=currs.next.next;
            left++;
            right--;

        }
        
    }
}