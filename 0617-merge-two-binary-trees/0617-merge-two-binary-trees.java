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
    public TreeNode preorder(TreeNode root1, TreeNode root2){
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        if(root1==null && root2==null){
            return null;
        }
        root1.val=root1.val+root2.val;
        root1.left=preorder(root1.left,root2.left);
        root1.right=preorder(root1.right,root2.right);
        return root1;
        
       
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
       TreeNode check=preorder(root1,root2);
       return check;

    }
}