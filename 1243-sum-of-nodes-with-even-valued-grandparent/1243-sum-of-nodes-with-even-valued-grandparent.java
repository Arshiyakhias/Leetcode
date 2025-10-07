/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum=0;
    private void preorder(TreeNode root,HashMap<TreeNode,TreeNode>parent){
        if(root==null){
            return;
        }
       
            if(root.left!=null){
                parent.put(root.left,root);
              
             

            }
            if(root.right!=null){
                parent.put(root.right,root);
      
            
            }
           
            
            System.out.println();
        
        
        preorder(root.left,parent);
        preorder(root.right,parent);
    }
    private void findsum(TreeNode root,HashMap<TreeNode,TreeNode>parent){
        if(root==null){
            return;
        }
        if(parent.containsKey(root)){
            TreeNode par=parent.get(root);
            if(parent.containsKey(par)){
                TreeNode grand=parent.get(par);
                if(grand.val%2==0){
                    sum=sum+root.val;
                }
            }
        }
        findsum(root.left,parent);
        findsum(root.right,parent);
        
    }
    public int sumEvenGrandparent(TreeNode root) {
        HashMap<TreeNode,TreeNode>parent=new HashMap<>();

        preorder(root,parent);
        findsum(root,parent);
        return sum;
    }
}