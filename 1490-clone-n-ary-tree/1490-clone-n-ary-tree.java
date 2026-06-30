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
    public Node cloneTree(Node root) {
        if(root==null){
            return null;
        }
        HashMap<Node,Node>map=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int vals=q.size();
            while(vals>0){
                Node curr=q.poll();
                List<Node>orig=curr.children;
                if(!orig.isEmpty()){
                    Node clo=new Node(curr.val);
                    List<Node>clone=new ArrayList<>();
                    for(int i=0;i<orig.size();i++){
                        Node n=new Node(orig.get(i).val);
                        clone.add(n);
                        q.add(orig.get(i));
                        map.put(orig.get(i),n);
                    }
                    if(map.containsKey(curr)){
                        Node gets=map.get(curr);
                        gets.children=clone;

                    }
                    else{
                        clo.children=clone;
                        map.put(curr,clo);
                    }
                }
                else{
                    Node addon=new Node(curr.val);
                    if(!map.containsKey(curr)){
                        map.put(curr,addon);
                    }
                }
                vals--;
            }
        }

        return map.get(root);

        
    }
}