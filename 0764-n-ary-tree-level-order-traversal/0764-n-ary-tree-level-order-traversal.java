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
    public List<List<Integer>> levelOrder(Node root) {
    
        List<List<Integer>>lis=new ArrayList<>();
        if(root==null){
            return lis;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int vals=q.size();
            List<Integer>addon=new ArrayList<>();
            while(vals!=0){
                Node check=q.poll();
                for(Node child:check.children){
                    q.add(child);
                }
                vals--;
                addon.add(check.val);
            }
            lis.add(addon);
        }
        return lis;
        
    }
}