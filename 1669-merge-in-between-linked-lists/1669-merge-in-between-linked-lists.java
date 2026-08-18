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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        List<Integer>lis=new ArrayList<>();
        ListNode head=list1;
        int count=0;
        while(head!=null){
            if(count<a){
                lis.add(head.val);
                
            }
            else if(count>b){
                break;
            }
            head=head.next;
            count++;

        }
        ListNode head1=list2;
        


        while(head1!=null){
            lis.add(head1.val);
            head1=head1.next;

        }
        
        while(head!=null){
            lis.add(head.val);
            head=head.next;
        }
        ListNode ans=new ListNode(0);
        ListNode fin=ans;
        for(int i=0;i<lis.size();i++){
            ListNode addon=new ListNode(lis.get(i));
            fin.next=addon;
            fin=fin.next;
        }
        System.out.println(lis);
       
        return ans.next;
    }
}