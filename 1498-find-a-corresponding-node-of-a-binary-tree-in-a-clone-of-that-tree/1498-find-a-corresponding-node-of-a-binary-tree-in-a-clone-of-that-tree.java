/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans=new TreeNode();
    private void preorder(TreeNode root,TreeNode target){
        if(root==null){
            return;
        }
        if(root.val==target.val){
            ans=root;
            
            
        }
        preorder(root.left,target);
        preorder(root.right,target);
    
        
        
        
        

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        preorder(cloned,target);
        return ans;
    }
}