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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer>map=new HashMap<>();
        ListNode curr=head;
        List<Integer>lis=new ArrayList<>();
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
        List<Integer>adds=new ArrayList<>(map.keySet());

        for(int i=0;i<adds.size();i++){
            if(map.get(adds.get(i))==1){
                lis.add(adds.get(i));
                System.out.println(adds.get(i));
            }
        }
        Collections.sort(lis);
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        for(int i=0;i<lis.size();i++){
            ListNode addon=new ListNode(lis.get(i));
            tail.next=addon;
            tail=tail.next;
        }
        return dummy.next;
    }
}