/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        HashMap<Node,Node>map=new HashMap<>();
        Node curr=head;
        
        Node addson=new Node(curr.val);
        map.put(curr,addson);
        while(curr!=null){
            if(!map.containsKey(curr)){
                Node adds=new Node(curr.val);
                map.put(curr,adds);

            }
            curr=curr.next;
        }
        
        Node curr1=head;
        while(curr1!=null){
            Node sing=map.get(curr1);
            Node sing_next=map.get(curr1.next);
            sing.next=sing_next;
            if(curr1.random!=null){
                Node ran=map.get(curr1.random);
                sing.random=ran;
            }
            curr1=curr1.next;
            


        }
        return addson;
    }
}