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
        ArrayList<Integer>lis=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            lis.add(curr.val);
            curr=curr.next;
        }
        ListNode curr1=head;
        int left=0;
        int right=lis.size()-1;
        int count=1;
        while(left<=right){
            if(count%2!=0){
                curr1.val=lis.get(left);
                count++;
                left++;
                curr1=curr1.next;
            }
            else{
                curr1.val=lis.get(right);
                right--;
                count++;
                curr1=curr1.next;
            }
        }
       
    }
}