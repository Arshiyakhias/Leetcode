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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
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
        List<Integer>lis=new ArrayList<>(map.keySet());
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<lis.size();i++){
            int vals1=map.get(lis.get(i));
            if(vals1==1){
                set.add(lis.get(i));
            }
        }
        ListNode curr1=head;
        ListNode ans=new ListNode(0);
        ListNode check=ans;
        while(curr1!=null){
            if(set.contains(curr1.val)){
                ListNode addon=new ListNode(curr1.val);
                check.next=addon;
                check=check.next;
            }
            curr1=curr1.next;

        }
        return ans.next;

    }
}