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
};
*/

class Solution {
    private void preorder(List<Integer>lis,Node root){
        
        if(root==null){
            return;
        }
        lis.add(root.val);
     
        for(Node child:root.children){
            preorder(lis,child);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer>lis=new ArrayList<>();
        preorder(lis,root);
        return lis;
    }
}