/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root==null){
            return null;
        }
        
        HashMap<Node,NodeCopy>map=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        NodeCopy root_clone=new NodeCopy(root.val);
        map.put(root,root_clone);
        
        while(!q.isEmpty()){
            int vals=q.size();
           
            while(vals>0){
                Node curr=q.poll();
                if(!map.containsKey(curr)){
                    NodeCopy curr1=new NodeCopy(curr.val);
                    map.put(curr,curr1);

                }
                NodeCopy curr_clone=map.get(curr);
                
                if(curr.left!=null){
                    q.add(curr.left);
                    if(map.containsKey(curr.left)){
                        NodeCopy left_clone=map.get(curr.left);
                        curr_clone.left=left_clone;
                    }
                    else{
                        NodeCopy leftie=new NodeCopy(curr.left.val);
                        curr_clone.left=leftie;
                        map.put(curr.left,leftie);
                    }
                   
                    
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    if(map.containsKey(curr.right)){
                        NodeCopy right_clone=map.get(curr.right);
                        curr_clone.right=right_clone;
                    }
                    else{
                        NodeCopy rightie=new NodeCopy(curr.right.val);
                        curr_clone.right=rightie;
                        map.put(curr.right,rightie);
                    }
                   
                    
                }
                
                vals--;
            }
        }

        Queue<Node>q1=new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int valss=q1.size();
            while(valss>0){
            Node currs=q1.poll();
            if(currs.random!=null){
                NodeCopy clone1=map.get(currs);
                NodeCopy clone2=map.get(currs.random);
                clone1.random=clone2;
            }
            if(currs.left!=null){
                q1.add(currs.left);
            }
            if(currs.right!=null){
                q1.add(currs.right);
            }
            valss--;
            }
        }
        return root_clone;

    }
}