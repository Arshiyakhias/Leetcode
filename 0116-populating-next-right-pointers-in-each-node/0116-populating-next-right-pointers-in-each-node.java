/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
      
        Queue<Node>q=new LinkedList<>();
        List<List<Node>>lis=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int vals=q.size();
            List<Node>addon=new ArrayList<>();
            while(vals>0){
                Node curr=q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                    addon.add(curr.left);

                }
                if(curr.right!=null){
                    q.add(curr.right);
                    addon.add(curr.right);

                }
                vals--;

            }
            lis.add(addon);
        }
        for(List<Node>sing:lis){
            if(sing.size()>1){
                for(int i=0;i<sing.size()-1;i++){
                    Node curr1=sing.get(i);
                    Node curr2=sing.get(i+1);
                    curr1.next=curr2;
                }

            }
        }
        return root;
        
    }
}