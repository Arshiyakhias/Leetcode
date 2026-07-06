/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        HashSet<Node>set=new HashSet<>();
        for(int i=0;i<tree.size();i++){
            List<Node>child=tree.get(i).children;
            for(int j=0;j<child.size();j++){
                set.add(child.get(j));
            }
        }
        for(int i=0;i<tree.size();i++){
           if(!set.contains(tree.get(i))){
            return tree.get(i);
           }
        }
        return tree.get(0);
        
    }
}