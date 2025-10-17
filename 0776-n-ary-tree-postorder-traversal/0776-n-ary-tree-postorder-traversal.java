/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    private void postorder(Node root,List<Integer>lis){
        if(root==null){
            return;
        }
        for(Node child:root.children){
            postorder(child,lis);
        }
        lis.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        
        List<Integer>lis=new ArrayList<>();
        postorder(root,lis);
        return lis;
        
    }
}