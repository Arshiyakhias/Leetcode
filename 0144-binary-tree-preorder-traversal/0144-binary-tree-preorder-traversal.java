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
    private void preorder(List<Integer>lis,TreeNode root){
        
        if(root==null){
            return;
        }
        lis.add(root.val);
     
        preorder(lis,root.left);
        preorder(lis,root.right);
    }  
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>lis=new ArrayList<>();
        preorder(lis,root);
        return lis;
        
    }
}