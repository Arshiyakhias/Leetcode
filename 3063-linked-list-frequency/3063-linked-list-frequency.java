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
    public ListNode frequenciesOfElements(ListNode head) {
        HashMap<Integer,Integer>map=new HashMap<>();
        ListNode curr=head;
        while(curr!=null){
            if(map.containsKey(curr.val)){
                int vals=map.get(curr.val);
                vals++;
                map.put(curr.val,vals);
            }
            else{
                map.put(curr.val,1);
            }
            curr=curr.next;
        }
        List<Integer>lis=new ArrayList<>(map.values());
        ListNode ans=new ListNode(0);
        ListNode cur=ans;
        for(int i=0;i<lis.size();i++){
            ListNode addon=new ListNode(lis.get(i));
            cur.next=addon;
            cur=cur.next;
        }
        return ans.next;
    }
}